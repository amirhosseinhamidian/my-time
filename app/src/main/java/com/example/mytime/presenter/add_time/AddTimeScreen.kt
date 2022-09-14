package com.example.mytime.presenter.add_time

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mytime.domain.model.Icon
import com.example.mytime.util.IconData

@Composable
fun AddTimeScreen(
    navHostController: NavHostController,
    viewModel: AddTimeViewModel = hiltViewModel()
) {
    val title by viewModel.title.observeAsState()
    var selectedIconId by remember { mutableStateOf(-1) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        navHostController.popBackStack()
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Add Task",
                    style = MaterialTheme.typography.h6
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colors.surface
            ) {
                TextField(
                    value = title ?: "",
                    onValueChange = viewModel::onTitleChange,
                    label = { Text(text = "Title") },
                    textStyle = MaterialTheme.typography.h5,
                    modifier = Modifier.background(Color.Transparent)
                )
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colors.surface
            ) {
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(4),
                    modifier = Modifier.height(260.dp)
                ) {
                    items(IconData.getData().size) { i ->
                        val icon = IconData.getData()[i]
                        IconItem(
                            icon = icon,
                            selected = icon.id == selectedIconId
                        ) {
                            viewModel.selectIcon(it)
                            selectedIconId = it.id!!
                        }
                    }
                }
            }
        }

        Button(
            onClick = {
                viewModel.saveTask()
                navHostController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondaryVariant),
        ) {
            Text(
                text = "LET'S GO",
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(6.dp)
            )
        }
    }
}

@Composable
fun IconItem(
    icon: Icon,
    selected: Boolean,
    onClick: (Icon) -> Unit
) {
    Box(
        modifier = Modifier
            .height(64.dp)
            .width(64.dp)
    ) {
        Icon(
            painter = painterResource(icon.iconRes!!),
            contentDescription = "icon",
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .clickable { onClick(icon) }
        )
        if (selected) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "check",
                tint = MaterialTheme.colors.secondaryVariant,
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}