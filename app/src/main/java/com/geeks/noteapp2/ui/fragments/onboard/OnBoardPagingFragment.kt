package com.geeks.noteapp2.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geeks.noteapp2.R
import com.geeks.noteapp2.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ON_BOARD_POSITION)) {
            0 -> {
                lottie.setAnimation(R.raw.animation_one)
                onBoardTxt.text = "Очень удобный фунционал"
            }

            1 -> {
                lottie.setAnimation(R.raw.animation_two)
                onBoardTxt.text = "Быстрый, качественный продукт"
            }

            2 -> {
                lottie.setAnimation(R.raw.animation_three)
                onBoardTxt.text = "Куча функций и интересных фишек"
            }
        }
    }

    companion object {
        const val ARG_ON_BOARD_POSITION = "onBoard"
    }
}