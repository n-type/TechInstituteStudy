package hello.j012345.tecinstitute.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button1);
        btn.setText("Hello");
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Button b = (Button) arg0;
                b.setText("こんにちは");
            }
        });
    }

}
