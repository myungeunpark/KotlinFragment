package com.example.kotlinfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {

            supportFragmentManager.beginTransaction()
                .replace(R.id.frameView, sub1()).commit()

        }

        button2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameView, sub2()).commit()
        }

        button3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frameView, sub3()).commit()

        }
    }
}
