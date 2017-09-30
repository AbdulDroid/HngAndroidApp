package team_galaxy.hnginterns.hngmobileapp;

import android.support.multidex.MultiDexApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import team_galaxy.hnginterns.hngmobileapp.di.ActivityBindingModule;

/**
 * Created by abdulrahman on 9/30/17.
 */
@Component(modules = {AndroidSupportInjectionModule.class, ActivityBindingModule.class})
public interface AppComponent extends AndroidInjector<AppController> {

    @Override
    void inject(AppController instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(MultiDexApplication application);
        AppComponent build();
    }
}
