package org.godotengine.godot;
import android.app.Activity;
import android.util.Log;
import com.smartlook.android.core.api.Smartlook;
import com.smartlook.android.core.api.enumeration.Status;

public class SmartlookPlugin extends Godot.SingletonBase {

  private Activity activity;
  private Smartlook smartlook;
  private String SDK_KEY = "YOUR_KEY";

  static public Godot.SingletonBase initialize(Activity p_activity) {
		return new SmartlookPlugin(p_activity);
	}

	public SmartlookPlugin(Activity p_activity) {
		registerClass("SmartlookPlugin", new String[]{
      "init",
      "startRecord"
    });
		this.activity = p_activity;
	}

  public void init() {
    activity.runOnUiThread(new Runnable() {
      @Override
      public void run() {
        if (smartlook == null) {
          Log.i("godot", "Smartlook Init Successfully");
          smartlook = Smartlook.getInstance();
          smartlook.getPreferences().setProjectKey(SDK_KEY);
          smartlook.getPreferences().setSurfaceRecordingEnabled(true);
          smartlook.getPreferences().setAdaptiveFrameRateEnabled(false);
        }
      }
    });
  }

  public void startRecord() {
    activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
        if (smartlook != null) {
          Status status = smartlook.getState().getStatus();

          if (status instanceof Status.NotRecording) {
            switch (((Status.NotRecording) status).getCause()) {
              case NOT_STARTED:
                Log.i("godot", "Smartlook Record Start");
                smartlook.start();
                break;
              case STOPPED:
                Log.i("godot", "Smartlook Record STOPPED");
                break;
              case PROJECT_LIMIT_REACHED:
                Log.i("godot", "Smartlook Record PROJECT_LIMIT_REACHED");
                break;
              case STORAGE_LIMIT_REACHED:
                Log.i("godot", "Smartlook Record STORAGE_LIMIT_REACHED");
                break;
              case INTERNAL_ERROR:
                Log.i("godot", "Smartlook Record INTERNAL_ERROR");
                break;
            }
          }
        }
      }
    });
  }
}