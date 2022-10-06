package com.example.memo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TextFileManager {
    private static final String FILE_NAME="memo.txt";
    Context m_context = null;

    public TextFileManager(Context context){
        m_context = context;
    }
    public void save(String data){
        if(data==null || data.equals("")){
            return;
        }
        FileOutputStream file = null;
        try{
            file = m_context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            file.write(data.getBytes());
            file.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String load(){
        try{
            FileInputStream file = m_context.openFileInput(FILE_NAME);
            byte[] memoData = new byte[file.available()];
            while (file.read(memoData)!=-1){
            }
            return new String(memoData);
        }catch (IOException e){

        }
        return "";
    }
    public void delete(){
        m_context.deleteFile(FILE_NAME);
    }
}
