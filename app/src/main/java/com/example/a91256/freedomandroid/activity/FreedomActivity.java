package com.example.a91256.freedomandroid.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.Service.MyService;
import com.example.a91256.freedomandroid.fragment.ComicListFragment;
import com.example.a91256.freedomandroid.fragment.FeaturedFragment;
import com.example.a91256.freedomandroid.utils.NetworkState;

import java.util.ArrayList;
import java.util.List;

public class FreedomActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private final static String TAG = "FreedomActivity";

    private RadioButton bookcase;
    private RadioButton library;
    private RadioButton featured;
    private RadioButton find;
    private RadioGroup bottomBar;
    private FragmentManager mFragmentManager;
    private ComicListFragment mComicListFragment;
    private FeaturedFragment mFeaturedFragment;
    private FragmentTransaction mTransaction;
    private Fragment mCurrentFragment;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freedom);
        init();
        test1();
    }

    private void init() {

        bookcase = (RadioButton) findViewById(R.id.bookcase_text);
        library = (RadioButton) findViewById(R.id.library_text);
        featured = (RadioButton) findViewById(R.id.featured_text);
        find = (RadioButton) findViewById(R.id.find_text);
        bottomBar = (RadioGroup) findViewById(R.id.bottom_bar);
        bottomBar.setOnCheckedChangeListener(this);
        initFragment();
    }

    private void initFragment() {
        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        mComicListFragment = new ComicListFragment();
        mFragments.add(mComicListFragment);
        mFeaturedFragment = new FeaturedFragment();
        mFragments.add(mFeaturedFragment);
        addAllFragment(mTransaction);
        showFragment(mTransaction, mComicListFragment);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        changeFragment(i);
    }

    private void changeFragment(int id) {
        if (mFragmentManager == null)
            mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        switch (id) {
            case R.id.bookcase_text:
                showFragment(mTransaction, mComicListFragment);
                break;
            case R.id.featured_text:
                showFragment(mTransaction, mFeaturedFragment);
                break;

           /* case R.id.library_text:
                mTransaction.hide(mComicListFragment);
                break;
            case R.id.find_text:
                break;*/
        }
    }

    private void addAllFragment(FragmentTransaction transaction) {
        for (Fragment fragment : mFragments) {
            transaction.add(R.id.content, fragment);
        }
    }

    private void showFragment(FragmentTransaction transaction, Fragment fragment) {
        for (Fragment fragment1 : mFragments) {
            transaction.hide(fragment1);
        }
        transaction.show(fragment);
        mCurrentFragment = fragment;
        transaction.commit();
    }

    private void test() {
        TelephonyManager manager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);

        String operator = manager.getSimOperator();

        if (operator != null) {

            if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007")) {

//中国移动

            } else if (operator.equals("46001")) {

//中国联通

            } else if (operator.equals("46003")) {

//中国电信

            }
        }
        String operator1 = manager.getNetworkOperator();
        /**通过operator获取 MCC 和MNC */
        int mcc = Integer.parseInt(operator.substring(0, 3));
        int mnc = Integer.parseInt(operator.substring(3));

        GsmCellLocation location = (GsmCellLocation) manager.getCellLocation();

        /**通过GsmCellLocation获取中国移动和联通 LAC 和cellID */
        int lac = location.getLac();
        int cellId = location.getCid();
        /**通过CdmaCellLocation获取中国电信 LAC 和cellID */
        CdmaCellLocation location1 = (CdmaCellLocation) manager.getCellLocation();
        lac = location1.getNetworkId();
        cellId = location1.getBaseStationId();

        int strength = 0;
        /**通过getNeighboringCellInfo获取BSSS */
        List<NeighboringCellInfo> infoLists = manager.getNeighboringCellInfo();
        System.out.println("infoLists:" + infoLists + "     size:" + infoLists.size());
        for (NeighboringCellInfo info : infoLists) {
            strength += (-133 + 2 * info.getRssi());// 获取邻区基站信号强度
            //info.getLac();// 取出当前邻区的LAC
            //info.getCid();// 取出当前邻区的CID
            System.out.println("rssi:" + info.getRssi() + "   strength:" + strength);
        }
    }

    private void test1(){
        Log.e(TAG, NetworkState.getInstance(this).getPhoneType() + "");
        Log.e(TAG, NetworkState.getInstance(this).getSimCountryIso() + "");

    }

}
