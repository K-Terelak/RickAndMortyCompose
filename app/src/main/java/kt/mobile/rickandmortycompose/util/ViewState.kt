package kt.mobile.rickandmortycompose.util

import kt.mobile.rickandmortycompose.model.SingleCharacter

sealed class ViewState {
    object Empty: ViewState()
    object Loading : ViewState()
    data class Success(val data: SingleCharacter) : ViewState()
    data class Error(val exception: Throwable) : ViewState()
}
