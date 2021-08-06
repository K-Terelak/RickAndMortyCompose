package kt.mobile.rickandmortycompose.ui.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi
import kotlinx.coroutines.FlowPreview
import kt.mobile.rickandmortycompose.ui.MainViewModel
import kt.mobile.rickandmortycompose.ui.navigation.MainActions

@ExperimentalCoilApi
@FlowPreview
@Composable
fun HomeScreen(viewModel: MainViewModel, actions: MainActions) {

    Scaffold(
        content = {
            HomeContentScreen(viewModel = viewModel, actions = actions)
        },
    )
}
