package hu.bme.aut.dagger2demo

import dagger.Module
import dagger.Provides

@Module
class InfoModule(var demoData: Int) {

    @Provides
    fun provideDetail() : Detail {
        return Detail(demoData)
    }

}