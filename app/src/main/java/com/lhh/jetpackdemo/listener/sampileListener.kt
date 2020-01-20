package com.lhh.jetpackdemo.listener

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextSwitcher

class sampileListener(afterTextChanged:((s: Editable?)->Unit)?=null,
                    beforeTextChanged: ((s: CharSequence?, start: Int, count: Int, after: Int)->Unit)?=null,
                    onTextChanged: ((s: CharSequence?, start: Int, before: Int, count: Int)->Unit)?=null
                    ):TextWatcher{
    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

}