package com.fanwe.www.develop.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.fanwe.lib.develop.callback.IBSCallback;

/**
 * Created by Administrator on 2017/10/31.
 */

public class BaseActivity extends AppCompatActivity implements IBSCallback
{
    private ProgressDialog mProgressDialog;

    @Override
    public void onBsShowProgress(String msg)
    {
        if (mProgressDialog == null)
        {
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    @Override
    public void onBsHideProgress()
    {
        if (mProgressDialog != null)
        {
            mProgressDialog.dismiss();
        }
    }
}
