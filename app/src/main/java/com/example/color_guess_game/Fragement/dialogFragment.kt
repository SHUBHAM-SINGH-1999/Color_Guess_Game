package com.example.color_guess_game.Fragement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.color_guess_game.databinding.FragmentDialogBinding


class dialogFragment : DialogFragment() {
    lateinit var binding: FragmentDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogBinding.inflate(inflater,container,false)

        return binding.root
    }

}