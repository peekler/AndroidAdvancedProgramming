package hu.bme.aut.viewbindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.viewbindingdemo.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTime.setOnClickListener {
            binding.tvHello.text = Date(System.currentTimeMillis()).toString()
        }
    }
}