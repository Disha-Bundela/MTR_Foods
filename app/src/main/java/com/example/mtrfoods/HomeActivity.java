package com.example.mtrfoods;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button btn_Sub;
    RadioButton rb_place;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        radioGroup = (RadioGroup) findViewById(R.id.rg);
        SelectFragment fragment = new SelectFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_framelayout, fragment);
        fragmentTransaction.commit();
    }

//    RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_home:
                showToast("Home");
                Intent iHome = new Intent(this, HomeActivity.class);
                startActivity(iHome);
                return true;
            case R.id.option_callus:
                Intent intentCall = new Intent(Intent.ACTION_DIAL);
                String phoneNumber1 = "9016157138";
                intentCall.setData(Uri.parse("tel:" + phoneNumber1));
                if (intentCall.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentCall);
                }
                return true;
            case R.id.option_contact_us:
                String[] addresses = {"krinabundela@gmail.com", "bundela.hitenbhai@mca.christuniversity.in"};
                String subject = "Contact us";
                String message = "Thank You For Connecting";
                //        Uri attachment
                Intent intent_Email = new Intent(Intent.ACTION_SEND);
                intent_Email.setType("*/*");
                intent_Email.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent_Email.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent_Email.putExtra(Intent.EXTRA_TEXT, message);
                //        intent.putExtra(Intent.EXTRA_STREAM, attachment);
                if (intent_Email.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent_Email);
                }
                return true;
            case R.id.option_location:
                String loc = "MTR Food";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri geoLocation = Uri.parse("geo:0,0?q=" + loc);
                intent.setData(geoLocation);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;
            case R.id.Feedback:
                Feedback fragment = new Feedback();
                FragmentManager fragmentManager = this.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_framelayout, fragment);
                fragmentTransaction.commit();
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
