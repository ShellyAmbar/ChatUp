package com.shelly.ambar.chatup.Service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.shelly.ambar.chatup.AllChatsActivity;
import com.shelly.ambar.chatup.MainActivity;
import com.shelly.ambar.chatup.R;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "Android News App";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //It is optional
        Log.e(TAG, "From: " + remoteMessage.getFrom());
        Log.e(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());

        //Calling method to generate notification
        sendNotification(remoteMessage.getNotification().getTitle()
                , remoteMessage.getNotification().getBody()
                ,remoteMessage.getNotification().getClickAction(),
                remoteMessage.getData().get("message")
                ,remoteMessage.getData().get("from_user_id"));
    }

    //This method is only generating push notification
    private void sendNotification(String title, String messageBody,String clickAction
            ,String dataMessage, String dataFrom) {
        Intent intent = new Intent(clickAction);
        intent.putExtra("message",dataMessage);
        intent.putExtra("from_user_id", dataFrom);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this,getString(R.string.default_notification_channel_id))
                .setSmallIcon(R.mipmap.ic_launcher_logo)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);




        int notificationId=(int)System.currentTimeMillis();

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notificationId, notificationBuilder.build());
    }

}
