package hu.bme.aut.sendbroadcasttest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSend = findViewById<Button>(R.id.btnSend)
        btnSend.setOnClickListener {
            sendBroadcast(Intent("hu.bme.aut.NOTIFY"))
        }
    }
}