package hackyeah.com.hackyeah.util

import android.view.View
import android.view.View.*

fun View.gone() {
    visibility = GONE
}

fun View.visible() {
    visibility = VISIBLE
}

fun View.invisible() {
    visibility = INVISIBLE
}