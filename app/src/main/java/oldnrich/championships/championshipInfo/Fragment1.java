package oldnrich.championships.championshipInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import oldnrich.championships.MainActivity;
import oldnrich.championships.R;
import oldnrich.championships.opening_competition;

public class  Fragment1 extends Fragment {

    private ImageButton open_competition;
    final static private String URL = "http://1.230.221.210:8080/contest/all";
    private RecyclerAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public Fragment1() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        open_competition = view.findViewById(R.id.open_competition);
        open_competition.bringToFront();

        open_competition.setOnClickListener(new View.OnClickListener() { // opening_competition으로 이동
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), opening_competition.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.championships_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);


        RequestQueue queue = Volley.newRequestQueue(getActivity());

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject order = jsonArray.getJSONObject(i);

                                //각 list의 값들을 data 객체에 set 해준다.
                                Data data = new Data();
                                data.setTitle(order.getString("name"));
                                data.setParticipants(order.getString("participants"));
                                data.setLocation(order.getString("locationX"));
                                data.setType(order.getString("type"));
                                data.setResId(R.mipmap.ic_launcher);

                                // 각 값이 들어간 data를 adapter에 추가합니다.
                                adapter.addItem(data);


                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(), "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);

        return view;

    }

}

