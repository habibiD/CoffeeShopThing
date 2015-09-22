package com.example.habibi.listviewexample;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private List<CoffeeShops> myCoffeeShops = new ArrayList<CoffeeShops>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateCoffeeList();
        populateListView();
        registerClickCallback();



    }


    private void populateCoffeeList() {
        myCoffeeShops.add(new CoffeeShops("0314020490","3 sports","fego",R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("0837845643","Westwood","Ninos",R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("2309423420","Engine","Delicious",R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("0314020490","3 sports","fego",R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("0837845643","Westwood","Ninos",R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("2309423420","Engine","Delicious",R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("0314020490","3 sports","fego",R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("0837845643","Westwood","Ninos",R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("2309423420", "Engine", "Delicious", R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("0314020490", "3 sports", "fego", R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("0837845643", "Westwood", "Ninos", R.drawable.coffeeshoppic));
        myCoffeeShops.add(new CoffeeShops("2309423420", "Engine", "Delicious", R.drawable.coffeeshoppic));
    }

    private void populateListView() {
        ArrayAdapter<CoffeeShops> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.CSListView);
        list.setAdapter(adapter);
    }
        private class MyListAdapter extends ArrayAdapter<CoffeeShops> {
            public MyListAdapter()
            {
                super(MainActivity.this, R.layout.item_view, myCoffeeShops);
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View itemView = convertView;
                if(itemView==null)
                {
                    itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
                }
                // find car to work with

                CoffeeShops currentShop = myCoffeeShops.get(position);

                // fill the view

                ImageView imageView = (ImageView)itemView.findViewById(R.id.item_icon);
                imageView.setImageResource(currentShop.getIconID());

                // name:

                TextView nameText = (TextView) itemView.findViewById(R.id.txtName);
                nameText.setText(currentShop.getName());

                // Tel

                TextView addressText = (TextView) itemView.findViewById(R.id.txtAddress);
                addressText.setText(currentShop.getAddress());

                // address

                TextView telText = (TextView) itemView.findViewById(R.id.txtTel);
                telText.setText(currentShop.getTel());

                return itemView;
            }
        }

    private void registerClickCallback() {

        ListView list = (ListView) findViewById(R.id.CSListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CoffeeShops chosenShop = myCoffeeShops.get(position);
                String message = "Yoy clicked position "  + position + " which is car make " + chosenShop.getName();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
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
}
