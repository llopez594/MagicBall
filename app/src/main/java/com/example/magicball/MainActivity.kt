package com.example.magicball

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val color = "color"
    val text  = "text"

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(color, phraseTextView.currentTextColor)
        outState?.putString(text, phraseTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        with(savedInstanceState){
            phraseTextView.text = getString(text)
            phraseTextView.setTextColor(getInt(color))
            pressMeBotton.setBackgroundColor(getInt(color))
        }
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pressMeBotton.setOnClickListener {
            val colors = resources.getIntArray(R.array.phrasesColors)
            val phrase = resources.getStringArray(R.array.phrases)
            val ramdomColor = colors.getRandomElement()

            pressMeBotton.setBackgroundColor(ramdomColor)
            //phraseTextView.text = phrase[getRamdonNum(phrase.size)]
            phraseTextView.text = phrase.getRandomElement()
            phraseTextView.setTextColor(ramdomColor)
        }
    }

    private fun getRamdonNum(max: Int): Int = (Math.random() * max).toInt()

    private fun IntArray.getRandomElement():Int = this[(Math.random() * this.size).toInt()]

    private fun <T>Array<T>.getRandomElement():T = this[(Math.random() * this.size).toInt()]
}
