package gq.baijie.classbasedviewadapter.android.sample.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gq.baijie.classbasedviewadapter.R;
import gq.baijie.classbasedviewadapter.android.adapter.ViewHolderFactory;
import gq.baijie.classbasedviewadapter.android.sample.ui.entity.Type1;

public class ViewType1Holder extends RecyclerView.ViewHolder {

    public TextView text1;

    public TextView text2;

    public ViewType1Holder(View itemView) {
        super(itemView);
        text1 = (TextView) itemView.findViewById(R.id.text1);
        text2 = (TextView) itemView.findViewById(R.id.text2);
    }

    public static class Factory implements ViewHolderFactory<Type1, ViewType1Holder> {

        @Override
        public Class<Type1> forClass() {
            return Type1.class;
        }

        @Override
        public ViewType1Holder createViewHolder(ViewGroup parent) {
            final View rootView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_type_1, parent, false);
            return new ViewType1Holder(rootView);
        }

        @Override
        public void bindViewHolder(ViewType1Holder holder, Type1 value) {
            holder.text1.setText(value.text1);
            holder.text2.setText(value.text2);
        }

    }

}
