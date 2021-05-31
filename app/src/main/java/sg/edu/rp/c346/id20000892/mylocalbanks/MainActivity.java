package sg.edu.rp.c346.id20000892.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2,btn3;
String w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn1.setTextColor(Color.BLACK);
        btn2.setTextColor(Color.BLACK);
        btn3.setTextColor(Color.BLACK);

        registerForContextMenu(btn1);
        registerForContextMenu(btn2);
        registerForContextMenu(btn3);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,getString(R.string.web));
        menu.add(0,1,1,getString(R.string.contact));
        menu.add(0,2,2,getString(R.string.fav));
        if(v == btn1){
            w = "DBS";
        }
        else if(v == btn2){
            w = "OCBC";
        }
        else if(v == btn3){
            w = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(w.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsurl)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbs1)));
                startActivity(i);
            }
            else if (item.getItemId() == 2 && btn1.getCurrentTextColor() == Color.BLACK) {
                btn1.setTextColor(Color.RED);
            }
            else if (item.getItemId() == 2 && btn1.getCurrentTextColor() == Color.RED) {
                btn1.setTextColor(Color.BLACK);
            }
        }

        if(w.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcurl)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.ocbc1)));
                startActivity(i);
            }
            else if (item.getItemId() == 2 && btn2.getCurrentTextColor() == Color.BLACK) {
                btn2.setTextColor(Color.RED);
            }
            else if (item.getItemId() == 2 && btn2.getCurrentTextColor() == Color.RED) {
                btn2.setTextColor(Color.BLACK);
            }
        }

        if(w.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uoburl)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uob1)));
                startActivity(i);
            }
            else if (item.getItemId() == 2 && btn3.getCurrentTextColor() == Color.BLACK) {
                btn3.setTextColor(Color.RED);
            }
            else if (item.getItemId() == 2 && btn3.getCurrentTextColor() == Color.RED) {
                btn3.setTextColor(Color.BLACK);
            }
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.eng){
            btn1.setText(getString(R.string.dbs));
            btn2.setText(getString(R.string.ocbc));
            btn3.setText(getString(R.string.uob));

        }
        if (id == R.id.cn){
            btn1.setText(getString(R.string.dbscn));
            btn2.setText(getString(R.string.ocbccn));
            btn3.setText(getString(R.string.uobcn));

        }
        return super.onOptionsItemSelected(item);
    }
}