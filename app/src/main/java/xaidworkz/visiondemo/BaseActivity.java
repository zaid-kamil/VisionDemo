package xaidworkz.visiondemo;

import android.Manifest;
import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by maithani on 18-08-2017.
 */

public class BaseActivity extends AppCompatActivity {
    public static final String PACKAGE_NAME = "xaidworkz.visiondemo";
    public static final String APP_NAME = "CVA";
    public Context context = this;

    private ProgressDialog dialog;

    public void showProgressDialog(String msg) {
        dialog = new ProgressDialog(this);
        dialog.setMessage(msg);
        dialog.setCancelable(false);
        dialog.show();

    }

    public boolean checkPermission(String permission, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{permission}, requestCode);

            } else {
                Toast.makeText(this, "permission granted", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return true;

    }

    public void animateIntent(Intent intent, int enterResId, int exitResId, Context context) {
        ActivityOptions options =
                ActivityOptions.makeCustomAnimation(context, enterResId, exitResId);
        this.context.startActivity(intent, options.toBundle());
    }

    public void hideProgressDialog() {
        if (dialog != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        }
    }

    public void message(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void messageBar(View v, String msg) {
        //require design library

        // Snackbar.make(v,msg,Snackbar.LENGTH_LONG).show();
    }

    public void showAlert(String title, String message, String yes, String no, int icon) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setIcon(icon)
                .setPositiveButton(yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton(no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        dialog.show();
    }


    public void log(String data) {
        Log.d("trainedge.training", data);
    }

    public void showAlert() {

    }

    public boolean handlePermission(String permission, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{permission}, requestCode);
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    public void snack(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }
}
