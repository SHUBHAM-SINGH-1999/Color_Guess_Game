package com.example.color_guess_game.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.color_guess_game.Utils.ColorPicker
import com.example.color_guess_game.R
import com.example.color_guess_game.databinding.ActivityInputScreenBinding

class Input_Screen : AppCompatActivity() {
    lateinit var binding: ActivityInputScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_screen)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_input_screen)
        userSignIn()
    }

    private fun userSignIn() {
        binding.registerButton.setOnClickListener {
            val name = binding.nameInput.text.toString()
            if(name.isEmpty()){
                Toast.makeText(this,"Enter the Name!",Toast.LENGTH_SHORT).show()
            }else{
                ColorPicker.setname(name)
                val intent = Intent(this, Color_Box::class.java)
                intent.putExtra("name",name)
                startActivity(intent)
                finish()
            }
        }
    }

}