package kt.mobile.rickandmortycompose.data

import kt.mobile.rickandmortycompose.model.CharacterResponse
import kt.mobile.rickandmortycompose.model.SingleCharacter
import javax.inject.Inject


class AppRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : AppGateway {


    override suspend fun getAllCharacters(page: Int): CharacterResponse {
        return remoteDataSource.getAllCharacters(page)
    }

    override suspend fun getCharacterById(characterId: Int): SingleCharacter {
        return remoteDataSource.getCharacterById(characterId)
    }
}