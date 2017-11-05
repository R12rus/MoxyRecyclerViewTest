package r12.moxybug.ui_mvp.activities;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import r12.moxybug.R;
import r12.moxybug.TypesEnum;

/**
 * Created by R12 on 05.11.2017.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        onFirstClicked();
    }

    protected void onFirstClicked() {
        getViewState().replaceFragment(TypesEnum.FIRST);
        getViewState().setCheckedItem(R.id.action_first);
    }

    protected void onSecondClicked() {
        getViewState().replaceFragment(TypesEnum.SECOND);
        getViewState().setCheckedItem(R.id.action_second);
    }

}
