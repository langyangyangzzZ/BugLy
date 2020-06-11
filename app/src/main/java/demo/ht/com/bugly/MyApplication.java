package demo.ht.com.bugly;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import static com.tencent.bugly.beta.tinker.TinkerManager.getApplication;

public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        // 调试时，将第三个参数改为true
        Bugly.init(getApplication(), "78e175c3a6", false);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        // 安装tinker
        Beta.installTinker();
    }

}
