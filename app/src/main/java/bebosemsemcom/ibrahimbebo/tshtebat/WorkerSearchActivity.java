 package bebosemsemcom.ibrahimbebo.tshtebat;

import android.app.ProgressDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class WorkerSearchActivity extends AppCompatActivity {
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_search);

       recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //show.append("ahmeeeeeeeeeeeed"+"\n");
         Retrofit retrofit=new Retrofit.Builder()
                 .baseUrl("https://ibrahimmosaadco.000webhostapp.com/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();


         getOwnerData getownerdata=retrofit.create(getOwnerData.class);


         Call<List<Owner>>connection=getownerdata.getOwners();

        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(WorkerSearchActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage(getApplication().getString(R.string.loading));
      //  progressDoalog.setTitle("");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDoalog.show();
       connection.enqueue(new Callback<List<Owner>>() {
           @Override
           public void onResponse(Call<List<Owner>> call, Response<List<Owner>> response) {
               progressDoalog.dismiss();
               Log.v("this", "Yes!");
               List<Owner>owners =new ArrayList<>();
               owners=response.body();

               layoutManager = new LinearLayoutManager(WorkerSearchActivity.this);
               recyclerView.setLayoutManager(layoutManager);
               BublishAdapter bublishAdapter=new BublishAdapter(owners);
               recyclerView.setAdapter(bublishAdapter);


              Toast toast = Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.successdownload), Toast.LENGTH_SHORT); toast.show();
           }

           @Override
           public void onFailure(Call<List<Owner>> call, Throwable t) {
               progressDoalog.dismiss();
               Log.v("this", "No Response!");

           }
       });

    }
   public interface getOwnerData{
        @GET("getOwners.php")
        Call<List<Owner>>getOwners();
    }





}
