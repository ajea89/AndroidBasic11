package com.ajea.module4androidbasic.fragments.params

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ajea.module4androidbasic.R
import com.ajea.module4androidbasic.databinding.FragmentReceiveParamsBinding
import com.ajea.module4androidbasic.intent.Persona

class ReceiveParamsFragment : Fragment() {

    private lateinit var binding : FragmentReceiveParamsBinding
    private var name : String? = ""
    private var lastName : String? = ""
    private var persona : Persona? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("EXTRA_NAME")
            lastName = it.getString("EXTRA_LASTNAME")
            persona = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
                it.getSerializable("EXTRA_PERSON", Persona::class.java)
            }else{
                it.getSerializable("EXTRA_PERSON") as Persona
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentReceiveParamsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "Name: $name, LastName: $lastName, Person name: ${persona?.name}", Toast.LENGTH_LONG).show()

        binding.btCallActivity.setOnClickListener {
            val intent = Intent(requireContext(), FinalActivity::class.java).apply {
                putExtra("EXTRA_NAME", name)
            }
            startActivity(intent)
        }
    }
    companion object {
        fun newInstance(name : String, lastName : String, persona: Persona) =
            ReceiveParamsFragment().apply {
                arguments = Bundle().apply {
                    putString("EXTRA_NAME", name)
                    putString("EXTRA_LASTNAME", lastName)
                    putSerializable("EXTRA_PERSON", persona)
                }
            }
    }
}