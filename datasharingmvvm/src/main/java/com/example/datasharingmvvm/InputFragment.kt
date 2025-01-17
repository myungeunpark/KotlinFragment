package com.example.datasharingmvvm

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.input_fragment.*


class InputFragment : Fragment() {

    private lateinit var viewModel: InputViewModel

    companion object {
        fun newInstance() = InputFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.input_fragment, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(activity!!).get(InputViewModel::class.java)

        inputButton.setOnClickListener {
            viewModel.setMessage(inputText.text.toString())
        }
    }

}
