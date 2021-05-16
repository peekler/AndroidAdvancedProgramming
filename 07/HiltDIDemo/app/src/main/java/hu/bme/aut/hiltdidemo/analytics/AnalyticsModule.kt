package hu.bme.aut.hiltdidemo.analytics

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TestAnalytics

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RealAnalytics

interface AnalyticsEngine {
    fun doTest(): String
}

class DemoAnalyitics @Inject constructor() : AnalyticsEngine {
    override fun doTest() = "TEST Analytics"
}

class RealAnalyitics @Inject constructor() : AnalyticsEngine {
    override fun doTest() = "REAL Analytics"
}

@Module
@InstallIn(ActivityComponent::class)
object AnalyticsModule {

    @TestAnalytics
    @Provides
    fun provideTestAnalytics(
        demoAnalytics: DemoAnalyitics
    ): AnalyticsEngine {
        return demoAnalytics
    }

    @RealAnalytics
    @Provides
    fun provideRealAnalytics(
        realAnalyitics: RealAnalyitics): AnalyticsEngine {
        return realAnalyitics
    }

}

