/*
 *
 *   Created Luis Chumi on 26/5/23 21:31
 *   Copyright Ⓒ 2023. All rights reserved Ⓒ 2023 http://freefuninfo.com/
 *   Last modified: 26/5/23 21:31
 *
 *   Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 *   except in compliance with the License. You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENS... Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 *    either express or implied. See the License for the specific language governing permissions and
 *    limitations under the License.
 * /
 */

package com.ista.gestion_capacitaciones.interfaces;

import com.ista.gestion_capacitaciones.model.LoginRequest;
import com.ista.gestion_capacitaciones.model.UserInfoResponse;
import com.ista.gestion_capacitaciones.security.JwtResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthCtrlApi {

    @POST("/api/auth/signin")
    Call<UserInfoResponse> authenticateUser(@Body LoginRequest loginRequest);

    @POST("/api/auth/generate-token")
    Call<JwtResponse> generarToken(@Body LoginRequest loginRequest);


}
