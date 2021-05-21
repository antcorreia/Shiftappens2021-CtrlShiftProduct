package com.example.shiftappens2021;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    float x1, x2, y1, y2;
    private Button informationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        informationButton = findViewById(R.id.informationButton);
        informationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageBuilder("Information", "Esta aplicação foi desenvolvida por um grupo de quatro pessoas como suvmissao no ShiftAPPens2021.\nA aplicacao tem como objetivo reduzir a poluicao visual nas embalagens de produtos, ao color esta informacao de forma organizada num QR code.\nApresenta ainda informacao mais detalhada sobre como reciclar o produto em questao.");
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean onTouchEvent (MotionEvent touchevent){
        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if (x1 < x2){
                    startCamera();
                }
                else if (x1 > x2){
                    Intent i = new Intent(MainActivity.this, SwipeRight.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }

    public void startCamera(){
        IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
        intentIntegrator.setOrientationLocked(true);
        intentIntegrator.setCaptureActivity(Capture.class);
        intentIntegrator.initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (intentResult.getContents() != null){
            if (intentResult.getContents().length() == 27 && intentResult.getContents().startsWith("shiftappens2021!#")){
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://databaseshiftappens2021-default-rtdb.europe-west1.firebasedatabase.app/");
                DatabaseReference reference = database.getReference().child("produtos").child(intentResult.getContents().substring(17, 27));
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()) {
                            Intent i = new Intent(MainActivity.this, ProductDisplay.class);
                            i.putExtra("name", snapshot.child("nome").getValue(String.class));
                            i.putExtra("brand", snapshot.child("marca").getValue(String.class));
                            i.putExtra("recycling", snapshot.child("reciclagem").getValue(String.class));
                            i.putExtra("nutritional", snapshot.child("informacao-nutricional").getValue(String.class));
                            i.putExtra("image", snapshot.child("imagem").getValue(String.class));

                            startActivity(i);
                        }
                        else
                            messageBuilder("Erro", "Este QR code nao corresponde a nenhum produto na nossa base de dados");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
            else {
                messageBuilder("Erro", "QR code invalido, confirme se o codigo que tentou usar foi feito para esta aplicacao");
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Whoops, nao foi detetado nenhum QR code", Toast.LENGTH_SHORT).show();
        }
    }

    public void messageBuilder(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

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
}