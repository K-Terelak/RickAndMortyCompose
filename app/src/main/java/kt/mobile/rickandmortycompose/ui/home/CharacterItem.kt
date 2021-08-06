package kt.mobile.rickandmortycompose.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import kt.mobile.rickandmortycompose.R
import kt.mobile.rickandmortycompose.model.SingleCharacter
import kt.mobile.rickandmortycompose.ui.components.ShowProgress
import kt.mobile.rickandmortycompose.ui.navigation.MainActions

@ExperimentalCoilApi
@Composable
fun CharacterItem(
    character: SingleCharacter?,
    actions: MainActions,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier
            .clickable { character?.let { actions.gotoDetails(it.id) } }
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.onBackground),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ItemImage(
            imageUrl = character?.image,
            modifier = Modifier
                .weight(1f)
                .aspectRatio(1f)
                .padding(4.dp)
        )

        ItemDetails(
            character = character,
            modifier = Modifier
                .weight(4f)
                .padding(horizontal = 16.dp)
        )
    }

}

@ExperimentalCoilApi
@Composable
fun ItemImage(
    imageUrl: String?,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.clip(MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center,
    ) {
        if (imageUrl == null) {
            ImagePlaceholder(modifier.matchParentSize())
        } else {
            val painter = rememberImagePainter(imageUrl)

            Image(
                painter = painter,
                contentDescription = stringResource(id = R.string.character_image),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
                    .clip(MaterialTheme.shapes.medium),
            )

            when (painter.state) {
                is ImagePainter.State.Loading -> {
                    ShowProgress()
                }
                is ImagePainter.State.Error -> ImagePlaceholder(modifier)
            }

        }
    }
}

@Composable
fun ImagePlaceholder(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.background(
            shape = MaterialTheme.shapes.medium,
            color = Color.Gray,
        ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.scale(1.5f)
        )
    }
}

@Composable
fun ItemDetails(
    character: SingleCharacter?,
    modifier: Modifier = Modifier,
) {
    Column(modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = character?.name ?: "",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                color = MaterialTheme.colors.onPrimary,
            )
            if (character?.status == "Alive" || character?.status == "Dead") {
                Icon(
                    painter = painterResource(id = R.drawable.ic_circle),
                    contentDescription = stringResource(R.string.status),
                    tint = if (character.status == "Alive") Color.Green else if (character.status == "Dead") Color.Red else Color.Transparent,
                    modifier = Modifier.size(16.dp)
                )
            }
        }


        Spacer(modifier = Modifier.width(16.dp))


        Text(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .alpha(0.8f),
            text = character?.location?.name ?: "",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp,
            color = MaterialTheme.colors.onPrimary,
            )


    }
}

