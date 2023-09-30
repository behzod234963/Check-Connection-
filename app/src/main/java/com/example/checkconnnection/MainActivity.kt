package com.example.checkconnnection

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkConnection()

    }

    private fun checkConnection() {

        val checkConnection=CheckConnection()
        val intentFilter= IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)

        checkConnection.internetOff={

            Toast.makeText(this, "No Internet please check your connection", Toast.LENGTH_SHORT).show()
            
        }
        checkConnection.internetOn={

            Toast.makeText(this, "Internet is Working On", Toast.LENGTH_SHORT).show()

        }

        registerReceiver(

            checkConnection,
            intentFilter

        )

    }
}