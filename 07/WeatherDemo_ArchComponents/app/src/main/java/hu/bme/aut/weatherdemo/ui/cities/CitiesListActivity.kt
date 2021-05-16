package hu.bme.aut.weatherdemo.ui.cities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.getInputField
import com.afollestad.materialdialogs.input.input
import hu.bme.aut.weatherdemo.R
import hu.bme.aut.weatherdemo.ui.cities.adapter.CityAdapter
import hu.bme.aut.weatherdemo.model.db.City
import kotlinx.android.synthetic.main.activity_scrolling.*

class CitiesListActivity : AppCompatActivity() {

    lateinit var cityAdapter: CityAdapter
    private val citiesViewModel: CitiesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            showAddCityDialog()
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        cityAdapter = CityAdapter(this, citiesViewModel)
        listCities.adapter = cityAdapter


        citiesViewModel.allCities.observe(this, {
            cities -> cityAdapter.submitList(cities)
        })
    }

    private fun showAddCityDialog() {
        MaterialDialog(this).show {
            noAutoDismiss()
            title(text = getString(R.string.title_city_add_dialog))
            input()

            positiveButton(text=getString(R.string.btn_add)) {
                val cityName = it.getInputField().text.toString()
                if (cityName.isNotEmpty()) {

                    //saveCity(City(null, cityName))
                    citiesViewModel.insert(City(null, cityName))

                    it.dismiss()
                } else {
                    it.getInputField().error = getString(R.string.error_empty_field)
                }
            }
            negativeButton(text=getString(R.string.btn_dismiss)) {
                it.dismiss()
            }
        }
    }

}
