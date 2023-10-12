package com.mk.pomoapi;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HistorialApiInterface {

    @GET("historial")
    Call<List<Historial>> getHistorial();
}
