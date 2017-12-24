

package best.solitair.solitaire.ui.about;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import best.solitair.solitaire.R;

/**
 * Adapter for the tabs
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES;

    TabsPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        TITLES = new String[]{context.getString(R.string.about_tab_1) , context.getString(R.string.about_tab_2), context.getString(R.string.about_tab_3)};
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int index) {
        switch (index) {
            case 0:
                return new InformationFragment();
            case 1:
                return new LicenseFragment();
            case 2:
                return new ChangeLogFragment();
        }

        return null;
    }

}