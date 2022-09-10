package com.example.simpleloginapplication

import android.os.Bundle
import android.view.*
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
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

        // adding share button to the top right
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // inflate the menu layout from menu res folder
                menuInflater.inflate(R.menu.home_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when(menuItem.itemId) {
                    R.id.shareIcon -> {
                        share()
                        true
                    }
                    else -> false
                }
            }
        },
        viewLifecycleOwner,
        Lifecycle.State.RESUMED)

    }


    private fun share(){
        startActivity(
            ShareCompat.IntentBuilder(requireActivity())
                .setText("i am playing with my account ${args.user.email} in the application")
                .setType("text/plain").intent
        )
    }
}

