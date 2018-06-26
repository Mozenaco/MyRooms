package rooms.my.android.myrooms.data.remote


import rooms.my.android.myrooms.data.model.ResponseApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Interface for call the api and get the json using [Retrofit]
 *
 * @author Mateus Andrade
 * @since 25/06/18
 *
 */

interface PropertyApi {

    @GET()
    fun getPropertiesResponse(@Url url: String): Call<ResponseApi>

    companion object Factory {
        fun create(): PropertyApi {
            val retrofit = Retrofit.Builder()
                    .baseUrl("https://gist.githubusercontent.com/ruimendesM/" +
                            "bf8d095f2e92da94938810b8a8187c21/raw/70b112f88e803\n" +
                            "bf0f101f2c823a186f3d076d9e6/properties.json/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(PropertyApi::class.java)
        }
    }
}