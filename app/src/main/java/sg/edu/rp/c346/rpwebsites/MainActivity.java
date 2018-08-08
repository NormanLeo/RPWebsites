package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spnCategory, spnPage;
    Button btnGo;
    WebView wvWeb;
    ArrayList<String> alWeb;
    ArrayAdapter<String> aaWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCategory = findViewById(R.id.spinnerCategory);
        spnPage = findViewById(R.id.spinnerPage);
        btnGo = findViewById(R.id.buttonGo);
        wvWeb = findViewById(R.id.webViewWeb);
        alWeb = new ArrayList<>();
        aaWeb = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alWeb);
        spnPage.setAdapter(aaWeb);

        spnCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i){
                    case 0:
                        alWeb.clear();
                        String[] rpPage = getResources().getStringArray(R.array.rp);
                        alWeb.addAll(Arrays.asList(rpPage));
                        break;
                    case 1:
                        alWeb.clear();
                        String[] soiPage = getResources().getStringArray(R.array.soi);
                        alWeb.addAll(Arrays.asList(soiPage));
                        break;
                }
                aaWeb.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int posCat = spnCategory.getSelectedItemPosition();
                int posPage = spnPage.getSelectedItemPosition();
                String url ="";
                if (posCat == 0 && posPage == 0){
                    url = "https://www.rp.edu.sg/";
                    spnCategory.setSelection(0);
                    spnPage.setSelection(0);
                }
                else if (posCat == 0 && posPage == 1){
                    url = "https://www.rp.edu.sg/student-life";
                    spnCategory.setSelection(0);
                    spnPage.setSelection(1);
                }
                else if (posCat == 1 && posPage == 0){
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                    spnCategory.setSelection(1);
                    spnPage.setSelection(0);
                }
                else if (posCat == 1 && posPage == 1){
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                    spnCategory.setSelection(1);
                    spnPage.setSelection(1);
                }

                Intent myIntent = new Intent(MainActivity.this, WebViewActivity.class);
                myIntent.putExtra("url", url);
                startActivity(myIntent);
            }
        });
    }
}
