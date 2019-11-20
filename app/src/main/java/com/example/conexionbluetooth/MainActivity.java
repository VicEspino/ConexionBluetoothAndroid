package com.example.conexionbluetooth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button botonBluetooth;

    ArrayList<Dispositivo> listaDispositivos;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listaBluetooth);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        listaDispositivos = new ArrayList<>();

        botonBluetooth = findViewById(R.id.btnBluetooth);
        botonBluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (bluetoothAdapter != null) {
                    // Device doesn't support Bluetooth if null
                    if (!bluetoothAdapter.isEnabled()) {
                        Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        //la api el requestcode es inidicado con una variable, pero esta puede ser un numero,
                        // parra controlar con que codigo se enciende
                        startActivityForResult(enableBtIntent, 10);
                    }

                    Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
                    if (bondedDevices.size() > 0) {
                        // There are paired devices. Get the name and address of each paired device.
                        for (BluetoothDevice device : bondedDevices) {
                            String deviceName = device.getName();
                            String deviceHardwareAddress = device.getAddress(); // MAC address

                            listaDispositivos.add(new Dispositivo(deviceName, deviceHardwareAddress, false));

                        }

                        AdaptadorDispositivo adaptadorDispositivo = new AdaptadorDispositivo(listaDispositivos);
                        recyclerView.setAdapter(adaptadorDispositivo);

                    }
                    bluetoothAdapter.cancelDiscovery();

                }
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
