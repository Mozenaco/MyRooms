package rooms.my.android.myrooms.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*
import rooms.my.android.myrooms.R
import rooms.my.android.myrooms.data.model.Property
import android.os.Build
import android.graphics.drawable.Drawable
import com.bumptech.glide.request.target.SimpleTarget

class PropertiesAdapter(
        private val context: Context,
        var propertiesList: ArrayList<Property> = arrayListOf<Property>()): RecyclerView.Adapter<PropertiesAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        propertiesList.also { items -> holder.bindItem(items[position]) }
    }

    override fun getItemCount(): Int = propertiesList?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val feedItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(feedItemView)
    }

    inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        fun bindItem(item: Property) {

            if(item.isFeatured){
                itemView.tvFeatured.text = "★ Featured Hostel"
            }else{
                itemView.tvFeatured.text = "Hostel"
            }

            var prefix = item.images?.get(0)?.prefix
            var suffix = item.images?.get(0)?.suffix

            Glide.with(context).load("http://"+prefix+suffix).into(object : SimpleTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: com.bumptech.glide.request.transition.Transition<in Drawable>?) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        itemView.clImage.background = resource
                    }
                }
            })

            itemView.tvName.text = getValue(item.propertyName)
            itemView.tvRating.text = getValue(item.overallRating?.overall.toString())

            val price = (item.lowestPricePerNight?.value)?.div(7.55f)
            val priceWithTwoDigits = "%.2f".format(price)
            val priceText = "€ $priceWithTwoDigits"
            itemView.tvPrice.text = priceText
            itemView.tvOverview.text = getValue( item.overview)
        }
    }

    fun getValue(value : String?): String = if(value.isNullOrEmpty()) "-" else value!!

}