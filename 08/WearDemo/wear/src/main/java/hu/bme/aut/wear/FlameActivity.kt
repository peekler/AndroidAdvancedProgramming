package hu.bme.aut.wear

import android.os.Bundle
import android.os.PowerManager.WakeLock
import android.support.wearable.activity.WearableActivity
import android.view.WindowManager
import android.widget.TextView


class FlameActivity : WearableActivity() {

    private val mTextView: TextView? = null
    private val wakeLock: WakeLock? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(FlameView(this))
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }
}
