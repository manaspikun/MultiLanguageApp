package multilanguageapp.com.androidinterview.multilanguageapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity {

    EditText ET_eamil,ET_password;
    TextView TV_Hindi,TV_English,TV_French;
    Locale mylocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET_eamil=(EditText)findViewById(R.id.emailid);
        ET_password=(EditText)findViewById(R.id.password);
        //Change Hint color text
        ET_eamil.setHintTextColor(getResources().getColor(R.color.text_color));
        ET_password.setHintTextColor(getResources().getColor(R.color.text_color));

        TV_Hindi=(TextView)findViewById(R.id.TVHindi);
        TV_English=(TextView)findViewById(R.id.TVEnglish);
        TV_French=(TextView)findViewById(R.id.TVFrench);

        //Set Hindi Language
        TV_Hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Hindi Language",Toast.LENGTH_SHORT).show();
                setLanguage("hi");
            }
        });

        //Set English Language
        TV_English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"English Language",Toast.LENGTH_SHORT).show();
                setLanguage("en");
            }
        });

        //Set French Language
        TV_French.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"French Language",Toast.LENGTH_SHORT).show();
                setLanguage("fr");
            }
        });
    }

    //Change language Method
    protected void setLanguage(String language){
        mylocale=new Locale(language);
        Resources resources=getResources();
        DisplayMetrics dm=resources.getDisplayMetrics();
        Configuration conf= resources.getConfiguration();
        conf.locale=mylocale;
        resources.updateConfiguration(conf,dm);
        Intent refreshIntent=new Intent(MainActivity.this,MainActivity.class);
        finish();
        startActivity(refreshIntent);
    }

}
