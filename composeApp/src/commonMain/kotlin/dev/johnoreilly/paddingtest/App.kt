package dev.johnoreilly.paddingtest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        Scaffold(
            // have bottom bar here for example but same behaviour
            // regardless
        ) {
            // this padding here seems to cause the issue
            Column(Modifier.padding(it)) {

                // "nested" Scaffold with top app bar
                // (normally in some nexted composable)
                Scaffold(
                    topBar = { TopAppBar(title = { Text("Some title") }) }
                ) {
                    Column(Modifier.padding()) {
                        Text("Hi")
                        Text("there")
                    }
                }
            }
        }
    }
}