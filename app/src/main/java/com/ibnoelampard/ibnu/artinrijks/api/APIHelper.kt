package com.ibnoelampard.ibnu.artinrijks.api

import com.ibnoelampard.ibnu.artinrijks.model.APIModelResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface APIHelper{

    @GET("/api/nl/collection?key=CUt40x2l&format=json&type=schilderij&f.normalized32Colors.hex=%20%23367614#")
    fun getCollectionData(): Observable<APIModelResponse.RijksMuseumResponse>

}