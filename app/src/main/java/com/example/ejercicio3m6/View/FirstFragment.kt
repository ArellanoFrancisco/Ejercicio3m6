package com.example.ejercicio3m6.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ejercicio3m6.Model.Modelo.Text
import com.example.ejercicio3m6.R
import com.example.ejercicio3m6.ViewModel.TextViewModel
import com.example.ejercicio3m6.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    val viewModel: TextViewModel by activityViewModels()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            val text = binding.textviewFirst.text.toString()
            if (text.isEmpty()) {
                Toast.makeText(requireContext(), "Debe agregar un texto", Toast.LENGTH_SHORT).show()
            } else {
                val newText = Text(Text = text)
                viewModel.insertText(newText)
                binding.textviewFirst.text.clear()
                Toast.makeText(requireContext(), "Texto Agregado", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
   //     _binding = null
    }
}