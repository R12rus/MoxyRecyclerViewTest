package r12.moxybug.ui_mvp.fragments;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import r12.moxybug.TypesEnum;
import r12.moxybug.api.GitHubApi;
import r12.moxybug.app.TestApplication;
import r12.moxybug.models.GitHubUser;

/**
 * Created by R12 on 05.11.2017.
 */

@InjectViewState
public class SimplePresenter extends MvpPresenter<SimpleView> {

    private static final String TAG = SimplePresenter.class.getSimpleName();

    @Inject
    GitHubApi mApiModule;

    private TypesEnum mType;

    public SimplePresenter(TypesEnum typesEnum) {
        TestApplication.getAppComponent().inject(this);
        mType = typesEnum;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        requestFollowers();
    }

    private void requestFollowers() {
        String userName = mType == TypesEnum.FIRST ? "JakeWharton" : "senneco";

        mApiModule.getUser(userName).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<GitHubUser>>() {
                    @Override
                    public void accept(List<GitHubUser> list) throws Exception {
                        getViewState().updateList(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e(TAG, throwable.toString());
                    }
                });
    }


}
