package com.example.julianabrarcaesario_trainingmobile.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.julianabrarcaesario_trainingmobile.data.remote.NbaTeamItem;
import com.example.julianabrarcaesario_trainingmobile.databinding.ItemNbaTeamBinding;

import java.util.List;

public class NbaTeamAdapter extends RecyclerView.Adapter <NbaTeamAdapter.ViewHolder>{

    private final List<NbaTeamItem> nbaTeamItems;

    public NbaTeamAdapter(List<NbaTeamItem> nbaTeamItems){
        this.nbaTeamItems = nbaTeamItems;
    }

    OnItemClickCallback mOnItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.mOnItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNbaTeamBinding binding = ItemNbaTeamBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(nbaTeamItems.get(position));
        holder.binding.btnSave.setOnClickListener(view -> {
            mOnItemClickCallback.onInsertClick(nbaTeamItems.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return nbaTeamItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ItemNbaTeamBinding binding;
        public ViewHolder(@NonNull ItemNbaTeamBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(NbaTeamItem nbaTeamItem){
            binding.tvName.setText(nbaTeamItem.getName());
            Glide.with(binding.getRoot())
                    .load(nbaTeamItem.getLogo())
                    .into(binding.ivLogo);

        }
    }

    public interface OnItemClickCallback{
        void onInsertClick(NbaTeamItem nbaTeamItem);
    }
}
