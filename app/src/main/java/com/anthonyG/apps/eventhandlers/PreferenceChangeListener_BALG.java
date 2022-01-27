package com.anthonyG.apps.eventhandlers;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.widget.Toast;

import com.anthonyG.apps.prueba2_anthony_lopez_guerrero.MainActivity_BALG;
import com.anthonyG.apps.prueba2_anthony_lopez_guerrero.R;

import java.util.Set;

public class PreferenceChangeListener_BALG implements OnSharedPreferenceChangeListener {
    private MainActivity_BALG mainActivityBALG;

    public PreferenceChangeListener_BALG(MainActivity_BALG mainActivityBALG) {
        this.mainActivityBALG = mainActivityBALG;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        this.mainActivityBALG.setPreferencesChanged(true);

        if (key.equals(this.mainActivityBALG.getREGIONS())) {
            this.mainActivityBALG.getQuizViewModel().setGuessRows(sharedPreferences.getString(
                    MainActivity_BALG.CHOICES, null));
            this.mainActivityBALG.getQuizFragment().resetQuiz();
        } else if (key.equals(this.mainActivityBALG.getCHOICES())) {
            Set<String> regions = sharedPreferences.getStringSet(this.mainActivityBALG.getREGIONS(),
                    null);
            if (regions != null && regions.size() > 0) {
                this.mainActivityBALG.getQuizViewModel().setRegionsSet(regions);
                this.mainActivityBALG.getQuizFragment().resetQuiz();
            } else {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                regions.add(this.mainActivityBALG.getString(R.string.default_region));
                editor.putStringSet(this.mainActivityBALG.getREGIONS(), regions);
                editor.apply();
                Toast.makeText(this.mainActivityBALG, R.string.default_region_message,
                        Toast.LENGTH_LONG).show();
            }
        }

        Toast.makeText(this.mainActivityBALG, R.string.restarting_quiz,
                Toast.LENGTH_SHORT).show();
    }
}
