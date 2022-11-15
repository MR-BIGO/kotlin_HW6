package com.example.kotlin_navigation_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FragmentAdd : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var uploadBtn: Button
    private lateinit var nameET: EditText
    private lateinit var genreET: EditText
    private lateinit var urlET: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        uploadBtn = view.findViewById(R.id.fragmentAddUploadBTN)
        nameET = view.findViewById(R.id.fragmentAddNameET)
        genreET = view.findViewById(R.id.fragmentAddGenreET)
        urlET = view.findViewById(R.id.fragmentAddVideoUrlET)

        uploadBtn.setOnClickListener {
            if (nameET.text.isNotEmpty() && genreET.text.isNotEmpty()){
                val video = Video(nameET.text.toString(), genreET.text.toString())
                nameET.text.clear()
                genreET.text.clear()
                urlET.text.clear()
                println(video)
                val action: NavDirections = FragmentAddDirections.actionAddToActionVideos(video = video)
                findNavController().navigate(action)
            }else{
                Toast.makeText(context, "Please, enter video details", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(videosList: ArrayList<Video>) =
            FragmentAdd().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList("data", videosList)
                }

            }

    }
}