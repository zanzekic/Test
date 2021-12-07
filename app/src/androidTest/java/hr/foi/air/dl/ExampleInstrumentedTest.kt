package hr.foi.air.dl

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("hr.foi.air.dl", appContext.packageName)
    }

    @Before
    fun appLaunchesSuccessfully() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun scenario() {
        Espresso.onView(ViewMatchers.withContentDescription("Open drawer")).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("About app")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.menu_about)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("Super Nova")).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.inputTxt)).perform(ViewActions.typeText("Nesto"))
        Espresso.onView(ViewMatchers.withContentDescription("Open drawer")).perform(ViewActions.click())
    }
}