package com.example.gariboy.service;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Telephony;
import android.telephony.SmsMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SASi on 22-Dec-15.
 */
public class SMSListener extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(SMS_RECEIVED)) {
            Bundle bundle = intent.getExtras();

            String senderNumber = "";
            String messageBody = "";
            String date = "";

            if (bundle != null) {

                SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

                for (int i = 0; i < messages.length; i++) {
                    SmsMessage message = messages[i];
                    senderNumber = message.getDisplayOriginatingAddress();

                    if(senderNumber.equals("6505551212")){

                        //Code to make vibrate the phone
                        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                        long[] pattern = {0, 100, 1000};
                        //deprecated in API 26
                        v.vibrate(pattern,0);

                        //Code to make the phone make sounds
                        try {
                            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                            Ringtone r = RingtoneManager.getRingtone(context, notification);
                            r.play();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Intent startIntent = context
                                .getPackageManager()
                                .getLaunchIntentForPackage(context.getPackageName());

                        startIntent.putExtra("state","1");
                        startIntent.setFlags(
                                Intent.FLAG_ACTIVITY_REORDER_TO_FRONT |
                                        Intent.FLAG_ACTIVITY_NEW_TASK |
                                        Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
                        );
                        context.startActivity(startIntent);



                    }
                }

            }



        }
    }

    private String getDate(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy hh:mm a");
            Date date = new Date(time);
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
