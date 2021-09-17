package com.example.a0915test.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
//import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.example.a0915test.R
import java.util.zip.Inflater

class DetailViewFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_detail,container,false)
        return view
    }
}
