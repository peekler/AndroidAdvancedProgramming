package hu.bme.aut.calllogger

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import hu.bme.aut.calllogger.data.AppDatabase
import hu.bme.aut.calllogger.data.OutCallEntity
import java.util.*
import kotlin.concurrent.thread

class OutCallReceiver : BroadcastReceiver(){

    override fun onReceive(context: Context?, intent: Intent) {
        val outNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER)

        thread {
            AppDatabase.getInstance(context!!).outCallDAO().addCall(
                OutCallEntity(null,
                Date(System.currentTimeMillis()).toString(), outNumber!!)
            )
        }

        Toast.makeText(context, outNumber, Toast.LENGTH_LONG).show()
    }

}