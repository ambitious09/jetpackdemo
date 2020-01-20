package com.lhh.jetpackdemo


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.lhh.jetpackdemo.databinding.FragmentLoginBinding
import com.lhh.jetpackdemo.model.LoginModel
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    lateinit var mLoginModel: LoginModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding: FragmentLoginBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)
        mLoginModel= LoginModel("","",context!!)
        binding.model=mLoginModel
        binding.activity=activity

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name=arguments?.getString("name")
          if (!TextUtils.isEmpty(name)){
              mLoginModel.name.set(name)
          }

//        login_activity.setOnClickListener {
//            val intent = Intent(context,MainActivity::class.java)
//            context!!.startActivity(intent)
//        }





    }


}
