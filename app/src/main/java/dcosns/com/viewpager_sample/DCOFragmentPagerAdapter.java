package dcosns.com.viewpager_sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import dcosns.com.viewpager_sample.fragment.child.ChildFragment1;
import dcosns.com.viewpager_sample.fragment.child.ChildFragment2;
import dcosns.com.viewpager_sample.fragment.child.ChildFragment3;

/**
 * Created by dnay2 on 2016-08-26.
 */
public class DCOFragmentPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] items;

    public DCOFragmentPagerAdapter(FragmentManager fm, Fragment[] items) {
        super(fm);
        this.items = items;
    }

    @Override
    public Fragment getItem(int position) {
        return getFragment(position);
    }

    @Override
    public int getCount() {
        if (items != null) return items.length;
        else return 0;
    }

    public Fragment getFragment(int position) {
        switch (position){
            case 0:
                items[position] = new ChildFragment1();
                break;
            case 1:
                items[position] = new ChildFragment2();
                break;
            case 2:
                items[position] = new ChildFragment3();
                break;
        }
        return items[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        items[position] = null;
    }
}
