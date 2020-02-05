package com.example.datasharinginterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), InputFragment.OnFragmentSummitListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = InputFragment.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.fameView, fragment).commit()
    }

    override fun onSummitMovie(title: String, release: String, time: Int, movie: Movie) {

        textTitle.text = title
        textRelease.text = release
        textRunning.text = time.toString() + " mins"

    }
}
