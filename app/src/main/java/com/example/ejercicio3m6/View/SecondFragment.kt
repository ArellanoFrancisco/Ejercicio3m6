package com.example.ejercicio3m6.View

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio3m6.Model.Modelo.Text
import com.example.ejercicio3m6.ViewModel.TextViewModel
import com.example.ejercicio3m6.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    val viewModel: TextViewModel by viewModels()
    private lateinit var adapter: TextAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TextAdapter()
        binding.RVContainer.adapter = adapter
        binding.RVContainer.layoutManager = LinearLayoutManager(context)

        viewModel.allText.observe(viewLifecycleOwner) { textList ->
            Log.d("SecondFragment", "onViewCreated: Observing allText with ${textList.size} items")
            adapter.update(textList)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

    //    _binding = null
    }
}