package com.fanwe.lib.develop.callback;

/**
 * Created by zhengjun on 2017/10/31.
 */

public interface IBSProgressCallback extends IBSCallback
{
    void onBsShowProgress(String msg);

    void onBsHideProgress();
}