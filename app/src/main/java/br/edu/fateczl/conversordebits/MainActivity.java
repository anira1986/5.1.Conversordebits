/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */

package br.edu.fateczl.conversordebits;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etBits;
    private RadioGroup radioGroup;
    private Button btnConverter;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etBits = findViewById(R.id.etBits);
        radioGroup = findViewById(R.id.radioGroup);
        btnConverter = findViewById(R.id.btnConverter);
        tvResultado = findViewById(R.id.tvResultado);

        btnConverter.setOnClickListener(v -> converter());
    }

    private void converter() {
        String input = etBits.getText().toString();

        if (input.isEmpty()) {
            tvResultado.setText("Por favor, insira um valor em bits.");
            return;
        }

        long bits = Long.parseLong(input);

        int selectedId = radioGroup.getCheckedRadioButtonId();
        double resultado = 0;

        if (selectedId == R.id.rbBytes) {
            resultado = bits / 8.0;
        } else if (selectedId == R.id.rbKB) {
            resultado = bits / (8.0 * 1024);
        } else if (selectedId == R.id.rbMB) {
            resultado = bits / (8.0 * 1024 * 1024);
        } else if (selectedId == R.id.rbGB) {
            resultado = bits / (8.0 * 1024 * 1024 * 1024);
        } else if (selectedId == R.id.rbTB) {
            resultado = bits / (8.0 * 1024 * 1024 * 1024 * 1024);
        }

        tvResultado.setText(String.format("Resultado: %.6f", resultado));
    }
}
