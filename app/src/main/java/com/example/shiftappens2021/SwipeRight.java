package com.example.shiftappens2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class SwipeRight extends AppCompatActivity {
    private Button backButton;
    float x1, x2, y1, y2;
    private String buttonNamesString;
    private String[] buttonNames;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String BUTTON_NAMES = "buttonNames";

    private final FirebaseDatabase database = FirebaseDatabase.getInstance("https://databaseshiftappens2021-default-rtdb.europe-west1.firebasedatabase.app/");
    private final DatabaseReference reference = database.getReference().child("produtos");

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_right);
        loadData();
        if (getIntent().getBooleanExtra("update", false)){
            if (notInHistorico(getIntent().getStringExtra("name"))) {
                if (buttonNames.length - 1 >= 0)
                    System.arraycopy(buttonNames, 0, buttonNames, 1, buttonNames.length - 1);
                buttonNames[0] = getIntent().getStringExtra("name");
                saveData();
                loadData();
            }
            finish();
        }
        backButton = findViewById(R.id.backButton);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn10 = findViewById(R.id.btn10);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btn1.getText().equals("-")){
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Intent i = new Intent(SwipeRight.this, ProductDisplay.class);
                            ArrayList<String> nome = new ArrayList<>();
                            nome = collectProductsId((Map<String, Object>) snapshot.getValue(), btn1);
                            String[] b = {"name", "brand", "recycling", "nutritional", "image"};
                            int c = 0;
                            for (String a : nome) {
                                i.putExtra(b[c], a);
                                c++;
                            }
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btn1.getText().equals("-")){
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Intent i = new Intent(SwipeRight.this, ProductDisplay.class);
                            ArrayList<String> nome = collectProductsId((Map<String, Object>) snapshot.getValue(), btn2);
                            String[] b = {"name", "brand", "recycling", "nutritional", "image"};
                            int c = 0;
                            for (String a : nome) {
                                i.putExtra(b[c], a);
                                c++;
                            }
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btn1.getText().equals("-")) {
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Intent i = new Intent(SwipeRight.this, ProductDisplay.class);
                            ArrayList<String> nome = collectProductsId((Map<String, Object>) snapshot.getValue(), btn3);
                            String[] b = {"name", "brand", "recycling", "nutritional", "image"};
                            int c = 0;
                            for (String a : nome) {
                                i.putExtra(b[c], a);
                                c++;
                            }
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btn1.getText().equals("-")) {
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Intent i = new Intent(SwipeRight.this, ProductDisplay.class);
                            ArrayList<String> nome = collectProductsId((Map<String, Object>) snapshot.getValue(), btn4);
                            String[] b = {"name", "brand", "recycling", "nutritional", "image"};
                            int c = 0;
                            for (String a : nome) {
                                i.putExtra(b[c], a);
                                c++;
                            }
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btn1.getText().equals("-")) {
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Intent i = new Intent(SwipeRight.this, ProductDisplay.class);
                            ArrayList<String> nome = collectProductsId((Map<String, Object>) snapshot.getValue(), btn5);
                            String[] b = {"name", "brand", "recycling", "nutritional", "image"};
                            int c = 0;
                            for (String a : nome) {
                                i.putExtra(b[c], a);
                                c++;
                            }
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btn1.getText().equals("-")) {
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Intent i = new Intent(SwipeRight.this, ProductDisplay.class);
                            ArrayList<String> nome = collectProductsId((Map<String, Object>) snapshot.getValue(), btn6);
                            String[] b = {"name", "brand", "recycling", "nutritional", "image"};
                            int c = 0;
                            for (String a : nome) {
                                i.putExtra(b[c], a);
                                c++;
                            }
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btn1.getText().equals("-")) {
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Intent i = new Intent(SwipeRight.this, ProductDisplay.class);
                            ArrayList<String> nome = collectProductsId((Map<String, Object>) snapshot.getValue(), btn7);
                            String[] b = {"name", "brand", "recycling", "nutritional", "image"};
                            int c = 0;
                            for (String a : nome) {
                                i.putExtra(b[c], a);
                                c++;
                            }
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btn1.getText().equals("-")) {
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Intent i = new Intent(SwipeRight.this, ProductDisplay.class);
                            ArrayList<String> nome = collectProductsId((Map<String, Object>) snapshot.getValue(), btn8);
                            String[] b = {"name", "brand", "recycling", "nutritional", "image"};
                            int c = 0;
                            for (String a : nome) {
                                i.putExtra(b[c], a);
                                c++;
                            }
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btn1.getText().equals("-")) {
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Intent i = new Intent(SwipeRight.this, ProductDisplay.class);
                            ArrayList<String> nome = collectProductsId((Map<String, Object>) snapshot.getValue(), btn9);
                            String[] b = {"name", "brand", "recycling", "nutritional", "image"};
                            int c = 0;
                            for (String a : nome) {
                                i.putExtra(b[c], a);
                                c++;
                            }
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!btn1.getText().equals("-")) {
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            Intent i = new Intent(SwipeRight.this, ProductDisplay.class);
                            ArrayList<String> nome = collectProductsId((Map<String, Object>) snapshot.getValue(), btn10);
                            String[] b = {"name", "brand", "recycling", "nutritional", "image"};
                            int c = 0;
                            for (String a : nome) {
                                i.putExtra(b[c], a);
                                c++;
                            }
                            startActivity(i);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                finish();
            }
        });
    }

    public boolean onTouchEvent (MotionEvent touchevent){
        switch (touchevent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchevent.getX();
                y2 = touchevent.getY();
                if (x1 < x2) {
                    saveData();
                    finish();
                }

                break;
        }
        return false;
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        StringBuilder sb = new StringBuilder();
        for (String buttonName : buttonNames)
            sb.append(buttonName).append(",");

        editor.putString(BUTTON_NAMES, String.valueOf(sb));
        editor.apply();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        buttonNamesString = sharedPreferences.getString(BUTTON_NAMES, "-,-,-,-,-,-,-,-,-,-,");
        buttonNames = buttonNamesString.split(",");

        setContentView(R.layout.activity_swipe_right);
        Button button;
        button = findViewById(R.id.btn1);
        button.setText(buttonNames[0]);
        button = findViewById(R.id.btn2);
        button.setText(buttonNames[1]);
        button = findViewById(R.id.btn3);
        button.setText(buttonNames[2]);
        button = findViewById(R.id.btn4);
        button.setText(buttonNames[3]);
        button = findViewById(R.id.btn5);
        button.setText(buttonNames[4]);
        button = findViewById(R.id.btn6);
        button.setText(buttonNames[5]);
        button = findViewById(R.id.btn7);
        button.setText(buttonNames[6]);
        button = findViewById(R.id.btn8);
        button.setText(buttonNames[7]);
        button = findViewById(R.id.btn9);
        button.setText(buttonNames[8]);
        button = findViewById(R.id.btn10);
        button.setText(buttonNames[9]);
    }

    public boolean notInHistorico(String nome){
        for (String i : buttonNames)
            if (i.equals(nome))
                return false;

        return true;
    }

    public ArrayList<String> collectProductsId(Map<String,Object> users, Button botao){
        ArrayList<String> nome = new ArrayList<>();
        for(Map.Entry<String, Object> entry : users.entrySet()){
            Map singleuser = (Map) entry.getValue();

            if(singleuser.get("nome").equals(botao.getText())){
                nome.add((String) singleuser.get("nome"));
                nome.add((String) singleuser.get("marca"));
                nome.add((String) singleuser.get("reciclagem"));
                nome.add((String) singleuser.get("informacao-nutricional"));
                nome.add((String) singleuser.get("imagem"));
            }
        }
        return nome;
    }
}
