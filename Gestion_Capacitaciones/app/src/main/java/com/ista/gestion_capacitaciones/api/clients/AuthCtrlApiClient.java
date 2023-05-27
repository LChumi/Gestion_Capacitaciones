/*
 *
 *   Created Luis Chumi on 26/5/23 21:40
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 26/5/23 21:40
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones.api.clients;

import com.ista.gestion_capacitaciones.constants.ApiUrls;
import com.ista.gestion_capacitaciones.interfaces.AuthCtrlApi;
import com.ista.gestion_capacitaciones.model.LoginRequest;
import com.ista.gestion_capacitaciones.model.UserInfoResponse;
import com.ista.gestion_capacitaciones.security.JwtResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthCtrlApiClient {

    AuthCtrlApi authCtrlApi;

    public AuthCtrlApiClient(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiUrls.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        authCtrlApi=retrofit.create(AuthCtrlApi.class);
    }

    public Call<UserInfoResponse> authenticateUser(LoginRequest loginRequest) {
        return authCtrlApi.authenticateUser(loginRequest);
    }

    public Call<JwtResponse> generarToken(LoginRequest loginRequest) {
        return authCtrlApi.generarToken(loginRequest);
    }
}
