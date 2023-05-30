package com.alamin.localnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun showNotification(view: View) {
        val notificationService = NotificationService(this)
        notificationService.showNotification(Counter.value)
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
    }
}