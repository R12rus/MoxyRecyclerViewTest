package r12.moxybug.app;

import android.app.Application;

import r12.moxybug.di.AppComponent;
import r12.moxybug.di.DaggerAppComponent;
import r12.moxybug.di.modules.ContextModule;

/**
 * Created by R12 on 05.11.2017.
 */

public class TestApplication extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

}
