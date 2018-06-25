package rooms.my.android.myrooms.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Property(
        var id: String = UUID.randomUUID().toString(),
        @SerializedName("isFeatured") var isFeatured: Boolean = false,
        @SerializedName("name") var propertyName: String? = null,
        @SerializedName("overallRating") var overallRating: OverallRating? = null,
        @SerializedName("lowestPricePerNight") var lowestPricePerNight: LowestPricePerNight? = null,
        @SerializedName("overview") var overview: String? = null,
        @SerializedName("images") var images: List<Image>? = null
)