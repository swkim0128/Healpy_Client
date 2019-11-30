package org.kitsoft.healpy.myapplication;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import org.kitsoft.healpy.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.M) {
            int permissionResult = checkCallingOrSelfPermission(Manifest.permission.CAMERA);

            if (permissionResult == PackageManager.PERMISSION_DENIED) {

                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {

                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("권한이 필요합니다.")
                            .setMessage("이 기능을 사용하기 위해서는 단말기의 \"카메라\" 권한이 필요합니다. 계속하시겠습니까?")
                            .setPositiveButton("네", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
                                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 1000);
                                    }
                                }
                            })

                            .setNegativeButton("아니오", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    Toast.makeText(MainActivity.this, "기능을 취소했습니다.", Toast.LENGTH_SHORT).show();

                                }
                            })
                            .create().show();
                } else {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 1000);
                }
            } else {
            }
        } else {
        }

        Button joiningBtn = (Button) findViewById(R.id.joiningBtn);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);


        joiningBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(MainActivity.this, JoiningMemberActivity.class);
                startActivity(intent);*/
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
