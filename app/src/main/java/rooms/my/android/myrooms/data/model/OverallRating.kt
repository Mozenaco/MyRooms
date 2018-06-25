package rooms.my.android.myrooms.data.model

import com.google.gson.annotations.SerializedName

data class OverallRating(
        @SerializedName("overall") var overall: Float? = null
)