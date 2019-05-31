package com.sd.www.develop.business;

import android.util.Log;

import com.sd.lib.develop.business.FBusiness;
import com.sd.lib.develop.callback.FBSProgressCallback;
import com.sd.lib.http.IRequest;
import com.sd.lib.http.Request;
import com.sd.lib.http.RequestManager;
import com.sd.lib.http.callback.StringRequestCallback;
import com.sd.lib.http.impl.httprequest.GetRequest;

/**
 * Created by Administrator on 2017/10/31.
 */
public class MainBusiness extends FBusiness<MainBusiness.Callback>
{
    public static final String TAG = MainBusiness.class.getSimpleName();

    public void requestInitAndShow()
    {
        Request request = new GetRequest();
        request.setBaseUrl("https://www.baidu.com");
        request.execute(new StringRequestCallback()
        {
            @Override
            public void onPrepare(IRequest request)
            {
                super.onPrepare(request);
                Log.i(TAG, "----- onPrepare " + this);
                request.setTag(MainBusiness.class.getName());
            }

            @Override
            public void onStart()
            {
                super.onStart();
                Log.i(TAG, "----- onStart " + this);
                showProgress("请稍后");
            }

            @Override
            public void onSuccess()
            {
                Log.i(TAG, "----- onSuccess " + this);
                getCallback().onBsShowInitResult(getResult());
            }

            @Override
            public void onError(Exception e)
            {
                Log.i(TAG, "----- onError " + e + " " + this);
                super.onError(e);
            }

            @Override
            public void onCancel()
            {
                Log.i(TAG, "----- onCancel " + this);
                super.onCancel();
            }

            @Override
            public void onFinish()
            {
                Log.i(TAG, "----- onFinish " + this);
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

    public interface Callback extends FBSProgressCallback
    {
        /**
         * 显示初始化接口的结果
         *
         * @param result
         */
        void onBsShowInitResult(String result);
    }
}
