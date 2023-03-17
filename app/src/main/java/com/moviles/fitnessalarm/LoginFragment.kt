package com.moviles.fitnessalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.moviles.fitnessalarm.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.login.setOnClickListener {
            it.findNavController()
                .navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
        }
        return binding.root
    }
}