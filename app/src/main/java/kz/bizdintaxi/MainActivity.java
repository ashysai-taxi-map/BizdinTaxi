package kz.bizdintaxi;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;

public class MainActivity extends Activity {
    private static final String BOT_URL = "https://t.me/AshysaiTaxiBot";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openTelegramBot();
    }

    private void openTelegramBot() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BOT_URL));
            intent.setPackage("org.telegram.messenger");
            startActivity(intent);
            finish();
        } catch (Exception e) {
            showFallback();
        }
    }

    private void showFallback() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(32, 32, 32, 32);
        layout.setBackgroundColor(Color.rgb(245, 249, 246));

        TextView title = new TextView(this);
        title.setText("🚕 Bizdin Taxi");
        title.setTextSize(30);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setTextColor(Color.rgb(20, 100, 55));
        title.setGravity(Gravity.CENTER);
        layout.addView(title, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TextView subtitle = new TextView(this);
        subtitle.setText("Такси шақыру үшін Telegram ботын ашыңыз");
        subtitle.setTextSize(17);
        subtitle.setTextColor(Color.DKGRAY);
        subtitle.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams sp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        sp.setMargins(0, 20, 0, 28);
        layout.addView(subtitle, sp);

        Button button = new Button(this);
        button.setText("TELEGRAM-ДЫ АШУ");
        button.setTextSize(16);
        button.setTextColor(Color.WHITE);
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(Color.rgb(22, 132, 73));
        bg.setCornerRadius(28);
        button.setBackground(bg);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(BOT_URL));
            startActivity(intent);
        });
        layout.addView(button, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        setContentView(layout);
    }
}
