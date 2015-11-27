package jp.techinstitute.spinnerxml;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

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

        // fragment_mainからSpinnerオブジェクトを取得
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // アイテムが選択された時の動作
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 引数のparentがイベントがあ発生したSpinnerのオブジェクト
                Spinner spinner = (Spinner) parent;
                String str = spinner.getSelectedItem().toString();
                Toast.makeText(getActivity(), str + "が選択されました", Toast.LENGTH_SHORT).show();
            }

            // 何も選択されなかった時の動作
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return rootView;
    }
}
