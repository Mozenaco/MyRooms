package rooms.my.android.myrooms.data.model

import com.google.gson.annotations.SerializedName

data class LowestPricePerNight(
        @SerializedName("value") var value: Float? = null
)