package hackyeah.com.hackyeah.ui.login

import android.os.Bundle
import android.view.Window
import hackyeah.com.hackyeah.R
import hackyeah.com.hackyeah.ui.MainActivity
import hackyeah.com.hackyeah.ui.register.RegisterActivity
import hackyeah.com.hackyeah.util.BaseActivity
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        supportActionBar?.hide()
        setContentView(R.layout.login_activity)

        loginButton.setOnClickListener {
            startActivity(MainActivity.prepareIntent(this))
        }
        registerLink.setOnClickListener {
            startActivity(RegisterActivity.prepareIntent(this))
        }
    }
}