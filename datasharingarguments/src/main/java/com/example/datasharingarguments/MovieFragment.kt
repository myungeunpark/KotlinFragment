package com.example.datasharingarguments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_movie.*
import java.io.Serializable

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "title"
private const val ARG_PARAM2 = "release"
private const val ARG_PARAM3 = "running"
private const val ARG_PARAM4 = "image"
private const val ARG_PARAM5 = "movie"


/**
 * A simple [Fragment] subclass.
 * Use the [MovieFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: Int? = -1
    private var param4: Int? = -1
    private lateinit var param5: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getInt(ARG_PARAM3)
            param4 = it.getInt(ARG_PARAM4)
            param5 = it.getSerializable(ARG_PARAM5) as Movie
        }
    }

    override fun onStart() {
        super.onStart()

        param4?.let { imageView.setImageResource(it) }
        title.text = param1
        release.text = param2
        running.text = param3?.let { it.toString() } + " min"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }


    companion object {

        @JvmStatic
        fun newInstance(title: String, release: String, running: Int, image:Int, movie:Movie) =
            MovieFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, title)
                    putString(ARG_PARAM2, release)
                    putInt(ARG_PARAM3, running)
                    putInt(ARG_PARAM4, image)
                    putSerializable(ARG_PARAM5, movie)
                }
            }
    }
}
