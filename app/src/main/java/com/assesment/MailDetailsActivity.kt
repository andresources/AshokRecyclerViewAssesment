package com.assesment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assesment.databinding.ActivityMailDetailsBinding
import com.assesment.databinding.ActivityMainBinding

class MailDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMailDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMailDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews(){
        val email = intent.extras?.get("Data") as MailDetails
        with(binding){
            txtSender.text = email.sender
            txtTitle.text = email.title
            txtBody.text = email.body
        }
    }
}