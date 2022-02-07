package kg.geektech.newsapp39.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.newsapp39.R;
import kg.geektech.newsapp39.models.News;

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<News>list=new ArrayList<>();

    public void setList(List<News> list) {
        this.list = list;
    }

    public void setOnItemClick(Adapter.onItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    private onItemClick onItemClick;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
       return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();

    }
    public  void addItem(News news) {
        list.add(news);
        notifyItemInserted(list.size());
    }
    public void delete( int position) {
        this.list.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tv_title);
            date=itemView.findViewById(R.id.tv_created);
            itemView.setOnClickListener(view ->{onItemClick.onLongClick(getAdapterPosition());} );
        }


        public void onBind(News news) {
            title.setText(news.getTitle());
            date.setText(news.getCreatedAT());

        }

    }
    public interface onItemClick{
        void onClick(int position);
        void  onLongClick(int position);

    }
}
