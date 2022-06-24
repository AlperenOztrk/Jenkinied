package com.c24.jenkinied.domain

data class BuildOverview(
    val status: BuildStatus,
    val result: BuildResult?,
    val buildNumber: Int,
    val buildFinishedTimestamp: Long?,
    val branch: String,
    val message: String

)


enum class BuildResult(name: String){
    SUCCESS("SUCCESS"),
    FAILURE("FAILURE"),
    UNKNOWN("UNKNOWN")
}

enum class BuildStatus(name: String){
    RUNNING("RUNNING"),
    DONE("DONE")
}