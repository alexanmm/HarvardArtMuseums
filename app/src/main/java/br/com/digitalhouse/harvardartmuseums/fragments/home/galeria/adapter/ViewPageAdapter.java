package br.com.digitalhouse.harvardartmuseums.fragments.home.galeria.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayFragmentos;
    private ArrayList<String> arrayTitulos;

    public ViewPageAdapter(FragmentManager fm, ArrayList<Fragment> arrayFragmentos, ArrayList<String> arrayTitulos) {
        super(fm);
        this.arrayFragmentos = arrayFragmentos;
        this.arrayTitulos = arrayTitulos;
    }

    @Override
    public Fragment getItem(int position) {
        return arrayFragmentos.get(position);
    }

    @Override
    public int getCount() {
        return arrayFragmentos.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayTitulos.get(position);
    }
}
