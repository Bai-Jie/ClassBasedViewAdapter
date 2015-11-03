package gq.baijie.classbasedviewadapter.android.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class ClassBasedRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List dataset;

    private ViewHolderFactoryRegister register;

    public List getDataset() {
        return dataset;
    }

    public void setDataset(List dataset) {
        this.dataset = dataset;
    }

    public ViewHolderFactoryRegister getRegister() {
        return register;
    }

    @NonNull
    private ViewHolderFactoryRegister getNonNullRegister() {
        if (register != null) {
            return register;
        } else {
            return ViewHolderFactoryRegisters.defaultViewHolderFactoryRegister();
        }
    }

    public void setRegister(ViewHolderFactoryRegister register) {
        this.register = register;
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getNonNullRegister().getItemViewType(dataset.get(position).getClass());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getNonNullRegister().createViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        getNonNullRegister().bindViewHolder(holder, dataset.get(position));
    }

}
