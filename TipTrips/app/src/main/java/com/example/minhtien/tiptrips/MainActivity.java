package com.example.minhtien.tiptrips;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.minhtien.adapter.ListTipAdapter;
import com.example.minhtien.models.Tip;
import com.example.minhtien.utils.DisplayUtil;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.SpringBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Tip> arrTip;
    ViewPager viewPager;
    private int unSelectColor;
    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;
    private Context context;
    private TextView txtNameCate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        viewPager = (ViewPager) findViewById(R.id.vp_list_tip_tricks);
        txtNameCate = (TextView) findViewById(R.id.txt_name_categories);
        txtNameCate.setText("");

        Indicator indicator = (ScrollIndicatorView) findViewById(R.id.spring_indicator);
        int selectColor = Color.parseColor("#ffffff");
        unSelectColor = Color.parseColor("#ffffff");
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(selectColor, unSelectColor));
        indicator.setScrollBar(new SpringBar(getApplicationContext(), Color.parseColor("#ffc028")));
        viewPager.setOffscreenPageLimit(4);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        indicatorViewPager.setAdapter(adapter);
        indicatorViewPager.setOnIndicatorPageChangeListener(new IndicatorViewPager.OnIndicatorPageChangeListener() {
            @Override
            public void onIndicatorPageChange(int i, int i1) {
                Log.e("test3","i = " + i + " i1 = " + i1);
                switch (i1){
                    case 0 :
                        txtNameCate.setText(getResources().getString(R.string.kind1));
                        break;
                    case 1 :
                        txtNameCate.setText(getResources().getString(R.string.kind2));
                        break;
                    case 2 :
                        txtNameCate.setText(getResources().getString(R.string.kind3));
                        break;
                    case 3 :
                        txtNameCate.setText(getResources().getString(R.string.kind4));
                        break;
                    case 4 :
                        txtNameCate.setText(getResources().getString(R.string.kind5));
                        break;
                    case 5 :
                        txtNameCate.setText(getResources().getString(R.string.kind6));
                        break;
                    case 6 :
                        txtNameCate.setText(getResources().getString(R.string.kind7));
                        break;
                    case 7 :
                        txtNameCate.setText(getResources().getString(R.string.kind8));
                        break;
                    case 8 :
                        txtNameCate.setText(getResources().getString(R.string.kind9));
                        break;
                    case 9 :
                        txtNameCate.setText(getResources().getString(R.string.kind2));
                        break;
                }
            }
        });
        indicatorViewPager.setCurrentItem(5, false);
    }


    private IndicatorViewPager.IndicatorPagerAdapter adapter = new IndicatorViewPager.IndicatorViewPagerAdapter() {
        private ListView listTip;

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            int padding = DisplayUtil.dipToPix(getApplicationContext(), 30);
            textView.setPadding(padding, 0, padding, 0);
            textView.setText(Integer.toString(position + 1));
            textView.setTextColor(unSelectColor);
            return convertView;
        }

        @Override
        public View getViewForPage(final int position, View convertView, ViewGroup container) {
            convertView = inflate.inflate(R.layout.content_viewpager, container, false);
            listTip = (ListView) convertView.findViewById(R.id.list_trip);
            switch (position){
                case 0:
                    initData0();
                    break;
                case 1:
                    initData1();
                    break;
                case 2:
                    initData1();
                    break;
                case 3:
                    initData1();
                    break;
                case 4:
                    initData1();
                    break;
                case 5:
                    initData1();
                    break;
                case 6:
                    initData1();
                    break;
                case 7:
                    initData1();
                    break;
                case 8:
                    initData1();
                    break;
                default:
                    arrTip = new ArrayList<>();
                    break;
            }

            ListTipAdapter adapter = new ListTipAdapter(context, arrTip);
            listTip.setAdapter(adapter);
            listTip.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                    intent.putExtra("details",arrTip.get(position).getDetails());
                    startActivity(intent);
                }
            });
            return convertView;
        }

        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_UNCHANGED;
        }

        @Override
        public int getCount() {
            return 9;
        }


    };

    private void initData0() {
        arrTip = new ArrayList<>();
        arrTip.add(new Tip(getResources().getString(R.string.tip1)));
        arrTip.add(new Tip(getResources().getString(R.string.tip1)));
        arrTip.add(new Tip(getResources().getString(R.string.tip1)));
        arrTip.add(new Tip(getResources().getString(R.string.tip1)));
        arrTip.add(new Tip(getResources().getString(R.string.tip1)));
        arrTip.add(new Tip(getResources().getString(R.string.tip1)));
        arrTip.add(new Tip(getResources().getString(R.string.tip1)));
        arrTip.add(new Tip(getResources().getString(R.string.tip1)));
        arrTip.add(new Tip(getResources().getString(R.string.tip1)));
    }
    private void initData1() {
        arrTip = new ArrayList<>();
        arrTip.add(new Tip(getResources().getString(R.string.tip2)));
        arrTip.add(new Tip(getResources().getString(R.string.tip3)));
        arrTip.add(new Tip(getResources().getString(R.string.tip3)));
        arrTip.add(new Tip(getResources().getString(R.string.tip3)));
        arrTip.add(new Tip(getResources().getString(R.string.tip3)));
        arrTip.add(new Tip(getResources().getString(R.string.tip3)));
        arrTip.add(new Tip(getResources().getString(R.string.tip3)));
        arrTip.add(new Tip(getResources().getString(R.string.tip3)));
        arrTip.add(new Tip(getResources().getString(R.string.tip3)));
    }
}
