package fr.grabarski.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;


public class MainActivity extends ActionBarActivity {

    //Properties
    public final static int ENTER_NAME_REQUEST = 0;
    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;
    private TextView mResultTextView;

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("MainActivity", "OnResume");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.v("MainActivity", "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.v("MainActivity", "OnDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciate graphical element
        this.mTextView = (TextView) findViewById(R.id.mytextview);
        this.mButton = (Button) findViewById(R.id.mybutton);
        this.mResultTextView = (TextView) findViewById(R.id.myresulttextview);

        this.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondAtivity();
//                openWebPage("http://www.grabarski.fr");
//                dialPhoneNumber("0679701103");
//                sendEmail();
//                openMap();
            }
        });

        if (savedInstanceState !=null) {
            this.mResultTextView.setText(savedInstanceState.getString("savedResultTextView"));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedResultTextView", this.mResultTextView.getText().toString());
    }

    private void goToSecondAtivity() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//        String myName = this.mEditText.getText().toString();
//        intent.putExtra("name", myName);
        startActivityForResult(intent, ENTER_NAME_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ENTER_NAME_REQUEST) {
            if (resultCode == RESULT_OK) {
                mResultTextView.setText("Hello " + data.getStringExtra("myName"));
            }
        }
    }

    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"robin.grabarski@isen-lille.fr"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");

        if (emailIntent.resolveActivity((getPackageManager())) != null) {
            startActivity(emailIntent);
        }
    }

    private void openMap() {
        Intent intent = new Intent(Intent.ACTION_VIEW);

        Uri uri = Uri.parse("geo:0,0?q=Université+Catholique+de+Lille");
        intent.setData(uri);

        if (intent.resolveActivity((getPackageManager())) != null) {
            startActivity(intent);
        }
    }

}
