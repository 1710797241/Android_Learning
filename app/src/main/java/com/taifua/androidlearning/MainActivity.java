package com.taifua.androidlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUIView;
    private Button jiaBtn;
    private Button theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setTheme(R.style.AppTheme2);
        setContentView(R.layout.activity_main);

        mBtnUIView = findViewById(R.id.btn_ui_view);
        jiaBtn = findViewById(R.id.jia);
        theme = findViewById(R.id.theme);
        setListeners();

    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnUIView.setOnClickListener(onClick);
        JiaClick jiaClick = new JiaClick();
        jiaBtn.setOnClickListener(jiaClick);
        ThemeClick themeClick = new ThemeClick();
        theme.setOnClickListener(themeClick);

    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.btn_ui_view:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }
    }

    private class JiaClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()) {
                case R.id.jia:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    startActivity(intent);
                    break;
                default:
                    break;
            }
        }


    }

    private class ThemeClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.theme:
                    setTheme(R.style.AppTheme2);
                    recreate();
                    break;
                default:
                    break;
            }

        }


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //前台显示
    }

    @Override
    protected void onPause() {
        super.onPause();
        //页面隐藏
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

}
