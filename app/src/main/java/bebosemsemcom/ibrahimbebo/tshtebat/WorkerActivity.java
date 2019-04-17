package bebosemsemcom.ibrahimbebo.tshtebat;

import android.app.ProgressDialog;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public class WorkerActivity extends AppCompatActivity {
    TextInputEditText nametext,phonetext,joptext;
    Button setInfo;
    String name,phone,jop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);
        setInfo=(Button) findViewById(R.id.worker);
        nametext=(TextInputEditText)findViewById(R.id.namew);
        phonetext=(TextInputEditText)findViewById(R.id.phonew);
        joptext=(TextInputEditText)findViewById(R.id.jopw);





        setInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                if (IsValid())
                {
                    workerInf();

                }

            }
        });


    }
    public interface WorkerData{
        @FormUrlEncoded
        @POST("workers.php")
        Call<ResponseBody>InsertData(@Field("name") String name,
                                     @Field("phone") String phone,
                                     @Field("jop")String jop);
    }

    private void workerInf() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://ibrahimmosaadco.000webhostapp.com/")
                .build();
        WorkerData workerdata=retrofit.create(WorkerData.class);

        Call<ResponseBody> connection=workerdata.InsertData(name,phone,jop);
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(WorkerActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage(getApplication().getString(R.string.Registermessage));
        //  progressDoalog.setTitle("");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDoalog.show();
        connection.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                progressDoalog.dismiss();
                Log.v("this", "Yes!");
                Toast.makeText(WorkerActivity.this,getApplicationContext().getString(R.string.sendSuccess), Toast.LENGTH_LONG).show();
                nametext.setText("");
                phonetext.setText("");
                joptext.setText("");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDoalog.dismiss();
                Log.v("this", "No Response!");
                Toast.makeText(WorkerActivity.this,getApplicationContext().getString(R.string.sendfail), Toast.LENGTH_LONG).show();

            }
        });




    }
    public boolean IsValid(){
        if (name.equals(" ")||name.isEmpty())
        {

            nametext.setError("Fill Here Please");
            nametext.requestFocus();
            return false;

        }
        if (phone.equals(" ")||phone.isEmpty())
        {

            phonetext.setError("Fill Here Please");
            phonetext.requestFocus();
            return false;

        }
        if (jop.equals(" ")||jop.isEmpty())
        {

            joptext.setError("Fill Here Please");
            joptext.requestFocus();
            return false;

        }
        return true;
    }
    public void getData(){
        name=nametext.getText().toString().toLowerCase().trim();
        phone=phonetext.getText().toString().trim();
        jop=joptext.getText().toString().toLowerCase().trim();

    }
}
