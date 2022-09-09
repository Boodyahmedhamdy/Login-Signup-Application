package com.example.simpleloginapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.simpleloginapplication.databinding.FragmentSignupEmailConfirmationBinding

class SignupEmailConfirmation : Fragment() {

    private lateinit var binding: FragmentSignupEmailConfirmationBinding

    private val args: SignupEmailConfirmationArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_email_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignupEmailConfirmationBinding.bind(view)

        binding.theEmail.text = args.user.email

        binding.btnConfirm.setOnClickListener {
            if(binding.etConfirmationCode.text.toString() == "000") {
                val action = SignupEmailConfirmationDirections.
                actionSignupEmailConfirmationToHomeFragment(args.user)

                findNavController().navigate(action)
            }
            else {
                Toast.makeText(activity, "wrong code use 000 instead", Toast.LENGTH_LONG).show()
            }
        }


    }


}