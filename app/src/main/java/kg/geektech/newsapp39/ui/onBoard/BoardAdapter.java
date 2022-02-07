package kg.geektech.newsapp39.ui.onBoard;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kg.geektech.newsapp39.R;
import kg.geektech.newsapp39.databinding.ItemVpBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {
    private ItemVpBinding binding;
    private int[] title = new int[]{R.string.title1, R.string.title2, R.string.title3};
    private int[] subTitle = new int[]{R.string.title1, R.string.title2, R.string.title3};
    private int[] img = new int[]{R.drawable.spongebob, R.drawable.spongebob, R.drawable.spongebob};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemVpBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
        if (position == 2) {
            binding.btnOnBoardGo.setVisibility(View.VISIBLE);

        } else {
            binding.btnOnBoardGo.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull ItemVpBinding itemView) {
            super(itemView.getRoot());
        }

        public void onBind(int position) {
            binding.tvOnBoardDesc.setText(subTitle[position]);
            binding.tvOnBoardTitle.setText(title[position]);
            binding.ivOnBoard.setImageResource(img[position]);
        }
    }
}
