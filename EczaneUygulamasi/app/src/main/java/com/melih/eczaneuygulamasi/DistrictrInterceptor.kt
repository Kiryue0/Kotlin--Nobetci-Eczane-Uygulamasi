package com.melih.eczaneuygulamasi

import okhttp3.Interceptor
import okhttp3.Response

class DistrictrInterceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =chain.request()
            .newBuilder()
            .addHeader("authorization","apikey 54UJCfqCb684CWUJvRHxFA:4zkM9QB6R41Px8pQ052VVR")
            .addHeader("content-type","application/json")
            .build()
        return chain.proceed(request)

    }
}