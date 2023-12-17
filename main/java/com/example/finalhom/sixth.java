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

public class sixth extends AppCompatActivity  implements View.OnClickListener {
    private SQLiteDatabase db=null;
    private Button search;
    private EditText id;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);
        ActionBar bar=getSupportActionBar();
        bar.setTitle("search");
        bar.setDisplayHomeAsUpEnabled(true);

        search=(Button)findViewById(R.id.search2);
        id=(EditText)findViewById(R.id.id4);
        search.setOnClickListener(this);
        db=this.openOrCreateDatabase("SpringDb1.db",MODE_PRIVATE,null);
    }
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }//on

    @Override
    public void onClick(View view) {
        if(view==search){
            Cursor rs=null;


            rs= db.rawQuery("select * from emp",null);
            int x=Integer.parseInt(id.getText().toString());
            while ( rs.moveToNext())
            {
                if(rs.getInt(0)==x){
                    System.out.println("yes ");
                    System.out.println("record---> "+ rs.getPosition()+"   id=" + rs.getInt(0) + " name=" + rs.getString(1)+ " sex="+ rs.getFloat(2)+" base="+ rs.getFloat(3)+" total="+ rs.getFloat(4)+" rate="+ rs.getFloat(5)+" salary="+ rs.getFloat(6));

                }///f
                else{
                    System.out.println("no record with this id ");
                }//else
            }//ehile
        }//searyhc
    }//on
}//sicth