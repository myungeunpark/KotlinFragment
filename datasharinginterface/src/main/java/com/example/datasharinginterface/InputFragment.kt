package com.example.datasharinginterface

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_input.*
import kotlinx.android.synthetic.main.fragment_input.view.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [InputFragment.OnFragmentSummitListener] interface
 * to handle interaction events.
 */
class InputFragment : Fragment() {
    private var listener: OnFragmentSummitListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_input, container, false)
        view.button.setOnClickListener {
            summitInputData()
        }

        return view
    }

    private fun summitInputData(){

        var  movie = Movie("", "", -1)
        movie.title = editTitle.text.toString()
        movie.release = editRelease.text.toString()
        movie.runningTime = editRunning.text.toString().toInt()

        // call listener
        listener?.onSummitMovie(movie.title, movie.release, movie.runningTime, movie)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentSummitListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentSummitListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentSummitListener {

        fun onSummitMovie(title:String, release:String, time:Int, movie: Movie)
    }


    companion object {

        @JvmStatic
        fun newInstance() = InputFragment()
    }
}
