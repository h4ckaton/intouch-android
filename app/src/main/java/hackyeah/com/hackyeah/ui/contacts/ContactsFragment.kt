package hackyeah.com.hackyeah.ui.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hackyeah.com.hackyeah.R
import hackyeah.com.hackyeah.util.BaseFragment

class ContactsFragment : BaseFragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.contacts_fragment, container, false)
    }

}