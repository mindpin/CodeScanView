package com.mindpin.android.codescanview;

/**
 * Created by dd on 14-6-26.
 */
public interface CodeScanListener {
    // 当读取到 code 时，这个方法就会运行
    // result 是读到的结果转换成的字符串
    public void on_code_read(String result);

    // 当手机没有摄像头时，这个方法就会运行
    public void camera_not_found();

    // 当摄像头扫描到图像，但是没有读到 code 时，这个方法就会运行
    public void on_code_not_read();
}
