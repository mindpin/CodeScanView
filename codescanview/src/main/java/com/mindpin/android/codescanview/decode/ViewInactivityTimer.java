package com.mindpin.android.codescanview.decode;

import com.mindpin.android.codescanview.CodeScanView;

import java.util.concurrent.*;

/**
 * 作者: 陈涛(1076559197@qq.com)
 * 
 * 时间: 2014年5月9日 下午12:25:12
 *
 * 版本: V_1.0.0
 * 
 */
public final class ViewInactivityTimer {

	private static final int INACTIVITY_DELAY_SECONDS = 5 * 60;

	private final ScheduledExecutorService inactivityTimer = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory());
	private final CodeScanView view;
	private ScheduledFuture<?> inactivityFuture = null;

	public ViewInactivityTimer(CodeScanView activity) {
		this.view = activity;
		onActivity();
	}

	public void onActivity() {
		cancel();
		inactivityFuture = inactivityTimer.schedule(new ViewFinishListener(view), INACTIVITY_DELAY_SECONDS, TimeUnit.SECONDS);
	}

	private void cancel() {
		if (inactivityFuture != null) {
			inactivityFuture.cancel(true);
			inactivityFuture = null;
		}
	}

	public void shutdown() {
		cancel();
		inactivityTimer.shutdown();
	}

	private static final class DaemonThreadFactory implements ThreadFactory {
		public Thread newThread(Runnable runnable) {
			Thread thread = new Thread(runnable);
			thread.setDaemon(true);
			return thread;
		}
	}

}
