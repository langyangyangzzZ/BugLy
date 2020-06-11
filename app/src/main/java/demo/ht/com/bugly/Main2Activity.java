package demo.ht.com.bugly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    public Handler mHandler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                if (GlobalVariable.mTime > 0) {
                    Log.i("GlobalVariable",GlobalVariable.mTime+"");
                    GlobalVariable.mTime--;

                    tv.setText(GlobalVariable.mTime+"");
                    mHandler.sendEmptyMessageDelayed(1,1000);
                }else{
                    GlobalVariable.mTime = 60;
                    tv.setText("倒计时结束");
                }
            }


        }
    };
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.tv);
        mHandler.sendEmptyMessageDelayed(1,1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
