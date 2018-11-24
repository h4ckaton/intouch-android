package hackyeah.com.hackyeah.util

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.brotherhood.gramatyka.di.modules.ApplicationModule
import com.brotherhood.gramatyka.di.modules.NetworkModule
import hackyeah.com.hackyeah.di.ApplicationComponent
import hackyeah.com.hackyeah.di.DaggerApplicationComponent

class BaseApplication : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .networkModule(NetworkModule())
                .build()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}