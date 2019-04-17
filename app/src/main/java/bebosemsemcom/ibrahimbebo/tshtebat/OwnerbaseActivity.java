package bebosemsemcom.ibrahimbebo.tshtebat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class OwnerbaseActivity extends AppCompatActivity {


    Button bublish,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ownerbase);
        bublish=(Button)findViewById(R.id.bublish);
        search=(Button)findViewById(R.id.search);

        bublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OwnerbaseActivity.this,BublishActivity.class);
                startActivity(intent);

            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OwnerbaseActivity.this,WorkerDataActivity.class);
                startActivity(intent);


            }
        });
    }
}
