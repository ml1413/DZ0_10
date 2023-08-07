package com.example.dz0_10

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast


class MainActivity : Activity() {
    private var result = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tv_plus).setOnClickListener {
            showResultOnToast(+1)
        }
        findViewById<TextView>(R.id.tv_minus).setOnClickListener {
            showResultOnToast(-1)
        }
    }

    private fun showResultOnToast(value: Int) {
        if (result > 1 || value > 0) {
            result += value
            Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "число 1 минимальное   $result", Toast.LENGTH_SHORT).show()
        }
    }
}