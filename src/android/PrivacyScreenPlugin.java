/**
 * PrivacyScreenPlugin.java Cordova Plugin Implementation
 * Created by Tommy-Carlos Williams on 18/07/14.
 * Copyright (c) 2014 Tommy-Carlos Williams. All rights reserved.
 * MIT Licensed
 */
package org.devgeeks.privacyscreen;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.os.Build;

/**
 * This class sets the FLAG_SECURE flag on the window to make the app
 *  private when shown in the task switcher
 */
public class PrivacyScreenPlugin extends CordovaPlugin {

  private void activate() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
      final Activity activity = this.cordova.getActivity();
      new Thread(new Runnable() {
        @Override
        public void run() {
          activity.runOnUiThread(new Runnable(){
            @Override
            public void run() {
              activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
            }
          });
        }
      }).start();
    }
  }

  private void deactivate() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
      final Activity activity = this.cordova.getActivity();
      new Thread(new Runnable() {
        @Override
        public void run() {
          activity.runOnUiThread(new Runnable(){
            @Override
            public void run() {
              activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
            }
          });
        }
      }).start();
    }
  }

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    this.activate();
  }

  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if ("activate".equals(action)) {
      this.activate();
    } else if("deactivate".equals(action)) {
      this.deactivate();
    } else {
      return false;
    }
    return true;
  }
}
