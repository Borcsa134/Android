package hu.bme.aut.amorg.examples.launcher;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import hu.bme.aut.amorg.examples.launcher.adapter.LauncherPagerAdapter;

public class LauncherActivity extends FragmentActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new LauncherPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
    }
}
