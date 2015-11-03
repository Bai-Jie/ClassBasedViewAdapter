package gq.baijie.classbasedviewadapter.android.adapter;

import android.support.annotation.NonNull;

import gq.baijie.classbasedviewadapter.android.adapter.impl.DefaultViewHolderFactoryRegister;

public class ViewHolderFactoryRegisters {

    private static final ViewHolderFactoryRegister DEFAULT = new DefaultViewHolderFactoryRegister();

    @NonNull
    public static ViewHolderFactoryRegister defaultViewHolderFactoryRegister() {
        return DEFAULT;
    }

}
