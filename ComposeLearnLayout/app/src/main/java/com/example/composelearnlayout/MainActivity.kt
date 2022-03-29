package com.example.composelearnlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.composelearnlayout.ui.theme.*
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*ComposeLearnLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    PhotographerCard(Modifier)
                    //ScrollingList()
                }
            }*/
            // Step 3
            //PhotographerCard(Modifier)

            // Step 5
            //LayoutsCodelab()

            // Step 6
            //SimpleList()
            //LazyList()
            //ImageList()
            //ScrollingList()

            // Step 7, 8, 9
            //LayoutsCodelab()

            // Step 10
            //ConstraintLayoutContent()
            //ConstraintLayoutContentExample2()
            //LargeConstraintLayout()
            //DecoupledConstraintLayout()

            // Step 11
            TwoTexts(text1 = "Hi", text2 = "there")
        }
    }
}

/*@Composable
fun PhotographerCard() {
    Row {
       Surface(
           modifier = Modifier.size(50.dp),
           shape = CircleShape,
           color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
       ) {
           // Image goes here
       }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(text = "Alfred Sisley", fontWeight = FontWeight.Bold)
            // LocalContentAlpha is defining opacity level of its children

            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("3 minutes ago", style = MaterialTheme.typography.body2)
            }
        }
    }

}*/

/*@Composable
fun LayoutsCodelab() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "LayoutsCodelab")
                    },
                    actions = {
                        IconButton(onClick = { *//*TODO*//* }) {
                            Icon(Icons.Filled.Favorite, contentDescription = null)
                        }
                    }
                )
            }
        ) { innerPadding ->
            BodyContent(Modifier.padding(innerPadding))
        }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Hi there!")
        Text(text = "Thanks for going through the Layouts codelab")
    }
}*/

/*@Composable
fun SimpleList() {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberScrollState()
    
    Column(Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text(text = "Item #$it")
        }
    }
}

@Composable
fun LazyList() {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            Text(text = "Item #$it")
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
            data = "https://developer.android.com/images/brand/Android_Robot.png"
        ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text(text = "Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ImageList() {
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            ImageListItem(it)
        }
    }
}

@Composable
fun ScrollingList() {
    val listSize = 100
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(it)
            }
        }
    }
}*/

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeLearnLayoutTheme {
        PhotographerCard()
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutsCodelabPreview() {
    ComposeLearnLayoutTheme {
        LayoutsCodelab()
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleListPreview() {
    ComposeLearnLayoutTheme {
        SimpleList()
    }
}

@Preview(showBackground = true)
@Composable
fun ImageListPreview() {
    ComposeLearnLayoutTheme {
        ImageList()
    }
}

@Preview(showBackground = true)
@Composable
fun ScrollingListPreview() {
    ComposeLearnLayoutTheme {
        ScrollingList()
    }
}