package text.bw.com.shop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

import text.bw.com.shop.Adapter.MyAdapter;
import text.bw.com.shop.Fragment.Fragment1;
import text.bw.com.shop.Fragment.Fragment2;
import text.bw.com.shop.Fragment.Fragment3;
import text.bw.com.shop.Fragment.Fragment4;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private RadioGroup rg;
    private RadioButton rb_homemy;
    private RadioButton rb_cart;
    private RadioButton rb_my;
    private RadioButton rb_tuan;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);
        rg = (RadioGroup) findViewById(R.id.rg);
        rb_homemy = (RadioButton) findViewById(R.id.rb_homemy);
        rb_cart = (RadioButton) findViewById(R.id.rb_cart);
        rb_my = (RadioButton) findViewById(R.id.rb_my);
        rb_tuan = (RadioButton) findViewById(R.id.rb_tuan);
        list = new ArrayList<>();
        Fragment1 f1 = new Fragment1();
        Fragment2 f2 = new Fragment2();
        Fragment3 f3 = new Fragment3();
        Fragment4 f4 = new Fragment4();
        list.add(f1);
        list.add(f2);
        list.add(f3);
        list.add(f4);
        vp.setAdapter(new MyAdapter(getSupportFragmentManager(),this,list));
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < rg.getChildCount(); i++) {
                    RadioButton rb = (RadioButton) rg.getChildAt(i);
                    if (position==i) {
                        rb.setChecked(true);
                        rb.setTextColor(Color.RED);
                    }else {
                        rb.setChecked(false);
                        rb.setTextColor(Color.parseColor("#999999"));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < rg.getChildCount(); i++) {
                    if (rg.getChildAt(i).getId()==checkedId){
                        vp.setCurrentItem(i);
                    }
                }
            }
        });
    }
}
