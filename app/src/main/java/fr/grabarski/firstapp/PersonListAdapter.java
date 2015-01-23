package fr.grabarski.firstapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Robin on 23/01/2015.
 */
public class PersonListAdapter extends BaseAdapter {

    private Context context;
    private List<Person> dataSource;
    private PersonItemViewHolder viewHolder;
    private View cellView;
    private Person person;

    public PersonListAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.dataSource = personList;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        cellView = convertView;
        person = dataSource.get(position);
        if (cellView == null) {
            viewHolder = new PersonItemViewHolder(context);
            cellView = viewHolder.getView();
            cellView.setTag(viewHolder);
        }
        viewHolder = (PersonItemViewHolder) cellView.getTag();
        viewHolder.updateView(person);
        return cellView;
    }
}
