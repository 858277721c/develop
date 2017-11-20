package com.fanwe.lib.develop.business;

import com.fanwe.lib.develop.callback.IBSCallback;

/**
 * Created by zhengjun on 2017/10/31.
 */
public abstract class BaseBusiness<V extends IBSCallback> implements IBusiness<V>
{
    private V mCallback;

    @Override
    public void setCallback(V callback)
    {
        mCallback = callback;
    }

    @Override
    public V getCallback()
    {
        return mCallback;
    }
}
