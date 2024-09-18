package com.example.mycaculator;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button bt_decimal,bt_pow, bt_clear, bt_delete, bt_equal, bt_number1, bt_number2, bt_number3, bt_number4, bt_number5, bt_number6, bt_number7, bt_number8, bt_number9, bt_number0, bt_devision, bt_multiplication, bt_subtraction, bt_addition, bt_percentage;
    TextView ed_result_display, ed_curent_caculation_display;
    boolean isResultDisplayed = false;
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

        init();

        // Kích hoạt cuộn ngang cho TextView
        ed_result_display.setMovementMethod(new ScrollingMovementMethod());
        ed_curent_caculation_display.setMovementMethod(new ScrollingMovementMethod());


        bt_number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("0");
            }
        });
        bt_number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("1");
            }
        });
        bt_number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("2");
            }
        });
        bt_number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("3");
            }
        });
        bt_number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("4");
            }
        });
        bt_number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("5");
            }
        });
        bt_number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("6");
            }
        });
        bt_number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("7");
            }
        });
        bt_number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("8");
            }
        });
        bt_number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("9");
            }
        });
        bt_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("%");
            }
        });
        bt_devision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("/");
            }
        });
        bt_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("*");
            }
        });
        bt_subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("-");
            }
        });
        bt_addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("+");
            }
        });
        bt_decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(".");
            }
        });
        bt_pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult("^");
            }
        });

        bt_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = ed_result_display.getText().toString();
                try {
                    Expression exp = new ExpressionBuilder(expression).build();
                    double result = exp.evaluate();
                    ed_curent_caculation_display.setText(expression);
                    ed_result_display.setText(String.valueOf(result));
                    // Đặt cờ để biết rằng kết quả đã được tính toán
                    isResultDisplayed = true;
                    ed_curent_caculation_display.post(() -> {
                        int scrollX = ed_curent_caculation_display.getLayout().getWidth() - ed_curent_caculation_display.getWidth();
                        if (scrollX > 0) {
                            ed_curent_caculation_display.scrollTo(scrollX, 0);
                        }
                    });
                } catch (Exception e) {
                    ed_result_display.setText("Error");
                }
            }
        });

        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_curent_caculation_display.setText("");
                ed_result_display.setText("");
                isResultDisplayed = false;
            }
        });

        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String originalString = ed_result_display.getText().toString();
                if (!originalString.isEmpty()) {
                    String modifiedString = originalString.substring(0, originalString.length() - 1);
                    ed_result_display.setText(modifiedString);
                }
            }
        });
    }

    private void setResult(String s) {
        if (isResultDisplayed) {
            ed_curent_caculation_display.setText(ed_result_display.getText().toString());
            // Nếu kết quả đã được hiển thị, xóa kết quả và cài đặt chế độ nhập mới
            ed_result_display.setText("");
            isResultDisplayed = false;
        }
        // Cập nhật nội dung của TextView
        ed_result_display.append(s);

        // Cuộn ngang đến cuối nội dung sau khi nội dung đã được cập nhật
        ed_result_display.post(() -> {
            int scrollX = ed_result_display.getLayout().getWidth() - ed_result_display.getWidth();
            if (scrollX > 0) {
                ed_result_display.scrollTo(scrollX, 0);
            }
        });

    }
    private void setThemeMode(boolean isDarkMode) {
        if (isDarkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    private void init() {
        bt_equal = findViewById(R.id.bt_equal);
        bt_number1 = findViewById(R.id.bt_number1);
        bt_number2 = findViewById(R.id.bt_number2);
        bt_number3 = findViewById(R.id.bt_number3);
        bt_number4 = findViewById(R.id.bt_number4);
        bt_number5 = findViewById(R.id.bt_number5);
        bt_number6 = findViewById(R.id.bt_number6);
        bt_number7 = findViewById(R.id.bt_number7);
        bt_number8 = findViewById(R.id.bt_number8);
        bt_number9 = findViewById(R.id.bt_number9);
        bt_number0 = findViewById(R.id.bt_number0);
        bt_pow = findViewById(R.id.bt_pow);
        bt_delete = findViewById(R.id.bt_delete);
        bt_clear = findViewById(R.id.bt_clear);
        bt_percentage = findViewById(R.id.bt_percentage);
        bt_devision = findViewById(R.id.bt_devision);
        bt_multiplication = findViewById(R.id.bt_multiplication);
        bt_subtraction = findViewById(R.id.bt_subtraction);
        bt_addition = findViewById(R.id.bt_addition);
        bt_decimal = findViewById(R.id.bt_decimal);
        ed_result_display = findViewById(R.id.ed_result_display);
        ed_curent_caculation_display = findViewById(R.id.ed_curent_caculation_display);
    }
}