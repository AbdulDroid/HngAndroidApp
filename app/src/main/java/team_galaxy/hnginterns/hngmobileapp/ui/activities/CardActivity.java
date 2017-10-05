package team_galaxy.hnginterns.hngmobileapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import team_galaxy.hnginterns.hngmobileapp.R;
import team_galaxy.hnginterns.hngmobileapp.ui.fragments.CardFragment;

public class CardActivity extends AppCompatActivity implements View.OnClickListener,
        ViewPager.OnPageChangeListener, CardFragment.OnFragmentInteractionListener{

    @BindView(R.id.card1)
    ImageView card1;
    @BindView(R.id.card2)
    ImageView card2;
    @BindView(R.id.card3)
    ImageView card3;
    @BindView(R.id.card4)
    ImageView card4;
    @BindView(R.id.viewPager)
    ViewPager pager;

    @BindView(R.id.saveButton)
    Button saveButton;

    private int page = 0;
    private SectionPagerAdapter mSectionPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        mSectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        ButterKnife.bind(this);
        pager.setAdapter(mSectionPagerAdapter);
        pager.addOnPageChangeListener(this);
        updateIndicators(page);
        pager.setCurrentItem(page);
        saveButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.saveButton:
                Intent intent = new Intent(this, BookingActivity.class);
                intent.putExtra("page", "Confirm");
                startActivity(intent);
        }
    }

    private void updateIndicators(int page) {
        switch (page) {
            case 0:
                default:
                card1.setBackgroundResource(R.drawable.viewpager_active);
                card2.setBackgroundResource(R.drawable.viewpager_inactive);
                card3.setBackgroundResource(R.drawable.viewpager_inactive);
                card4.setBackgroundResource(R.drawable.viewpager_inactive);
                break;
            case 1:
                card1.setBackgroundResource(R.drawable.viewpager_inactive);
                card2.setBackgroundResource(R.drawable.viewpager_active);
                card3.setBackgroundResource(R.drawable.viewpager_inactive);
                card4.setBackgroundResource(R.drawable.viewpager_inactive);
                break;
            case 2:
                card1.setBackgroundResource(R.drawable.viewpager_inactive);
                card2.setBackgroundResource(R.drawable.viewpager_inactive);
                card3.setBackgroundResource(R.drawable.viewpager_active);
                card4.setBackgroundResource(R.drawable.viewpager_inactive);
                break;
            case 3:
                card1.setBackgroundResource(R.drawable.viewpager_inactive);
                card2.setBackgroundResource(R.drawable.viewpager_inactive);
                card3.setBackgroundResource(R.drawable.viewpager_inactive);
                card4.setBackgroundResource(R.drawable.viewpager_active);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        page = position;
        updateIndicators(page);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return CardFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
