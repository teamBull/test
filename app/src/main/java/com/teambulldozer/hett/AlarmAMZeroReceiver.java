package com.teambulldozer.hett;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by GHKwon on 2016-02-27.
 */
public class AlarmAMZeroReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context,Intent intent) {
        //여따가 12시 되면 해야될 것들 작성해라.
        double todayPoint;
        double totalPoint;
        EventTableController eventTableControllerr;
        FriendDataManager friendDataManager;

        eventTableControllerr = EventTableController.get(context);
        friendDataManager = FriendDataManager.get(context);

        if(eventTableControllerr.numOfEntries() == 0){
            todayPoint = 0;
        }else {
            todayPoint = (float) eventTableControllerr.getCompletedDataSize() / eventTableControllerr.numOfEntries();
        }
        friendDataManager.updateTodayPoint(1, todayPoint);
        //FriendDatamanager에서 점수 불러옥 오늘 점수를 더해준 후 없뎃
        totalPoint = friendDataManager.getTotalPoint()+todayPoint;
        friendDataManager.updateTotalPoint(1, totalPoint);


    }
}
