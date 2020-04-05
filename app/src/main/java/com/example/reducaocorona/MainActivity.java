package com.example.reducaocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mViewHolder.editSalario = findViewById(R.id.editSalario);
        this.mViewHolder.buttonCalcular = findViewById(R.id.buttonCalcular);
        this.mViewHolder.text25percent = findViewById(R.id.text25percent);
        this.mViewHolder.textSalario25 = findViewById(R.id.textSalario25);
        this.mViewHolder.textBeneficio25 = findViewById(R.id.textBeneficio25);
        this.mViewHolder.text50percent = findViewById(R.id.text50percent);
        this.mViewHolder.textSalario50 = findViewById(R.id.textSalario50);
        this.mViewHolder.textBeneficio50 = findViewById(R.id.textBeneficio50);
        this.mViewHolder.text70percent = findViewById(R.id.text70percent);
        this.mViewHolder.textSalario70 = findViewById(R.id.textSalario70);
        this.mViewHolder.textBeneficio70 = findViewById(R.id.textBeneficio70);
        this.mViewHolder.textAvisoSindical = findViewById(R.id.textAvisoSindical);
        this.mViewHolder.textSalarioEmpresa25 = findViewById(R.id.textSalarioEmpresa25);
        this.mViewHolder.textSalarioEmpresa50 = findViewById(R.id.textSalarioEmpresa50);
        this.mViewHolder.textSalarioEmpresa70 = findViewById(R.id.textSalarioEmpresa70);

        this.mViewHolder.buttonCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonCalcular) {
            calculaSalarios();
        }
    }

    private void calculaSalarios() {
        double salario = Double.valueOf(this.mViewHolder.editSalario.getText().toString());
        String aux;
        if (salario <= 1599.61) {
            //Calculo do beneficio para esta faixa salarial
            double previaBeneficio = salario * 0.8;

            calculoTotalComBeneficio(salario, previaBeneficio);

        } else if (salario <= 2666.29) {
            //Calculo do beneficio para esta faixa salarial
            double previaBeneficio = ((salario - 1599.61) * 0.5) + 1279.69;

            calculoTotalComBeneficio(salario, previaBeneficio);

        } else {
            //Calculo do beneficio para esta faixa salarial

            double previaBeneficio = 1813.03;

            calculoTotalComBeneficio(salario, previaBeneficio);
        }
    }

    private void calculoTotalComBeneficio(double salario, double previaBeneficio) {
        String aux;

        //Salarios sem beneficios
        double previsaoSalario25 = salario - (salario * 0.25);
        aux = getString(R.string.salario_empresa_RS) + " " + String.format("%.2f", previsaoSalario25);
        this.mViewHolder.textSalarioEmpresa25.setText(aux);
        double previsaoSalario50 = salario - (salario * 0.50);
        aux = getString(R.string.salario_empresa_RS) + " " + String.format("%.2f", previsaoSalario50);
        this.mViewHolder.textSalarioEmpresa50.setText(aux);
        double previsaoSalario70 = salario - (salario * 0.70);
        aux = getString(R.string.salario_empresa_RS) + " " + String.format("%.2f", previsaoSalario70);
        this.mViewHolder.textSalarioEmpresa70.setText(aux);

        //Calculo do percentual do beneficio
        double previaBeneficio25 = previaBeneficio * 0.25;
        aux = getString(R.string.beneficio_RS) + " " + String.format("%.2f", previaBeneficio25);
        this.mViewHolder.textBeneficio25.setText(aux);
        double previaBeneficio50 = previaBeneficio * 0.50;
        aux = getString(R.string.beneficio_RS) + " " + String.format("%.2f", previaBeneficio50);
        this.mViewHolder.textBeneficio50.setText(aux);
        double previaBeneficio70 = previaBeneficio * 0.70;
        aux = getString(R.string.beneficio_RS) + " " + String.format("%.2f", previaBeneficio70);
        this.mViewHolder.textBeneficio70.setText(aux);

        //Salarios finais
        double salario25 = previsaoSalario25 + previaBeneficio25;
        aux = getString(R.string.salario_total_RS) + " " + String.format("%.2f", salario25);
        this.mViewHolder.textSalario25.setText(aux);
        double salario50 = previsaoSalario50 + previaBeneficio50;
        aux = getString(R.string.salario_total_RS) + " " + String.format("%.2f", salario50);
        this.mViewHolder.textSalario50.setText(aux);
        double salario70 = previsaoSalario70 + previaBeneficio70;
        aux = getString(R.string.salario_total_RS) + " " + String.format("%.2f", salario70);
        this.mViewHolder.textSalario70.setText(aux);

        if (salario > 3135) {
            this.mViewHolder.textAvisoSindical.setText("***Mediante autorização sindical***");
        } else {
            this.mViewHolder.textAvisoSindical.setText("");
        }
    }


    private class ViewHolder {
        EditText editSalario;
        Button buttonCalcular;
        TextView text25percent;
        TextView textSalario25;
        TextView textBeneficio25;
        TextView text50percent;
        TextView textSalario50;
        TextView textBeneficio50;
        TextView text70percent;
        TextView textSalario70;
        TextView textBeneficio70;
        TextView textAvisoSindical;
        TextView textSalarioEmpresa25;
        TextView textSalarioEmpresa50;
        TextView textSalarioEmpresa70;
    }
}
