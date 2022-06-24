package com.example.checkdob.ui.datepicker

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.checkdob.R
import com.example.checkdob.utils.ConstellationUtil
import com.example.checkdob.utils.DateUtil
import java.util.*

data class DatePickerState(
    val date: MutableState<String> = mutableStateOf("Date Of Birth"),
    val constellation: MutableState<String> = mutableStateOf(""),
    val loading: MutableState<Boolean> = mutableStateOf(true),
    val icon: MutableState<Int> = mutableStateOf(0)
)

class DatePickerViewModel: ViewModel() {
    val state = DatePickerState()

    fun selectDateTime(context: Context) {
        val currentDate = Calendar.getInstance()
        val startYear = currentDate.get(Calendar.YEAR)
        val startMonth = currentDate.get(Calendar.MONTH)
        val startDay = currentDate.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(context, { _, year, month, day ->
            updateDateTime("$day/${month + 1}/$year")
            checkConstellation("$day/${month + 1}")
        }, startYear, startMonth, startDay).show()
    }

    private fun checkConstellation(dateTime: String) {
        val date = DateUtil.getDate(dateTime)
        when {
            date.before(ConstellationUtil.AQUARIUS_START_DATE) -> {
                updateIcon(R.drawable.ic_capricorn)
                updateConstellation(ConstellationUtil.CAPRICORNUS)
            }
            date.before(ConstellationUtil.PISCES_START_DATE) -> {
                updateIcon(R.drawable.ic_aquarius)
                updateConstellation(ConstellationUtil.AQUARIUS)
            }
            date.before(ConstellationUtil.ARIES_START_DATE) -> {
                updateIcon(R.drawable.ic_pisces)
                updateConstellation(ConstellationUtil.PISCES)
            }
            date.before(ConstellationUtil.TAURUS_START_DATE) -> {
                updateIcon(R.drawable.ic_aries)
                updateConstellation(ConstellationUtil.ARIES)
            }
            date.before(ConstellationUtil.GEMINI_START_DATE) -> {
                updateIcon(R.drawable.ic_taurus)
                updateConstellation(ConstellationUtil.TAURUS)
            }
            date.before(ConstellationUtil.CANCER_START_DATE) -> {
                updateIcon(R.drawable.ic_gemini)
                updateConstellation(ConstellationUtil.GEMINI)
            }
            date.before(ConstellationUtil.LEO_START_DATE) -> {
                updateIcon(R.drawable.ic_cancer)
                updateConstellation(ConstellationUtil.CANCER)
            }
            date.before(ConstellationUtil.VIRGO_START_DATE) -> {
                updateIcon(R.drawable.ic_leo)
                updateConstellation(ConstellationUtil.LEO)
            }
            date.before(ConstellationUtil.LIBRA_START_DATE) -> {
                updateIcon(R.drawable.ic_virgo)
                updateConstellation(ConstellationUtil.VIRGO)
            }
            date.before(ConstellationUtil.SCORPIUS_START_DATE) -> {
                updateIcon(R.drawable.ic_libra)
                updateConstellation(ConstellationUtil.LIBRA)
            }
            date.before(ConstellationUtil.SAGITTARIUS_START_DATE) -> {
                updateIcon(R.drawable.ic_scorpio)
                updateConstellation(ConstellationUtil.SCORPIUS)
            }
            date.before(ConstellationUtil.CAPRICORNUS_START_DATE) -> {
                updateIcon(R.drawable.ic_sagittarius)
                updateConstellation(ConstellationUtil.SAGITTARIUS)
            }
        }
    }

    private fun updateIcon(icon: Int) {
        state.icon.value = icon
    }

    private fun updateDateTime(dateTime: String) {
        state.date.value = dateTime
    }

    private fun updateConstellation(constellation: String) {
        state.constellation.value = constellation
    }
}