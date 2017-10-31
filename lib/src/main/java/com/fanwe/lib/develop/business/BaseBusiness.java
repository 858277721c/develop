package com.fanwe.lib.develop.business;

import com.fanwe.lib.develop.view.IView;

/**
 * Created by zhengjun on 2017/10/31.
 */
public abstract class BaseBusiness<V extends IView> implements IBusiness<V>
{
    private V mView;

    @Override
    public void setView(V view)
    {
        mView = view;
    }

    @Override
    public V getView()
    {
        return mView;
    }
}
