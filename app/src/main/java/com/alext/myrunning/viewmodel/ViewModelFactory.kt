import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alext.myrunning.navigation.Navigator
import com.alext.myrunning.navigation.coordinators.RootFlowCoordinator
import com.alext.myrunning.navigation.coordinators.RunSplitsCoordinator
import com.alext.myrunning.viewmodel.RunSplitsViewModel


class AppViewModelFactory(application: Application) : ViewModelProvider.Factory {

    val navigator = Navigator()

    val rootCoordinator = RootFlowCoordinator()
    private val runSplitsCoordinator = RunSplitsCoordinator(navigator = navigator)

    init {
        rootCoordinator.runSplitsCoordinator = runSplitsCoordinator
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
        RunSplitsViewModel::class.java -> RunSplitsViewModel()
        else -> throw IllegalArgumentException("No ViewModel registered for $modelClass") as Throwable
    } as T
}

