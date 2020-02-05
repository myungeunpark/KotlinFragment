package com.example.datasharingarguments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create data class
        val param = Movie("Spider-Man: Far From Home",
                        "June 28, 2017",
                         133, R.drawable.img1)

        val fragment = MovieFragment.newInstance(param.title, param.release, param.running, param.image, param)
        supportFragmentManager.beginTransaction().replace(R.id.frameView, fragment).commit()


    }
}
