package hu.bme.aut.hiltdidemo.logger

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

interface LogService {
    fun doLogging()
}

class MainLogger @Inject constructor() : LogService{
    override fun doLogging() {
        Log.d("TAG_LOG", "demo")
    }
}

@Module
@InstallIn(ActivityComponent::class)
abstract class LogModule {

    @Binds
    abstract fun bindLogService(
        mainLogger: MainLogger
    ): LogService
}