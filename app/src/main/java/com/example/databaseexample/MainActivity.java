package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnInsert;
    Button btnDelete;
    Button btnSearch;
    Button btnGetAll;
    TextView txtInsertName;
    TextView txtInsertAge;
    TextView txtDelete;
    TextView txtSearch;

    DataManager dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dm = new DataManager(this);

        btnInsert = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);
        btnSearch = findViewById(R.id.btnSearch);
        btnGetAll = findViewById(R.id.btnSelectAll);

        txtInsertName = findViewById(R.id.txtName);
        txtInsertAge = findViewById(R.id.txtAge);
        txtDelete = findViewById(R.id.txtDelete);
        txtSearch = findViewById(R.id.txtSearch);

        btnInsert.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnGetAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnDelete)
        {
            if(txtDelete.getText() != "")
            {
                dm.DeleteAUser(txtDelete.getText().toString());
            }
        }
        else if(v.getId() == R.id.btnInsert)
        {
            if(txtInsertName.getText() != "" && txtInsertAge.getText() != "")
            {
                dm.InsertAUser(txtInsertName.getText().toString(), txtInsertAge.getText().toString());
            }
        }

        else if(v.getId() == R.id.btnSearch)
        {
            if(txtSearch.getText() != "")
            {
                showData(dm.GetAUser(txtSearch.getText().toString()));
            }
        }
        else if(v.getId() == R.id.btnSelectAll)
        {
            showData(dm.SelectAll());
        }

    }

    public void showData(Cursor c)
    {
        while(c.moveToNext())
        {
            Toast.makeText(this,c.getString(1)+" "+c.getString(2),Toast.LENGTH_LONG).show();
            Log.i(c.getString(1), c.getString(2));
        }
    }
}