package com.fanwe.www.develop.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fanwe.www.develop.R;
import com.fanwe.www.develop.business.MainBusiness;
import com.fanwe.www.develop.business.impl.MainBusinessImpl;

public class MainActivity extends BaseActivity implements MainBusiness.MainView
{
    private MainBusiness mBusiness = new MainBusinessImpl();

    private Button btn_request;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBusiness.setView(this);

        btn_request = (Button) findViewById(R.id.btn_request);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_request.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mBusiness.requestInitAndShow();
            }
        });
    }

    @Override
    public void showInitResult(String result)
    {
        tv_result.setText(result);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mBusiness.onDestroy();
    }
}
