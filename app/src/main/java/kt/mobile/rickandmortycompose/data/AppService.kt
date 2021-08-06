package kt.mobile.rickandmortycompose.data

import kt.mobile.rickandmortycompose.model.CharacterResponse
import kt.mobile.rickandmortycompose.model.SingleCharacter
import kt.mobile.rickandmortycompose.util.Constants.CHARACTERS_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AppService {

    @GET(CHARACTERS_ENDPOINT)
    suspend fun getAllCharacters(
        @Query("page")
        page: Int?,
    ): CharacterResponse

    @GET("api/character/{id}")
    suspend fun getCharacterId(
        @Path("id")
        id: Int
    ): SingleCharacter
}