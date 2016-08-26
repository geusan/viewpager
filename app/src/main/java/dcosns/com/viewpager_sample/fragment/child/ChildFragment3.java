package dcosns.com.viewpager_sample.fragment.child;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dcosns.com.viewpager_sample.R;

/**
 * Created by dnay2 on 2016-08-26.
 */
public class ChildFragment3 extends Fragment {

    public ChildFragment3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_child, null);

        TextView textView = (TextView) v.findViewById(R.id.text);
        textView.setText("current page : 3");

        return v;
    }
}
