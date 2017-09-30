package team_galaxy.hnginterns.hngmobileapp.di;

import dagger.Module;
import team_galaxy.hnginterns.hngmobileapp.ui.activities.MainActivity;

/**
 * Created by abdulrahman on 9/30/17.
 */
@Module
public abstract class ActivityBindingModule {

    //@ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();
}
