package test.bwie.com.a06yue_fuxi;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {


    @BindView(R.id.rb_qz)
    RadioButton rbQz;
    @BindView(R.id.rb_py)
    RadioButton rbPy;
    @BindView(R.id.rb_wd)
    RadioButton rbWd;
    @BindView(R.id.rg_tab_qz)
    RadioGroup rgTabQz;
    @BindView(R.id.vpager)
    ViewPager vpager;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    private MyFragmentPagerAdapter mAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        bindViews();
        rbQz.setChecked(true);
    }

    private void bindViews() {
        rgTabQz.setOnCheckedChangeListener(this);
        vpager.setAdapter(mAdapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_qz:
                vpager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.rb_py:
                vpager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.rb_wd:
                vpager.setCurrentItem(PAGE_THREE);
                break;

        }
    }

    //重写ViewPager页面切换的处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    rbQz.setChecked(true);
                    break;
                case PAGE_TWO:
                    rbPy.setChecked(true);
                    break;
                case PAGE_THREE:
                    rbWd.setChecked(true);
                    break;

            }

        }
    }
}
