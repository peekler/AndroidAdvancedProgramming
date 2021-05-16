package hu.bme.aut.hiltdidemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.hiltdidemo.analytics.AnalyticsEngine
import hu.bme.aut.hiltdidemo.analytics.RealAnalytics
import hu.bme.aut.hiltdidemo.analytics.TestAnalytics
import hu.bme.aut.hiltdidemo.databinding.ActivityMainBinding
import hu.bme.aut.hiltdidemo.logger.LogService
import hu.bme.aut.hiltdidemo.logger.MainLogger
import hu.bme.aut.hiltdidemo.uiutils.PowerToaster
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var info: Info
    @Inject
    lateinit var vehicle: Vehicle
    @Inject
    lateinit var demoToaster: PowerToaster

    @Inject
    //ateinit var logger: LogService
    lateinit var logger: MainLogger

    @TestAnalytics
    @Inject
    lateinit var analyitics: AnalyticsEngine

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvData.text = info.text

        binding.tvData.append("\n${vehicle.type}")

        binding.tvData.setOnClickListener {
            demoToaster.doToast()

            logger.doLogging()

            var demo = analyitics.doTest()
            binding.tvData.append("\n${demo}")
        }
    }
}