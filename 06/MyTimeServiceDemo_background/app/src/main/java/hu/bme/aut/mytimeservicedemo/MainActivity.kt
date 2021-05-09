package hu.bme.aut.mytimeservicedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hu.bme.aut.mytimeservicedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intentMyTimeService = Intent(this, MyTimeService::class.java)
        binding.btnStart.setOnClickListener {
            startService(intentMyTimeService)
        }
        binding.btnStop.setOnClickListener {
            stopService(intentMyTimeService)
        }
    }
}