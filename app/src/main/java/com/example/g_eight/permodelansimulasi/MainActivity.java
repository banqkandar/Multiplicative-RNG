package com.example.g_eight.permodelansimulasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGenerate = findViewById(R.id.btn_generate);

        EditText etC = findViewById(R.id.et_c);
        final String strEtC = etC.getText().toString();
        btnGenerate.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(strEtC == "" ) {

                } else {
                    lcg();
                }

            }
        });
    }

    public void lcg() {
        EditText etA = findViewById(R.id.et_a);
        String val1 = etA.getText().toString();
        Integer a = Integer.valueOf(val1);

        EditText etC = findViewById(R.id.et_c);
        String val2 = etC.getText().toString();
        Integer c = Integer.valueOf(val2);

        EditText etZ0 = findViewById(R.id.et_z0);
        String val3 = etZ0.getText().toString();
        Integer z0 = Integer.valueOf(val3);

        EditText etM = findViewById(R.id.et_m);
        String val4 = etM.getText().toString();
        Integer m = Integer.valueOf(val4);

        EditText etValue = findViewById(R.id.et_value);
        String val5 = etValue.getText().toString();
        Integer value = Integer.valueOf(val5);

        TableLayout tl = findViewById(R.id.tl_display);

        for (int i = 1; i < value+1; i++) {
            TableRow tr = new TableRow(this);
            tr.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT));

            TextView tvZ0 = new TextView(this);
            tr.addView(tvZ0);

            int zi = (a * z0 + c) % m;
            TextView tvZi = new TextView(this);
            tvZi.setText("   Z" + String.valueOf(i) + " = ( " + String.valueOf(a) + "x" + String.valueOf(z0) + " + " + String.valueOf(c) + " ) mod " + String.valueOf(m) + " = " + String.valueOf(zi));
            tr.addView(tvZi);

            double ui = Double.valueOf(zi) / Double.valueOf(m);
            TextView tvUi = new TextView(this);
            tvUi.setText(String.format("    %.3f", ui));
            tr.addView(tvUi);

            z0 = zi;
            tl.addView(tr);
        }
    }

}
