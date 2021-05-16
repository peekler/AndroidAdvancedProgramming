package hu.bme.aut.dagger2demo

import dagger.Component

@Component(modules=[InfoModule::class])
interface MyGeneralComponent {
    fun inject(activity: MainActivity)
}