package dev.johnoreilly.paddingtest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold(bottomBar = { BottomBar() }) {

            // this padding here seems to cause the issue
            Column(Modifier.padding(it)) {

                // "nested" Scaffold with top app bar
                // (normally in some nested composable)
                Scaffold(
                    topBar = { CenterAlignedTopAppBar(
                        title = { Text("Some title") },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                        )
                    )}
                ) {
                    Column(Modifier.padding(it)) {
                        LazyColumn {
                            items(50) { index ->
                                Text(text = "Item: ${index+1}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun BottomBar() {
    NavigationBar{
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "",) },
            label = { Text("Option 1") },
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "",) },
            label = { Text("Option 2") },
        )
    }
}