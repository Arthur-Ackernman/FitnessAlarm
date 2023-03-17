package com.moviles.fitnessalarm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.MaterialTimePicker.INPUT_MODE_KEYBOARD
import com.google.android.material.timepicker.TimeFormat
import com.moviles.fitnessalarm.databinding.FragmentRoutineSuggestedBinding
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.Category


class RoutineSuggestedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRoutineSuggestedBinding.inflate(inflater, container, false)

        binding.teDate.setOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()

            datePicker.addOnPositiveButtonClickListener {
                binding.date.editText?.setText(convertLongToTime(it))
            }
            datePicker.show(childFragmentManager, "data_picker")
        }


        binding.teTime.setOnClickListener {
            val picker =
                MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_12H)
                    .setTitleText("Select Appointment time")
                    .setInputMode(INPUT_MODE_KEYBOARD)
                    .build()

            picker.addOnPositiveButtonClickListener {
                binding.time.editText?.setText("${picker.hour}:${picker.minute}")
            }

            picker.show(childFragmentManager, "data_picker")
        }

        binding.activate.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(resources.getString(R.string.title_reminder))
                .setMessage(resources.getString(R.string.supporting_text_reminder))
                .setPositiveButton(resources.getString(R.string.accept)) { dialog, which ->
                    it.findNavController()
                        .navigate(RoutineSuggestedFragmentDirections.actionRoutineSuggestedFragmentToHomeFragment())
                }
                .show()
        }

        return binding.root
    }

    private fun convertLongToTime(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return format.format(date)
    }

}