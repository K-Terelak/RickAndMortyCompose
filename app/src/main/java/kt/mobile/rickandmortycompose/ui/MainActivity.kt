package kt.mobile.rickandmortycompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import coil.annotation.ExperimentalCoilApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kt.mobile.rickandmortycompose.ui.navigation.NavGraph
import kt.mobile.rickandmortycompose.ui.theme.RickAndMortyComposeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalCoilApi
    @FlowPreview
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyComposeTheme {
                NavGraph()
            }
        }
    }
}
