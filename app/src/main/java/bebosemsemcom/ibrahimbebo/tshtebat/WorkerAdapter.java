package bebosemsemcom.ibrahimbebo.tshtebat;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.WorkerHolder> {

    List<Worker> Workers;
    public WorkerAdapter(List<Worker>Workers)
    {
        this.Workers=Workers;

    }



    @Override
    public WorkerHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View row = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.workershow_layout,viewGroup,false);
        WorkerHolder holder=new WorkerHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder( WorkerHolder viewHolder, int position) {

       Worker worker=Workers.get(position);
       viewHolder.name.setText(worker.getName());
       viewHolder.phone.setText(worker.getPhone());
       viewHolder.jop.setText(worker.getJop());

    }

    @Override
    public int getItemCount() {
        return Workers.size();
    }
    public class WorkerHolder extends RecyclerView.ViewHolder {
        TextView name,phone,jop;

        public WorkerHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.workname);
            phone=(TextView)itemView.findViewById(R.id.workphone);
            jop=(TextView)itemView.findViewById(R.id.workjop);

        }
    }
}
