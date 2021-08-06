package kt.mobile.rickandmortycompose.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import kt.mobile.rickandmortycompose.R
import kt.mobile.rickandmortycompose.model.SingleCharacter
import kt.mobile.rickandmortycompose.ui.MainViewModel
import kt.mobile.rickandmortycompose.ui.components.ShowError
import kt.mobile.rickandmortycompose.ui.components.ShowProgress
import kt.mobile.rickandmortycompose.util.ViewState

@Composable
fun DetailContentScreen(viewModel: MainViewModel) {

    when (val characterDetail = viewModel.characterDetails.collectAsState().value) {
        is ViewState.Loading -> {
            ShowProgress()

        }
        is ViewState.Success -> {
            Box(modifier = Modifier.background(MaterialTheme.colors.surface)) {
                ShowDetails(characterDetail.data)
            }
        }
        is ViewState.Error -> {
            ShowError()
        }
    }


}

@Composable
fun ShowDetails(character: SingleCharacter) {
    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Image(
            painter = rememberImagePainter(
                data = character.image
            ),
            contentDescription = stringResource(R.string.character_image),
            modifier = Modifier
                .size(240.dp)
                .padding(24.dp)
                .clip(RoundedCornerShape(8.dp)),
        )


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .clip(shape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                .background(MaterialTheme.colors.onBackground)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .background(MaterialTheme.colors.onBackground)
                    .fillMaxSize()
            ) {

                Text(
                    text = character.name ?: "",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onPrimary,
                )

                Spacer(modifier = Modifier.height(12.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .background(MaterialTheme.colors.onBackground)
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {



                    CharacterDetail(data = stringResource(R.string.gender), status = character.gender)

                    Spacer(modifier = Modifier.height(16.dp))

                    CharacterDetail(data = stringResource(R.string.species), status = character.species)

                    Spacer(modifier = Modifier.height(16.dp))

                    CharacterDetail(data = stringResource(R.string.type), status = character.type)

                    Spacer(modifier = Modifier.height(16.dp))

                    CharacterDetail(data = stringResource(R.string.location), status = character.location?.name)

                    Spacer(modifier = Modifier.height(16.dp))

                    CharacterDetail(data = stringResource(R.string.origin_name), status = character.origin?.name)

                    Spacer(modifier = Modifier.height(16.dp))

                }
            }
        }

    }

}


@Composable
fun CharacterDetail(data: String, status: String?) {


    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = data,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            modifier = Modifier.alpha(0.8f),
            color = MaterialTheme.colors.onPrimary,
        )
        Spacer(modifier = Modifier.padding(2.dp))
        Text(
            text = if (status.isNullOrEmpty()) stringResource(R.string.unknown) else status,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            color = MaterialTheme.colors.onPrimary,
        )
    }
}
