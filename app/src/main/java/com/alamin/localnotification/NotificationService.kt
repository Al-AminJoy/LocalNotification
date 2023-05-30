package com.alamin.localnotification

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

class NotificationService(val context: Context) {

    companion object{
        const val CHANNEL_ID = "channel_id"
    }

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter:Int){

        val intent = Intent(context,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context,1,intent,PendingIntent.FLAG_IMMUTABLE)

        val notificationIntent = PendingIntent.getBroadcast(context,2,
            Intent(context,CounterNotificationReceiver::class.java),PendingIntent.FLAG_IMMUTABLE)

        val notification = Notification.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_bolt)
            .setContentTitle("Increment Counter")
            .setContentText("Increment value is $counter")
            .setContentIntent(pendingIntent)
            .addAction(R.drawable.ic_bolt,"Increment",notificationIntent)
            .build()

        notificationManager.notify(1,notification)

    }

}