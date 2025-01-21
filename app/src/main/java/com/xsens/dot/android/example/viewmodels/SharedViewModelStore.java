package com.xsens.dot.android.example.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

public class SharedViewModelStore implements ViewModelStoreOwner {
    private static volatile SharedViewModelStore instance;
    private final ViewModelStore viewModelStore;

    private SharedViewModelStore() {
        viewModelStore = new ViewModelStore();
    }

    public static SharedViewModelStore getInstance() {
        if (instance == null) {
            synchronized (SharedViewModelStore.class) {
                if (instance == null) {
                    instance = new SharedViewModelStore();
                }
            }
        }
        return instance;
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return viewModelStore;
    }
}
