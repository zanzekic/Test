package hr.foi.air.database

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import hr.foi.air.database.entities.Discount
import hr.foi.air.database.entities.Store
import org.junit.After

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

    private lateinit var mainDatabase: MainDatabase

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("hr.foi.air.database.test", appContext.packageName)
    }

    @Before
    fun initDb() {
        mainDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().targetContext, MainDatabase::class.java).build()
        val store1: Store = Store()
        store1.name = "Store 1"
        mainDatabase.getDao().insertStores(store1)
    }

    @Test
    fun getStores() {
        val stores = mainDatabase.getDao().getAllStores()
        assert(stores.isNotEmpty())
    }

    @Test
    fun insertDiscounts() {
        val discount: Discount = Discount()
        discount.name = "Popust"
        discount.description = "Nesto"
        discount.discountValue = 50
        mainDatabase.getDao().insertDiscounts(discount)
        val discounts = mainDatabase.getDao().getAllDiscounts()
        assert(discounts.isNotEmpty())
    }

    @Test
    fun getDiscountByStore() {
        val discount: Discount = Discount()
        discount.name = "Prvi"
        discount.storeId = 1
        mainDatabase.getDao().insertDiscounts(discount)
        val dis = mainDatabase.getDao().getAllDiscountsByStore(1)
        assert(dis.isEmpty())
    }

    @After
    fun closeDb() {
        mainDatabase.close()
    }

}