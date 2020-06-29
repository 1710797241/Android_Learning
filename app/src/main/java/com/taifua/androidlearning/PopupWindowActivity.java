package com.taifua.androidlearning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

public class PopupWindowActivity extends AppCompatActivity
{

    private Button mBtnPop;
    private PopupWindow mPop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        mBtnPop = findViewById(R.id.btn_pop);
        mBtnPop.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                View popview = getLayoutInflater().inflate(R.layout.layout_pop, null);
                TextView textView = popview.findViewById(R.id.tv_good);
                textView.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        mPop.dismiss();
                        ToastUtil.showMsg(PopupWindowActivity.this, "妙啊");
                    }
                });
                TextView textView1 = popview.findViewById(R.id.tv_bad);
                textView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPop.dismiss();
                        ToastUtil.showMsg(PopupWindowActivity.this, "no妙");

                    }
                });
                mPop = new PopupWindow(popview, mBtnPop.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                mPop.setOutsideTouchable(true);//离焦消失
                mPop.setFocusable(true);//聚焦显示
                mPop.showAsDropDown(mBtnPop);
            }
        });
    }
}
