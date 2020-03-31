package org.deafsapps.android.datastoragemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static int DEFAULT = 0;
    private final static String SHARED_PREFERENCES_FILENAME = "my-preferences-file";
    private final static String UPDATE_INFO_KEY = "update-info";
    private final static String EMPTY_STRING = "";

    private EditText etInfo;
    private TextView tvUpdateInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(this);

        etInfo = findViewById(R.id.edtTextUpdate);

        tvUpdateInfo = findViewById(R.id.textViewHello);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sPrefs = getSharedPreferences(SHARED_PREFERENCES_FILENAME, MODE_PRIVATE);
        String storedInfo = sPrefs.getString(UPDATE_INFO_KEY, getString(R.string.default_text));
        tvUpdateInfo.setText(storedInfo);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnOk) {
            Log.i("btnOk", "'btnOk' clicked");
            storeUpdateInfoIntoPreferences();
        }

    }

    private void storeUpdateInfoIntoPreferences() {
        String info = etInfo.getText().toString();

        if (updateInfoIsValid(info)) {
            String simplifiedInfo = info.trim();
            SharedPreferences sPrefs = getSharedPreferences(SHARED_PREFERENCES_FILENAME, MODE_PRIVATE);
            SharedPreferences.Editor sPrefsEditor = sPrefs.edit();
            sPrefsEditor.putString(UPDATE_INFO_KEY, simplifiedInfo);
            sPrefsEditor.apply();

            etInfo.setText(EMPTY_STRING);
            Toast.makeText(this, "String '" + simplifiedInfo + "' saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Data not valid", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean updateInfoIsValid(String info) {
        return !info.trim().isEmpty();
    }

}