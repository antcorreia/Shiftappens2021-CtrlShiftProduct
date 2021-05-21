package com.example.shiftappens2021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProductDisplay extends AppCompatActivity{
    private TextView nameView;
    private TextView brandView;
    private TextView recycleView;
    private ImageView imageView;
    private Button closeButton;
    private Button nutritionalInformationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_display);
        nameView = findViewById(R.id.nameView);
        brandView = findViewById(R.id.brandView);
        recycleView = findViewById(R.id.recycleView);
        imageView = findViewById(R.id.productImageView);
        String name = getIntent().getStringExtra("name");
        atualizaHistorico(name);
        String brand = getIntent().getStringExtra("brand");
        String recycling = getIntent().getStringExtra("recycling");
        String nutritional = getIntent().getStringExtra("nutritional");
        nameView.setText(name);
        brandView.setText(brand);
        recycleView.setText(recycling);
        closeButton = findViewById(R.id.closeButton);
        nutritionalInformationButton = findViewById(R.id.nutritionalInformationButton);
        Glide.with(ProductDisplay.this).load(getIntent().getStringExtra("image")).into(imageView);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nutritionalInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageBuilder("Nutritional Information", recebeNutritionalValues(nutritional));
            }
        });
    }

    public void messageBuilder(String title, StringBuilder message){
        AlertDialog.Builder builder = new AlertDialog.Builder(ProductDisplay.this);

        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    public StringBuilder recebeNutritionalValues(String string){
        String[] array = string.split("/");
        String[][] array2 = new String[array.length][2];
        StringBuilder returned = new StringBuilder();
        for (int i = 0; i < array.length; i++)
            array2[i] = array[i].split("=");

        for (String[] i : array2)
            returned.append(i[0]).append(": ").append(i[1]).append("\n");

        return returned;
    }

    public void atualizaHistorico(String name){
        Intent intent = new Intent(ProductDisplay.this, SwipeRight.class);
        intent.putExtra("name", name);
        intent.putExtra("update", true);
        startActivity(intent);
    }
}