package jp.techinstitute.cameraintent;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button1;
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        imageView1 = (ImageView) findViewById(R.id.imageView1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // カメラでの撮影画面を暗黙Intentで呼び出し
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                // 結果を受け取るためにstartActivityForResult(intent, requestCode)を使う
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == 0 && resultCode == Activity.RESULT_OK ){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView1.setImageBitmap(image);
        }
    }
}
