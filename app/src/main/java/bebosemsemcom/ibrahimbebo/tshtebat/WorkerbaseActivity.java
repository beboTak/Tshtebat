package bebosemsemcom.ibrahimbebo.tshtebat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


public class WorkerbaseActivity extends AppCompatActivity {
      Button search,info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workerbase);
        search=(Button)findViewById(R.id.searchwo);
        info=(Button)findViewById(R.id.infowo);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WorkerbaseActivity.this,WorkerSearchActivity.class);
                startActivity(intent);

            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WorkerbaseActivity.this,WorkerActivity.class);
                startActivity(intent);

            }
        });
    }





}
