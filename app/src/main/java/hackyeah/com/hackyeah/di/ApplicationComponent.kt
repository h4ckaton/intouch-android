package hackyeah.com.hackyeah.di

import com.brotherhood.gramatyka.di.modules.ApplicationModule
import com.brotherhood.gramatyka.di.modules.NetworkModule
import dagger.Component
import hackyeah.com.hackyeah.ui.MainActivity
import hackyeah.com.hackyeah.ui.qr.ScanFragment
import hackyeah.com.hackyeah.util.BaseApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: ScanFragment)
    fun baseApplication(): BaseApplication
}