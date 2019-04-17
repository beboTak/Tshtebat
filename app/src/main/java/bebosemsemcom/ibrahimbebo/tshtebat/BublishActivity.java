package bebosemsemcom.ibrahimbebo.tshtebat;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public class BublishActivity extends AppCompatActivity {
    TextInputEditText nametext,phonetext,destext;
    String name,phone,des;
    Button bublisher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bublish);

        nametext=(TextInputEditText)findViewById(R.id.bname);
        phonetext=(TextInputEditText)findViewById(R.id.bphone);
        destext=(TextInputEditText)findViewById(R.id.bdes);
        bublisher=(Button)findViewById(R.id.bublisher);

        bublisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                if(IsValid())
                {

                    connection();
                }


            }
        });




    }
    public interface Bublish{
        @FormUrlEncoded
        @POST("InsertData.php")
        Call<ResponseBody> InsertData(@Field("name") String name,
                                       @Field("phone") String phone,
                                       @Field("description") String description);

    }

    private void connection() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://ibrahimmosaadco.000webhostapp.com/")
                .build();

        Bublish bublish=retrofit.create(Bublish.class);

        Call<ResponseBody> publishconnection=bublish.InsertData(name,phone,des);

        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(BublishActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage(getApplication().getString(R.string.Registermessage));
        //  progressDoalog.setTitle("");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDoalog.show();
        publishconnection.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                progressDoalog.dismiss();
                Log.v("this", "Yes!");
                Toast.makeText(BublishActivity.this,getApplicationContext().getString(R.string.sendsuccessowner), Toast.LENGTH_LONG).show();
                nametext.setText("");
                phonetext.setText("");
                destext.setText("");

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                progressDoalog.dismiss();
                Log.v("this", "No Response!");
                Toast.makeText(BublishActivity.this, getApplicationContext().getString(R.string.sendfail), Toast.LENGTH_LONG).show();


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
        if (des.equals(" ")||des.isEmpty())
        {

            destext.setError("Fill Here Please");
            destext.requestFocus();
            return false;

        }
        return true;
    }

    public void getData(){
        name=nametext.getText().toString().toLowerCase().trim();
        phone=phonetext.getText().toString().trim();
        des=destext.getText().toString().toLowerCase().trim();


    }
}
