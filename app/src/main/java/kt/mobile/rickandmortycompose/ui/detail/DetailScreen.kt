package kt.mobile.rickandmortycompose.ui.detail

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import kt.mobile.rickandmortycompose.ui.MainViewModel
import kt.mobile.rickandmortycompose.ui.navigation.MainActions

@Composable
fun DetailScreen(viewModel: MainViewModel, actions: MainActions) {


    Scaffold(
        topBar = { DetailTopBar(actions = actions)},
        content = { DetailContentScreen(viewModel = viewModel)}
    )
}