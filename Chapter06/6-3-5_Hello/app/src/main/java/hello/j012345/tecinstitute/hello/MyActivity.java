package hello.j012345.tecinstitute.hello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by n_type on 2015/11/10.
 */
public class MyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView v = new MyView(this);
        Intent intent = getIntent();
        int vx = intent.getIntExtra("vx", 1);
        int vy = intent.getIntExtra("vy", 1);
        v.mVX = vx;
        v.mVY = vy;
        setContentView(v);
    }
}
