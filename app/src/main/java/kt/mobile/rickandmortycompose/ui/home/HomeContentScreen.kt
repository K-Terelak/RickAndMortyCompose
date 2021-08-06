package kt.mobile.rickandmortycompose.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import kotlinx.coroutines.FlowPreview
import kt.mobile.rickandmortycompose.ui.MainViewModel
import kt.mobile.rickandmortycompose.ui.components.ShowProgress
import kt.mobile.rickandmortycompose.ui.components.SnackbarRefresh
import kt.mobile.rickandmortycompose.ui.navigation.MainActions

@ExperimentalCoilApi
@FlowPreview
@Composable
fun HomeContentScreen(viewModel: MainViewModel, actions: MainActions) {


    val characters = viewModel.charactersList.collectAsLazyPagingItems()

    LazyColumn(Modifier.background(MaterialTheme.colors.surface)) {
        items(characters) { character ->
            CharacterItem(character = character, actions = actions)
        }

        characters.apply {
            when {
                loadState.refresh is LoadState.Loading -> item {
                    ShowProgress()

                }
                loadState.append is LoadState.Loading -> item {
                    ShowProgress()
                }
                loadState.refresh is LoadState.Error -> item {
                    val error = characters.loadState.refresh as LoadState.Error
                    SnackbarRefresh(
                        errorMessage = error.error.message.toString()
                    ) { retry() }
                }
                loadState.append is LoadState.Error -> item {
                    val error = characters.loadState.refresh as LoadState.Error
                    SnackbarRefresh(
                        errorMessage = error.error.message.toString()
                    ) { retry() }

                }
            }
        }

    }

}

