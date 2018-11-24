package hackyeah.com.hackyeah.ui.cardDetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.journeyapps.barcodescanner.BarcodeResult
import hackyeah.com.hackyeah.R
import hackyeah.com.hackyeah.util.BaseActivity

class CardDetailsActivity : BaseActivity() {
    private lateinit var qrValue: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.card_details_activity)
        loadIntentData()

    }

    private fun loadIntentData() {
        qrValue = intent.getStringExtra(QR_VALUE)
    }

    companion object {
        private const val QR_VALUE = "QR_VALUE"

        fun prepareIntent(context: Context, barCodeResult: BarcodeResult): Intent {
            val intent = Intent(context, CardDetailsActivity::class.java)
            intent.putExtra(QR_VALUE, barCodeResult.text)
            return intent
        }
    }
}