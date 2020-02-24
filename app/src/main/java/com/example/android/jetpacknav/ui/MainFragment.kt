package com.example.android.jetpacknav.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.android.jetpacknav.R

class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var navController: NavController

    private lateinit var btnViewTransaction: Button
    private lateinit var btnSendMoney: Button
    private lateinit var btnViewBalance: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNavController(view)
        initViews(view)
        setOnClickListenersOnButtons()
    }

    private fun initNavController(view: View) {
        navController = Navigation.findNavController(view)
    }

    private fun initViews(view: View) {
        btnViewTransaction = view.findViewById(R.id.btn_view_transaction)
        btnSendMoney = view.findViewById(R.id.btn_send_money)
        btnViewBalance = view.findViewById(R.id.btn_view_balance)
    }

    private fun setOnClickListenersOnButtons() {
        btnViewTransaction.setOnClickListener(this)
        btnSendMoney.setOnClickListener(this)
        btnViewBalance.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_view_transaction -> navigateToViewTransactionFragment()
            R.id.btn_send_money -> navigateToSendMoneyFragment()
            R.id.btn_view_balance -> navigateToViewBalanceFragment()
        }
    }

    private fun navigateToViewTransactionFragment() {
        navController.navigate(R.id.action_mainFragment_to_viewTransactionFragment)
    }

    private fun navigateToSendMoneyFragment() {
        navController.navigate(R.id.action_mainFragment_to_chooseRecipientFragment)
    }

    private fun navigateToViewBalanceFragment() {
        navController.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
    }
}
