package com.ibnoelampard.ibnu.artinrijks.injection.module

import com.ibnoelampard.ibnu.artinrijks.api.APIHelper
import com.ibnoelampard.ibnu.artinrijks.model.APIModelResponse
import com.ibnoelampard.ibnu.artinrijks.utils.ApiUtils
import com.ibnoelampard.ibnu.artinrijks.utils.POST_MOCK_PATH
import com.ibnoelampard.ibnu.artinrijks.utils.general.BASE_URL
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object APIModule {
    @Provides
    @Singleton
    internal fun providePostApi(retrofit: Retrofit): APIHelper {
        return object : APIHelper {
            override fun getWeather(latLong:String): Observable<APIModelResponse.WeatherResponse> {
                return Observable.fromCallable { ApiUtils.getUrl<APIModelResponse.WeatherResponse>(POST_MOCK_PATH) }
            }
        }
    }

    @Provides
    @Singleton
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).build()
    }
}