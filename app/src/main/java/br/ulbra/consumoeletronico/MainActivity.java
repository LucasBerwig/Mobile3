package br.ulbra.consumoeletronico;

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
    EditText edtPotencia, edtUso, edtPreco;
    Button btnCalcular;
    TextView txtConsumo, txtCusto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtPotencia = findViewById(R.id.edtPotencia);
        edtPreco = findViewById(R.id.edtPreco);
        edtUso = findViewById(R.id.edtUso);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtConsumo = findViewById(R.id.txtConsumo);
        txtCusto = findViewById(R.id.txtCusto);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double potencia, uso, preco, consumo, custo;
                try {
                    potencia = Double.parseDouble(edtPotencia.getText().toString());
                    uso = Double.parseDouble(edtUso.getText().toString());
                    preco = Double.parseDouble(edtPreco.getText().toString());
                    consumo = (potencia * uso) / 1000;
                    custo = consumo * preco;
                    txtConsumo.setText("Consumo de energia: " + consumo + " kWh");
                    txtCusto.setText("Custo total: R$ " + custo);
                } catch (NumberFormatException e) {
                    Toast.makeText(view.getContext(), "Por favor, preencha todos os campos corretamente", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}