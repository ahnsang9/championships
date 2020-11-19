package oldnrich.championships.championshipInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ramotion.foldingcell.FoldingCell;

import oldnrich.championships.R;
import oldnrich.championships.opening_competition;

public class  Fragment1 extends Fragment {

    private ImageButton open_competition;

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
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_1,container,false);

        open_competition = view.findViewById(R.id.open_competition);

        open_competition.setOnClickListener(new View.OnClickListener() { // opening_competition으로 이동
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), opening_competition.class);
                startActivity(intent);
            }
        });

//        final FoldingCell fc = (FoldingCell) view.findViewById(R.id.folding_cell);
//
//        fc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fc.toggle(false);
//            }
//        });

        return view;



    }


}
