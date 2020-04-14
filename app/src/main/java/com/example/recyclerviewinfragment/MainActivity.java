package com.example.recyclerviewinfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements PersonAdapter.OnItemSelected {

    TextView tvName, tvTel;
    EditText etName, etTel;
    Button btnAdd;
    ListFrag listFrag;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvName = findViewById(R.id.tvName);
        tvTel = findViewById(R.id.tvTel);
        etName = findViewById(R.id.etName);
        etTel = findViewById(R.id.etTel);
        btnAdd = findViewById(R.id.btnAdd);

        manager = getSupportFragmentManager();
        listFrag = (ListFrag) manager.findFragmentById(R.id.listfrag);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myApplication.people.add(new Person(etName.getText().toString(),etTel.getText().toString()));
                listFrag.notifyDataChanged();
                etName.setText("");
                etTel.setText("");
            }
        });

        onItemClick(0);

    }

    @Override
    public void onItemClick(int index) {
        tvName.setText(myApplication.people.get(index).getName());
        tvTel.setText(myApplication.people.get(index).getTelnumber());
    }
}