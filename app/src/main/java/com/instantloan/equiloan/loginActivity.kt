package com.instantloan.equiloan

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task

class loginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupButtonListeners()

        val equiloanFont: TextView = findViewById(R.id.Equiloan)
        val typeface: Typeface? = ResourcesCompat.getFont(this, R.font.gorditas)
        equiloanFont.typeface = typeface

        val welcomeFont: TextView = findViewById(R.id.welcomeMessage)
        val welcome: Typeface? = ResourcesCompat.getFont(this, R.font.carme)
        welcomeFont.typeface = welcome

        val continueGoogleFont: TextView = findViewById(R.id.continueGoogle)
        val googleFont: Typeface? = ResourcesCompat.getFont(this, R.font.carme)
        continueGoogleFont.typeface = googleFont

        val or: TextView = findViewById(R.id.or)
        val orFont: Typeface? = ResourcesCompat.getFont(this, R.font.carme)
        or.typeface = orFont

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val signInButton = findViewById<TextView>(R.id.continueGoogle)
        signInButton.setOnClickListener {
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }

    }
    private fun navigateTo(activityClass: Class<*>) {
        startActivity(Intent(this, activityClass))
        true
    }
    private fun setupButtonListeners(){
        findViewById<TextView>(R.id.signup)?.setOnClickListener {
            navigateTo(signupActivity::class.java)
        }
    }

    private companion object {
        private const val RC_SIGN_IN = 9001
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            // updateUI(account)
        } catch (e: ApiException) {
            // Log.w(TAG, "signInResult:failed code=${e.statusCode}")
            // updateUI(null)
        }
    }
}
