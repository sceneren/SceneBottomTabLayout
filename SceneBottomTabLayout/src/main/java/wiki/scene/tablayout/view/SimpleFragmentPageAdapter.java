package wiki.scene.tablayout.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class SimpleFragmentPageAdapter extends FragmentStatePagerAdapter {
    private List<String> titles;
    private List<Fragment> fragments;

    public SimpleFragmentPageAdapter(@NonNull FragmentManager fm, final List<String> titles,
                                     @NonNull final List<Fragment> fragments) {
        super(fm, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.titles = titles;
        this.fragments = fragments;

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles == null) {
            return "";
        }
        return position < titles.size() ? titles.get(position) : "";
    }
}
