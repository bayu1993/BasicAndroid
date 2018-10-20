package io.github.bayu1993.androidbasic.data.network;

import android.support.annotation.NonNull;

import io.github.bayu1993.androidbasic.data.network.response.PariwisataResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Bayu teguh pamuji on 10/20/18.
 * email : bayuteguhpamuji@gmail.com.
 */
public class RestService {
    private NetworkService networkService;

    public RestService(NetworkService networkService) {
        this.networkService = networkService;
    }

    public void getPariwisata(final MyCallback callback) {
        networkService.getPariwisata().enqueue(new Callback<PariwisataResponse>() {
            @Override
            public void onResponse(@NonNull Call<PariwisataResponse> call, @NonNull Response<PariwisataResponse> response) {
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<PariwisataResponse> call, @NonNull Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public interface MyCallback {
        void onSuccess(PariwisataResponse response);

        void onFailure(Throwable error);
    }
}
