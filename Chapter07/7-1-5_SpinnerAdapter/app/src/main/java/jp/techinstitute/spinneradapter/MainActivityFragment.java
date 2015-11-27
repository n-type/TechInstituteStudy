package jp.techinstitute.spinneradapter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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

        // ArrayAdapterオブジェクトを作成して選択肢アイテムをセット
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item);
        adapter.add("リンゴ");
        adapter.add("みかん");
        adapter.add("梨");
        adapter.add("ドリアン");

        // Spinnerに作成したArrayAdapterをセット
        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);

        return rootView;
    }
}
