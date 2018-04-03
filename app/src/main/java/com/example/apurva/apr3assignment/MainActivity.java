package com.example.apurva.apr3assignment;

import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;
    Button click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click=findViewById(R.id.btn_click);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu p1=new PopupMenu(MainActivity.this,click);
                p1.getMenuInflater().inflate(R.menu.popup_menu_option,p1.getMenu());
                p1.show();
                p1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.item1:
                                dialog=new Dialog(MainActivity.this);
                                dialog.setContentView(R.layout.my_custom_dialog);
                                dialog.show();


                                Button btn_green,btn_blue,btn_red;

                                btn_green=dialog.findViewById(R.id.btn_green);
                                btn_blue=dialog.findViewById(R.id.btn_blue);
                                btn_red=dialog.findViewById(R.id.btn_red);

                                //set click backgroundd  to green if green button is clicked
                                btn_green.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        click.setBackgroundColor(Color.GREEN);
                                        dialog.dismiss();
                                    }
                                });

                                //set click background to blue if blue button is clicked

                                btn_blue.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        click.setBackgroundColor(Color.BLUE);
                                        dialog.dismiss();
                                    }
                                });

                                //set click background to red if red button is clicked

                                btn_red.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        click.setBackgroundColor(Color.RED);
                                        dialog.dismiss();
                                    }
                                });

                                break;
                            case R.id.item2:
                                dialog=new Dialog(MainActivity.this);
                                dialog.setContentView(R.layout.custom_dialog_to_rename);
                                dialog.show();
                                Button btn_rename=dialog.findViewById(R.id.btn_rename);
                                final EditText et_rename=dialog.findViewById(R.id.et_rename);
                                et_rename.setText(click.getText().toString());
                                btn_rename.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        click.setText(et_rename.getText().toString());
                                        dialog.dismiss();
                                    }
                                });
                                break;
                        }
                        return false;
                    }
                });
            }
        });
    }
}
