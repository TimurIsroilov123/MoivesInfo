package com.bignerdranch.android.androidacademy

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_practice_one.*

class practice_one : AppCompatActivity() {
    var counter = 1
    var showImage = true
    var isBlack = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice_one)

        buttonTxt.setOnClickListener {
            textView.text = counter.toString()
            counter++
            if (counter == 10)
                counter = 0
        }

        buttonImg.setOnClickListener {
            if (showImage) {
                imageView.isVisible = true
                imageView.setImageResource(R.drawable.download)
                showImage = false
                buttonImg.text = "Hide him"
            }
            else {
                imageView.isVisible = false
                showImage = true
                buttonImg.text = "Show him"
            }
        }

        switch1.setOnClickListener{
            if(!isBlack) {
                layout.setBackgroundColor(Color.BLACK)
                isBlack = true
                textView.setTextColor(Color.WHITE)
                switch1.setTextColor(Color.WHITE)
            }
            else{
                layout.setBackgroundColor(Color.WHITE)
                isBlack = false
                textView.setTextColor(Color.GRAY)
                switch1.setTextColor(Color.BLACK)
            }
        }

    }
}