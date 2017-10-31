package com.fanwe.www.develop.business;

import com.fanwe.lib.develop.business.BaseBusiness;
import com.fanwe.lib.develop.view.IProgressView;
import com.fanwe.lib.develop.view.IView;

/**
 * Created by Administrator on 2017/10/31.
 */
public abstract class MainBusiness extends BaseBusiness<MainBusiness.MainView>
{
    /**
     * 请求初始化接口
     */
    abstract public void requestInitAndShow();

    public interface MainView extends IView, IProgressView
    {
        /**
         * 显示初始化接口的结果
         *
         * @param result
         */
        void showInitResult(String result);
    }
}
