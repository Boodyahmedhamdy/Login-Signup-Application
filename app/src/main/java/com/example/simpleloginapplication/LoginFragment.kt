package com.example.simpleloginapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.simpleloginapplication.core.User
import com.example.simpleloginapplication.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // hold all elements
        binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            val email: String = binding.etEmail.text.toString()
            val password: String = binding.etPassword.text.toString()

            if(login(email, password)) {
                // navigate and pass data to home fragment

                val action = LoginFragmentDirections.
                actionLoginFragmentToHomeFragment(User(email, password))
                findNavController().navigate(action)
            }
            else {
                Toast.makeText(activity, "wrong email or password", Toast.LENGTH_LONG).show()
            }
        }

        binding.tvSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

    }

    // simulating login process
    private fun login(email: String, password: String): Boolean {
        val emailIsValid = (email == "some@gmail.com")
        val passwordIsValid = (password == "1234")

        if(emailIsValid && passwordIsValid) {
            return true
        }
        return false
    }
}