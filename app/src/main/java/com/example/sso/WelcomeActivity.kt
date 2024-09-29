package com.example.sso

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.example.sso.databinding.ActivityWelcomeBinding
import android.text.Html


class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan pengguna yang sedang login
        val user = FirebaseAuth.getInstance().currentUser

        // Mengambil nama pengguna dari intent jika ada
        val userName = intent.getStringExtra("USER_NAME")

        // Menampilkan pesan selamat datang dengan nama pengguna
        binding.welcomeTextView.text = if (!userName.isNullOrEmpty()) {
            Html.fromHtml("Selamat datang,<br> $userName!", Html.FROM_HTML_MODE_COMPACT)
        } else if (user?.displayName != null) {
            Html.fromHtml("Selamat datang, <br> ${user.displayName}!", Html.FROM_HTML_MODE_COMPACT)
        } else {
            "Selamat datang!"
        }
    }
}
