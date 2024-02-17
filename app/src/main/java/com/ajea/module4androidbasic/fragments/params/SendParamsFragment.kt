package com.ajea.module4androidbasic.fragments.params

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ajea.module4androidbasic.R
import com.ajea.module4androidbasic.databinding.FragmentSendParamsBinding
import com.ajea.module4androidbasic.intent.Persona


class SendParamsFragment : Fragment() {

    private lateinit var binding : FragmentSendParamsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSendParamsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btSendParams.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerParams, ReceiveParamsFragment.newInstance("Alan", "Espinosa", Persona("Luis", "luis")))
                .addToBackStack("ReceiveParamsFragment")
                .commit()

        }
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            SendParamsFragment()
    }
}