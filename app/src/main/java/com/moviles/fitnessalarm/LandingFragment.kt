package com.moviles.fitnessalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.moviles.fitnessalarm.databinding.FragmentLandingBinding

class LandingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLandingBinding.inflate(inflater, container, false)
        binding.sigIn.setOnClickListener{
            it.findNavController().navigate(LandingFragmentDirections.actionLandingFragmentToSigninFragment())
        }
        binding.login.setOnClickListener{
            it.findNavController().navigate(LandingFragmentDirections.actionLandingFragmentToLoginFragment())
        }
        return binding.root
    }
}






