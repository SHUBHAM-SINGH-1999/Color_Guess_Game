package com.example.color_guess_game.Fragement

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.color_guess_game.Activity.Color_Box
import com.example.color_guess_game.Utils.ColorPicker
import com.example.color_guess_game.Adapter.CorrectOrderAdapter
import com.example.color_guess_game.R
import com.example.color_guess_game.Adapter.UserOderAdapter
import com.example.color_guess_game.Utils.Communicator
import com.example.color_guess_game.databinding.FragmentResultBinding


class ResultFragment : DialogFragment() {

    lateinit var binding: FragmentResultBinding
    lateinit var  userOrder: ArrayList<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater,container,false)
        userOrder = arguments?.getIntegerArrayList("shu")!!

        setRecyclerView()
        result()
        floatingActionButton()

        return binding.root
    }

    private fun floatingActionButton() {
        binding.actionButton.setOnClickListener {
            val communicator = activity as Communicator
            communicator.backtest()
        }
    }

    private fun result() {
        if(ColorPicker.generatedColorSet==userOrder){
            binding.imageView8.setImageResource(R.drawable.right)
            binding.username.text = "YOU WIN"
        }else{
            binding.imageView8.setImageResource(R.drawable.wrong)
            binding.username.text = "YOU LOSE"
        }
    }

    private fun setRecyclerView() {
        binding.textView3.text = ColorPicker.name.toString()

        binding.correctOrderRecyclerView.adapter = CorrectOrderAdapter(ColorPicker.generatedColorSet)
        binding.correctOrderRecyclerView.layoutManager = LinearLayoutManager(context)

        binding.userOrderRecyclerView.adapter = UserOderAdapter(userOrder)
        binding.userOrderRecyclerView.layoutManager = LinearLayoutManager(context)
    }
}