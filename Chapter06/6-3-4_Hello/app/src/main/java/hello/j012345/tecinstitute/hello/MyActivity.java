package hello.j012345.tecinstitute.hello;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by n_type on 2015/11/10.
 */
public class MyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView v = new MyView(this);
        setContentView(v);
    }
}
