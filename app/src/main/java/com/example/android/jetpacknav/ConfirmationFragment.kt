package com.example.android.jetpacknav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class ConfirmationFragment : Fragment() {

    private lateinit var money: Money
    private lateinit var recipient: String

    private lateinit var tvConfirmationMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        money = arguments?.getParcelable("amount") ?: Money(BigDecimal(0))
        recipient = arguments?.getString("recipient") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvConfirmationMessage = view.findViewById(R.id.tv_confirmation_message)

        val amount = money.amount

        val message = "You have sent $amount to $recipient"

        tvConfirmationMessage.text = message
    }
}
