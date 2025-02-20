package com.bodakesatish.template.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.template.R
import com.bodakesatish.template.databinding.FragmentMemberListBinding
import com.bodakesatish.template.list.adapter.MemberAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentMemberList : Fragment() {

    private var _binding: FragmentMemberListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MemberListViewModel by viewModels()

    private var customerAdapter : MemberAdapter = MemberAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(tag, "$tag->onCreateView")
        _binding = FragmentMemberListBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(tag, "$tag->onViewCreated")
        viewModel.getMemberList()

        initView()
        initListeners()
        initObservers()
        initData()
        onBackPressed()
    }

    private fun onBackPressed() {
        // This callback will only be called when FragmentCustomerList is at least Started.
        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            // Handle the back button event
            // e.g., navigate to the previous screen or pop the back stack
            requireActivity().finish()
        }

        // You can enable/disable the callback based on certain conditions
        // callback.isEnabled = someCondition
    }

    private fun initView() {
        binding.headerGeneric.tvHeader.text = "List of Member"
        binding.headerGeneric.btnBack.setImageResource(R.drawable.ic_menu_24)
    }

    private fun initListeners() {
        binding.btnNewCustomer.setOnClickListener {
            findNavController().navigate(R.id.add_user_fragment)
        }
        customerAdapter.setOnClickListener {
//            val action = FragmentCustomerListDirections.actionFragmentCustomerListToFragmentAddOrUpdateCustomer(it)
//            findNavController().navigate(action)
        }
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.memberList.collect { data ->
                    Log.d(tag, "$tag->initObservers collect->customers")
                    // Update UI with the received data
                    customerAdapter.setData(data)
                }
            }
        }
    }

    private fun initData() {
        binding.rvMemberList.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvMemberList.adapter = customerAdapter
        binding.rvMemberList.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(tag, "$tag->onDestroyView")
        _binding = null
    }

}