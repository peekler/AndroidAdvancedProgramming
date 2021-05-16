package hu.bme.aut.hiltdidemo.uiutils

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class PowerToaster @Inject constructor(@ActivityContext private val context: Context) {
    fun doToast() {
        Toast.makeText(context, "HI", Toast.LENGTH_LONG).show()
    }
}