package app.bidar.basicscodelab

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.bidar.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Greetings()
}

@Composable
fun Greetings(
    names: List<String> = listOf("World", "Earth")
) {
    Surface(
        modifier = Modifier.padding(vertical = 4.dp),
        color = MaterialTheme.colors.background
    ) {
        Column {
            for (name in names) {
                Greeting(name = name)
            }
        }

    }
}

@Composable
fun Greeting(name: String) {

    var more by remember { mutableStateOf(false)}

    val width = if (more) 48.dp else 0.dp

    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {


        Row(modifier = Modifier.padding(24.dp)) {

            Column(modifier = Modifier.weight(1f).padding(bottom = width)) {
                Text(text = "Hello, ")
                Text(text = "$name!")
            }

            OutlinedButton(onClick = { more = !more }) {
//                    if (more) Text(text = "Show More") else Text(text = "Show less")
                Text(if (more) "Show less" else "Show more")
            }
        }

    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}



