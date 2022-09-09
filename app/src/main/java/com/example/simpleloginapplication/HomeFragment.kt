package com.example.simpleloginapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.simpleloginapplication.core.User
import com.example.simpleloginapplication.databinding.FragmentHomeBinding
import com.example.simpleloginapplication.databinding.FragmentLoginBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val args: HomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // load binding object
        binding = FragmentHomeBinding.bind(view)

        // hold the user from arguments
        val user: User = args.user

        val userString = """
            email: ${user.email}
            password: ${user.password}
        """.trimIndent()
        binding.mainText.text = userString

    }



}