package com.c24.jenkinied.network

import android.util.Log
import com.c24.jenkinied.TAG
import com.c24.jenkinied.domain.BuildOverview
import com.c24.jenkinied.domain.BuildResult
import com.c24.jenkinied.domain.BuildStatus
import com.c24.jenkinied.logNow
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.get
import retrofit2.Retrofit

object Repository {

    val json = Json { ignoreUnknownKeys = true}

    @OptIn(ExperimentalSerializationApi::class)
    val api: Api by lazy {
        Retrofit.Builder()
            .baseUrl("https://random-data-api.com/api/")
            .addConverterFactory(json.asConverterFactory(get("application/json")))
            .build()
            .create(Api::class.java)
    }

    private var username: String? = null
    private var password: String? = null
    private var branch: String? = null

    suspend fun login(
        username: String,
        password: String,
        branch: String,
    ) {
        // make api call to check if this combo is valid




    }

    @Throws
    suspend fun getListOfBuilds(): List<BuildOverview>{
        return createDummyListOfBuilds()
    }

    private fun createDummyListOfBuilds() = listOf(
        BuildOverview(
            status = BuildStatus.RUNNING,
            result = null,
            buildNumber = 5,
            buildFinishedTimestamp = null,
            branch = "release/2022.27.0",
            message = "[release/2022.25.1] fixing proguard"
        ),
        BuildOverview(
            status = BuildStatus.DONE,
            result = BuildResult.SUCCESS,
            buildNumber = 4,
            buildFinishedTimestamp = 1656070756,
            branch = "release/2022.27.0",
            message = "new feature"
        ),
        BuildOverview(
            status = BuildStatus.DONE,
            result = BuildResult.FAILURE,
            buildNumber = 3,
            buildFinishedTimestamp = 1655977156,
            branch = "release/2022.27.0",
            message = "fix buildjob (this time for real)"
        ),
        BuildOverview(
            status = BuildStatus.DONE,
            result = BuildResult.FAILURE,
            buildNumber = 2,
            buildFinishedTimestamp = 1655887096,
            branch = "release/2022.27.0",
            message = "fix buildjob"
        ),
        BuildOverview(
            status = BuildStatus.DONE,
            result = BuildResult.UNKNOWN,
            buildNumber = 2,
            buildFinishedTimestamp = 1655793496,
            branch = "release/2022.27.0",
            message = "build stuff"
        )
    )

    suspend fun testApi(){
        val result = api.testRandomApi()
        Log.d("TEST","Test: $result")
    }
}
