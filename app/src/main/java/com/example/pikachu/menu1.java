package com.example.pikachu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class menu1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);
    }


    public void openweb(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://basecampstudy.co.uk/"));
        startActivity(intent);
    }

    public void openfb(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web.facebook.com/groups/risersnext/?paipv=0&eav=AfaZ8HTYbiJN1VQW1p04kIYzUyNnRvUUuDDMDlkwW7gqwbXxy0kSgRw-cEgJPAENuH0&_rdc=1&_rdr"));
        startActivity(intent);
    }

    public void openlinkedin(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/egsbasecamp/"));
        startActivity(intent);
    }

    public void openmap(View view) {
        Uri gmmIntentUri = Uri.parse("https://maps.app.goo.gl/PY2M5yqxkJ2bxm7KA");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.app.goo.gl/NSy3KAjK4ghMdBrE7"));
            startActivity(intent);
        }

    }


    public void feedback(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://forms.gle/obHyBVQizzG6uwoV7"));
        startActivity(intent);
    }

    public void update(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/prometheus/index/nahid"));
        startActivity(intent);
    }

    public void chatsupp(View view) {
        String phoneNumber = "8801707274452";
        Uri gmmIntentUri = Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.whatsapp");

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        } else {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber));
            startActivity(intent);
            Toast.makeText(this, "WhatsApp not available. Opening in browser...", Toast.LENGTH_SHORT).show(); //next time
        }
    }


}