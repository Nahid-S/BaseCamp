//package com.example.pikachu;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ImageButton;
//
//import androidx.appcompat.app.AppCompatActivity;
//
////import com.github.barteksc.pdfviewer.PDFView;
//
//public class NewBook extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_new_book);
//
//        ImageButton button1 = findViewById(R.id.imageButton12);
//        ImageButton button2 = findViewById(R.id.imageButton19);
//        ImageButton button3 = findViewById(R.id.imageButton20);
//        ImageButton button4 = findViewById(R.id.imageButton21);
//        ImageButton button5 = findViewById(R.id.imageButton15);
//        ImageButton button6 = findViewById(R.id.imageButton13);
//
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPdf("https://www.africau.edu/images/default/sample.pdf");
//            }
//        });
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPdf("URL_TO_PDF_2");
//            }
//        });
//
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPdf("URL_TO_PDF_3");
//            }
//        });
//
//        button4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPdf("URL_TO_PDF_4");
//            }
//        });
//
//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPdf("URL_TO_PDF_5");
//            }
//        });
//
//        button6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openPdf("URL_TO_PDF_6");
//            }
//        });
//    }
//
//    private void openPdf(String url) {
//        Intent intent = new Intent(this, PDFViewerActivity.class);
//        intent.putExtra("pdfUrl", url);
//        startActivity(intent);
//    }
//}
