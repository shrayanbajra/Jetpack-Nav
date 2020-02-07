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
class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    private lateinit var btnNext: Button
    private lateinit var btnCancel: Button

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNext = view.findViewById(R.id.btn_next)
        btnCancel = view.findViewById(R.id.btn_cancel)

        navController = Navigation.findNavController(view)

        btnNext.setOnClickListener(this)
        btnCancel.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.btn_next -> navController.navigate(
                R.id.action_chooseRecipientFragment_to_specifyAmountFragment
            )
            R.id.btn_cancel -> activity?.onBackPressed()
        }
    }
}
