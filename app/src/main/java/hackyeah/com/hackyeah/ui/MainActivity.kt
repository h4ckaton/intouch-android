package hackyeah.com.hackyeah.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.brotherhood.gramatyka.di.viewModelFactory.ViewModelFactory
import hackyeah.com.hackyeah.R
import hackyeah.com.hackyeah.ui.cardDetails.CardDetailsFragment
import hackyeah.com.hackyeah.ui.contacts.ContactsFragment
import hackyeah.com.hackyeah.ui.qr.ScanFragment
import hackyeah.com.hackyeah.util.BaseApplication
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : FragmentActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private var prevMenuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        BaseApplication.applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupWindowAnimations()
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.userCardDetails -> {
                    viewPager.currentItem = 0
                }
                R.id.scanner -> {
                    viewPager.currentItem = 1
                }
                R.id.something -> {
                    viewPager.currentItem = 2
                }
            }
            true
        }
        navigation.selectedItemId = R.id.scanner
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null)
                    prevMenuItem!!.isChecked = false
                else
                    navigation.menu.getItem(0).isChecked = false

                navigation.menu.getItem(position).isChecked = true
                prevMenuItem = navigation.menu.getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        setupPagerAdapter()
        viewPager.currentItem = 1
    }

    private fun setupPagerAdapter() {
        val adapter = MainPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
    }

    class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
        private val fragments = arrayListOf<Fragment>(CardDetailsFragment(), ScanFragment(), ContactsFragment())

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment? {
            return fragments[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return ""
        }
    }

    private fun setupWindowAnimations() {
        val slide = Slide()
        slide.duration = 1000
        window.exitTransition = slide
    }

    companion object {
        fun prepareIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
