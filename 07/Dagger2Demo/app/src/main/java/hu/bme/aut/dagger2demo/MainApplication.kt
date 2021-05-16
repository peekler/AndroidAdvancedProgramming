package hu.bme.aut.dagger2demo

import android.app.Application

class MainApplication : Application() {
    lateinit var injector: MyGeneralComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerMyGeneralComponent.builder().infoModule(InfoModule(10)).build()
    }
}