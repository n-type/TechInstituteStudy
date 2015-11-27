package jp.techinstitute.imageid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_main, container, false);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // fragment_mainからImageViewオブジェクトを取得
        ImageView iv = (ImageView) rootView.findViewById(R.id.imageView1);

        // ImageViewにic_launcherをセット
        iv.setImageResource(R.mipmap.ic_launcher);

        return rootView;
    }
}
