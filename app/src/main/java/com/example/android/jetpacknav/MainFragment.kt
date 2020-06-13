package com.example.android.jetpacknav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {

    private lateinit var btnNavigateToViewBalance: Button
    private lateinit var btnNavigateToViewTransactions: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNavigateToViewBalance = view.findViewById(R.id.btn_navigate_to_view_balance)
        btnNavigateToViewTransactions = view.findViewById(R.id.btn_navigate_to_view_transactions)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnNavigateToViewBalance.setOnClickListener {
            // Lets Navigate to ViewBalanceFragment
            val action = MainFragmentDirections
                .actionMainFragmentToViewBalanceFragment(userID = 1)
            findNavController().navigate(action)
        }


        btnNavigateToViewTransactions.setOnClickListener {
            // Lets Navigate to ViewTransactionsFragment
            findNavController().navigate(R.id.action_mainFragment_to_viewTransactionsFragment)
        }
    }


}
