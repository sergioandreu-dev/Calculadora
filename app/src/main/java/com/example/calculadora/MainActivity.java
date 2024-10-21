package com.example.calculadora;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText panelResultado;
    private StringBuilder cadenaEntrada = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panelResultado = findViewById(R.id.panelResultado);

        inicializarBotonesNumeros();
        inicializarBotonesOperaciones();
    }

    private void inicializarBotonesNumeros() {
        Button[] botonesNumeros = new Button[]{
                findViewById(R.id.button0),
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9)
        };

        for (Button boton : botonesNumeros) {
            boton.setOnClickListener(v -> {
                cadenaEntrada.append(boton.getText());
                panelResultado.setText(cadenaEntrada.toString());
            });
        }
    }

    private void inicializarBotonesOperaciones() {
        findViewById(R.id.buttonSumar).setOnClickListener(v -> agregarOperacion("+"));
        findViewById(R.id.buttonMenos).setOnClickListener(v -> agregarOperacion("-"));
        findViewById(R.id.buttonMultiplicar).setOnClickListener(v -> agregarOperacion("*"));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> agregarOperacion("/"));
        findViewById(R.id.buttonLimpiar).setOnClickListener(v -> limpiarEntrada());
        findViewById(R.id.buttonIgual).setOnClickListener(v -> calcularYMostrarResultado());
    }

    private void agregarOperacion(String operacion) {
        cadenaEntrada.append(" ").append(operacion).append(" ");
        panelResultado.setText(cadenaEntrada.toString());
    }

    private void limpiarEntrada() {
        cadenaEntrada.setLength(0);
        panelResultado.setText("");
    }

    private void calcularYMostrarResultado() {
        String[] partes = cadenaEntrada.toString().split(" ");
        if (partes.length != 3) {
            panelResultado.setText("-1");
            return;
        }

        int num1, num2;
        try {
            num1 = Integer.parseInt(partes[0]);
            num2 = Integer.parseInt(partes[2]);
        } catch (NumberFormatException e) {
            panelResultado.setText("-1");
            return;
        }

        String operador = partes[1];
        int resultado = -1;

        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    resultado = -1;
                }
                break;
            default:
                resultado = -1;
                break;
        }

        panelResultado.setText(String.valueOf(resultado));
        cadenaEntrada.setLength(0);
    }
}
