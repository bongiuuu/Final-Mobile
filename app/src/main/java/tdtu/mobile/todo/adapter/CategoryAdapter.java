package tdtu.mobile.todo.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import tdtu.mobile.todo.model.Category;
import tdtu.mobile.todo.R;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private Category[] categories;

    public CategoryAdapter(Category[] categories){
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.custom_category_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        final Category category = categories[position];
        holder.tvCategory.setText(categories[position].getCategory());
        holder.tvNumTask.setText(categories[position].getNumberOfTask() + " task");
        holder.cvCategory.setOnClickListener(view -> Toast.makeText(view.getContext(), category.getCategory(), Toast.LENGTH_LONG).show());
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCategory;
        public TextView tvNumTask;
        public CardView cvCategory;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvCategory = itemView.findViewById(R.id.tvCategory);
            this.tvNumTask = itemView.findViewById(R.id.tvNumTask);
            this.cvCategory = itemView.findViewById(R.id.cvCategory);
        }
    }
}
