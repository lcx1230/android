package com.liuchuxin.demo.eventBus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.liuchuxin.demo.R;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {
    private TextView tv_message;
    private Button bt_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv_message=findViewById(R.id.tv_message);
        tv_message.setText("MainActivity");
        bt_message=findViewById(R.id.bt_message);
        bt_message.setText("发送事件");
        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("欢迎来到2025.8.30刘楚鑫的家"));
                finish();
            }
        });
    }
}