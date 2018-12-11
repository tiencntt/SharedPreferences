package windstudy.com.sharedpreferences.json;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import windstudy.com.sharedpreferences.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    ArrayList<Product> arrData = new ArrayList<>();
    Context context;
    OnItemClickListener onItemClickListener;


    public interface  OnItemClickListener{
        void onItemClick(int position);


    }
    public void setOnItemClickListener(OnItemClickListener listener){
        onItemClickListener =listener;
    }



    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item_layout,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = arrData.get(position);
        holder.tvPrice.setText(""+product.getBasePrice());
        holder.tvProduct.setText(""+product.getName());
        Picasso.get().load(product.getImage()).into(holder.imgProduct);

    }

    @Override
    public int getItemCount() {
        return arrData.size() ;
    }

    class  ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct;
        TextView tvProduct,tvPrice;


        public ProductViewHolder(View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_product);
            tvProduct = itemView.findViewById(R.id.txt_product_name);
            tvPrice = itemView.findViewById(R.id.txt_product_price);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null ) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }


}
