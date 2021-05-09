package hu.bme.aut.mytimeservicedemo

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import java.util.*

class MyTimeService : Service() {

    var enabled = false

    inner class MyTimeThread : Thread() {
        override fun run() {
            val handlerMain = Handler(Looper.getMainLooper())

            while (enabled) {
                handlerMain.post {
                    Toast.makeText(
                        this@MyTimeService, Date(System.currentTimeMillis()).toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }

                sleep(5000)
            }
        }
    }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!enabled) {
            enabled = true
            MyTimeThread().start()
        }

        return START_STICKY_COMPATIBILITY
    }

    override fun onDestroy() {
        super.onDestroy()
        enabled = false
    }
}