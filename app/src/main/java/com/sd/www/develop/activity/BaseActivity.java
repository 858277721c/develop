package com.sd.www.develop.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sd.lib.develop.callback.BSProgress;
import com.sd.lib.stream.FStream;
import com.sd.lib.stream.FStreamManager;

/**
 * Created by Administrator on 2017/10/31.
 */
public class BaseActivity extends AppCompatActivity implements BSProgress
{
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        FStreamManager.getInstance().register(this);
    }

    @Override
    public Object getTagForStream(Class<? extends FStream> clazz)
    {
        return toString();
    }

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

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        FStreamManager.getInstance().unregister(this);
    }
}
