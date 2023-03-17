package com.moviles.fitnessalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.moviles.fitnessalarm.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.save.setOnClickListener {
            it.findNavController()
                .navigate(ProfileFragmentDirections.actionProfileFragmentToHomeFragment())
        }
        binding.topAppBar.setNavigationOnClickListener{
            it.findNavController()
                .navigate(ProfileFragmentDirections.actionProfileFragmentToHomeFragment())
        }
        return binding.root
    }
}