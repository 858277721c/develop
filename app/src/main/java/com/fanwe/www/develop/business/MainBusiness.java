package com.fanwe.www.develop.business;

import com.fanwe.lib.develop.business.BaseBusiness;
import com.fanwe.lib.develop.view.IBSProgressView;
import com.fanwe.lib.develop.view.IBSView;
import com.fanwe.lib.http.PostRequest;
import com.fanwe.lib.http.Request;
import com.fanwe.lib.http.RequestManager;
import com.fanwe.lib.http.callback.StringRequestCallback;

/**
 * Created by Administrator on 2017/10/31.
 */
public class MainBusiness extends BaseBusiness<MainBusiness.MainView>
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
                getView().onBsShowProgress("请稍后");
            }

            @Override
            public void onSuccess()
            {
                getView().onBsShowInitResult(getResult());
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
        RequestManager.getInstance().cancelTag(MainBusiness.class.getName());
    }

    public interface MainView extends IBSView, IBSProgressView
    {
        /**
         * 显示初始化接口的结果
         *
         * @param result
         */
        void onBsShowInitResult(String result);
    }
}
