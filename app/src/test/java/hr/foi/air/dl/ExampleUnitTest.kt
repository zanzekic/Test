package hr.foi.air.dl

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun addition_isNotCorrect() {
        assertEquals(5, 2+3)
    }

    @Test
    fun checkDate() {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val currentDateFormat = sdf.format(Date())
        val date = "07/12/2021"
        assertEquals(date, currentDateFormat)
    }

    @Test
    fun checkList() {
        val list = listOf("a1", "a2")
        assertTrue(list.contains("a1"))
    }

    @Test
    fun checkListSize() {
        val list = listOf("a1", "a2")
        assertEquals(2, list.size)
    }


}