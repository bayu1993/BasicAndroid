package io.github.bayu1993.androidbasic.data.network.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.github.bayu1993.androidbasic.data.model.PariwisataModel;

/**
 * Created by Bayu teguh pamuji on 10/20/18.
 * email : bayuteguhpamuji@gmail.com.
 */
public class PariwisataResponse {
    @SerializedName("result")
    private Boolean result;
    @SerializedName("data")
    private List<PariwisataModel> data;

    public Boolean getResult() {
        return result;
    }

    public List<PariwisataModel> getData() {
        return data;
    }
}
