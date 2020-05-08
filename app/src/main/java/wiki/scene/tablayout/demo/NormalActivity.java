package wiki.scene.tablayout.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import wiki.scene.tablayout.NavigationController;
import wiki.scene.tablayout.PageNavigationView;
import wiki.scene.tablayout.internal.BottomTabLayoutUtils;
import wiki.scene.tablayout.view.NoTouchViewPager;
import wiki.scene.tablayout.view.SimpleFragmentPageAdapter;

public class NormalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        PageNavigationView navigationView = findViewById(R.id.navigationView);
        NoTouchViewPager viewPager = findViewById(R.id.viewPager);
        List<String> titles = new ArrayList<>();
        titles.add("Recents");
        titles.add("Favorites");
        titles.add("Nearby");
        titles.add("Favorites");
        titles.add("Recents");

        int defaultTextColor = Color.parseColor("#FF888888");
        int checkedTextColor = Color.parseColor("#FF009688");

        NavigationController navigationController = navigationView.custom()
                .addItem(BottomTabLayoutUtils.newItem(this, R.drawable.ic_restore_gray_24dp, R.drawable.ic_restore_teal_24dp, titles.get(0), defaultTextColor, checkedTextColor))
                .addItem(BottomTabLayoutUtils.newItem(this, R.drawable.ic_favorite_gray_24dp, R.drawable.ic_favorite_teal_24dp, titles.get(1), defaultTextColor, checkedTextColor))
                .addItem(BottomTabLayoutUtils.newItem(this, R.drawable.ic_nearby_gray_24dp, R.drawable.ic_nearby_teal_24dp, titles.get(2), defaultTextColor, checkedTextColor))
                .addItem(BottomTabLayoutUtils.newItem(this, R.drawable.ic_favorite_gray_24dp, R.drawable.ic_favorite_teal_24dp, titles.get(3), defaultTextColor, checkedTextColor))
                .addItem(BottomTabLayoutUtils.newItem(this, R.drawable.ic_restore_gray_24dp, R.drawable.ic_restore_teal_24dp, titles.get(4), defaultTextColor, checkedTextColor))
                .build();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(TestFragment.newInstance(0));
        fragments.add(TestFragment.newInstance(1));
        fragments.add(TestFragment.newInstance(2));
        fragments.add(TestFragment.newInstance(3));
        fragments.add(TestFragment.newInstance(4));


        viewPager.setAdapter(new SimpleFragmentPageAdapter(getSupportFragmentManager(), titles, fragments));

        //自动适配ViewPager页面切换
        navigationController.setupWithViewPager(viewPager);
    }
}
