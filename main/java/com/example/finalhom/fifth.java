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

public class fifth extends AppCompatActivity implements View.OnClickListener{
    private SQLiteDatabase db=null;

    private Button modify;
    private EditText id;
    private EditText name;
    private EditText sex;
    private EditText total;
    private EditText rate;
    private EditText base;
    private EditText salary;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        ActionBar bar=getSupportActionBar();
        bar.setTitle("modify");
        bar.setDisplayHomeAsUpEnabled(true);
        modify=(Button)findViewById(R.id.modify2);
        id=(EditText)findViewById(R.id.id3);
        name=(EditText)findViewById(R.id.name3);
        sex=(EditText)findViewById(R.id.sex3);
        total=(EditText)findViewById(R.id.total3);
        rate=(EditText)findViewById(R.id.rate3);
        base=(EditText)findViewById(R.id.base3);
        salary=(EditText)findViewById(R.id.salary3);

        modify.setOnClickListener(this);
        db=this.openOrCreateDatabase("SpringDb1.db",MODE_PRIVATE,null);
    }

    @Override
    public void onClick(View view) {
        String s=name.getText().toString();
        String a=sex.getText().toString();
        String d=base.getText().toString();
        String f =total.getText().toString();
        String g =rate.getText().toString();
        String h=salary.getText().toString();
        if(view==modify) {
            Cursor rs = null;

            int flag=0;
            rs = db.rawQuery("select * from emp", null);
            int x = Integer.parseInt(id.getText().toString());
            while (rs.moveToNext()) {
                if(rs.getInt(0)==x) {
                    if (s.isEmpty() == false)
                        db.execSQL("update emp set name =? where id = ?", new Object[]{s, id.getText()});
                    if (a.isEmpty() == false)
                        db.execSQL("update emp set sex =? where id = ?", new Object[]{a, id.getText()});
                    if (d.isEmpty() == false)
                        db.execSQL("update emp set base =? where id = ?", new Object[]{base.getText(), id.getText()});
                    if (f.isEmpty() == false)
                        db.execSQL("update emp set total =? where id = ?", new Object[]{total.getText(), id.getText()});
                    if (g.isEmpty() == false)
                        db.execSQL("update emp set rate=? where id = ?", new Object[]{rate.getText(), id.getText()});
                    if (h.isEmpty() == false)
                        db.execSQL("update emp set salary =? where id = ?", new Object[]{salary.getText(), id.getText()});
                    flag=1;
                }//if

            }//while
            if (flag==0)System.out.println("no record with this id");
        }//if
    }//onclick
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }//on
}