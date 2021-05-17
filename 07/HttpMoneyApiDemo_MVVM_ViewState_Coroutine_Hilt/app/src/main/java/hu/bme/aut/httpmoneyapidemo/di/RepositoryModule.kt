package hu.bme.aut.httpmoneyapidemo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.httpmoneyapidemo.datasource.MoneyNetworkDataSource
import hu.bme.aut.httpmoneyapidemo.network.MoneyAPI
import hu.bme.aut.httpmoneyapidemo.repository.MoneyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMoneyNetworkDataSource(moneyAPI: MoneyAPI): MoneyNetworkDataSource {
        return MoneyNetworkDataSource(moneyAPI)
    }

    @Singleton
    @Provides
    fun provideMoneyRepository(
        moneyNetworkDataSource: MoneyNetworkDataSource
    ): MoneyRepository {
        return MoneyRepository(moneyNetworkDataSource)
    }
}