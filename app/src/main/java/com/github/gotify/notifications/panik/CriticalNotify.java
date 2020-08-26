package com.github.gotify.notifications.panik;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.github.gotify.notifications.panik.CBUtils.SmsCbCmasInfo;
import com.github.gotify.notifications.panik.CBUtils.SmsCbConstants;
import com.github.gotify.notifications.panik.CBUtils.SmsCbLocation;
import com.github.gotify.notifications.panik.CBUtils.SmsCbMessage;

public class CriticalNotify {

    public static int getSerialNumber() {
        int messageId = 0;
        int newMessageId = (messageId + 1) % 65536;
        return newMessageId;
    }

    public static SmsCbMessage createCmasSmsMessage(int serviceCategory, String body, int priority ) {
        int messageClass = CellBroadcastAlertService.getCmasMessageClass(serviceCategory);
        if (priority == 121){
            priority = SmsCbMessage.MESSAGE_PRIORITY_EMERGENCY;
        }
        SmsCbCmasInfo cmasInfo =
                new SmsCbCmasInfo(
                        messageClass,
                        SmsCbCmasInfo.CMAS_CATEGORY_INFRA,
                        SmsCbCmasInfo.CMAS_RESPONSE_TYPE_EXECUTE,
                        SmsCbCmasInfo.CMAS_SEVERITY_EXTREME,
                        SmsCbCmasInfo.CMAS_URGENCY_IMMEDIATE,
                        SmsCbCmasInfo.CMAS_CERTAINTY_OBSERVED );
        SmsCbMessage msg = new SmsCbMessage(SmsCbMessage.MESSAGE_FORMAT_3GPP,0, getSerialNumber(),new SmsCbLocation("1234"),serviceCategory, "en", body, priority,null, cmasInfo, 0,0);
        return msg;
    }

    public static void AlertCritical(int Priority, String Body, Context context, Boolean mute){
        onFire(new CellBroadcastAlertService(), context,  Priority, Body, SmsCbMessage.MESSAGE_PRIORITY_EMERGENCY, mute);
    }

    public static void onFire(CellBroadcastAlertService CBS, Context context,  int serviceCategory,  String body, int priority, Boolean mute) {
        Intent AlertIntent = new Intent(context, CellBroadcastAlertService.class);

        AlertIntent.putExtra(CellBroadcastAlertService.MUTE, mute);
        AlertIntent.putExtra(CellBroadcastAlertService.EXTRA_MESSAGE, createCmasSmsMessage(serviceCategory, body, priority));

        context.startService(AlertIntent);
    }

}
