package com.bignerdranch.android.androidacademy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.bignerdranch.android.androidacademy.databinding.ActivityPracticeTwoBinding

class practice_two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var counter = 1
        var showImage = true
        var isBlack = false
        lateinit var binding: ActivityPracticeTwoBinding

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice_two)

        binding = ActivityPracticeTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonTxt.setOnClickListener {
            binding.textView.text = counter.toString()
            counter++
            if (counter == 10)
                counter = 0
        }

        binding.buttonImg.setOnClickListener {
            if (showImage) {
                binding.imageView.isVisible = true
                binding.imageView.setImageResource(R.drawable.download)
                showImage = false
                binding.buttonImg.text = "Hide him"
            }
            else {
                binding.imageView.isVisible = false
                showImage = true
                binding.buttonImg.text = "Show him"
            }
        }
        binding.switch1.setOnClickListener{
            if(!isBlack) {
                binding.layout.setBackgroundColor(Color.BLACK)
                isBlack = true
                binding.textView.setTextColor(Color.WHITE)
                binding.switch1.setTextColor(Color.WHITE)
            }
            else{
                binding.layout.setBackgroundColor(Color.WHITE)
                isBlack = false
                binding.textView.setTextColor(Color.GRAY)
                binding.switch1.setTextColor(Color.BLACK)
            }
        }

    }
}