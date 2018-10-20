package io.github.bayu1993.androidbasic.data.network;

import io.github.bayu1993.androidbasic.data.network.response.PariwisataResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Bayu teguh pamuji on 10/20/18.
 * email : bayuteguhpamuji@gmail.com.
 */
public interface NetworkService {
    @GET("bootcamp/jsonBootcamp.php")
    Call<PariwisataResponse> getPariwisata();
}
