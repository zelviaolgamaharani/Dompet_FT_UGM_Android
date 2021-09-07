package com.teknikugm.dompetft.retrofit

import com.teknikugm.dompetft.pembayaran.DataItemPromo
import com.teknikugm.dompetft.pembayaran.ResponsePromo
import com.teknikugm.dompetft.pembayaran.Response_Detail
import com.teknikugm.dompetft.revisi.api.Constants
import com.teknikugm.dompetft.revisi.model.*
import com.teknikugm.dompetft.revisi.topup.ResponseTopup
import retrofit2.Call
import retrofit2.http.*

interface API {

    @GET(Constants.USER_URL)
    fun getProfile(): Call<Profile_m>

    @POST(Constants.REGISTER_URL)
    //@FormUrlEncoded
    fun addUser(@Body userInfo: RegisterRequest): Call<RegisterResponse>

    //@Headers("Content-Type: application/json")
    @POST(Constants.LOGIN_URL)
    //@FormUrlEncoded
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("index.php/User/login")
    @FormUrlEncoded
    fun loginUser(
            @Field("username") username: String,
            @Field("password") password: String
    ): Call<ResponseLogin>

//    @POST("appkantin/register.php")
//    @FormUrlEncoded
//    fun registeruser (@Field("username") username:String,
//                      @Field("name") name:String,
//                      @Field("password") password:String,
//                      @Field("email") email:String,
//                      @Field("nik") nik:String): Observable<String>

    @POST("index.php/User/saldo_c/{key}")
    fun getsaldo(
            @Path("key") key: String?): Call<ResponseSaldo>

    @FormUrlEncoded
    @POST("index.php/Transaksi_topup/send_topup")
    fun topUpSaldo(

            @Field("jumlah_topup") finalTopUp: Int,
            @Field("username") username: String?,
            @Field("random_topup") randomNumber: Int

    ): Call<Response_Topup>

    @GET("api/promo/?format=json")
    fun ambil_promodua(): Call<List<DataItemPromo>>

    @GET("index.php/Transaksi_promo/api_list_promo")
    fun ambil_promo(): Call<ResponsePromo>

    @FormUrlEncoded
    @POST("index.php/Transaksi_kantin/detail_transaksi")
    fun detailTransaksi(

            @Field("user") user: String?,
            @Field("total_bayar") totalBayar: Int?,
            @Field("total_asli") totalAsli: Int?,
            @Field("diskon") diskonDetail: Int?

    ): Call<Response_Detail>

    @FormUrlEncoded
    @POST("index.php/User/register")
    fun register(

            @Field("username") username: String?,
            @Field("name") nameReg: String?,
            @Field("password") passwordReg: String?,
            @Field("email") emailReg: String?,
            @Field("nik") nikReg: String?

    ): Call<Response_Detail>

    @FormUrlEncoded
    @POST("index.php/Transaksi_saldo/transaksi")
    fun transaksi(

            @Field("username") username: String?,
            @Field("jumlah_payment") nameReg: Int?,
            @Field("username_to") passwordReg: String?

    ): Call<Response_Detail>

    //    REVISI
    @FormUrlEncoded
    @POST("saldo/?format=json")
    fun topUpNEW(
            @Field("jumlah_topup") finalTopUp: Int,
            @Field("id_user") iduser: Int?

    ): Call<ResponseTopup>

    //transfer saldo
    @FormUrlEncoded
    @POST("index.php/Transaksi_saldo/transaksi")
    fun transfersaldo(

        @Field("username") username: String?,
        @Field("jumlah_payment") nameReg: Int?,
        @Field("username_to") passwordReg: String?

    ): Call<Response_Detail>


}