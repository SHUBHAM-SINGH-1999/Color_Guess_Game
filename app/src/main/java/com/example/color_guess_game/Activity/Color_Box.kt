package com.example.color_guess_game.Activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.color_guess_game.Utils.ColorPicker
import com.example.color_guess_game.R
import com.example.color_guess_game.databinding.ActivityColorBoxBinding
import kotlinx.coroutines.*

class Color_Box : AppCompatActivity() {
    lateinit var binding: ActivityColorBoxBinding
    lateinit var list: MutableList<Int>
     var name:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_color_box)
        name = intent.getStringExtra("name")

        binding.textView.text = name
        GlobalScope.launch(Dispatchers.Main) {
            countdown()
            setColorToScreen()
        }
    }

    private suspend fun countdown(){
        binding.imageView.visibility = View.GONE
        binding.colorName.visibility = View.GONE
        for(i in 5 downTo 1){
            binding.timerView.text = i.toString()
            delay(1000)
        }
    }

    private suspend fun setColorToScreen() {
        binding.timerView.visibility = View.GONE
        binding.textView10.visibility = View.GONE
        binding.imageView.visibility = View.VISIBLE
        binding.colorName.visibility = View.VISIBLE
        ColorPicker.setRandomColor()
        list= ColorPicker.generatedColorSet
        val imageview = binding.imageView
        for(i in 0..6){
            imageview.setBackgroundColor(Color.parseColor(ColorPicker.colors[list[i]]))
            binding.colorName.text = ColorPicker.colorname[list[i]]
            delay(1000)
        }
        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("username",name)
        startActivity(intent)
        finish()
    }
}