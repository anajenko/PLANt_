package si.uni_lj.fe.tnuv.plant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<Razpis> razpisiList = null;
    private ArrayList<Razpis> arraylist;

    public ListViewAdapter(Context context, List<Razpis> razpisiList) {
        mContext = context;
        this.razpisiList = razpisiList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Razpis>();
        this.arraylist.addAll(razpisiList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return razpisiList.size();
    }

    @Override
    public Razpis getItem(int position) {
        return razpisiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.list_view_items, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(razpisiList.get(position).getEn_razpis());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        razpisiList.clear();
        if (charText.length() == 0) {
            razpisiList.addAll(arraylist);
        } else {
            for (Razpis wp : arraylist) {
                if (wp.getEn_razpis().toLowerCase(Locale.getDefault()).contains(charText)) {
                    razpisiList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
