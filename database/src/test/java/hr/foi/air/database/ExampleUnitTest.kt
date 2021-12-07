package hr.foi.air.database

import hr.foi.air.database.converters.DateConverter
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val dateConverter = DateConverter()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun toDate() {
        val dateConverted = dateConverter.toDate(System.currentTimeMillis())
        val date = Date()
        assertEquals(date, dateConverted)
    }
}