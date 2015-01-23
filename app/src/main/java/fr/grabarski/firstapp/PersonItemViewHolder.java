package fr.grabarski.firstapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Robin on 22/01/2015.
 */
public class PersonItemViewHolder {
    private final Context context;
    private View personView;
    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private View colorView;

    public PersonItemViewHolder(Context context) {
        this.context = context;
        createView();
    }

    private void createView() {
        personView = LayoutInflater.from(context).inflate(R.layout.person_item, null);
        firstNameTextView = (TextView) personView.findViewById(R.id.firstname_textview);
        lastNameTextView = (TextView) personView.findViewById(R.id.lastname_textview);
        colorView = personView.findViewById(R.id.color_view);
    }

    public void updateView(Person person) {
        firstNameTextView.setText(person.getFirstName());
        lastNameTextView.setText(person.getLastName());
        colorView.setBackgroundColor(person.getFavoriteColor());
    }

    public View getView() {
        return personView;
    }
}
