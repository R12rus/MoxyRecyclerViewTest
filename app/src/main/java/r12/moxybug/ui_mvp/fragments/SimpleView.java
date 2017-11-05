package r12.moxybug.ui_mvp.fragments;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import r12.moxybug.models.GitHubUser;

/**
 * Created by R12 on 05.11.2017.
 */

@StateStrategyType(AddToEndSingleStrategy.class)
public interface SimpleView extends MvpView {
    void updateList(List<GitHubUser> list);
}
