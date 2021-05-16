package hu.bme.aut.dagger2demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.dagger2demo.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var info: Info

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as MainApplication).injector.inject(this)

        binding.tvData.text = info.text


    }
}