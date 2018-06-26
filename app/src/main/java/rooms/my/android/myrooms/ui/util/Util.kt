package rooms.my.android.myrooms.ui.util

import android.app.Activity
import android.content.Context
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager



class Util(activity: Activity){

    var activity: Activity = activity

    open fun isNetworkOnline(): Boolean {
        val cm = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        if (activeNetwork != null)
            return true
        else
            return false
    }
}