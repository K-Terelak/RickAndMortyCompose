package kt.mobile.rickandmortycompose.model


import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val singleCharacter: List<SingleCharacter>
)