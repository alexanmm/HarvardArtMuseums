package br.com.digitalhouse.harvardartmuseums.fragments.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.digitalhouse.harvardartmuseums.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings){
            Toast.makeText(this,"action_settings", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.action_help){
            Toast.makeText(this,"action_help", Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.action_logout){
            Toast.makeText(this,"action_logout", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
