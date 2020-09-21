package com.example.contrato;

import android.os.AsyncTask;
import android.view.View;
import android.widget.*;
import com.example.illidan.MainActivity;
import com.example.illidan.R;

public class anyTaskContratos extends AsyncTask<String, Integer, String> {

    private Contratos context;
    private ProgressBar progressBar;
    private EditText  idOrden;
    private EditText  idfecha;
    private Spinner idCantones;
    private EditText  idCliente;
    private EditText  idDireccion;
    private EditText  idDescripcion;
    private Button guardar;
    private Button cancelar;
    private TextView porcentaje;

    public anyTaskContratos (Contratos context){
        this.context = context;
        this.progressBar = (ProgressBar)context.findViewById(R.id.progressBarGuardar);
        this.idOrden = (EditText )context.findViewById(R.id.idOrden);
        this.idfecha = (EditText)context.findViewById(R.id.idFecha);
        this.idCantones = (Spinner)context.findViewById(R.id.lisCiudades);
        this.idCliente = (EditText )context.findViewById(R.id.idCliente);
        this.idDireccion = (EditText )context.findViewById(R.id.idDireccion);
        this.idDescripcion = (EditText )context.findViewById(R.id.idDescripcion);
        this.guardar = (Button)context.findViewById(R.id.idGuardar);
        this.cancelar = (Button)context.findViewById(R.id.idCancelar);
        this.porcentaje = (TextView)context.findViewById(R.id.idPorcentaje);
    }

    //Metodo para que no editen la informacion hasta que se guarde la informacion
    private void enableComponente(Boolean accion){
        idOrden.setEnabled(accion);
        idfecha.setEnabled(accion);
        idCantones.setEnabled(accion);
        idCliente.setEnabled(accion);
        idDireccion.setEnabled(accion);
        idDescripcion.setEnabled(accion);
        guardar.setEnabled(accion);
        cancelar.setEnabled(accion);
    }

    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
        porcentaje.setVisibility(View.VISIBLE);
        enableComponente(false);
        Toast.makeText(context, "Guardando...", Toast.LENGTH_LONG).show();
    }

    @Override
    protected String doInBackground(String... params)
    {
        for(int i = 0; i <= 100; i++)
        {
            try
            {
                Thread.sleep(200);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        return String.valueOf(params[0]);
    }

    @Override
    protected void onProgressUpdate (Integer... valores)
    {
        super.onProgressUpdate(valores);
        progressBar.setProgress(valores[0]);
        porcentaje.setText(valores[0] + "%");
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        progressBar.setVisibility(View.INVISIBLE);
        porcentaje.setVisibility(View.INVISIBLE);
        enableComponente(true);
        Toast.makeText(context, "GUARDADO CORRECTAMENTE", Toast.LENGTH_LONG).show();
    }
}
