## How to share data with interface 

### 1. Create framelayout in activiy layout

### 2. Create data class for sharing

------------------------------------------


package com.example.datasharinginterface

data class Movie (var title:String, var release: String, var runningTime: Int)



### 3. create layout and kt class for fragment

----------------------------------------------

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


### 4. activity implement the listener callback 


--------------------------------------------------

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
