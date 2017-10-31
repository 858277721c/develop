package com.fanwe.lib.develop.view;

/**
 * Created by zhengjun on 2017/10/31.
 */

public interface IProgressView extends IView
{
    void showProgress(String msg);

    void hideProgress();
}
