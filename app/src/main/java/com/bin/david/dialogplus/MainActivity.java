package com.bin.david.dialogplus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.bin.david.dialoglib.BaseDialog;
import com.bin.david.dialoglib.anim.CircularDialogAnim;
import com.bin.david.dialoglib.anim.RotateXDialogAnim;
import com.bin.david.dialoglib.anim.RotateYDialogAnim;
import com.bin.david.dialoglib.anim.SpringDialogAnim;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_center).setOnClickListener(this);
        findViewById(R.id.btn_bottom).setOnClickListener(this);
        findViewById(R.id.btn_top).setOnClickListener(this);
        findViewById(R.id.btn_circular).setOnClickListener(this);
        findViewById(R.id.btn_rotateX).setOnClickListener(this);
        findViewById(R.id.btn_rotateY).setOnClickListener(this);
        findViewById(R.id.btn_spring).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
      BaseDialog.Builder builder =  new  BaseDialog.Builder(this);
        switch (v.getId()){
            case R.id.btn_center:
                builder.setGravity(Gravity.CENTER);
                break;
            case R.id.btn_bottom:
                builder.setGravity(Gravity.BOTTOM);
                break;
            case R.id.btn_top:
                builder.setGravity(Gravity.TOP);
                break;
            case R.id.btn_circular:
                builder.setDialogAnimtor(new CircularDialogAnim());
                break;
            case R.id.btn_rotateX:
                builder.setDialogAnimtor(new RotateXDialogAnim());
                break;
            case R.id.btn_rotateY:
                builder.setDialogAnimtor(new RotateYDialogAnim());
                break;
            case R.id.btn_spring:
                builder.setGravity(Gravity.BOTTOM).setFillHeight(true).setDialogAnimtor(new SpringDialogAnim());
                break;

        }
        builder.setFillWidth(true).setContentViewBackground(R.drawable.dialog_white_bg);
        BaseCheckDialog<String> checkDialog = new BaseCheckDialog<>("测试标题", new BaseCheckDialog.OnCheckChangeListener<String>() {
            @Override
            public String getItemText(String s) {
                return s;
            }

            @Override
            public void onItemClick(String s, int position) {

            }
        },builder);
        List<String> datas = new ArrayList<>();
        for(int i = 0;i <5;i++){
            datas.add("测试项目序列"+i);
        }
        checkDialog.show(this,true,datas);
    }
}
