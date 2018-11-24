package hackyeah.com.hackyeah.ui.qr

import android.Manifest
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brotherhood.gramatyka.di.viewModelFactory.ViewModelFactory
import com.google.zxing.BarcodeFormat
import com.google.zxing.ResultPoint
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.journeyapps.barcodescanner.BarcodeResult
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import hackyeah.com.hackyeah.R
import hackyeah.com.hackyeah.util.BaseApplication
import hackyeah.com.hackyeah.util.BaseFragment
import hackyeah.com.hackyeah.util.gone
import kotlinx.android.synthetic.main.scan_activity.*
import javax.inject.Inject


class ScanFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.scan_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Dexter.withActivity(context as Activity)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(object : PermissionListener {
                    override fun onPermissionGranted(response: PermissionGrantedResponse) {
                        qrScanner.resume()
                    }

                    override fun onPermissionDenied(response: PermissionDeniedResponse) {
                        qrScanner.pause()
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
        qrScanner.viewFinder.gone()
        qrScanner.setStatusText(getString(R.string.scan_info))

        try {
            val barcodeEncoder = BarcodeEncoder()
            val bitmap = barcodeEncoder.encodeBitmap("content", BarcodeFormat.QR_CODE, 800, 800)//TODO content from sharedprefs - user identificator
            qrCode.setImageBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        BaseApplication.applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    private fun validateQR(result: BarcodeResult) {
        //startActivity(CardDetailsFragment.prepareIntent(context!!, result))
    }

    override fun onPause() {
        super.onPause()
        qrScanner.pause()
    }
}