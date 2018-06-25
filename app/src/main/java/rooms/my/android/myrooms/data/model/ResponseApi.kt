package rooms.my.android.myrooms.data.model

import com.google.gson.annotations.SerializedName


data class ResponseApi (
        @SerializedName("location") var city: Location? = null,
        @SerializedName("properties") val properties: List<Property>
)