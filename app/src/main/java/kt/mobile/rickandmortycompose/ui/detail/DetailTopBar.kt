package kt.mobile.rickandmortycompose.ui.detail

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import kt.mobile.rickandmortycompose.ui.navigation.MainActions

@Composable
fun DetailTopBar(actions: MainActions) {

    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = { actions.upPress() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow back.")
            }
        },
        title = {}
    )

}