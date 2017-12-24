
package best.solitair.solitaire.ui.about;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

import best.solitair.solitaire.R;
import best.solitair.solitaire.classes.CustomAppCompatActivity;

/**
 * This is created with help of this article: http://simpledeveloper.com/how-to-create-android-swipe-views-tabs/
 * The About activity contains 3 tabs. The content of the tabs is in the fragments
 */

public class AboutActivity extends CustomAppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_about);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager(), this);

        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        //only menu item is the back button in the action bar so finish this activity
        finish();
        return true;
    }
}
