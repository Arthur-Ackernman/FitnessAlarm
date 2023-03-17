package com.moviles.fitnessalarm

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
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
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(resources.getString(R.string.title_reminder))
                .setMessage(resources.getString(R.string.supporting_text_reminder))
                .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                    it.findNavController()
                        .navigate(CreateReminderFragmentDirections.actionCreateReminderFragmentToHomeFragment())
                }
                .show()
        }






        return binding.root
    }
}