package org.techtown.fitness;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button storebt;
    EditText name_edt, age_edt, weight_edt;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = firebaseDatabase.getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storebt = (Button) findViewById(R.id.btn1);
        name_edt = (EditText)findViewById(R.id.edt1);
        age_edt = (EditText)findViewById(R.id.edt2);
        weight_edt = (EditText)findViewById(R.id.edt3);



        storebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = name_edt.getText().toString();
                databaseReference.child("message").push().setValue(user_name);

                String user_age = age_edt.getText().toString();
                databaseReference.child("message").push().setValue(user_age);

                String user_weight = weight_edt.getText().toString();
                databaseReference.child("message").push().setValue(user_weight);

                Toast.makeText(getApplicationContext(), "저장 완료", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
