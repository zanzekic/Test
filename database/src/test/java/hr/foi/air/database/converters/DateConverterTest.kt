package hr.foi.air.database.converters

import org.junit.Assert.*

import org.junit.Test
import java.util.*

class DateConverterTest {

    private val dateConverter = DateConverter()

    @Test
    fun toDate() {
        val dateConverted = dateConverter.toDate(System.currentTimeMillis())
        val date = Date()
        assertEquals(date, dateConverted)
    }
}