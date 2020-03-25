package fun.iardo.rqv1.utils;

import com.google.gson.Gson;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import fun.iardo.rqv1.data.api.IRealQuestsApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    public static final List<Class<?>> NETWORK_EXCEPTIONS = Arrays.asList(
            UnknownHostException.class,
            SocketTimeoutException.class,
            ConnectException.class
    );

    private static OkHttpClient sClient;
    private static Retrofit sRetrofit;
    private static Gson sGson;
    private static IRealQuestsApi sApi;

    private static OkHttpClient getClient(){
        if (sClient == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    //.connectTimeout(10000, TimeUnit.SECONDS)
                    //.readTimeout(10000,TimeUnit.SECONDS)
                    //.addInterceptor(new ApiKeyInterceptor());
                    .addInterceptor(logging);

            sClient = builder.build();
        }
        return sClient;
    }

    private static Retrofit getRetrofit(String baseUrl){
        if (sGson == null){sGson = new Gson();}
        if (sRetrofit == null){
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(sGson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return sRetrofit;
    }


    public static IRealQuestsApi getApiService(String baseUrl){
        if (sApi == null){
            sApi = getRetrofit(baseUrl).create(IRealQuestsApi.class);
        }
        return sApi;
    }
}
