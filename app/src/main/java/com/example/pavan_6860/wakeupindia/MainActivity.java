package com.example.pavan_6860.wakeupindia;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pavan_6860.wakeupindia.db.DbHelper;
import com.example.pavan_6860.wakeupindia.db.Utils;
import com.example.pavan_6860.wakeupindia.model.Record;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText userName=null;
    EditText password=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(PackageManager.PERMISSION_GRANTED!= getPackageManager().checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE,getPackageName())){
            providePermissions();
        }
    }

    private void providePermissions() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivity(intent);
        Toast.makeText(this,getResources().getString(R.string.permission_msg),Toast.LENGTH_LONG).show();

    }


    public void signIn(View view){
        Intent homeIntent=new Intent(this,Home.class);
        try{
            userName=(EditText) findViewById(R.id.user_name_id);
            password=(EditText) findViewById(R.id.password_id);
            if(userName!=null && password!=null && !userName.getText().toString().trim().isEmpty() && !password.getText().toString().trim().isEmpty()){
                Record record=new Record();
                record.setUserName(userName.getText().toString().trim());
                record.setPassword(password.getText().toString().trim());
                if(Utils.verifyRecord(this,record)) {
                    startActivity(homeIntent);
                }
            }
            else{
                Toast.makeText(this,getResources().getString(R.string.error_message),Toast.LENGTH_LONG).show();
            }

          /*  if(PackageManager.PERMISSION_GRANTED!= getPackageManager().checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE,getPackageName())){
              providePermissions();
            }
            else {
//                String path = Environment.getExternalStorageDirectory().toString()+File.separator+"DCIM"+File.separator+"Camera";
//                File f = new File(path);
//                File file[] = f.listFiles();
//                ArrayList<Uri> files = new ArrayList<Uri>();
//                for (int i = 0; i < 3; i++) {
//                        Uri uri = Uri.fromFile(file[i]);
//                        files.add(uri);
//                }
//                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_SEND_MULTIPLE);
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Here are some files.");
//                intent.setType("image/jpg");
//                intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
//                intent.setPackage("com.whatsapp");
//                intent.putExtra("jid", PhoneNumberUtils.stripSeparators("919154646416")+"@s.whatsapp.net");
//                startActivity(intent);
                startActivity(homeIntent);
            }*/
        }
        catch (Exception e){
            Toast.makeText(this,getResources().getString(R.string.error_message),Toast.LENGTH_LONG).show();
        }
    }
}
