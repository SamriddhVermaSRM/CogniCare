package com.example.cognicare.data

import androidx.annotation.DrawableRes
import com.example.cognicare.R


class user(
    val name: String = "",
    val age: String = "0 years",
    val gender: String = "",
    val reports: List<report> = listOf(),
    @DrawableRes val dp: Int = R.drawable.dp
)

class report(
    val date: String = "",
    val alpha: Double = 0.0,
    val beta: Double = 0.0,
    val delta: Double = 0.0,
    val theta: Double = 0.0,
    val comment: String = "",
    @DrawableRes val rep: Int = R.drawable.r0
)

object DataSource {
    val users: List<user> = listOf(
        user(
            name = "Gracy Saxena",
            age = "21",
            gender = "female",
            dp = R.drawable.gracy,
            reports = listOf(
                report(
                    date = "11-04-2024",
                    alpha = 47.0,
                    beta = 26.0,
                    delta = 9.4,
                    theta = 17.0,
                    comment = "Relax but alert",
                    rep = R.drawable.r2

                ),
                report(
                    date = "24-03-2024",
                    alpha = 20.0,
                    beta = 10.0,
                    delta = 15.0,
                    theta = 54.0,
                    comment = "State of deep consiouness",
                    rep = R.drawable.r1
                ),
                report(
                    date = "12-03-2024",
                    alpha = 28.0,
                    beta = 9.2,
                    delta = 9.2,
                    theta = 54.0,
                    comment = "State of deep consiouness",
                    rep = R.drawable.r0
                ),
            )
        ),
        user(
            name = "Aditi Jaiswal",
            age = "20",
            gender = "female",
            dp = R.drawable.aditi,
            reports = listOf(
                report(
                    date = "24-03-2024",
                    alpha = 20.0,
                    beta = 10.0,
                    delta = 15.0,
                    theta = 54.0,
                    comment = "State of deep consiouness",
                    rep = R.drawable.r1
                ),
                report(
                    date = "20-01-2023",
                    alpha = 28.0,
                    beta = 9.2,
                    delta = 9.2,
                    theta = 54.0,
                    comment = "State of deep consiouness",
                    rep = R.drawable.r0
                ),
                report(
                    date = "03-01-2023",
                    alpha = 9.3,
                    beta = 41.0,
                    delta = 25.0,
                    theta = 25.0,
                    comment = "State of alertness and activeness",
                    rep = R.drawable.r3
                ),
            )
        ),
        user(
            name = "Gargi", age = "20", gender = "female", dp = R.drawable.gargi, reports = listOf(
                report(
                    date = "12-03-2024",
                    alpha = 28.0,
                    beta = 9.2,
                    delta = 9.2,
                    theta = 54.0,
                    comment = "State of deep consiouness",
                    rep = R.drawable.r0
                ),
                report(
                    date = "19-02-2024",
                    alpha = 9.3,
                    beta = 41.0,
                    delta = 25.0,
                    theta = 25.0,
                    comment = "State of alertness and activeness",
                    rep = R.drawable.r3
                ),
                report(
                    date = "01-02-2024",
                    alpha = 47.0,
                    beta = 26.0,
                    delta = 9.4,
                    theta = 17.0,
                    comment = "Relax but alert",
                    rep = R.drawable.r2
                ),
            )
        )
    )
    val usernames: List<String> = listOf("gracy04", "aditi22", "gargi09")
    val passwords: List<String> = listOf("0411", "2203", "0908")
}