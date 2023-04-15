package com.example.color_guess_game.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.color_guess_game.Utils.Communicator
import com.example.color_guess_game.Fragement.ResultFragment
import com.example.color_guess_game.Fragement.mainFragment
import com.example.color_guess_game.R

class MainActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name = intent.getStringExtra("username")
        Log.d("shu11",name.toString())
        supportFragmentManager.beginTransaction().replace(R.id.container,mainFragment()).commit()
    }

    override fun passData(data: ArrayList<Int>) {
        val bundle = Bundle()
        bundle.putIntegerArrayList("shu",data)

        val transaction = this.supportFragmentManager.beginTransaction()
        val frag2 = ResultFragment()
        frag2.arguments = bundle

        transaction.replace(R.id.container, frag2)
        transaction.commit()
    }

    override fun backtest() {
        startActivity(Intent(this,Color_Box::class.java))
        finish()
    }

}