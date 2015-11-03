package gq.baijie.classbasedviewadapter.android.sample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import gq.baijie.classbasedviewadapter.R;
import gq.baijie.classbasedviewadapter.android.adapter.ClassBasedRecyclerViewAdapter;
import gq.baijie.classbasedviewadapter.android.adapter.ViewHolderFactoryRegister;
import gq.baijie.classbasedviewadapter.android.adapter.ViewHolderFactoryRegisters;
import gq.baijie.classbasedviewadapter.android.sample.ui.entity.Type1;
import gq.baijie.classbasedviewadapter.android.sample.ui.entity.Type2;
import gq.baijie.classbasedviewadapter.android.sample.ui.entity.Type3;
import gq.baijie.classbasedviewadapter.android.sample.ui.viewholder.ViewType1Holder;
import gq.baijie.classbasedviewadapter.android.sample.ui.viewholder.ViewType2Holder;
import gq.baijie.classbasedviewadapter.android.sample.ui.viewholder.ViewType3Holder;

public class MainActivity extends AppCompatActivity {

    private static final List SAMPLE = Arrays.asList(new Type1(), new Type2(), new Type3());

    private ClassBasedRecyclerViewAdapter mAdapter = new ClassBasedRecyclerViewAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.contents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        final ViewHolderFactoryRegister register =
                ViewHolderFactoryRegisters.defaultViewHolderFactoryRegister();
        register.registerViewHolderFactory(new ViewType1Holder.Factory());
        register.registerViewHolderFactory(new ViewType2Holder.Factory());
        register.registerViewHolderFactory(new ViewType3Holder.Factory());

        mAdapter.setDataset(SAMPLE);
        mAdapter.notifyDataSetChanged();

    }

}
