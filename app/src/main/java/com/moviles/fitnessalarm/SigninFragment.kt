package com.moviles.fitnessalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.moviles.fitnessalarm.databinding.FragmentSigninBinding


class SigninFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSigninBinding.inflate(inflater, container, false)
        binding.signIn.setOnClickListener {
            it.findNavController().navigate(SigninFragmentDirections.actionSigninFragmentToSigninProfileFragment())
        }
        return binding.root
    }
}