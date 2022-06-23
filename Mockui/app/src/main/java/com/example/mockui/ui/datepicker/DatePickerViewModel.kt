package com.example.mockui.ui.datepicker

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.*


class DatePickerViewModel: ViewModel() {
    var date = mutableStateOf("Date Of Birth")
        private set

    var constellation = mutableStateOf("Test")
        private set

    fun selectDateTime(context: Context) {
        val currentDate = Calendar.getInstance()
        val startYear = currentDate.get(Calendar.YEAR)
        val startMonth = currentDate.get(Calendar.MONTH)
        val startDay = currentDate.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(context, { _, year, month, day ->
            updateDateTime("$day/${month + 1}/$year")
        }, startYear, startMonth, startDay).show()
    }

    private fun updateDateTime(dateTime: String) {
        date.value = dateTime
    }
}