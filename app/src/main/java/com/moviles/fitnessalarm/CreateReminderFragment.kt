package com.moviles.fitnessalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.moviles.fitnessalarm.databinding.FragmentCreateReminderBinding


class CreateReminderFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCreateReminderBinding.inflate(inflater, container, false)

        binding.teTime.setOnClickListener {
            val picker =
                MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_12H)
                    .setTitleText("Select Appointment time")
                    .setInputMode(MaterialTimePicker.INPUT_MODE_KEYBOARD)
                    .build()

            picker.addOnPositiveButtonClickListener {
                binding.tiTime.editText?.setText("${picker.hour}:${picker.minute}")
            }

            picker.show(childFragmentManager, "data_picker")
        }

        binding.btnSave.setOnClickListener {
            it.findNavController()
                .navigate(CreateEventFragmentDirections.actionCreateEventFragmentToSuccessFragment())
        }






        return binding.root
    }
}