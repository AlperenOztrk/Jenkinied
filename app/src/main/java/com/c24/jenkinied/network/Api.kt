package com.c24.jenkinied.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET

interface Api {

    @GET("address/random_address")
    suspend fun testRandomApi(): TestData
}

@Serializable
data class TestData(
    @SerialName("id")
    val id: Int,
    @SerialName("uid")
    val uid: String
)