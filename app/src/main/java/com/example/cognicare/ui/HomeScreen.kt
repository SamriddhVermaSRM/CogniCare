package com.example.cognicare.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cognicare.R
import com.example.cognicare.data.DataUiState
import com.example.cognicare.ui.theme.AppTheme


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewHomeScreen() {
    AppTheme {
        HomeScreen()
    }
}


@Composable
fun HomeScreen(
    viewModel: DataUiModel = DataUiModel(),
    onNavigate: () -> Unit = {},
) {
    val uiState by viewModel.uiState.collectAsState()

    Box() {
        Image(
            painter = painterResource(id = R.drawable.home_page),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
        )
        Column {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(uiState.dp),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shape = MaterialTheme.shapes.small),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(id = R.string.welcome_user, uiState.name),
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
            Spacer(modifier = Modifier.height(5.dp).background(Color.Black))
            Text(
                text = stringResource(id = R.string.your_reports),
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                fontSize = 20.sp,
                color = Color.White
            )
            Table(uiState, viewModel, onNavigate, uiState.indexOfUser)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Table(
    uiState: DataUiState,
    viewModel: DataUiModel,
    onNavigate: () -> Unit,
    user: Int
) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(uiState.reports.size) { index ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier.fillParentMaxWidth(0.5f),
                    border = BorderStroke(2.dp, Color.Black),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),

                    shape = CardDefaults.shape,
                    onClick = {
                        viewModel.setReportToIndex(index, user) {
                            onNavigate()
                        }
                    }
                ) {
                    Text(
                        text = uiState.reports[index].date,
                        modifier = Modifier
                            .padding(16.dp)
                            .fillParentMaxWidth(),
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
