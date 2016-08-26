package dcosns.com.viewpager_sample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import dcosns.com.viewpager_sample.DCOFragmentPagerAdapter;
import dcosns.com.viewpager_sample.R;

/**
 * Created by dnay2 on 2016-08-26.
 */
public class ParaentFragment extends FragmentActivity {

    LinearLayout.LayoutParams llp;
    RelativeLayout.LayoutParams rlp;
    LinearLayout mainLayout;
    private Fragment[] items = new Fragment[3];
    private DCOFragmentPagerAdapter fPagerAdpater = new DCOFragmentPagerAdapter(getSupportFragmentManager(), items);

    private ViewPager mPager;
    private int[] mColor = {0xffff0000, 0xff00ff00, 0xff0000ff};
    private ImageView[] btnImg = new ImageView[3];
    private int curr = -1;
    /**
     * 1. 버튼에 들어갈 이미지(색상)
     * 2. viewpager
     * 3. viewpagerAdapter
     * 4. viewpager child
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent);

        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        mainLayout.setBackgroundColor(0xffdbdbdb);
        setUp();
    }

    private void setUp(){
        llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1);
        mPager = new ViewPager(this);
        mPager.setLayoutParams(llp);
        mPager.setId(View.generateViewId());
        mPager.setHorizontalScrollBarEnabled(true);
        mPager.setAdapter(fPagerAdpater);
        mPager.setOffscreenPageLimit(3);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                setCurrentPager(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mPager.setCurrentItem(0);
        Log.d("test", "view pager created");
        mainLayout.addView(mPager);

        llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
        LinearLayout tabBar = new LinearLayout(this);
        tabBar.setBackgroundColor(0xff00ffff);
        tabBar.setLayoutParams(llp);
        tabBar.setOrientation(LinearLayout.HORIZONTAL);
        mainLayout.addView(tabBar);
        LinearLayout[] btns = new LinearLayout[3];
        llp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1);
        for(int i = 0 ; i<btns.length; i++){
            Log.d("test", "tabbtn"+i+" created");
            btns[i] = new LinearLayout(this);
            btns[i] = (LinearLayout) View.inflate(this, R.layout.move_btn, null);
            btns[i].setLayoutParams(llp);
            btnImg[i] = (ImageView) btns[i].findViewById(R.id.moveBtn);
            btnImg[i].setBackgroundColor(mColor[i]);
            btnImg[i].setTag(i);
            btnImg[i].setOnClickListener(btnListener);
            tabBar.addView(btns[i]);
        }

    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setCurrentPager((Integer)view.getTag());
        }
    };
    private void setCurrentPager(int position){
        if(curr == position) return;
        for(ImageView iv : btnImg) iv.setBackgroundColor(0xff00ff00);
        btnImg[position].setBackgroundColor(0xffffff00);
        mPager.setCurrentItem(position);
    }
}
