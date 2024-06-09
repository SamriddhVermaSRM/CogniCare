package com.example.cognicare.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.cognicare.data.DataSource
import com.example.cognicare.data.DataUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DataUiModel : ViewModel() {
    private val _uiState = MutableStateFlow(DataUiState())
    val uiState: StateFlow<DataUiState> = _uiState.asStateFlow()


    fun userLogin(username: String, password: String, onSuccessfulLogin: () -> Unit) {
        if (username.isNotEmpty() && password.isNotEmpty()) {
            val index = DataSource.usernames.indexOf(username.trim())
            if (index != -1 && DataSource.passwords[index] == password) {
                Log.d("hehe", "userLogin: loggedin $index")
                _uiState.value = DataUiState(user = DataSource.users[index], indexOfUser = index)
                onSuccessfulLogin()
            } else {
                Log.d("hehe", "userLogin: !loggedin $index")
                _uiState.value = DataUiState(error = true)
            }
        }
    }

    fun setReportToIndex(index: Int, user: Int, reportChangeNavigate: () -> Unit) {
        _uiState.value = DataUiState(
            user = DataSource.users[uiState.value.indexOfUser],
            indexOfUser = uiState.value.indexOfUser,
            report = index
        )
        Log.d("hehe", "report: $index")
        reportChangeNavigate()
    }
}