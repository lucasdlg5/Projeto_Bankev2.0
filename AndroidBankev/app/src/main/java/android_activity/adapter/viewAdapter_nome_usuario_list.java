package android_activity.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

import sjc.fatec.sp.br.bankev20.R;

public class viewAdapter_nome_usuario_list extends RecyclerView.Adapter<viewAdapter_nome_usuario_list.ViewHolder> {
    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mItemCLickListener;

    public void setmItemCLickListener (ItemClickListener itemCLickListener){
        this.mItemCLickListener = itemCLickListener;
    }

    public viewAdapter_nome_usuario_list (Context context, List<String> data){
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public viewAdapter_nome_usuario_list.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.list_nomes, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewAdapter_nome_usuario_list.ViewHolder viewHolder, int i) {
        String nome = mData.get(i);
        viewHolder.firstLine.setText(nome);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView firstLine;

        ViewHolder (View itemView){
            super(itemView);
            firstLine = itemView.findViewById(R.id.firstLine);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {}
    }

    public interface ItemClickListener {
        void onItemClick (View view, int position);
    }
}
