package gq.baijie.classbasedviewadapter.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public interface ViewHolderFactoryRegister {

    void registerViewHolderFactory(ViewHolderFactory viewHolderFactory);

    int getItemViewType(Class itemType);

    RecyclerView.ViewHolder createViewHolder(ViewGroup parent, int itemViewType);

    void bindViewHolder(RecyclerView.ViewHolder holder, Object forThis, int position);

}
