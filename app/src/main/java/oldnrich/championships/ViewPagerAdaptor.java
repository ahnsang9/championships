package oldnrich.championships;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdaptor extends FragmentPagerAdapter {
    public ViewPagerAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }


    // 프레그먼트 교체를 보여주는 처리를 구현하는 곳
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Fragment1.newInstance();
            case 1:
                return Fragment2.newInstance();
            case 2:
                return Fragment3.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3; // 인디케이터 갯수
    }

    // 상단의 탭 레이아웃 인디케이터 쪽에 텍스트를 선언해주는 곳
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "대회정보";
            case 1:
                return "관심대회";
            case 2:
                return "더보기";
            default:
                return null;
        }
    }
}
