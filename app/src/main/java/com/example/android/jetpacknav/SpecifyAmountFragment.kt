package com.example.android.jetpacknav


import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    private lateinit var recipient: String

    private lateinit var tvRecipient: TextView
    private lateinit var etAmount: EditText

    private lateinit var btnSend: Button
    private lateinit var btnCancelTransaction: Button

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recipient = arguments?.getString("recipient") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvRecipient = view.findViewById(R.id.tv_recipient)
        etAmount = view.findViewById(R.id.et_input_amount)

        btnSend = view.findViewById(R.id.btn_send)
        btnCancelTransaction = view.findViewById(R.id.btn_cancel_transaction)

        tvRecipient.text = "Sending money to $recipient"

        navController = Navigation.findNavController(view)

        btnSend.setOnClickListener(this)
        btnCancelTransaction.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_send -> {
                if (!TextUtils.isEmpty(etAmount.text.toString().trim())) {
                    val amount = Money(BigDecimal(etAmount.text.toString().trim()))
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "amount" to amount
                    )
                    navController.navigate(
                        R.id.action_specifyAmountFragment_to_confirmationFragment,
                        bundle
                    )
                } else {
                    Toast.makeText(activity, "Please Enter Amount", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.btn_cancel_transaction -> {
                activity?.onBackPressed()
            }
        }
    }
}
