package com.example.staffandroidsql;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    EditText cajaDni;
    ImageButton btnBuscar;
    TextView lbNombre,lbApellido,lbDireccion,lbTelefono,lbSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cajaDni= findViewById(R.id.cajaDni);
        btnBuscar=findViewById(R.id.btnBuscar);
        lbNombre=findViewById(R.id.lbNombre);
        lbApellido=findViewById(R.id.lbApellido);
        lbDireccion=findViewById(R.id.lbDireccion);
        lbTelefono=findViewById(R.id.lbTelefono);
        lbSalario=findViewById(R.id.lbSalario);
    }
    public void evento(View view) {
        if(view.getId()==R.id.btnBuscar){
            QueryStaff();

        }
    }


    public Connection conectionBd(){
        Connection cnn=null;
        try {
            StrictMode.ThreadPolicy politica=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            cnn= DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.1.5;databaseName=StaffAndroid;user=marceloo;password=123;trustServerCertificate=true;");

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

        }
        return cnn;
    }
    public void QueryStaff(){
        try {
            Statement stm=conectionBd().createStatement();
            ResultSet rs =stm.executeQuery("SELECT* FROM Staff WHERE dni='"+cajaDni.getText().toString()+"'");
            if(rs.next()){
            lbNombre.setText(rs.getString(2));
            lbApellido.setText(rs.getString(3));
            lbDireccion.setText(rs.getString(4));
            lbTelefono.setText(rs.getString(5));
            lbSalario.setText(rs.getString(6));
            }
            cajaDni.setText("");

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

}