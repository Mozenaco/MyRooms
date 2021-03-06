package rooms.my.android.myrooms.ui

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
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
import javax.inject.Inject
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.widget.Toast
import rooms.my.android.myrooms.ui.util.Util


/**
 * The first activity called. Show a list of [Property] based on the data loaded
 * from the viewmodel [ItensViewModel]
 *
 * @author Mateus Andrade
 * @since 25/06/18
 *
 */

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: ItensViewModel

//    @Inject
//    lateinit var factory: ViewModelProvider.Factory

//    private val mViewModel: ItensViewModel by lazy {
//        ViewModelProviders.of(this, factory).get(ItensViewModel::class.java)
//    }

    private val propertiesAdapter by lazy {
        PropertiesAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObservers()

        rvListRooms.adapter = propertiesAdapter
        rvListRooms.layoutManager = LinearLayoutManager(this)

        if(Util(this).isNetworkOnline()){
            launch(UI) {
                mViewModel.getProperties()
                mViewModel.getCity()
            }
        }else
        {
            Toast.makeText(this, "You are not connected", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setupObservers() {

        mViewModel = ViewModelProviders.of(this).get(ItensViewModel::class.java)

        mViewModel.properties.observeNotNull(this, ::setUpListOfProperties)
        mViewModel.city.observeNotNull(this, ::setUpCity)
    }

    fun setUpListOfProperties(list: List<Property>) {

        propertiesAdapter.propertiesList.clear()
        propertiesAdapter.propertiesList.addAll(list)
        propertiesAdapter.notifyDataSetChanged()
        //Toast.makeText(this, "Data List Loaded", Toast.LENGTH_SHORT).show()
    }

    fun setUpCity(location: Location) {

        val name = location.city?.name
        val country = location.city?.country
        tvCity.text = getString(R.string.city, name, country)
        //Toast.makeText(this, "Data City Loaded", Toast.LENGTH_SHORT).show()
    }
}
