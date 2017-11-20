package com.fanwe.www.develop.business.impl;

import com.fanwe.lib.http.PostRequest;
import com.fanwe.lib.http.Request;
import com.fanwe.lib.http.RequestManager;
import com.fanwe.lib.http.callback.StringRequestCallback;
import com.fanwe.www.develop.business.MainBusiness;

/**
 * Created by Administrator on 2017/10/31.
 */
public class MainBusinessImpl extends MainBusiness
{
    @Override
    public void requestInitAndShow()
    {
        Request request = new PostRequest("http://ilvbt3.fanwe.net/mapi/index.php");
        request.param("ctl", "app").param("act", "init");
        request.execute(new StringRequestCallback()
        {
            @Override
            public void onPrepare(Request request)
            {
                super.onPrepare(request);
                request.setTag(MainBusinessImpl.class.getName());
            }

            @Override
            public void onStart()
            {
                super.onStart();
                getView().onBsShowProgress("请稍后");
            }

            @Override
            public void onSuccess()
            {
                getView().bsv_showInitResult(getResult());
            }

            @Override
            public void onFinish()
            {
                super.onFinish();
                getView().onBsHideProgress();
            }
        });
    }

    @Override
    public void onDestroy()
    {
        RequestManager.getInstance().cancelTag(MainBusinessImpl.class.getName());
    }
}
