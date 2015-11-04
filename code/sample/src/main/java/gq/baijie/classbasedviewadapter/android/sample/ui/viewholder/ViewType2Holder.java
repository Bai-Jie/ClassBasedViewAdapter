package gq.baijie.classbasedviewadapter.android.sample.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gq.baijie.classbasedviewadapter.android.adapter.ViewHolderFactory;
import gq.baijie.classbasedviewadapter.android.sample.R;
import gq.baijie.classbasedviewadapter.android.sample.ui.entity.Type2;

public class ViewType2Holder extends RecyclerView.ViewHolder {

    public TextView text1;

    public TextView text2;

    public ViewType2Holder(View itemView) {
        super(itemView);
        text1 = (TextView) itemView.findViewById(R.id.text1);
        text2 = (TextView) itemView.findViewById(R.id.text2);
    }

    public static class Factory implements ViewHolderFactory<Type2, ViewType2Holder> {

        @Override
        public Class<Type2> forClass() {
            return Type2.class;
        }

        @Override
        public ViewType2Holder createViewHolder(ViewGroup parent) {
            final View rootView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_type_2, parent, false);
            return new ViewType2Holder(rootView);
        }

        @Override
        public void bindViewHolder(ViewType2Holder holder, Type2 value) {
            holder.text1.setText(value.text1);
            holder.text2.setText(value.text2);
        }

    }

}
