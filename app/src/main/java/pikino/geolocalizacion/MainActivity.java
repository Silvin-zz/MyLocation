package pikino.geolocalizacion;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private LocationManager locationMan;
    private String proveedor;
    TextView latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.latitude       = (TextView) findViewById(R.id.latitude);
        this.longitude      = (TextView) findViewById(R.id.longitude);

        this.locationMan    = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        Criteria   criteria = new Criteria();
        this.proveedor      = locationMan.getBestProvider(criteria,false);

        Location mylocation = locationMan.getLastKnownLocation(this.proveedor);

        Log.d("datos","=========================" + Double.toString(mylocation.getLatitude()) + " latitud" );

        latitude.setText(Double.toString(mylocation.getLatitude()) + " latitud");
        longitude.setText(Double.toString(mylocation.getLongitude()) + " longitud");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
