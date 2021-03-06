package com.hu.qiucheng.robredpackage.services;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import com.hu.qiucheng.robredpackage.jobs.WeChatAccessibilityJob;


/**
 * Created by Leo on 16/6/13.
 */
public class MyAccessibilityService extends AccessibilityService{
    final  String TAG="MyAcessibilityService";
    @Override
    public void onCreate() {
        WeChatAccessibilityJob.setService(this);
        MyNotificationService.setService(this);
        super.onCreate();
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d(TAG, "事件--->" + event+"----"+WeChatAccessibilityJob.step);
        new WeChatAccessibilityJob().onReceiveJob(event);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
