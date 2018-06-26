package rooms.my.android.myrooms.data.model

import com.google.gson.annotations.SerializedName

/**
 *  Response Model - With this, is possible parse the [Json] data to objects
 *
 * @author Mateus Andrade
 * @since 25/06/18
 *
 */

data class ResponseApi (
        @SerializedName("location") var city: Location? = null,
        @SerializedName("properties") val properties: List<Property>
)