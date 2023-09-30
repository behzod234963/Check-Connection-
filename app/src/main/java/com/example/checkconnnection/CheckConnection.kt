package com.example.checkconnnection

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class CheckConnection:BroadcastReceiver() {

    var internetOn:(()->Unit)?=null
    var internetOff:(()->Unit)?=null

    override fun onReceive(context: Context?, intent: Intent?) {

        if (isConnect(context!!)){

            internetOn!!.invoke()

        }else{

            internetOff!!.invoke()

        }

    }

    private fun isConnect(context: Context): Boolean {

        val connecManager=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork=connecManager.activeNetworkInfo
        return activeNetwork !=null && activeNetwork.isConnectedOrConnecting

    }

}