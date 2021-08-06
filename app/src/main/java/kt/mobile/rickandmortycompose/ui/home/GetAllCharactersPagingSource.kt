package kt.mobile.rickandmortycompose.ui.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kt.mobile.rickandmortycompose.model.SingleCharacter
import kt.mobile.rickandmortycompose.usecase.GetAllCharactersUseCase
import retrofit2.HttpException
import javax.inject.Inject

private const val STARTING_PAGE_INDEX = 1

class GetAllCharactersPagingSource @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : PagingSource<Int, SingleCharacter>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SingleCharacter> {

        return try {
            val page = params.key ?: STARTING_PAGE_INDEX
            val appResponse = getAllCharactersUseCase(page)

            LoadResult.Page(
                data = appResponse.singleCharacter,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (page == appResponse.info.pages || appResponse.info.pages == 0) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(Throwable(message = "Check internet connection."))
        } catch (e: HttpException) {
            LoadResult.Error(Throwable(message = "Error: ${e.code()}"))
        }
    }

    override fun getRefreshKey(state: PagingState<Int, SingleCharacter>): Int? {
        return state.anchorPosition
    }
}