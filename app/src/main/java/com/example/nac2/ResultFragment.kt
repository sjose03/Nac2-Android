package com.example.nac2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.nac2.R.id.action_resultFragment_to_homeFragment
import com.example.nac2.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private  lateinit var bindings : FragmentResultBinding
    private  var num1 = 0;
    private  var num2 = 0;
    private  var result = 0;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindings = DataBindingUtil.inflate(inflater,R.layout.fragment_result, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        bindings.button.setOnClickListener{
            setupSum()
            val action = ResultFragmentDirections.actionResultFragmentToHomeFragment(result)
            findNavController().navigate(action)
        }

    }

    private fun setupSum() {
        num1 = Integer.parseInt(bindings.userAnswer.text.toString())
        num2 = Integer.parseInt(bindings.userAnswer2.text.toString())

        result = num1.plus(num2)
    }
}