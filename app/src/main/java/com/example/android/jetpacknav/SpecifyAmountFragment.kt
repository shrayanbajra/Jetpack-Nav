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
class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private lateinit var btnSend: Button
    private lateinit var btnCancelTransaction: Button

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSend = view.findViewById(R.id.btn_send)
        btnCancelTransaction = view.findViewById(R.id.btn_cancel_transaction)

        navController = Navigation.findNavController(view)

        btnSend.setOnClickListener(this)
        btnCancelTransaction.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_send -> {
                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment)
            }
            R.id.btn_cancel_transaction -> {
                activity?.onBackPressed()
            }
        }
    }
}
