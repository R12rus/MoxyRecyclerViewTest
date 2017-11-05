package r12.moxybug.di;

import javax.inject.Singleton;

import dagger.Component;
import r12.moxybug.di.modules.ApiModule;
import r12.moxybug.di.modules.ContextModule;
import r12.moxybug.di.modules.RetrofitModule;
import r12.moxybug.ui_mvp.fragments.SimplePresenter;

/**
 * Created by R12 on 05.11.2017.
 */

@Singleton
@Component(modules = {ContextModule.class, RetrofitModule.class, ApiModule.class})
public interface AppComponent {

    void inject(SimplePresenter simplePresenter);
}
