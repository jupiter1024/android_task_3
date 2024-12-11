package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val user_name:String? = binding.UserName.text.toString()
            val password:String? = binding.Password.text.toString()

            if (user_name != null) {
                if (password != null) {
                    if (user_name.isBlank() || password.isBlank()
                    ) {
                        Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()


                    } else if (password.length < 8) {
                        binding.error.setTextSize(10f)

                        binding.error.setText("password length should be 8 or more")
                        binding.error.setVisibility(View.VISIBLE);
                    } else if (!isValidText(password)) {
                        binding.error.setVisibility(View.GONE);
                        binding.error.setTextSize(10f)
                        binding.error.setText("password should contain at least one char and one number")
                        binding.error.setVisibility(View.VISIBLE);
                    } else {

                        val intent = Intent(this, tryre::class.java)

                        // Start SecondActivity
                        startActivity(intent)

                        // Close MainActivity to remove it from the back stack
                        finish()
                    }
                }
            }


        }
        // Enable Edge-to-Edge content for immersive UI
        enableEdgeToEdge()

        // Handle system bars insets (status bar and navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun isValidText(text: String): Boolean {
        val regex = "^(?=.*[a-zA-Z])(?=.*\\d).+$"
        return regex.toRegex().matches(text)
    }
}
