package text.bw.com.shop.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Pooh on 2017/2/9.
 */
public class MyAdapter extends FragmentPagerAdapter {
    Context context;
    ArrayList<Fragment> list;

    public MyAdapter(FragmentManager fm, Context context, ArrayList<Fragment> list) {
        super(fm);
        this.context = context;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
