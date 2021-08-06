package kt.mobile.rickandmortycompose.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kt.mobile.rickandmortycompose.R

@Composable
fun SnackbarRefresh(errorMessage: String, onRetryClick: () -> Unit) {
    Snackbar(
        backgroundColor = MaterialTheme.colors.onBackground,
        content = { Text(text = errorMessage, style = TextStyle(color = MaterialTheme.colors.onPrimary)) },
        shape = RoundedCornerShape(0.dp),
        action = {
            ClickableText(
                text = AnnotatedString(text = stringResource(R.string.refresh)),
                style = TextStyle(color = MaterialTheme.colors.onPrimary,fontWeight = FontWeight.Medium)
            ) {
                onRetryClick()
            }

        }
    )
}


@Preview
@Composable
fun SnackbarRefreshPreview() {
    SnackbarRefresh(errorMessage = "error message") {
    }
}