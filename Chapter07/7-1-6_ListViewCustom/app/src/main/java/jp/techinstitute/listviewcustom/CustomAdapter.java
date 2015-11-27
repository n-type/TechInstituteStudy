package jp.techinstitute.listviewcustom;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by n_type on 2015/11/14.
 */
public class CustomAdapter extends ArrayAdapter<ItemData> {
    private LayoutInflater layoutInflater_;

    public CustomAdapter(Context context, int textViewResourceId, List<ItemData> objects) {
        super(context, textViewResourceId, objects);

        layoutInflater_ = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 表示する行(position)のデータを得る
        ItemData item = (ItemData) getItem(position);

        // convertViewは使い回しされている可能性があるのでnullの時だけ新しく作る
        if (null == convertView) {
            convertView = layoutInflater_.inflate(R.layout.item_layout, null);
        }

        // ItemDataのデータを各Viewにセットする
        ImageView imageView;
        imageView = (ImageView) convertView.findViewById(R.id.image);
        imageView.setImageBitmap(item.getImage());

        TextView textView;
        textView = (TextView) convertView.findViewById(R.id.text);
        textView.setText(item.getText());

        return convertView;
    }
}
