package rooms.my.android.myrooms


import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import rooms.my.android.myrooms.data.model.*
import rooms.my.android.myrooms.data.remote.PropertyApi
import rooms.my.android.myrooms.data.remote.Repository
import rooms.my.android.myrooms.viewmodel.ItensViewModel
import java.util.*

class ItensViewModelTest() {

    @MockK
    private lateinit var mViewModel: ItensViewModel

    @MockK
    var propertyApi =  PropertyApi.create()

    @MockK
    var repository = Repository(propertyApi)

    @Test
    fun `should get list of properties`() = runBlocking {

        /*mViewModel = ItensViewModel()

        every { repository.getProperties() } returns dummyProperties()

        mViewModel.getProperties()
        */
    }

    @Test
    fun `should get the city`() = runBlocking {

        /*mViewModel = ItensViewModel()

        coEvery { repository.getCity() } returns dummyLocation()

        mViewModel.getCity()
        */
    }

    fun dummyProperties(): List<Property>{

        val list: MutableList<Property> = arrayListOf()

        for (i in 0 until 5) {
            list.add(Property(
                    id = UUID.randomUUID().toString(),
                    isFeatured = true,
                    propertyName = "Property",
                    overview = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                    overallRating = OverallRating(overall = 10f),
                    lowestPricePerNight = LowestPricePerNight(value = 100f),
                    images = null))
        }

        return list
    }

    fun dummyLocation(): Location{
        return Location(city = City(name = "Dublin", country = "Ireland"))
    }
}