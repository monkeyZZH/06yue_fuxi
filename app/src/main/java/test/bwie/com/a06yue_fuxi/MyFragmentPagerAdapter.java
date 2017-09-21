package test.bwie.com.a06yue_fuxi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * name:周振辉
 * 时间：2017/8/25 15:40
 * 类描述：
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 3;
    private F1 f1 = null;
    private F2 f2 = null;
    private F3 f3 = null;



    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        f1 = new F1();
        f2 = new F2();
        f3 = new F3();

    }


    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("position Destory" + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = f1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = f2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = f3;
                break;

        }
        return fragment;
    }
}
