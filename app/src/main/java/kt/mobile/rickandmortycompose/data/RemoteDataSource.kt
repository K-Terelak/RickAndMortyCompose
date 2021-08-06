package kt.mobile.rickandmortycompose.data

import kt.mobile.rickandmortycompose.model.CharacterResponse
import kt.mobile.rickandmortycompose.model.SingleCharacter
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val appService: AppService,
) {

    suspend fun getAllCharacters(page:Int):CharacterResponse{
        return appService.getAllCharacters(page)
    }

    suspend fun getCharacterById(characterId:Int):SingleCharacter{
        return appService.getCharacterId(characterId)
    }

}