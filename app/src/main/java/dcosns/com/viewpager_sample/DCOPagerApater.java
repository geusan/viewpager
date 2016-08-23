package dcosns.com.viewpager_sample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * PagerAdapter를 상속받아서 구현
 */
public class DCOPagerApater extends PagerAdapter {

    Context context;            //XML inflate를 위해 Context가 필요하다.
    ArrayList<Integer> items;   //화면에서 보여줄 데이터리스트

    public DCOPagerApater(Context context, ArrayList<Integer> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        if(items != null) return items.size(); // 아이템 갯수 반환, 아이템이 없을 때는 0개 반환
        else return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    } // 뷰화면과 고른 객체가 같은지 여부 검사 유용하게 쓰이진 않는다.

    /**
     * 화면을 실제로 구현하는 메소드
     * @param container viewpager를 의미한다. (그래서 마지막에 conainer에 addview 메소드로 뷰를 추가해줘야 한다.)
     * @param position  viewpager에서 몇번쨰 아이템인지 골라낸다.
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = null;  //view를 하나 선언
        view = View.inflate(context, R.layout.viewpager_child, null); // xml inflate 우리가 원하는 화면으로 만듦
        int color = items.get(position); //데이터리스트에서 데이터 가져옴
        ImageView img = (ImageView) view.findViewById(R.id.child); //xml 화면에 있는 이미지뷰 가져옴
        img.setBackgroundColor(color); // xml에 있는 이미지뷰 UI변경

        container.addView(view); // 완성된 뷰 하나를 viewpager에 넣어서 보여준다.

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View)object); // 안보고 있는 화면은 파괴시켜버린다.
    }
}
