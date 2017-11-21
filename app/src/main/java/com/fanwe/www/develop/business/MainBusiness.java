package com.fanwe.www.develop.business;

import com.fanwe.lib.develop.business.BaseBusiness;
import com.fanwe.lib.develop.callback.IBSProgressCallback;
import com.fanwe.lib.http.PostRequest;
import com.fanwe.lib.http.Request;
import com.fanwe.lib.http.RequestManager;
import com.fanwe.lib.http.callback.StringRequestCallback;

/**
 * Created by Administrator on 2017/10/31.
 */
public class MainBusiness extends BaseBusiness<MainBusiness.Callback>
{

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
                request.setTag(MainBusiness.class.getName());
            }

            @Override
            public void onStart()
            {
                super.onStart();
                showProgress("请稍后");
            }

            @Override
            public void onSuccess()
            {
                getCallback().onBsShowInitResult(getResult());
            }

            @Override
            public void onFinish()
            {
                super.onFinish();
                hideProgress();
            }
        });
    }

    @Override
    public void onDestroy()
    {
        RequestManager.getInstance().cancelTag(MainBusiness.class.getName());
    }

    public interface Callback extends IBSProgressCallback
    {
        /**
         * 显示初始化接口的结果
         *
         * @param result
         */
        void onBsShowInitResult(String result);
    }
}
