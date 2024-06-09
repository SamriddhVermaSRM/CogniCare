package com.example.cognicare.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cognicare.R
import com.example.cognicare.data.report

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ReportScreen(
    viewModel: DataUiModel = DataUiModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    val report: report = uiState.reports[uiState.report]
    val painter = report.rep
    Box() {
        Image(painter = painterResource(R.drawable.bg),
            contentDescription = null,
            alpha = 0.8f,
            contentScale = ContentScale.Crop,
            )
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Brain Wave Report", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = stringResource(id = R.string.name, uiState.name))
            Text(text = stringResource(id = R.string.age, uiState.age))
            Text(text = stringResource(id = R.string.gender, uiState.gender))
            Text(text = stringResource(id = R.string.date, report.date))
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Brain Wave Activity")
            Graphs("Alpha", report.alpha)
            Graphs("Beta", report.beta)
            Graphs("Theta", report.theta)
            Graphs("Delta", report.delta)
            Text(text = stringResource(R.string.comment, report.comment))
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Brain Wave Analysis")
            Image(painter = painterResource(painter), contentDescription = null,
                modifier = Modifier.border(3.dp, Color.Gray))
        }
    }
}


@Composable
fun Graphs(
    text: String,
    num: Double,
    ) {
    val no: Float = (num/100).toFloat()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentAlignment = androidx.compose.ui.Alignment.CenterStart
    ) {
        Row() {
            Spacer(modifier = Modifier
                .weight(no)
                .height(28.dp)
                .background(Color.Gray))
            Spacer(modifier = Modifier
                .weight(1f - no)
                .height(28.dp))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            Text(text = text,
                modifier = Modifier.padding(start = 8.dp))
            Spacer(modifier = Modifier.weight(1f))
            Text(text = num.toString())
        }
    }
}