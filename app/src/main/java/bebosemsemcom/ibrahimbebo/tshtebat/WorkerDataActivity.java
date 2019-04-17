package bebosemsemcom.ibrahimbebo.tshtebat;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class WorkerDataActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_data);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view1);

        recyclerView.setHasFixedSize(true);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://ibrahimmosaadco.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getWorkerData getworkerData=retrofit.create(getWorkerData.class);

        Call<List<Worker>> connection=getworkerData.getWorkers();

        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(WorkerDataActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage(getApplicationContext().getString(R.string.loading));
        //  progressDoalog.setTitle("");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDoalog.show();

        connection.enqueue(new Callback<List<Worker>>() {
            @Override
            public void onResponse(Call<List<Worker>> call, Response<List<Worker>> response) {
                progressDoalog.dismiss();
                Log.v("this", "Yes!");
                List<Worker> workers = new ArrayList<>();
                workers=response.body();
                linearLayoutManager=new LinearLayoutManager(WorkerDataActivity.this);

                recyclerView.setLayoutManager(linearLayoutManager);

                WorkerAdapter workerAdapter=new WorkerAdapter(workers);

                recyclerView.setAdapter(workerAdapter);

                Toast toast = Toast.makeText(getApplicationContext(), getApplicationContext().getString(R.string.successdownload), Toast.LENGTH_SHORT); toast.show();



            }

            @Override
            public void onFailure(Call<List<Worker>> call, Throwable t) {
                progressDoalog.dismiss();
                Log.v("this", "No Response!");

            }
        });
    }
    public interface getWorkerData{
        @GET("getworkers.php")
        Call<List<Worker>> getWorkers();
    }
}
