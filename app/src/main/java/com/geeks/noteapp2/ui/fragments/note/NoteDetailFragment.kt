package com.geeks.noteapp2.ui.fragments.note

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geeks.noteapp2.App
import com.geeks.noteapp2.data.model.NoteModel
import com.geeks.noteapp2.databinding.FragmentNoteDetailBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class NoteDetailFragment : Fragment() {

    private lateinit var binding: FragmentNoteDetailBinding
    private var noteId: Int = -1

    var color: Int = Color.BLACK
    var time = ""
    var date = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        upDate()
        setUpListener()
        setupTextChangedListener()
        checkButtonVisibility()
        chooseColor()

        val currentDate = Calendar.getInstance().time
        val dateFormat: DateFormat = SimpleDateFormat("dd MMMM", Locale.getDefault())
        date = dateFormat.format(currentDate)
        val timeFormat: DateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        time = timeFormat.format(currentDate)
        binding.tvTime.text = time
        binding.tvDate.text = date
    }

    private fun upDate() {
        arguments?.let { args->
            noteId = args.getInt("noteId", -1)
        }
        if (noteId != -1){
            val argsNote = App().getInstance()?.noteDao()?.getNoteById(noteId)
            argsNote?.let { model->
                binding.etTitle.setText(model.title)
                binding.etDescription.setText(model.description)
            }
        }
    }


    private fun setupTextChangedListener() {
        binding.etTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                checkButtonVisibility()
            }
        })

        binding.btnAdd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                checkButtonVisibility()
            }
        })
    }

    private fun checkButtonVisibility() {
        val etTitle = binding.etTitle.text.toString().trim()
        val etDescription = binding.btnAdd.text.toString().trim()

        binding.btnAdd.visibility = if (etTitle.isNotEmpty() && etDescription.isNotEmpty()) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    private fun setUpListener() {
        binding.btnAdd.setOnClickListener {
            val etTitle = binding.etTitle.text.toString()
            val etDescription = binding.etDescription.text.toString()
            val date = binding.tvDate.text.toString()
            val time = binding.tvTime.text.toString()
            if (noteId != -1){
                val updateNote = NoteModel(etTitle, etDescription, date, time)
                updateNote.id = noteId
                App().getInstance()?.noteDao()?.updateNote(updateNote)
            }else {
                App().getInstance()?.noteDao()?.insertNote(NoteModel(etTitle, etDescription))
            }
            findNavController().navigateUp()
        }
    }
    private fun chooseColor() = with(binding){
        btnBlack.setOnClickListener {
            if (!btnBlack.isChecked){
                btnBlack.isChecked = true
            }
            btnGray2.isChecked = !btnBlack.isChecked
            btnRed.isChecked = !btnBlack.isChecked

            color = Color.BLACK
        }
        btnGray2.setOnClickListener {
            if (!btnGray2.isChecked){
                btnGray2.isChecked = true
            }
            btnBlack.isChecked = !btnGray2.isChecked
            btnRed.isChecked = !btnGray2.isChecked

            color = Color.GRAY
        }
        btnRed.setOnClickListener {
            if (!btnRed.isChecked){
                btnRed.isChecked = true
            }
            btnGray2.isChecked = !btnRed.isChecked
            btnBlack.isChecked = !btnRed.isChecked

            color = Color.RED
        }
    }
}

