package com.example.ktramusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_bai_hat extends AppCompatActivity implements View.OnClickListener {

    public static String EXTRA_INDEX_MUSIC = "index_music";
    public static String EXTRA_RES_ID_MUSIC = "res_id_music";

    private TextView mTxtIndex;
    private int mIndexSelected;
    private int mResIdSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_hat);

        getSupportActionBar().setTitle("chon nhac");

        mTxtIndex = findViewById(R.id.tv_index);

        findViewById(R.id.btn_select).setOnClickListener(this);
        findViewById(R.id.btn_index_1).setOnClickListener(this);
        findViewById(R.id.btn_index_2).setOnClickListener(this);
        findViewById(R.id.btn_index_3).setOnClickListener(this);
        findViewById(R.id.btn_index_4).setOnClickListener(this);
        findViewById(R.id.btn_index_5).setOnClickListener(this);
        findViewById(R.id.btn_index_6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_select:
                Intent intent = new Intent();
                intent.putExtra(EXTRA_INDEX_MUSIC, mIndexSelected);
                intent.putExtra(EXTRA_RES_ID_MUSIC, mResIdSelected);
                if(mIndexSelected == 0){
                    setResult(RESULT_CANCELED);
                } else {
                    setResult(RESULT_OK, intent);
                }
                finish();
                break;
            case R.id.btn_index_1:
                mResIdSelected = R.raw.bai-1;
                mIndexSelected = Integer.parseInt(((Button)v).getText().toString());
                mTxtIndex.setText(mIndexSelected + "");
                break;
            case R.id.btn_index_2:
                mResIdSelected = R.raw.bai-2;
                mIndexSelected = Integer.parseInt(((Button)v).getText().toString());
                mTxtIndex.setText(mIndexSelected + "");
                break;
            case R.id.btn_index_3:
                mResIdSelected = R.raw.bai-3;
                mIndexSelected = Integer.parseInt(((Button)v).getText().toString());
                mTxtIndex.setText(mIndexSelected + "");
                break;
            case R.id.btn_index_4:
                mResIdSelected = R.raw.bai-4;
                mIndexSelected = Integer.parseInt(((Button)v).getText().toString());
                mTxtIndex.setText(mIndexSelected + "");
                break;
            case R.id.btn_index_5:
                mResIdSelected = R.raw.bai-5;
                mIndexSelected = Integer.parseInt(((Button)v).getText().toString());
                mTxtIndex.setText(mIndexSelected + "");
                break;
            case R.id.btn_index_6:
                mResIdSelected = R.raw.bai-6;
                mIndexSelected = Integer.parseInt(((Button)v).getText().toString());
                mTxtIndex.setText(mIndexSelected + "");
                break;

            default:
                // @TODO: default
                break;
        }
    }
}