package com.sd.www.develop;

import android.app.Application;

import com.fanwe.lib.http.RequestManager;
import com.fanwe.lib.http.cookie.SerializableCookieStore;

/**
 * Created by Administrator on 2017/10/27.
 */
public class App extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        RequestManager.getInstance().setDebug(BuildConfig.DEBUG);
        RequestManager.getInstance().setCookieStore(new SerializableCookieStore(this));
    }
}
