package com.fanwe.lib.develop.business;

/**
 * Created by zhengjun on 2017/10/31.
 */
public interface IBusiness<T>
{
    void setCallback(T callback);

    T getCallback();

    void onDestroy();
}
