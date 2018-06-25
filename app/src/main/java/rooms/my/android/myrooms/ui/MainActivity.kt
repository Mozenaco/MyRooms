package rooms.my.android.myrooms.ui

import android.arch.lifecycle.MutableLiveData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import rooms.my.android.myrooms.R
import rooms.my.android.myrooms.data.model.Property
import rooms.my.android.myrooms.data.remote.PropertyApi
import rooms.my.android.myrooms.data.remote.Repository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import rooms.my.android.myrooms.data.model.Location

class MainActivity : AppCompatActivity() {

    var properties = MutableLiveData<List<Property>>()
    var city = MutableLiveData<Location>()

    var propertyApi =  PropertyApi.create()
    var repository = Repository(propertyApi)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launch (UI) {
            getProperties()
            getCity()
        }
        Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show()
    }

    suspend fun getProperties(){
        properties.value = async(CommonPool) {
            repository.getProperties() }.await()
    }

    suspend fun getCity(){
        city.value = async(CommonPool) {
            repository.getCity() }.await()
    }
}
