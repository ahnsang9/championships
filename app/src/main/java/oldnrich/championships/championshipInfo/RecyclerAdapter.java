package oldnrich.championships.championshipInfo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import oldnrich.championships.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    private ArrayList<Data> listData = new ArrayList<>();
    private Intent intent;

    @NonNull
    @Override
    public RecyclerAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.championships_list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position));

        /*holder.championship_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(),championship_info.class);
                view.getContext().startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    void addItem(Data data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView Title;
        private TextView participants;
        private TextView location;
        private ImageView championship_image;
        private LinearLayout Linear_item;

        ItemViewHolder(View itemView) {
            super(itemView);

            Title = itemView.findViewById(R.id.Title);
            participants = itemView.findViewById(R.id.participants);
            location = itemView.findViewById(R.id.location);
            championship_image = itemView.findViewById(R.id.championship_image);
            Linear_item = itemView.findViewById(R.id.Linear_item);
        }

        void onBind(Data data) {
            Title.setText(data.getTitle());
            participants.setText(data.getParticipants());
            location.setText(data.getLocation());
            championship_image.setImageResource(data.getResId());
            Linear_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.Linear_item:
                    intent = new Intent(view.getContext(),championship_info.class);
                    Data data = new Data();
                    intent.putExtra("title", "왜 안되지");
                    intent.putExtra("type", data.getType());
                    view.getContext().startActivity(intent);
                    break;
                }
        }
    }
}
