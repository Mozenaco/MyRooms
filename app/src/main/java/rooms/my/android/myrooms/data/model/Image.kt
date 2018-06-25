package rooms.my.android.myrooms.data.model

import com.google.gson.annotations.SerializedName

data class Image(
        @SerializedName("prefix") var prefix: String? = null,
        @SerializedName("suffix") var suffix: String? = null
)