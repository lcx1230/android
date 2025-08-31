package com.liuchuxin.demo.eventBus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.liuchuxin.demo.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.w3c.dom.Text;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    private TextView tv_message;
    private Button bt_message;
    private Button bt_subscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_message=findViewById(R.id.tv_message);
        tv_message.setText("MainActivity");
        bt_subscription=findViewById(R.id.bt_subscription);
        bt_subscription.setText("注册事件");
        bt_message=findViewById(R.id.bt_message);
        bt_message.setText("跳转到SecondActivity");

        bt_subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注册事件
                EventBus.getDefault().register(MainActivity.this);
            }
        });
        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //注册事件
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册事件
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
        public void onMoonEvent(MessageEvent messageEvent){
        tv_message.setText(messageEvent.getMessage());
    }
}