package com.ajea.module4androidbasic.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajea.module4androidbasic.R
import com.ajea.module4androidbasic.databinding.FragmentBindingBinding


class BindingFragment : Fragment() {

    private lateinit var binding : FragmentBindingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBindingBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            BindingFragment()
    }
}