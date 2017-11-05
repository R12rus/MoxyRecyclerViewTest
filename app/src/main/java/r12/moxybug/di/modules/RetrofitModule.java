package r12.moxybug.di.modules;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import r12.moxybug.BuildConfig;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by R12 on 14.08.2017.
 */

@Module
public class RetrofitModule {

    @Provides
    @Singleton
    Retrofit provideRetrofit(Retrofit.Builder builder) {
        return builder.baseUrl(BuildConfig.BASE_URL).build();
    }

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder(RxJava2CallAdapterFactory rxFactory, List<Converter.Factory> converterFactories, OkHttpClient client) {
        Retrofit.Builder builder = new Retrofit.Builder();
        for (Converter.Factory factory : converterFactories) {
            builder.addConverterFactory(factory);
        }
        builder.client(client).addCallAdapterFactory(rxFactory);
        return builder;
    }

    @Provides
    @Singleton
    OkHttpClient provideClient(HttpLoggingInterceptor interceptor) {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return client;
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor provideInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        return interceptor;
    }

    @Provides
    @Singleton
    public List<Converter.Factory> provideConverterFactories() {
        List<Converter.Factory> factories = new ArrayList<>();
        factories.add(SimpleXmlConverterFactory.createNonStrict(new Persister(new AnnotationStrategy())));
        factories.add(GsonConverterFactory.create());
        return factories;
    }

    @Provides
    @Singleton
    public RxJava2CallAdapterFactory provideCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

}
