package hackyeah.com.hackyeah.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {
    var liveData: MutableLiveData<Int> = MutableLiveData()
}