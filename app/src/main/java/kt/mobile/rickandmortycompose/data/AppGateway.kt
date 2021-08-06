package kt.mobile.rickandmortycompose.data

import kt.mobile.rickandmortycompose.model.CharacterResponse
import kt.mobile.rickandmortycompose.model.SingleCharacter

interface AppGateway {

    suspend fun getAllCharacters(page:Int):CharacterResponse
    suspend fun getCharacterById(characterId:Int):SingleCharacter
}