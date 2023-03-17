package com.moviles.fitnessalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.moviles.fitnessalarm.databinding.FragmentRoutineSetupBinding


class RoutineSetupFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRoutineSetupBinding.inflate(inflater, container, false)
        binding.next.setOnClickListener {
            it.findNavController()
                .navigate(RoutineSetupFragmentDirections.actionRoutineSetupFragmentToRoutineSuggestedFragment())
        }
        return binding.root
    }
}