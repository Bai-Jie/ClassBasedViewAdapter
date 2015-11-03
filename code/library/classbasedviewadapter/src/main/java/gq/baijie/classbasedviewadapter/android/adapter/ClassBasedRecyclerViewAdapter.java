package gq.baijie.classbasedviewadapter.android.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class ClassBasedRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List dataset;

    @Nullable
    private ViewHolderFactoryRegister register;

    public List getDataset() {
        return dataset;
    }

    public void setDataset(List dataset) {
        this.dataset = dataset;
    }

    @NonNull
    public ViewHolderFactoryRegister getRegister() {
        if (register != null) {
            return register;
        } else {
            return ViewHolderFactoryRegisters.defaultViewHolderFactoryRegister();
        }
    }

    /**
     * set {@link ViewHolderFactoryRegister} used to find {@link ViewHolderFactory}
     *
     * @param register a {@link ViewHolderFactoryRegister} or null to use default register
     */
    public void setRegister(@Nullable ViewHolderFactoryRegister register) {
        this.register = register;
    }

    @Override
    public int getItemCount() {
        return dataset != null ? dataset.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return getRegister().getItemViewType(dataset.get(position).getClass());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getRegister().createViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        getRegister().bindViewHolder(holder, dataset.get(position));
    }

}
