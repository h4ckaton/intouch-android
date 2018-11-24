package hackyeah.com.hackyeah.ui

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.brotherhood.gramatyka.di.viewModelFactory.ViewModelFactory
import com.google.zxing.integration.android.IntentIntegrator
import hackyeah.com.hackyeah.R
import hackyeah.com.hackyeah.ui.qr.ScanActivity
import hackyeah.com.hackyeah.util.BaseActivity
import hackyeah.com.hackyeah.util.BaseApplication
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        BaseApplication.applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java)
        println(viewModel)
        button.setOnClickListener {
            startActivity(ScanActivity.prepareIntent(this))
        }

    }
}
