package gq.baijie.classbasedviewadapter.android.adapter;

import android.support.annotation.NonNull;

import gq.baijie.classbasedviewadapter.android.adapter.impl.DefaultViewHolderFactoryRegister;

public class ViewHolderFactoryRegisters {

    @NonNull
    public static ViewHolderFactoryRegister newRegister() {
        return new DefaultViewHolderFactoryRegister();
    }

}
