Android Code Scan View
============================
Android 条形码、二维码扫描组件

## 如何引用此组件：
### 安装
```
git clone https://github.com/mindpin/codescanview.git
cd codescanview
mvn clean install
```

### maven引用
在maven项目，pom.xml添加以下依赖引用：

```
<dependency>
  <groupId>com.mindpin.android.codescanview</groupId>
  <artifactId>codescanview</artifactId>
  <version>0.1.0-SNAPSHOT</version>
  <type>apklib</type>
</dependency>
```

### android权限设置
AndroidManifest.xml 添加如下权限
```
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.FLASHLIGHT" />
<uses-permission android:name="android.permission.VIBRATE" />
<uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

<uses-feature android:name="android.hardware.camera" />
<uses-feature android:name="android.hardware.camera.autofocus" />
```

## 使用说明
请参考示例

## 使用注意事项

### 设置listener

Code Scan View必须```set_code_scan_listener```对于扫描结果才会有响应，否则只是一个简单的显示组件
```
code_scan_view = (CodeScanView)findViewById(R.id.code_scan_view);

code_scan_view.set_code_scan_listener(new CodeScanListener(){
    public void on_code_read(String result){
    };

    public void camera_not_found(){
    };
    public void on_code_not_read(){
    };
});
```

### 重写Activity
由于使用此组建需要用到摄像头（相机），是很耗资源的，需要在切出、退出时关闭摄像头，所以需要做以下Override
```
@Override
protected void onResume() {
  super.onResume();
  code_scan_view.start_preview();
}

@Override
protected void onPause() {
  super.onPause();
  code_scan_view.stop_preview();
}

@Override
protected void onDestroy() {
  code_scan_view.onDestroy();
  super.onDestroy();
}
```

