package jp.techinstitute.fragmenttablet;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by n_type on 2015/11/14.
 */
public class MyListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] Data = {
                "リンゴ",
                "みかん",
                "梨",
                "ドリアン"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Data);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // MainActivityのオブジェクトを取得
        MainActivity activity = (MainActivity) getActivity();

        // 選択されたアイテム
        String itemStr = l.getItemAtPosition(position).toString();

        // R.id.detailがあるか否かで場合分け
        boolean hasDetail = false;
        View detail = activity.findViewById(R.id.detail);
        if (detail == null) {
            hasDetail = false;
        } else {
            hasDetail = true;
        }

        // R.id.detailがある場合
        if (hasDetail) {
            // ActivityのFragmentManagerからFragmentTransactionを取得
            FragmentManager fm = activity.getFragmentManager();
            FragmentTransaction t = fm.beginTransaction();

            // DetailFragmentに渡す
            DetailFragment fragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString("item", itemStr);
            fragment.setArguments(bundle);

            // レイアウトにFragmentをセット
            t.replace(R.id.detail, fragment);
            t.commit();
        } else {
            // R.id.detailがない場合はToastで呼び出し
            Toast.makeText(getActivity(), itemStr, Toast.LENGTH_SHORT).show();
        }
    }
}
