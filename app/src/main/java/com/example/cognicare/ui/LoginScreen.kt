package com.example.cognicare.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cognicare.R
import com.example.cognicare.ui.theme.AppTheme

@Preview(showBackground = true, backgroundColor = 0xFFA02525)
@Composable
fun CogniPreview() {
    AppTheme {
        LoginScreen()
    }
}

@Composable
fun LoginScreen(
    viewModel: DataUiModel = DataUiModel(),
    onSuccessfulLogin: () -> Unit = {}
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsState()

    AppTheme {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.green_organic_quote_poster
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background, MaterialTheme.shapes.medium)
            ) {
                TextField(
                    label = "Username",
                    value = username,
                    onValueChange = { username = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    error = uiState.error,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    )
                )
                TextField(
                    label = "Password",
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    error = uiState.error,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    onDone = { viewModel.userLogin(username, password, onSuccessfulLogin) },
                    pass = true,
                )
                Button(
                    onClick = { viewModel.userLogin(username, password, onSuccessfulLogin) },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "Login")
                }
            }
        }
    }
}


@Composable
fun TextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    error: Boolean = false,
    keyboardOptions: KeyboardOptions,
    onDone: () -> Unit = {},
    pass: Boolean = false,
) {
    var showPassword by remember { mutableStateOf(false) }
    if (!pass)
        showPassword = true
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = MaterialTheme.colorScheme.onBackground) },
        trailingIcon = {
            if (pass) {
                Image(
                    painter = painterResource(id = if (showPassword) R.drawable.hidden else R.drawable.visible),
                    contentDescription = "Password visibility",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(size = 20.dp)
                        .clickable { showPassword = !showPassword }
                )
            }
        },
        modifier = modifier,
        isError = error,
        singleLine = true,
        visualTransformation = if (showPassword)
            VisualTransformation.None
        else PasswordVisualTransformation(),
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions(
            onDone = { onDone() }),

        )
}
