package manshoor.ali.spinnericons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] spinnerTitles;
    int[] spinnerImages;
    Spinner mSpinner;
    Boolean isUserInteracting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = (Spinner) findViewById(R.id.spinner_icon);

        spinnerTitles = new String[]{"Select Crop", "Sunflower", "Potato", "Sugarcane", "Wheat", "Rice", "Corn", "Corn Fodder", "Live Fodder", "Color Fodder", "Mat-Grass Fodder", "Jantar Fodder", "Rhodes-Grass Fodder"};
        spinnerImages = new int[]{R.drawable.ic_select
                , R.drawable.ic_sunflower
                , R.drawable.ic_potatoes
                , R.drawable.ic_sugarcane
                , R.drawable.ic_wheat
                , R.drawable.ic_rice
                , R.drawable.ic_maize
                , R.drawable.ic_maize
                , R.drawable.ic_livefodder
                , R.drawable.ic_colorfodder
                , R.drawable.ic_matgrassfodder
                , R.drawable.ic_jantarfodder
                , R.drawable.ic_rhodesfodder};

        CustomAdapter mCustomAdapter = new CustomAdapter(MainActivity.this, spinnerTitles, spinnerImages);
        mSpinner.setAdapter(mCustomAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int i, long l) {
                if (isUserInteracting) {
                    Toast.makeText(MainActivity.this, spinnerTitles[i], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView adapterView) {

            }
        });

    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        isUserInteracting = true;
    }

}
