package kt.mobile.rickandmortycompose.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kt.mobile.rickandmortycompose.model.SingleCharacter
import kt.mobile.rickandmortycompose.ui.home.GetAllCharactersPagingSource
import kt.mobile.rickandmortycompose.usecase.GetAllCharactersUseCase
import kt.mobile.rickandmortycompose.usecase.GetCharacterByIdUseCase
import kt.mobile.rickandmortycompose.util.ViewState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase,
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    var charactersList: Flow<PagingData<SingleCharacter>> = getAllCharacters()

    private val _characterDetails = MutableStateFlow<ViewState>(ViewState.Loading)
    val characterDetails: StateFlow<ViewState> = _characterDetails


    // get all characters
    private fun getAllCharacters(): Flow<PagingData<SingleCharacter>> {

        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { GetAllCharactersPagingSource(getAllCharactersUseCase) },
        ).flow.cachedIn(viewModelScope)
    }

    //get character by ID
    fun getCharacterById(characterId: Int) {
        viewModelScope.launch {
            try {
                _characterDetails.value = ViewState.Success(getCharacterByIdUseCase(characterId))
            } catch (e: Exception) {
                _characterDetails.value = ViewState.Error(e)
            }
        }
    }


}