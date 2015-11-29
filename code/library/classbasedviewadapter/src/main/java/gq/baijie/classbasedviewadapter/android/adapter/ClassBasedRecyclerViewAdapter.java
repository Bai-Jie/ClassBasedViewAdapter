package gq.baijie.classbasedviewadapter.android.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public class ClassBasedRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull
    private final ViewHolderFactoryRegister register;

    private DataSet dataSet;


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

    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public void setDataSet(List dataSet) {
        setDataSet(new ListDataSetAdapter(dataSet));
    }

    @NonNull
    public ViewHolderFactoryRegister getRegister() {
        return register;
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return getRegister().getItemViewType(dataSet.get(position).getClass());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getRegister().createViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        getRegister().bindViewHolder(holder, dataSet.get(position), position);
    }

    private static class ListDataSetAdapter implements DataSet {

        private final List delegate;

        private ListDataSetAdapter(List delegate) {
            this.delegate = delegate;
        }

        @Override
        public int size() {
            return delegate.size();
        }

        @Override
        public Object get(int location) {
            return delegate.get(location);
        }

    }

}
