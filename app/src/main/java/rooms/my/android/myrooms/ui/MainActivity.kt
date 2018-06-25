package rooms.my.android.myrooms.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import rooms.my.android.myrooms.R
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import rooms.my.android.myrooms.data.extensions.observeNotNull
import rooms.my.android.myrooms.data.model.Location
import rooms.my.android.myrooms.viewmodel.ItensViewModel
import rooms.my.android.myrooms.data.model.Property
import rooms.my.android.myrooms.ui.adapter.PropertiesAdapter

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: ItensViewModel

    private val propertiesAdapter by lazy {
        PropertiesAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObservers()

        rvListRooms.adapter = propertiesAdapter
        rvListRooms.layoutManager = LinearLayoutManager(this)

        launch (UI) {
            mViewModel.getProperties()
            mViewModel.getCity()
        }

    }

    private fun setupObservers() {

        mViewModel = ViewModelProviders.of(this).get(ItensViewModel::class.java)

        mViewModel.properties.observeNotNull(this, ::setUpListOfProperties)
        mViewModel.city.observeNotNull(this, ::setUpCity)
    }

    fun setUpListOfProperties(list: List<Property>){

        propertiesAdapter.propertiesList.clear()
        propertiesAdapter.propertiesList.addAll(list)
        propertiesAdapter.notifyDataSetChanged()
        //Toast.makeText(this, "Data List Loaded", Toast.LENGTH_SHORT).show()
    }

    fun setUpCity(location: Location){

        val name = location.city?.name
        val country = location.city?.country

        tvCity.text = "$name, $country"
        //Toast.makeText(this, "Data City Loaded", Toast.LENGTH_SHORT).show()
    }

}
