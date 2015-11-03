package gq.baijie.classbasedviewadapter.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface ViewHolderFactory<T, VH extends RecyclerView.ViewHolder> {

    Class<T> forClass();

    VH createViewHolder(ViewGroup parent);

    void bindViewHolder(VH holder, T value);

}
