package r12.moxybug.ui_mvp.activities;

import android.support.annotation.IdRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import r12.moxybug.TypesEnum;

/**
 * Created by R12 on 05.11.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

    void replaceFragment(TypesEnum type);
    void setCheckedItem(@IdRes int id);

}
