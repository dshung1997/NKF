package com.example.tp_baseline.nkf;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AboutUsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_about_us_fragment,container,false);

//        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/abc.ttf");
//
//        tx.setTypeface(custom_font);

//        TextView textViewHistory = (TextView) v.findViewById(R.id.textView_aboutus_history);
//        TextView textViewVision = (TextView) v.findViewById(R.id.textView_aboutus_vision);

        String history_1 = "NKF began in early 1960s when Dr Khoo Oon Teik witnessed the agonising plight of kidney failure sufferers from close quarters. ";
        String history_2 = "In 1969, Dr Khoo and a cohort of friends successfully established Singapore's first dialysis unit at Singapore general hospital (SGH).";

        String vision = "Giving Life & Hope through affordable, sustainable and quality renal care and Education and prevention of Kidney disease in partnership with the Community";
//        textViewHistory.setText(history_1 + history_2);
//        textViewVision.setText(vision);

        return v;
    }

}

//    String historyText;
//        historyText = "<html><body style=\"background-color: #ECF0f1; font-size: 18px; color: #2C3E50\">";
//
//                historyText += "<p align=\"justify\">";
//                historyText+= history_1;
//                historyText+= "</p>";
//
//                historyText += "<p align=\"justify\">";
//                historyText += history_2;
//                historyText+= "</p>";
//
//                historyText += "</body></html>";
//
//                webViewHistory.loadData(historyText, "text/html", "utf-8");
//
//
//                WebView webViewVision = (WebView) v.findViewById(R.id.webView_aboutus_vision);
//                String visionText;
//
//                visionText = "<html><body style=\"background-color: #ECF0f1; font-size: 18px; color: #2C3E50\">";
//                visionText += "<p align=\"justify\">";
//                visionText += vision;
//                visionText += "</p>";
//                visionText += "</body></html>";
//
//                webViewVision.loadData(visionText, "text/html", "utf-8");
