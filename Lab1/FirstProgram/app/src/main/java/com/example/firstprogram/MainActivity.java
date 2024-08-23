package com.example.firstprogram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtX, txtY;
    TextView txtResult;
    Button btnPlus, btnMinus, btnDevide, btnMulti, btnDevide2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initControl();
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtX.getText().toString().isEmpty()||txtY.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ dữ kiện",Toast.LENGTH_SHORT).show();
                }else{
                    int x = Integer.parseInt(txtX.getText().toString());
                    int y = Integer.parseInt(txtY.getText().toString());
                    int result = x+y;
                    txtResult.setText(String.valueOf(result));
                }
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtX.getText().toString().isEmpty()||txtY.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ dữ kiện",Toast.LENGTH_SHORT).show();
                }else{
                    int x = Integer.parseInt(txtX.getText().toString());
                    int y = Integer.parseInt(txtY.getText().toString());
                    int result = x-y;
                    txtResult.setText(String.valueOf(result));
                }
            }
        });
        btnDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtX.getText().toString().isEmpty()||txtY.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ dữ kiện",Toast.LENGTH_SHORT).show();
                }else{
                    int x = Integer.parseInt(txtX.getText().toString());
                    int y = Integer.parseInt(txtY.getText().toString());
                    if (y==0){
                        Toast.makeText(MainActivity.this,"Không thực hiện được phép chia cho số 0",Toast.LENGTH_SHORT).show();
                    }
                   else {
                        double result = x*1.0/y;
                        txtResult.setText(String.format("%.2f",result));
                    }
                }
            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtX.getText().toString().isEmpty()||txtY.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ dữ kiện",Toast.LENGTH_SHORT).show();
                }else{
                    int x = Integer.parseInt(txtX.getText().toString());
                    int y = Integer.parseInt(txtY.getText().toString());
                    int result = x*y;
                    txtResult.setText(String.valueOf(result));
                }
            }
        });
        btnDevide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtX.getText().toString().isEmpty()||txtY.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ dữ kiện",Toast.LENGTH_SHORT).show();
                }else{
                    int x = Integer.parseInt(txtX.getText().toString());
                    int y = Integer.parseInt(txtY.getText().toString());
                    if (y==0){
                        Toast.makeText(MainActivity.this,"Không thực hiện được phép chia cho số 0",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        int result = x%y;
                        txtResult.setText(String.valueOf(result));
                    }
                }
            }
        });
    }
    void initControl(){
        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtResult = findViewById(R.id.txtResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDevide = findViewById(R.id.btnDevide);
        btnMulti = findViewById(R.id.btnMulti);
        btnDevide2 = findViewById(R.id.btnDevide2);
    }

}