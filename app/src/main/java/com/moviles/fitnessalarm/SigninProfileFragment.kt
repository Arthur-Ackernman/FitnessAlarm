package com.moviles.fitnessalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.moviles.fitnessalarm.databinding.FragmentSigninProfileBinding


class SigninProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSigninProfileBinding.inflate(inflater, container, false)
        binding.save.setOnClickListener {
            it.findNavController()
                .navigate(SigninProfileFragmentDirections.actionSigninProfileFragmentToHomeFragment())
        }

        return binding.root
    }
}