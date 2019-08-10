package br.com.digitalhouse.harvardartmuseums.adapters;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
