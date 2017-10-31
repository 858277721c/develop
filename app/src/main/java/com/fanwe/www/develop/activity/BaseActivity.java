package com.fanwe.www.develop.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.fanwe.lib.develop.view.IProgressView;

/**
 * Created by Administrator on 2017/10/31.
 */

public class BaseActivity extends AppCompatActivity implements IProgressView
{
    private ProgressDialog mProgressDialog;

    @Override
    public void showProgress(String msg)
    {
        if (mProgressDialog == null)
        {
            mProgressDialog = new ProgressDialog(this);
        }
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    @Override
    public void hideProgress()
    {
        if (mProgressDialog != null)
        {
            mProgressDialog.dismiss();
        }
    }
}
