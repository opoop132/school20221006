package com.example.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt = null;
    TextFileManager blah = new TextFileManager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setTitle("메모장");
        
        txt = findViewById(R.id.memo);
        
        
    }
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.load_btn: {
                String memodata = blah.load();
                txt.setText(memodata);
                Toast.makeText(this, "불러오기 완료", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.save_btn: {
                String memodata = txt.getText().toString();
                blah.save(memodata);
                Toast.makeText(this, "저장 완료", Toast.LENGTH_SHORT).show();
                txt.setText("");
                break;
            }
            case R.id.delete_btn: {
                blah.delete();
                txt.setText("");
                Toast.makeText(this, "삭제 완료", Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }
}