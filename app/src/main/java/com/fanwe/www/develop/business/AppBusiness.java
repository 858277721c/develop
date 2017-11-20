package com.fanwe.www.develop.business;

import com.fanwe.lib.develop.business.BaseBusiness;
import com.fanwe.lib.develop.view.IBSView;

/**
 * Created by Administrator on 2017/11/1.
 */

public abstract class AppBusiness<V extends IBSView> extends BaseBusiness<V>
{
    /**
     * 获得取消http请求的tag
     *
     * @return
     */
    public String getHttpCancelTag()
    {
        return getClass().getName();
    }



}
