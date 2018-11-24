package hackyeah.com.hackyeah.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import hackyeah.com.hackyeah.R
import hackyeah.com.hackyeah.util.BaseActivity

class RegisterActivity : BaseActivity() {

    companion object {
        fun prepareIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
    }
}