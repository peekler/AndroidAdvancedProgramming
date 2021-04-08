package hu.bme.aut.calllogger

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.calllogger.adapter.OutCallAdapter
import hu.bme.aut.calllogger.data.AppDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: OutCallAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestNeededPermission()

        initDB()
    }

    private fun initDB() {
        adapter = OutCallAdapter(this)
        findViewById<RecyclerView>(R.id.recyclerCalls).adapter = adapter

        AppDatabase.getInstance(this).outCallDAO().getAllCalls()
                .observe(this, Observer { items ->
                    adapter.submitList(items)
                })
    }

    private fun requestNeededPermission() {
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.PROCESS_OUTGOING_CALLS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.PROCESS_OUTGOING_CALLS),
                    101)
        } else {
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            101 -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty()
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this@MainActivity, "perm granted", Toast.LENGTH_SHORT).show()


                } else {
                    Toast.makeText(this@MainActivity,
                            "perm not granted", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }
}