package rooms.my.android.myrooms.data.model

import com.google.gson.annotations.SerializedName

data class City(
        @SerializedName("name") var name: String? = null,
        @SerializedName("country") var country: String? = null
)