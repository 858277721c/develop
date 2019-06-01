package com.sd.lib.develop.callback;

import com.sd.lib.stream.FStream;

public interface BSProgress extends FStream
{
    void onBsShowProgress(String msg);

    void onBsHideProgress();
}
