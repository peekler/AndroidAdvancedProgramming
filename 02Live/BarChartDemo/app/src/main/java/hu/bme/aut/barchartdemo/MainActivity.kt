package hu.bme.aut.barchartdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chart: BarChart = findViewById(R.id.barchart)

        val noOfEmployees = mutableListOf<BarEntry>()

        noOfEmployees.add(BarEntry(945f, 0f))
        noOfEmployees.add(BarEntry(1040f, 1f))
        noOfEmployees.add(BarEntry(1133f, 2f))
        noOfEmployees.add(BarEntry(1240f, 3f))
        noOfEmployees.add(BarEntry(1369f, 4f))
        noOfEmployees.add(BarEntry(1487f, 5f))
        noOfEmployees.add(BarEntry(1501f, 6f))
        noOfEmployees.add(BarEntry(1645f, 7f))
        noOfEmployees.add(BarEntry(1578f, 8f))
        noOfEmployees.add(BarEntry(1695f, 9f))

        val year = mutableListOf<String>()
        year.add("2008")
        year.add("2009")
        year.add("2010")
        year.add("2011")
        year.add("2012")
        year.add("2013")
        year.add("2014")
        year.add("2015")
        year.add("2016")
        year.add("2017")

        val bardataset = BarDataSet(noOfEmployees, "No Of Employee")
        chart.animateY(5000)
        val data = BarData(bardataset)
        chart.setData(data)
    }
}