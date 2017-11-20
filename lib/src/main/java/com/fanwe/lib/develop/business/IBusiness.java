package com.fanwe.lib.develop.business;

/**
 * Created by zhengjun on 2017/10/31.
 */
public interface IBusiness<V>
{
    void setCallback(V callback);

    V getCallback();

    void onDestroy();
}
