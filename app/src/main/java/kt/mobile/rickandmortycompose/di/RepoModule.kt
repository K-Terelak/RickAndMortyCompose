package kt.mobile.rickandmortycompose.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kt.mobile.rickandmortycompose.data.AppGateway
import kt.mobile.rickandmortycompose.data.AppRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideAppGateway(
        appRepository: AppRepository
    ): AppGateway = appRepository
}