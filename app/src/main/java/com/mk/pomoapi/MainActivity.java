package com.mk.pomoapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HistorialAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HistorialApiInterface apiService = HistorialApiClient.getApiClient().create(HistorialApiInterface.class);

        Call<List<Historial>> call = apiService.getHistorial();
        call.enqueue(new Callback<List<Historial>>() {
            @Override
            public void onResponse(Call<List<Historial>> call, Response<List<Historial>> response) {
                List<Historial> historiales = response.body();
                adapter = new HistorialAdapter(historiales);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Historial>> call, Throwable t) {
                // Manejo de errores
            }
        });
    }
}