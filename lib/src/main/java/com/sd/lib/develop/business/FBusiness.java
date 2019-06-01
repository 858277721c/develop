package com.sd.lib.develop.business;

import com.sd.lib.stream.FStream;

public abstract class FBusiness
{
    private final String mTag;

    public FBusiness(String tag)
    {
        mTag = tag;
        onCreate();
    }

    public final String getTag()
    {
        return mTag;
    }

    protected final <T extends FStream> T getStream(Class<T> clazz)
    {
        return new FStream.ProxyBuilder().setTag(getTag()).build(clazz);
    }

    public void onCreate()
    {
    }

    public void onDestroy()
    {
    }
}
