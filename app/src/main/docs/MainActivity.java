package com.example.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText panelResultado;
    private StringBuilder cadenaEntrada = new StringBuilder();
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();
        panelResultado = findViewById(R.id.panelResultado);

        inicializarBotonesNumeros();
        inicializarBotonesOperaciones();
    }

    private void inicializarBotonesNumeros() {
        Button[] botonesNumeros = new Button[]{
                findViewById(R.id.button0), findViewById(R.id.button1), findViewById(R.id.button2),
                findViewById(R.id.button3), findViewById(R.id.button4), findViewById(R.id.button5),
                findViewById(R.id.button6), findViewById(R.id.button7), findViewById(R.id.button8),
                findViewById(R.id.button9)
        };

        for (Button boton : botonesNumeros) {
            boton.setOnClickListener(v -> {
                cadenaEntrada.append(((Button) v).getText());
                panelResultado.setText(cadenaEntrada.toString());
            });
        }
    }

    private void agregarOperacion(String operacion) {
        cadenaEntrada.append(operacion);
        panelResultado.setText(cadenaEntrada.toString());
    }

    private void inicializarBotonesOperaciones() {
        findViewById(R.id.buttonSumar).setOnClickListener(v -> agregarOperacion("+"));
        findViewById(R.id.buttonMenos).setOnClickListener(v -> agregarOperacion("-"));
        findViewById(R.id.buttonMultiplicar).setOnClickListener(v -> agregarOperacion("*"));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> agregarOperacion("/"));
        findViewById(R.id.buttonLimpiar).setOnClickListener(v -> limpiarEntrada());
        findViewById(R.id.buttonIgual).setOnClickListener(v -> {
            String resultado = String.valueOf(calculator.calculate(panelResultado.getText().toString()));
            panelResultado.setText(resultado);
        });
    }

    private void limpiarEntrada() {
        cadenaEntrada.setLength(0);
        panelResultado.setText("");
    }
}
