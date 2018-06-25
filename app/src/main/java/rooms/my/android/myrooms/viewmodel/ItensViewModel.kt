package rooms.my.android.myrooms.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import rooms.my.android.myrooms.data.model.Location
import rooms.my.android.myrooms.data.model.Property
import rooms.my.android.myrooms.data.remote.PropertyApi
import rooms.my.android.myrooms.data.remote.Repository
import java.util.*

class ItensViewModel : ViewModel() {

    var properties = MutableLiveData<List<Property>>()
    var city = MutableLiveData<Location>()

    var propertyApi =  PropertyApi.create()
    var repository = Repository(propertyApi)

    suspend fun getProperties(){
        properties.value = async(CommonPool) {
            repository.getProperties() }.await()
    }

    suspend fun getCity(){
        city.value = async(CommonPool) {
            repository.getCity() }.await()
    }
}