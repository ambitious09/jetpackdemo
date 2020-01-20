package com.lhh.jetpackdemo.model

import android.content.Context
import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.lhh.jetpackdemo.MainActivity
import com.lhh.jetpackdemo.listener.SimpleWatcher
import com.lhh.jetpackdemo.listener.sampileListener

class LoginModel constructor(pwd: String, nameStr: String, context: Context) {
    val name = ObservableField<String>(nameStr)
    val pw = ObservableField<String>(pwd)

    val context: Context = context

    fun setName(n: CharSequence) {
        name.set(n.toString())
    }

    fun setPw(p: CharSequence) {
        pw.set(p.toString())
    }

    fun login() {
        Log.i("tag", "name=" + name.get())
        if (name.get()!!.isNotEmpty() && pw.get()!!.isNotEmpty()) {
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    //    val nameListener = sampileListener(afterTextChanged = { s -> name.set(s.toString()) })
//    val pwdListener = sampileListener(afterTextChanged = { s -> pw.set(s.toString()) })
    val nameWatcher = object : SimpleWatcher() {
        override fun afterTextChanged(s: Editable) {
            super.afterTextChanged(s)
            name.set(s.toString())
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("addTextChangedListener")
        fun addTextChangedListener(editText: EditText, listener: SimpleWatcher) {
            editText.addTextChangedListener(listener)

        }
    }


}