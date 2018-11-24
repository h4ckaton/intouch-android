package hackyeah.com.hackyeah.ui.qr

import android.Manifest
import android.os.Bundle
import hackyeah.com.hackyeah.util.BaseActivity
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.single.PermissionListener
import android.Manifest.permission
import android.content.Context
import android.content.Intent
import com.karumi.dexter.Dexter
import com.karumi.dexter.listener.PermissionRequest
import hackyeah.com.hackyeah.R
import kotlinx.android.synthetic.main.scan_activity.*
import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.BarcodeCallback
import hackyeah.com.hackyeah.ui.cardDetails.CardDetailsActivity


class ScanActivity : BaseActivity() {

    companion object {
        fun prepareIntent(context: Context): Intent {
            return Intent(context, ScanActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scan_activity)
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse) {
                        qrScanner.resume()
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse) {
                        finish()
                    }

                    override fun onPermissionRationaleShouldBeShown(permission: PermissionRequest, token: PermissionToken) {

                    }
                }).check()


        qrScanner.decodeContinuous(object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult) {
                validateQR(result)
            }

            override fun possibleResultPoints(resultPoints: List<ResultPoint>) {

            }
        })


    }

    private fun validateQR(result: BarcodeResult) {
        startActivity(CardDetailsActivity.prepareIntent(this, result))
    }

    override fun onPause() {
        super.onPause()
        qrScanner.pause()
    }
}