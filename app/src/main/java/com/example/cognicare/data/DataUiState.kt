package com.example.cognicare.data

import com.example.cognicare.data.DataSource.users

class DataUiState(
    val user: user = users[0],
    val indexOfUser: Int = 0,
    val error: Boolean = false,
    val name: String = user.name,
    val age: String = user.age,
    val dp: Int = user.dp,
    val gender: String = user.gender,
    val reports: List<report> = user.reports,
    val report: Int = 0,
)