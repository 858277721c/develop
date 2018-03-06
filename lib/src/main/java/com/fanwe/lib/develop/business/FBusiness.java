package com.fanwe.lib.develop.business;

import com.fanwe.lib.develop.callback.FBSProgressCallback;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

/**
 * Created by zhengjun on 2017/10/31.
 */
public abstract class FBusiness<T>
{
    private T mCallback;

    public void setCallback(T callback)
    {
        mCallback = callback;
    }

    public T getCallback()
    {
        if (mCallback == null)
        {
            final ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
            final Type[] types = parameterizedType.getActualTypeArguments();
            if (types != null && types.length == 1)
            {
                final Class<T> clazz = (Class<T>) types[0];
                if (clazz.isInterface())
                {
                    mCallback = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[]{clazz}, new InvocationHandler()
                    {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
                        {
                            final Class returnType = method.getReturnType();
                            if (returnType.isPrimitive())
                            {
                                return 0;
                            } else
                            {
                                return null;
                            }
                        }
                    });
                }
            } else
            {
                throw new RuntimeException("generic type length must be 1");
            }
        }
        return mCallback;
    }

    /**
     * 显示加载框
     *
     * @param msg
     */
    public void showProgress(String msg)
    {
        final T callback = getCallback();
        if (callback instanceof FBSProgressCallback)
        {
            FBSProgressCallback progressCallback = (FBSProgressCallback) callback;
            progressCallback.onBsShowProgress(msg);
        }
    }

    /**
     * 隐藏加载框
     */
    public void hideProgress()
    {
        final T callback = getCallback();
        if (callback instanceof FBSProgressCallback)
        {
            FBSProgressCallback progressCallback = (FBSProgressCallback) callback;
            progressCallback.onBsHideProgress();
        }
    }

    public abstract void onDestroy();
}
