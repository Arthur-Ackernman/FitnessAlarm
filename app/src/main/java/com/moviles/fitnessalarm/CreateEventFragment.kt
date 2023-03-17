package com.moviles.fitnessalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.moviles.fitnessalarm.databinding.FragmentCreateEventBinding
import java.text.SimpleDateFormat
import java.util.*


class CreateEventFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCreateEventBinding.inflate(inflater, container, false)

        binding.teDate.setOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()

            datePicker.addOnPositiveButtonClickListener {
                binding.tiDate.editText?.setText(convertLongToTime(it))
            }
            datePicker.show(childFragmentManager, "data_picker")
        }


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

    private fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return format.format(date)
    }
}