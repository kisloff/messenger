package ru.k_kiselev.messenger.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.k_kiselev.messenger.R;

public class ImportContactsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview;
        return rootview = inflater.inflate(R.layout.menu3_layout, container, false);
    }
}
