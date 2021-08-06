package kt.mobile.rickandmortycompose.usecase

import kt.mobile.rickandmortycompose.data.AppGateway
import kt.mobile.rickandmortycompose.model.CharacterResponse
import javax.inject.Inject

class GetAllCharactersUseCase @Inject constructor(
    private val appGateway: AppGateway
){

    suspend operator fun invoke(page:Int):CharacterResponse{
        return appGateway.getAllCharacters(page)
    }
}