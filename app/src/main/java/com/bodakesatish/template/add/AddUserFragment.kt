package com.bodakesatish.template.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bodakesatish.domain.model.Member
import com.bodakesatish.template.databinding.FragmentAddUserBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddUserFragment : Fragment() {

    private var _binding: FragmentAddUserBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddUserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Collect Response and Update UI
        lifecycleScope.launch {
            viewModel.response.collectLatest { response ->
                if (response) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Operation Successful", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        // Add User Button Click
        binding.btnAddUser.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val mobile = binding.etMobile.text.toString()
            binding.progressBar.visibility = View.VISIBLE

            if (name.isNotEmpty() && email.isNotEmpty() && mobile.isNotEmpty()) {
                val user = Member(0, name, email, mobile)
                viewModel.addUser(user)
            } else {
                Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
