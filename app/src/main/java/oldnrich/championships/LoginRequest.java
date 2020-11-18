package oldnrich.championships;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    //서버 URL 설정 (php 파일 연동)
    final static private String URL = "http://1.230.221.210:8080/user";

    public LoginRequest(String userID, String userPassword, Response.Listener<String> listener){
        super(Method.GET, URL+"?"+"userID="+userID+"&"+"userPassword="+userPassword, listener, null);
    }
}
