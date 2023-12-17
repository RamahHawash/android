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

public class third extends AppCompatActivity implements View.OnClickListener {
    private SQLiteDatabase db=null;
    private Button display;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ActionBar bar=getSupportActionBar();
        bar.setTitle("display");
        bar.setDisplayHomeAsUpEnabled(true);
        //  add = dialogView.findViewById<Button>(R.id.buttonOk)

        display=(Button)findViewById(R.id.display2);
        display.setOnClickListener(this);
        db=this.openOrCreateDatabase("SpringDb1.db",MODE_PRIVATE,null);
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }//on


    @Override
    public void onClick(View view) {
        if(view==display){
            Cursor rs=null;


            rs= db.rawQuery("select * from emp",null);

            int co = rs.getColumnCount();
            System.out.println(" Number of rows ="+rs.getCount() + "   before first "+ rs.isBeforeFirst());



            for (int i =0 ; i < co ; i++)
            {
                System.out.print(rs.getColumnName(i) + " ");
            }
            System.out.println();

            while ( rs.moveToNext())
            {
                System.out.println("record---> "+ rs.getPosition()+"   id=" + rs.getInt(0) + " name=" + rs.getString(1)+ " sex="+ rs.getFloat(2)+" base="+ rs.getFloat(3)+" total="+ rs.getFloat(4)+" rate="+ rs.getFloat(5)+" salary="+ rs.getFloat(6));


            }//while
        }//if
    }//on click
}//third