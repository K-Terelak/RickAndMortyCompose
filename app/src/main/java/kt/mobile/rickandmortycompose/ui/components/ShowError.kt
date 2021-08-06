package kt.mobile.rickandmortycompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kt.mobile.rickandmortycompose.R

@Composable
fun ShowError() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = stringResource(R.string.something_went_wrong), fontSize = 16.sp, modifier = Modifier
                    .alpha(0.65f),
                color = MaterialTheme.colors.onPrimary
            )

            Spacer(modifier = Modifier.padding(12.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_error),
                modifier = Modifier
                    .size(64.dp)
                    .alpha(0.6f),
                contentDescription = stringResource(R.string.error_image),
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Preview
@Composable
fun ShowErrorPreview() {
    ShowError()
}