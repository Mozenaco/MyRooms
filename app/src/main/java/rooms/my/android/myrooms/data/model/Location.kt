package rooms.my.android.myrooms.data.model

import com.google.gson.annotations.SerializedName

data class Location(
        @SerializedName("city") var city: City? = null
)