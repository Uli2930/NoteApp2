package com.geeks.noteapp2.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.viewpager2.widget.ViewPager2
import com.geeks.noteapp2.databinding.FragmentOnBoardBinding
import com.geeks.noteapp2.ui.adapter.OnBoardViewpagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListener()
        nextButton()
        tablayout()
    }


    private fun initialize() {
        binding.viewPager.adapter = OnBoardViewpagerAdapter(this@OnBoardFragment)
    }

    private fun setUpListener() = with(binding.viewPager) {
        binding.nextText.setOnClickListener {
            if (currentItem < 3) {
                setCurrentItem(currentItem + 2, true)
            }


        }

    }

    private fun nextButton() = with(binding) {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        nextText.isVisible = true
                        goTxt.isVisible = false
                    }

                    1 -> {
                        nextText.isVisible = true
                        goTxt.isVisible = false
                    }

                    2 -> {
                        nextText.isVisible = false
                        goTxt.isVisible = true
                    }
                }
                super.onPageSelected(position)
            }
        })
    }

    private fun tablayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ ->
        }.attach()
    }
}