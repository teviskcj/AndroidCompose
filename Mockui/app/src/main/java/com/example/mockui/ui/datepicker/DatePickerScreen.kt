package com.example.mockui.ui.datepicker

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mockui.ui.components.rippleClickable

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DatePickerScreen() {
    val viewModel: DatePickerViewModel = viewModel()
    val date = viewModel.date
    // Fetching the Local Context
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .border(0.5.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
                    .rippleClickable { viewModel.selectDateTime(context) }
            ) {
                Text(
                    text = date.value,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterStart)
                )

                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(20.dp, 20.dp)
                        .align(Alignment.CenterEnd),
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            Text(
                text = viewModel.constellation.value,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }

}
