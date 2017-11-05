package r12.moxybug.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import r12.moxybug.api.GitHubApi;
import retrofit2.Retrofit;

/**
 * Created by R12 on 14.08.2017.
 */

@Module(includes = {RetrofitModule.class})
public class ApiModule {

    @Singleton
    @Provides
    GitHubApi provideGitHubApi(Retrofit retrofit) {
        return retrofit.create(GitHubApi.class);
    }

}
