package r12.moxybug.ui_mvp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import r12.moxybug.R;
import r12.moxybug.TypesEnum;
import r12.moxybug.models.GitHubUser;
import r12.moxybug.ui_mvp.adapters.SimpleUserAdapter;

/**
 * Created by R12 on 05.11.2017.
 */

public class SimpleFragment extends MvpAppCompatFragment implements SimpleView {

    private static final String EXTRA_TYPE = "type";

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private SimpleUserAdapter mAdapter;

    @InjectPresenter
    SimplePresenter mPresenter;

    @ProvidePresenter
    SimplePresenter provideSimplePresenter() {
        return new SimplePresenter((TypesEnum) getArguments().getSerializable(EXTRA_TYPE));
    }

    public static SimpleFragment newInstance(TypesEnum type) {
        SimpleFragment fragment = new SimpleFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_simple, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mAdapter = new SimpleUserAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void updateList(List<GitHubUser> list) {
        mAdapter.setList(list);
    }
}
