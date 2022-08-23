package com.melih.eczaneuygulamasi

import okhttp3.Interceptor
import okhttp3.Response

class DistrictrInterceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =chain.request()
            .newBuilder()
            .addHeader("authorization","apikey 0OcbaSy13b2MTxCl6VSMHt:0QSZxia781QokvlfwYWAiH")
            .addHeader("content-type","application/json")
            .build()
        return chain.proceed(request)

    }
}