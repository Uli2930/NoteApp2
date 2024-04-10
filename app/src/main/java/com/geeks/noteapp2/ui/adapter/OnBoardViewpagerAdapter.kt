package com.geeks.noteapp2.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.geeks.noteapp2.ui.fragments.onboard.OnBoardPagingFragment
import com.geeks.noteapp2.ui.fragments.onboard.OnBoardPagingFragment.Companion.ARG_ON_BOARD_POSITION

class OnBoardViewpagerAdapter (fragment: Fragment
): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ON_BOARD_POSITION, position)
        }
    }
}
