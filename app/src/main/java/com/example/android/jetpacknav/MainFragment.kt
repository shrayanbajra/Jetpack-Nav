package com.example.android.jetpacknav


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 */
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

        navController = Navigation.findNavController(view)

        btnViewTransaction = view.findViewById(R.id.btn_view_transaction)
        btnSendMoney = view.findViewById(R.id.btn_send_money)
        btnViewBalance = view.findViewById(R.id.btn_view_balance)

        btnViewTransaction.setOnClickListener(this)
        btnSendMoney.setOnClickListener(this)
        btnViewBalance.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.btn_view_transaction -> navController.navigate(
                R.id.action_mainFragment_to_viewTransactionFragment
            )

            R.id.btn_send_money -> navController.navigate(
                R.id.action_mainFragment_to_chooseRecipientFragment
            )

            R.id.btn_view_balance -> navController.navigate(
                R.id.action_mainFragment_to_viewBalanceFragment
            )
        }
    }
}
