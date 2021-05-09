package hu.bme.aut.jobintentservicedemo

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import hu.bme.aut.jobintentservicedemo.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private val handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            if (msg.arg1 == Activity.RESULT_OK) {
                binding.ivPhoto.setImageBitmap(msg.obj as Bitmap)
            }
        }
    }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rand = Random(System.currentTimeMillis())
        binding.btnGetImage.setOnClickListener {
            val intentImage = Intent(this@MainActivity, ImageDownloadService::class.java)

            intentImage.putExtra(ImageDownloadService.KEY_MESSENGER,
                Messenger(handler)
            )
            intentImage.putExtra(ImageDownloadService.KEY_IMAGE_URL,
                "https://picsum.photos/200/200/?image=${rand.nextInt(1000)}")

            ImageDownloadService.enqueueWork(this, intentImage)
        }
    }
}