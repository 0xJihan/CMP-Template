package org.jihan.kmp


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable


@Composable
fun App() {
    MaterialTheme {


        MainApp()

    }
}


@Composable
fun MainApp() {
    val navController = rememberNavController()

    NavHost(navController, Screen.Home) {
        composable<Screen.Home> {
            CenterBox("Home Screen") {
                Button(onClick = {
                    navController.navigate(Screen.About)
                }) { Text("Go To About Screen") }
            }
        }
        composable<Screen.About> { CenterBox("About Screen") }
    }

}


sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data object About : Screen
}

@Composable
fun CenterBox(text: String, content: @Composable () -> Unit = {}) {

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text, style = MaterialTheme.typography.h4)
        Spacer(Modifier.height(10.dp))
        content()
    }


}