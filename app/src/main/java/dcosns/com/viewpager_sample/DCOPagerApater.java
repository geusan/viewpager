package dcosns.com.viewpager_sample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by dnay2 on 2016-08-16.
 */
public class DCOPagerApater extends PagerAdapter {

    Context context;
    ArrayList<Integer> items;

    public DCOPagerApater(Context context, ArrayList<Integer> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        if(items != null) return items.size();
        else return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = null;
        view = View.inflate(context, R.layout.viewpager_child, null);
        int color = items.get(position);
        ImageView img = (ImageView) view.findViewById(R.id.child);
        img.setBackgroundColor(color);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View)object);
    }
}
