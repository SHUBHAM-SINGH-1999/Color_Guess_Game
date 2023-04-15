package com.example.color_guess_game.Fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.color_guess_game.Utils.Communicator
import com.example.color_guess_game.databinding.FragmentMainBinding


class mainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    var flag = 1
    lateinit var list: ArrayList<Int>
    lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        list = ArrayList()
        communicator = activity as Communicator

        counterSet()
        submitButton()
        resetButton()
        binding.resetbutton.visibility = View.GONE
        return binding.root
    }

    private fun resetButton() {
        binding.resetbutton.setOnClickListener {
            flag=1
            binding.one.text = ""
            binding.two.text = ""
            binding.three.text = ""
            binding.four.text = ""
            binding.five.text = ""
            binding.six.text = ""
            binding.seven.text = ""
            list.clear()
            if(list.size>=5) binding.resetbutton.visibility = View.VISIBLE
            else binding.resetbutton.visibility = View.GONE
        }
    }

    private fun submitButton() {
        binding.button.setOnClickListener {
            if(list.size<7)
                Toast.makeText(context,"Select all colors!",Toast.LENGTH_SHORT).show()
            else{
                communicator.passData(list)
                dialog()
            }
        }
    }

    private fun dialog() {
        dialogFragment().show((activity as AppCompatActivity).supportFragmentManager,"Dialog Box")
    }

    private fun counterSet() {
        // for One
        binding.imageView1.setOnClickListener {
            if(binding.one.text.isEmpty()) {
                binding.one.text = flag.toString()
                flag++
                list.add(0)
            }
            else {
                if(binding.one.text.toString()==(flag-1).toString()) {
                    binding.one.text = ""
                    flag--
                    list.remove(0)
                }
            }
            if(list.size>=7) binding.resetbutton.visibility = View.VISIBLE
            else binding.resetbutton.visibility = View.GONE
        }
        // for Two
        binding.imageView2.setOnClickListener {
            if(binding.two.text.isEmpty()) {
                binding.two.text = flag.toString()
                flag++
                list.add(1)
            }
            else {
                if(binding.two.text.toString()==(flag-1).toString()) {
                    binding.two.text = ""
                    flag--
                    list.remove(1)
                }
            }
            if(list.size>=7) binding.resetbutton.visibility = View.VISIBLE
            else binding.resetbutton.visibility = View.GONE
        }
        //for Three
        binding.imageView3.setOnClickListener {
            if(binding.three.text.isEmpty()) {
                binding.three.text = flag.toString()
                flag++
                list.add(2)
            }
            else {
                if(binding.three.text.toString()==(flag-1).toString()) {
                    binding.three.text = ""
                    flag--
                    list.remove(2)
                }
            }
            if(list.size>=7) binding.resetbutton.visibility = View.VISIBLE
            else binding.resetbutton.visibility = View.GONE
        }
        //for Four
        binding.imageView4.setOnClickListener {

            if(binding.four.text.isEmpty()) {
                binding.four.text = flag.toString()
                flag++
                list.add(3)
            }
            else {
                if(binding.four.text.toString()==(flag-1).toString()) {
                    binding.four.text = ""
                    flag--
                list.remove(3)
                }
            }
            if(list.size>=7) binding.resetbutton.visibility = View.VISIBLE
            else binding.resetbutton.visibility = View.GONE
        }
        // for Five
        binding.imageView5.setOnClickListener {
            if(binding.five.text.isEmpty()) {
                binding.five.text = flag.toString()
                flag++
                list.add(4)
            }
            else {
                if(binding.five.text.toString()==(flag-1).toString()) {
                    binding.five.text = ""
                    flag--
                    list.remove(4)
                }
            }
            if(list.size>=7) binding.resetbutton.visibility = View.VISIBLE
            else binding.resetbutton.visibility = View.GONE
        }
        //for Six
        binding.imageView6.setOnClickListener {

            if(binding.six.text.isEmpty()) {
                binding.six.text = flag.toString()
                flag++
                list.add(5)
            }
            else {
                if(binding.six.text.toString()==(flag-1).toString()) {
                    binding.six.text = ""
                    flag--
                    list.remove(5)
                }
            }
            if(list.size>=7) binding.resetbutton.visibility = View.VISIBLE
            else binding.resetbutton.visibility = View.GONE
        }
        //for Seven
        binding.imageView7.setOnClickListener {

            if(binding.seven.text.isEmpty()) {
                binding.seven.text = flag.toString()
                flag++
                list.add(6)
            }
            else {
                if(binding.seven.text.toString()==(flag-1).toString()) {
                    binding.seven.text = ""
                    flag--
                    list.remove(6)
                }
            }
            if(list.size>=7) binding.resetbutton.visibility = View.VISIBLE
            else binding.resetbutton.visibility = View.GONE
        }
    }


}