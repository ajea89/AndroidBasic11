package com.ajea.module4androidbasic.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajea.module4androidbasic.R
import com.ajea.module4androidbasic.databinding.FragmentBinding2Binding


class Binding2Fragment : Fragment(R.layout.fragment_binding2) {

    private lateinit var binding : FragmentBinding2Binding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBinding2Binding.bind(view)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            Binding2Fragment()
    }
}