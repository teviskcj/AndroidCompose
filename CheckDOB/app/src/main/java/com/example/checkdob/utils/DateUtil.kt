package com.example.checkdob.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    private const val DATE_STRING_FORMAT = "dd/MM"

    /**
     * START DateString Method
     * */
    private fun isDateStringValid(dateString: String): Boolean {
        return try {
            val formatter = SimpleDateFormat(DATE_STRING_FORMAT, Locale.getDefault())
            formatter.parse(dateString)
            true
        } catch (ex: ParseException) {
            false
        }
    }

    private fun getDayFromDateString(dateString: String?): Int? {
        if (dateString.isNullOrEmpty()) return null
        return if (isDateStringValid(dateString)) {
            return dateString.split("/")[0].toInt()
        } else null
    }

    private fun getMonthFromDateString(dateString: String?): Int? {
        if (dateString.isNullOrEmpty()) return null
        return if (isDateStringValid(dateString)) {
            return dateString.split("/")[1].toInt() - 1
        } else null
    }

    private fun getYearFromDateString(dateString: String?): Int? {
        if (dateString.isNullOrEmpty()) return null
        return if (isDateStringValid(dateString)) {
            return dateString.split("/")[2].toInt()
        } else null
    }

    fun fromDateString(dateString: String?): Calendar? {
        dateString ?: return null
        val calendar = Calendar.getInstance()
        if (isDateStringValid(dateString)) {
            val year = getYearFromDateString(dateString) ?: return null
            val month = getMonthFromDateString(dateString) ?: return null
            val day = getDayFromDateString(dateString) ?: return null

            calendar.set(0, month, day, 0, 0, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            return calendar
        }
        return null
    }

    fun getDate(dateString: String): Date {
        return SimpleDateFormat(DATE_STRING_FORMAT, Locale.getDefault()).parse(dateString) ?: Date()
    }

    fun getDateFromString(dateString: String): Date? {
        val calendar = Calendar.getInstance()
        if (isDateStringValid(dateString)) {
            val month = getMonthFromDateString(dateString) ?: return null
            val day = getDayFromDateString(dateString) ?: return null

            calendar.set(0, month, day, 0, 0, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            return calendar.time
        }
        return null
    }
}