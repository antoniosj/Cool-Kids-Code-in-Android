package com.antoniosj.cleanmvp.home;

import com.antoniosj.cleanmvp.models.CityListResponse;

public interface HomeView {

    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getityListSuccess(CityListResponse cityListResponse);

}
