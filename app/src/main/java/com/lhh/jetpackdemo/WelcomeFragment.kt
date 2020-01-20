package com.lhh.jetpackdemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }
    lateinit var mRegister: Button
    lateinit var mLogin: Button



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRegister=view.findViewById(R.id.mRegister)
        mLogin=view.findViewById(R.id.mLogin)
        mRegister.setOnClickListener {
            val action=WelcomeFragmentDirections
                .actionWelcomeFragmentToRegisterFragment()
                .setEmail("ceshi@163.com")
            findNavController().navigate(action)
        }

        mLogin.setOnClickListener {

            val navigations= navOptions {
                anim {

                }
            }

            val bundle= bundleOf(
                "name" to "lisi"

            )

            findNavController().navigate(R.id.loginFragment,bundle)

        }

    }





}
