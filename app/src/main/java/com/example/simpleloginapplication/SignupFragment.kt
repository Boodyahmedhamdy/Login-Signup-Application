package com.example.simpleloginapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simpleloginapplication.core.User
import com.example.simpleloginapplication.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {


    private lateinit var binding: FragmentSignupBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignupBinding.bind(view)

        binding.btnCreateAccount.setOnClickListener {
            createAccount()
        }
    }

    private fun createAccount() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        val user = User(email, password)

        findNavController().navigate(
            SignupFragmentDirections.actionSignupFragmentToSignupEmailConfirmation(user)
        )

    }

}