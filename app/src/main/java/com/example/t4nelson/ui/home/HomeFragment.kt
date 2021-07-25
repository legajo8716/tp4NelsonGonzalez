package com.example.t4nelson.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.t4nelson.R
import com.example.t4nelson.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ingresoNombreEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if(s!!.length != 0)
                    binding.ingresoNombre.setEndIconDrawable(R.drawable.ic_menu_gallery)
                if(s!!.length == 0) binding.ingresoNombre.setEndIconDrawable(R.drawable.ic_menu_camera)
            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.ingresoNombre.setEndIconDrawable(R.drawable.ic_menu_gallery)
                if(s!!.length != 0) binding.ingresoNombre.setEndIconDrawable(R.drawable.ic_menu_gallery)
                if(s!!.length == 0) binding.ingresoNombre.setEndIconDrawable(R.drawable.ic_menu_camera)

                ;
            }

            override fun afterTextChanged(s: Editable?) {
                if(s!!.length != 0)
                    binding.ingresoNombre.setEndIconDrawable(R.drawable.ic_menu_gallery)
                if(s!!.length == 0) binding.ingresoNombre.setEndIconDrawable(R.drawable.ic_menu_camera)
            }


        })

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}