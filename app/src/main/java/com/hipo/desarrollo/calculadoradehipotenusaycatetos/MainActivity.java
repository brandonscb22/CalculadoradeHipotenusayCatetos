package com.hipo.desarrollo.calculadoradehipotenusaycatetos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        final Button button = (Button) findViewById(R.id.button_calculator);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.one_num);
                EditText editText1 = (EditText) findViewById(R.id.two_num);
                if (!editText.getText().toString().trim().equals("")){
                    float par = Float.parseFloat(editText.getText().toString());
                    if (!editText1.getText().toString().trim().equals("")){
                        TextView resul1 = (TextView) findViewById(R.id.resul);
                        float par2 = Float.parseFloat(editText1.getText().toString());
                        if(spinner.getFirstVisiblePosition()== 0){
                            float resultado1 = (float) Math.sqrt(Math.pow(par,2)+Math.pow(par2,2));
                            resul1.setText(Float.toString(resultado1));
                        }
                        else if(spinner.getFirstVisiblePosition()== 1){
                            float resultado1 = (float) Math.sqrt(Math.pow(par2,2)-Math.pow(par,2));
                            resul1.setText(Float.toString(resultado1));
                        }
                        else if(spinner.getFirstVisiblePosition()== 2){
                            float resultado1 = (float) Math.sqrt(Math.pow(par2,2)-Math.pow(par,2));
                            resul1.setText(Float.toString(resultado1));
                        }
                    }
                    else {
                        editText1.setError( "Segundo numero requerido!" );
                    }
                }
                else{
                    editText.setError( "Primer numero requerido!" );
                }
            }
        });

    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        // Cambian los TextView cuando se selecciona una opcion de spinner
        TextView text1 = (TextView) findViewById(R.id.text_1);
        TextView text2 = (TextView) findViewById(R.id.text_2);
        switch (pos) {
            case 0:
                // seleccionado hipotenusa
                text1.setText("Cateto A");
                text2.setText("Cateto B");
                break;
            case 1:
                // seleccionado Cateto A
                text1.setText("Cateto B");
                text2.setText("Hipotenusa C");
                break;
            case 2:
                // seleccionado Cateto B
                text1.setText("Cateto A");
                text2.setText("Hipotenusa C");
                break;

        }
    }
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
