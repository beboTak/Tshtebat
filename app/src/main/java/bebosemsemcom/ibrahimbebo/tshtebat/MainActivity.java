package bebosemsemcom.ibrahimbebo.tshtebat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button worker,owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        worker=(Button)findViewById(R.id.worker);
        owner=(Button)findViewById(R.id.owner);

          worker=(Button)findViewById(R.id.worker);
        owner=(Button)findViewById(R.id.owner);
        worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,WorkerbaseActivity.class);
                startActivity(intent);
               // finish();
            }
        });


        owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,OwnerbaseActivity.class);
                startActivity(intent);
               // finish();
            }
        });


    }
}
