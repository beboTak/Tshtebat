package bebosemsemcom.ibrahimbebo.tshtebat;

import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ibrahim bebo on 9/10/2018.
 */

public class BublishAdapter extends RecyclerView.Adapter<BublishAdapter.BublishHolder> {

   List<Owner>Owners;

    public BublishAdapter(List<Owner> owners) {
        Owners = owners;
    }

    @Override
    public BublishHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_ownerpublish_row,parent,false);
        BublishHolder holder=new BublishHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(BublishHolder holder, int position) {

        Owner owner=Owners.get(position);
        holder.name.setText(owner.getName());
        holder.phone.setText(owner.getPhone());
        holder.des.setText(owner.getDescription());




    }

    @Override
    public int getItemCount() {
        return Owners.size();
    }
    public class BublishHolder extends RecyclerView.ViewHolder{
        TextView name,phone,des;

        public BublishHolder(View itemView) {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.nameos);
            phone=(TextView)itemView.findViewById(R.id.phoneos);
            des=(TextView)itemView.findViewById(R.id.desos);
        }
    }
}
