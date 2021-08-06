package kt.mobile.rickandmortycompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShowProgress() {
    LinearProgressIndicator(modifier = Modifier.fillMaxWidth(),color = Color.Red)
}

@Preview
@Composable
fun ShowProgressPreview() {
    ShowProgress()
}