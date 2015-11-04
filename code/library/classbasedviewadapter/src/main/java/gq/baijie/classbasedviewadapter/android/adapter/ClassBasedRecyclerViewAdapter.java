package gq.baijie.classbasedviewadapter.android.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class ClassBasedRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull
    private final ViewHolderFactoryRegister register;

    private List dataset;


    /**
     * construct with {@link ViewHolderFactoryRegister} used to find {@link ViewHolderFactory}
     *
     * @param register a {@code ViewHolderFactoryRegister} or null to use {@link
     *                 ViewHolderFactoryRegisters#newRegister()}
     */
    public ClassBasedRecyclerViewAdapter(@Nullable ViewHolderFactoryRegister register) {
        if (register != null) {
            this.register = register;
        } else {
            this.register = ViewHolderFactoryRegisters.newRegister();
        }
    }

    /**
     * same as {@link #ClassBasedRecyclerViewAdapter(ViewHolderFactoryRegister)
     * ClassBasedRecyclerViewAdapter(null)}
     */
    public ClassBasedRecyclerViewAdapter() {
        this(null);
    }

    public List getDataset() {
        return dataset;
    }

    public void setDataset(List dataset) {
        this.dataset = dataset;
    }

    @NonNull
    public ViewHolderFactoryRegister getRegister() {
        return register;
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
