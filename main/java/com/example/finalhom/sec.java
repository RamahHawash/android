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

public class sec extends AppCompatActivity implements View.OnClickListener {
    private SQLiteDatabase db = null;
    private Button add;
    private EditText id;
    private EditText name;
    private EditText salary;
    private EditText base;
    private EditText total;
    private EditText sex;
    private EditText rate;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("add");
        bar.setDisplayHomeAsUpEnabled(true);
        //  add = dialogView.findViewById<Button>(R.id.buttonOk)

        add = (Button) findViewById(R.id.add2);
        name = (EditText) findViewById(R.id.name);
        salary = (EditText) findViewById(R.id.salary);
        base = (EditText) findViewById(R.id.base);
        total = (EditText) findViewById(R.id.total);
        sex = (EditText) findViewById(R.id.sex);
        id = (EditText) findViewById(R.id.id);
        rate = (EditText) findViewById(R.id.rate);
        //findViewById(R.id.add2).setOnClickListener(this);

        add.setOnClickListener(this);
        db = this.openOrCreateDatabase("SpringDb1.db", MODE_PRIVATE, null);

    }

    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }//on

    @Override
    public void onClick(View view) {

        if (view == add) {
            Cursor rs = null;

            int flag = 0;
            rs = db.rawQuery("select * from emp", null);
            int x = Integer.parseInt(id.getText().toString());
            while (rs.moveToNext()) {
                if (rs.getInt(0) == x) {
                    System.out.println("there a record with this id choose another id ");
                    flag = 1;

                }//if

            }//while
            if (flag == 0) {
                db.execSQL("insert into emp values(?,?,?,?,?,?,?);", new Object[]{id.getText(), name.getText(), sex.getText(), base.getText(), total.getText(), rate.getText(), salary.getText()});

            }//if
        }//if
    }//on click
}//sec