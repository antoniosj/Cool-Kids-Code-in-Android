package com.antoniosj.cleanmvp.networking;


import com.antoniosj.cleanmvp.models.CityListResponse;

import retrofit2.http.GET;
import rx.Observable;

public interface NetworkService {

    @GET("v1/city")
    Observable<CityListResponse> getCityList();


}
