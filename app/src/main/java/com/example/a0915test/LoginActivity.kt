package com.example.a0915test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent

class LoginActivity : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        email_login_button.setOnClickListener{
            signinAndSignup()
        }
    }
    fun signinAndSignup(){
        auth?.createUserWithEmailAndPassword(email_edittext.text.toString(), password_edittext.text.toString())
            ?.addOnCompleteListener {
            task ->
                if(task.isSuccessful) {
                    //Creating a user account
                    moveMainPage(task.result?.user)
                }else if(task.exception?.message.isNullOrEmpty()){
                    Toast.makeText(this,task.exception?.message,Toast.LENGTH_LONG).show()
                }else{
                    //Login if you have account
                    signinEmail()
                }
        }
    }
    fun signinEmail(){
        auth?.signInWithEmailAndPassword(email_edittext.text.toString(), password_edittext.text.toString())
            ?.addOnCompleteListener {
                    task ->
                if(task.isSuccessful) {
                    //Login
                    moveMainPage(task.result?.user)
                }else{
                    //Error
                    Toast.makeText(this,task.exception?.message,Toast.LENGTH_LONG).show()
                }
            }
    }
    fun moveMainPage(user:FirebaseUser?){
        if(user != null){
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}