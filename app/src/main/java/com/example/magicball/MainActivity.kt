package com.example.magicball

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pressMeBotton.setOnClickListener {
            val colors = arrayOf(Color.CYAN, Color.RED, Color.MAGENTA, Color.GREEN, Color.BLACK)

            val phrase = resources.getStringArray(R.array.phrases)

            val ramdomColor = colors[getRamdonNum(colors.size)]

            pressMeBotton.setBackgroundColor(ramdomColor)

            phraseTextView.text = phrase[getRamdonNum(phrase.size)]
            phraseTextView.setTextColor(ramdomColor)
        }
    }

    private fun getRamdonNum(max: Int): Int = (Math.random() * max).toInt()
}
