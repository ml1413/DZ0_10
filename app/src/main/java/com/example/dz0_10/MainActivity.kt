package com.example.dz0_10

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.View.OnClickListener
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import android.widget.Toast


class MainActivity : Activity(), OnClickListener {
    private var result = (1..10).random()
    private lateinit var resultOnScreen: TextView
    private lateinit var tvPlus: TextView
    private lateinit var tvMinus: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        resultOnScreen = findViewById(R.id.tv_result)
        resultOnScreen.text = result.toString()

        tvPlus = findViewById(R.id.tv_plus)
        tvPlus.setOnClickListener(this)

        tvMinus = findViewById(R.id.tv_minus)
        tvMinus.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_plus -> {
                setValueOnResult(+1)
                tvPlus.setAmin(R.anim.button_animatiom)
            }

            R.id.tv_minus -> {
                setValueOnResult(-1)
                tvMinus.setAmin(R.anim.button_animatiom)
            }
        }
    }

    private fun setValueOnResult(value: Int) {
        if ((result > 1 || value > 0) && (result < 10 || value < 0)) {
            result += value
            resultOnScreen.text = result.toString()
            resultOnScreen.setAmin(R.anim.myscale)
        } else {
            val message = if (result < 5) "1 минимальное число" else "10 максимальное число"
            resultOnScreen.setAmin(R.anim.left_right)
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

        }
    }

    private fun TextView.setAmin(animation: Int) {
        this.startAnimation(
            AnimationUtils.loadAnimation(
                this@MainActivity,
                animation
            )
        )
    }
}