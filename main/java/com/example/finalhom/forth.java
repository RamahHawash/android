package com.example.finalhom;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forth extends AppCompatActivity implements View.OnClickListener{
    private SQLiteDatabase db=null;

    private Button delete;
    private EditText id;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);
        ActionBar bar=getSupportActionBar();
        bar.setTitle("delete");
        bar.setDisplayHomeAsUpEnabled(true);
        delete=(Button)findViewById(R.id.delete2);
        id=(EditText)findViewById(R.id.id2);
        delete.setOnClickListener(this);
        db=this.openOrCreateDatabase("SpringDb1.db",MODE_PRIVATE,null);

    }

    @Override
    public void onClick(View view) {
        Cursor rs = null;
        rs = db.rawQuery("select * from emp", null);
        int flag=0;
        int x = Integer.parseInt(id.getText().toString());
        if(view==delete){
            while (rs.moveToNext()) {
                if(rs.getInt(0)==x) {
                    db.execSQL("delete from emp where id ==?", new Object[]{id.getText()});
                    flag =1;
                }//if
            }//while
            if(flag==0)System.out.println("no record with this id");
        }//delete

    }//on
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }//on

}