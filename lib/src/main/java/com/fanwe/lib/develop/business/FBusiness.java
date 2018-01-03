package com.fanwe.lib.develop.business;

import com.fanwe.lib.develop.callback.FBSProgressCallback;

/**
 * Created by zhengjun on 2017/10/31.
 */
public abstract class FBusiness<T>
{
    private T mCallback;

    public void setCallback(T callback)
    {
        mCallback = callback;
    }

    public T getCallback()
    {
        return mCallback;
    }

    /**
     * 返回用于取消http请求的标识
     *
     * @return
     */
    public String getHttpCancelTag()
    {
        return getClass().getName();
    }

    /**
     * 显示加载框
     *
     * @param msg
     */
    public void showProgress(String msg)
    {
        final T callback = getCallback();
        if (callback instanceof FBSProgressCallback)
        {
            FBSProgressCallback progressCallback = (FBSProgressCallback) callback;
            progressCallback.onBsShowProgress(msg);
        }
    }

    /**
     * 隐藏加载框
     */
    public void hideProgress()
    {
        final T callback = getCallback();
        if (callback instanceof FBSProgressCallback)
        {
            FBSProgressCallback progressCallback = (FBSProgressCallback) callback;
            progressCallback.onBsHideProgress();
        }
    }

    public abstract void onDestroy();
}
