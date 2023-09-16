package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import com.google.android.material.tabs.TabLayout;
import android.media.MediaPlayer;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.header);
        tabLayout.setupWithViewPager(pager);
        MediaPlayer mp = MediaPlayer.create(getBaseContext(), R.raw.lol);
        mp.start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Weather","onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Weather","onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Weather","onDestroy() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Weather","onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Weather","onResume() called");
    }
    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private String titles[] = new String[] { "Hanoi", "Paris", "Toulouse" };
        public HomeFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return PAGE_COUNT; // number of pages for a ViewPager
        }
        @Override
        public Fragment getItem(int page) {
            switch (page) {
                case 0:
                    return new WeatherAndForecastFragment();
                case 1:
                    return new WeatherAndForecastFragment();
                case 2:
                    return new WeatherAndForecastFragment();
            }
            return new Fragment();
        }
        @Override
        public CharSequence getPageTitle(int page) {
            return titles[page];
        }
    }


}