### How to share data with argument

1. Add the FrameLayout to the activity layout

2. Create data class for passing arguments

![image](https://user-images.githubusercontent.com/53125879/73971163-3d2ed480-48d3-11ea-8f44-3bf6ee7f9612.png)


3. Create the layout and class kt for fragment

---------------------------
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
---------------------------

4. Activity call the fragment

![image](https://user-images.githubusercontent.com/53125879/73971111-28524100-48d3-11ea-898b-23de05129222.png)


