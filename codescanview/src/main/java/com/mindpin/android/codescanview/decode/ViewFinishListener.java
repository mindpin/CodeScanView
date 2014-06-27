package com.mindpin.android.codescanview.decode;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;

public final class ViewFinishListener
        implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, Runnable {

    private final Activity activityToFinish;

    public ViewFinishListener(View activityToFinish) {
        this.activityToFinish = (Activity) activityToFinish.getContext();
    }

    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    public void run() {
        activityToFinish.finish();
    }

}
