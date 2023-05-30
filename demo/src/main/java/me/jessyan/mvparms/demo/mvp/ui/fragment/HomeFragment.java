package me.jessyan.mvparms.demo.mvp.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;

import java.util.ArrayList;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;

public class HomeFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @BindView(R.id.tab_text_1)
    TextView tab_text_1;
    @BindView(R.id.tab_text_2)
    TextView tab_text_2;
    @BindView(R.id.tab_bottom_1)
    View tab_bottom_1;
    @BindView(R.id.tab_bottom_2)
    View tab_bottom_2;

    private ArrayList<Fragment> fragments = new ArrayList<>();


    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        fragments.add(new HomeFragmentPopular("Popular"));
        fragments.add(new HomeFragmentNew("New"));

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                if (position == 0) {
                    return "Popular";
                } else {
                    return "New";
                }
            }
        };

        viewpager.setAdapter(adapter);

        tab_text_1.setOnClickListener(this);
        tab_text_2.setOnClickListener(this);

        tab_text_1.setTextColor(Color.parseColor("#28DE60"));
        tab_text_2.setTextColor(Color.parseColor("#FFFFFF"));
        tab_bottom_1.setVisibility(View.VISIBLE);
        tab_bottom_2.setVisibility(View.GONE);
    }

    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_text_1:
                tab_text_1.setTextColor(Color.parseColor("#28DE60"));
                tab_text_2.setTextColor(Color.parseColor("#FFFFFF"));
                tab_bottom_1.setVisibility(View.VISIBLE);
                tab_bottom_2.setVisibility(View.GONE);
                break;
            case R.id.tab_text_2:
                tab_text_1.setTextColor(Color.parseColor("#FFFFFF"));
                tab_text_2.setTextColor(Color.parseColor("#28DE60"));
                tab_bottom_1.setVisibility(View.GONE);
                tab_bottom_2.setVisibility(View.VISIBLE);
                break;
        }
    }
}
