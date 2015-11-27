package jp.techinstitute.fragmenttablet;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by n_type on 2015/11/15.
 */
public class DetailFragment extends Fragment {

    // フラグメントのビュー生成時に呼ばれる
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        if (container == null) {
            return null;
        }
        TextView rootView = new TextView(getActivity());
        rootView.setTextSize(18);
        rootView.setText(getArguments().getString("item") + "が選択されました");
        return rootView;
    }
}
