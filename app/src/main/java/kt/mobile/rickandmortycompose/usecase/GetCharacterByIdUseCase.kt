package kt.mobile.rickandmortycompose.usecase

import kt.mobile.rickandmortycompose.data.AppGateway
import kt.mobile.rickandmortycompose.model.SingleCharacter
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val appGateway: AppGateway,
) {

    suspend operator fun invoke(characterId: Int): SingleCharacter {
        return appGateway.getCharacterById(characterId)
    }
}