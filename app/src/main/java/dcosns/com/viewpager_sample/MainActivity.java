package dcosns.com.viewpager_sample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager mPager;
    ArrayList<Integer> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items.add(0xffff0000); //red
        items.add(0xff00ff00); //green
        items.add(0xff0000ff); //blue
        items.add(0xffffff00); //yellow
        items.add(0xff00ffff); //

        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPager.setAdapter(new DCOPagerApater(this, items));
        mPager.setOffscreenPageLimit(3);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
