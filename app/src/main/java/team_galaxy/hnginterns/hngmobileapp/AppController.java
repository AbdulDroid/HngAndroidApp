package team_galaxy.hnginterns.hngmobileapp;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.facebook.FacebookSdk;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by abdulrahman on 9/30/17.
 */

public class AppController extends MultiDexApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        //
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .build());
        FacebookSdk.sdkInitialize(this);

        DaggerAppComponent.builder().application(this)
                .build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
