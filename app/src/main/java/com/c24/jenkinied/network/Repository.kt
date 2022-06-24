package com.c24.jenkinied.network

import android.util.Log
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.get
import retrofit2.Retrofit

object Repository {

    val json = Json { ignoreUnknownKeys = true}

    val api: Api by lazy {
        Retrofit.Builder()
            .baseUrl("https://random-data-api.com/api/")
            .addConverterFactory(json.asConverterFactory(get("application/json")))
            .build()
            .create(Api::class.java)
    }

    suspend fun login(
        username: String,
        password: String,
        branch: String,
    ) {

    }

    suspend fun testApi(){
        val result = api.testRandomApi()
        Log.d("TEST","Test: $result")
    }
}
