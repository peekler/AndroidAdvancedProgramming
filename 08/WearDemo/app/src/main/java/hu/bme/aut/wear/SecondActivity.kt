package hu.bme.aut.wear

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.RemoteInput
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val remoteResult = getRemoteMessageText(intent)
        if (remoteResult != null) {
            Toast.makeText(applicationContext, remoteResult, Toast.LENGTH_LONG).show()
            tvOrder.text = remoteResult
        }
    }

    private fun getRemoteMessageText(intent: Intent): String {
        val remoteInput = RemoteInput.getResultsFromIntent(intent)
        return if (remoteInput != null) {
            remoteInput.getCharSequence(MainActivity.EXTRA_VOICE_REPLY).toString()
        } else ""
    }
}
