package oldnrich.championships;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL 설정 (php 파일 연동)
    final static private String URL = "http://ahnsang9.dothome.co.kr/Register.php";
    private Map<String, String> map;



    public RegisterRequest(String userID, String userPassword, String userName, Integer userAge, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);
        map.put("userName",userName);
        map.put("userAge",userAge + "");

    }

//    public RegisterRequest(User user, Response.Listener<String> listener){
//        super(Method.POST, URL, listener, null);
//
//        map = new HashMap<>();
//        map.put("userID",user.getUserId());
//        map.put("userPassword",user.getPassword());
//        map.put("userName",user.getName());
//        map.put("userAge",user.getAge() + "");
//
//    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
