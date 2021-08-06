package kt.mobile.rickandmortycompose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import kotlinx.coroutines.FlowPreview
import kt.mobile.rickandmortycompose.ui.MainViewModel
import kt.mobile.rickandmortycompose.ui.detail.DetailScreen
import kt.mobile.rickandmortycompose.ui.home.HomeScreen
import java.lang.IllegalStateException

@ExperimentalCoilApi
@FlowPreview
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {

        //home
        composable(route = Screen.MainScreen.route) {
            val viewModel: MainViewModel = viewModel(
                factory = HiltViewModelFactory(LocalContext.current, it)
            )
            HomeScreen(viewModel = viewModel, actions = actions)
        }

        //detail
        composable(
            route = "${Screen.DetailScreen.route}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val viewModel = hiltViewModel<MainViewModel>(it)
            val id = it.arguments?.getInt("id")
                ?: throw IllegalStateException("'Character ID' shouldn't be null")

            viewModel.getCharacterById(id)
            DetailScreen(viewModel = viewModel, actions = actions)
        }
    }

}

class MainActions(navController: NavController) {

    val upPress: () -> Unit = {
        navController.popBackStack()
    }

    val gotoDetails: (Int) -> Unit = { id ->
        navController.navigate("${Screen.DetailScreen.route}/$id")
    }

}