package r12.moxybug.ui_mvp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import r12.moxybug.R;
import r12.moxybug.models.GitHubUser;

/**
 * Created by R12 on 05.11.2017.
 */

public class SimpleUserAdapter extends RecyclerView.Adapter<SimpleUserAdapter.ViewHolder> {

    private List<GitHubUser> mList = new ArrayList<>();

    public void setList(List<GitHubUser> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setName(mList.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_name)
        TextView nameTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setName(String name) {
            nameTextView.setText(name);
        }
    }

}
