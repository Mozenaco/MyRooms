package rooms.my.android.myrooms.data.remote

import rooms.my.android.myrooms.data.model.Location
import rooms.my.android.myrooms.data.model.Property
import rooms.my.android.myrooms.data.model.ResponseApi

class Repository constructor(val api: PropertyApi) {

    fun getProperties(): List<Property>? {

        val response = api.getPropertiesResponse("")
        return response.execute().body()?.properties
    }

    fun getCity(): Location? {

        val response = api.getPropertiesResponse("")
        return response.execute().body()?.city
    }
}