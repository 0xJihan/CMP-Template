package org.jihan.kmp


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        MainApp()

    }
}


@Composable
fun MainApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController,Screen.Home){
       composable<Screen.Home> { CenterBox("Home Screen"){ Button(onClick = {
           navController.navigate(Screen.About)
       }){ Text("Go To About Screen") } } }
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
fun CenterBox(text:String,content: @Composable () -> Unit = {}){

    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(text, style = MaterialTheme.typography.h4)
        Spacer(Modifier.height(10.dp))
        content()
    }



}