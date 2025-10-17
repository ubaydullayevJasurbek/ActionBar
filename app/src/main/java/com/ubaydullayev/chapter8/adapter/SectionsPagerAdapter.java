package com.ubaydullayev.chapter8.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ubaydullayev.chapter8.R;
import com.ubaydullayev.chapter8.fragment.PastaFragment;
import com.ubaydullayev.chapter8.fragment.PizzaFragment;
import com.ubaydullayev.chapter8.fragment.StoresFragment;
import com.ubaydullayev.chapter8.fragment.TopFragment;

public class SectionsPagerAdapter extends FragmentStateAdapter {
    private final Context context;

    public SectionsPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.context = fragmentActivity;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new TopFragment();
            case 1:
                return new PizzaFragment();
            case 2:
                return new PastaFragment();
            case 3:
                return new StoresFragment();
            default:
                return new TopFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public String getPageTitle(int position) {

        switch (position) {
            case 0:
                return context.getString(R.string.home_tab);
            case 1:
                return context.getString(R.string.pizza_tab);
            case 2:
                return context.getString(R.string.pasta_tab);
            case 3:
                return context.getString(R.string.store_tab);
            default:
                return "";
        }
    }
}
