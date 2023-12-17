package com.example.finalhom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar bar=getSupportActionBar();
        bar.setTitle("menu");
        bar.setDisplayHomeAsUpEnabled(true);

        db=this.openOrCreateDatabase("SpringDb1.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists emp (id number primary key , name text ," +
                "                                  sex char , base  float ,total float , rate float ,salary float)");
    }//create
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater XX=getMenuInflater();
        XX.inflate(R.menu.menu1,menu);

        return super.onCreateOptionsMenu(menu);
    }//oncreatoption

    @SuppressLint("RestrictedApi")
    @Override

    public boolean onPrepareOptionsMenu(Menu menu) {
        if(menu instanceof MenuBuilder){
            ((MenuBuilder)menu).setOptionalIconsVisible((true));

        }//IF
        return super.onPrepareOptionsMenu(menu);
    }//prepear
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.add)
        {
            Intent A= new Intent(this,sec.class);

            startActivity(A);

        }//if
        else  if (item.getItemId()==R.id.display)
        {
            Intent  B= new Intent(this,third.class);

            startActivity(B);

        }//if
        else  if (item.getItemId()==R.id.delete)
        {
            Intent  C= new Intent(this,forth.class);

            startActivity(C);

        }//if
        else  if (item.getItemId()==R.id.modify)
        {
            Intent  d= new Intent(this,fifth.class);

            startActivity(d);

        }//if
        else  if (item.getItemId()==R.id.search)
        {
            Intent  t= new Intent(this,sixth.class);

            startActivity(t);

        }//if

        return super.onOptionsItemSelected(item);
    }//item selected
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}