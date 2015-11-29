package gq.baijie.classbasedviewadapter.android.sample.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gq.baijie.classbasedviewadapter.android.adapter.ViewHolderFactory;
import gq.baijie.classbasedviewadapter.android.sample.R;
import gq.baijie.classbasedviewadapter.android.sample.ui.entity.Type3;

public class ViewType3Holder extends RecyclerView.ViewHolder {

    public TextView text1;

    public TextView text2;

    public TextView text3;

    public ViewType3Holder(View itemView) {
        super(itemView);
        text1 = (TextView) itemView.findViewById(R.id.text1);
        text2 = (TextView) itemView.findViewById(R.id.text2);
        text3 = (TextView) itemView.findViewById(R.id.text3);
    }

    public static class Factory implements ViewHolderFactory<Type3, ViewType3Holder> {

        @Override
        public Class<Type3> forClass() {
            return Type3.class;
        }

        @Override
        public ViewType3Holder createViewHolder(ViewGroup parent) {
            final View rootView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.view_type_3, parent, false);
            return new ViewType3Holder(rootView);
        }

        @Override
        public void bindViewHolder(ViewType3Holder holder, Type3 value, int position) {
            holder.text1.setText(value.text1);
            holder.text2.setText(value.text2);
            holder.text3.setText(value.text3 + " @ position " + position);
        }

    }

}
