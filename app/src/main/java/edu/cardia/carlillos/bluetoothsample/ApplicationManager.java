package edu.cardia.carlillos.bluetoothsample;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;

import edu.cardia.carlillos.bluetoothsample.utils.PRNGFixes;

/**
 * Clase encargada de gestionar el comportamiento de la aplicación en general
 * definiendo los métodos necesarios para poder almacenar y descargar el valor
 * del servicio Bluetooth en toda la aplcación. Se implementa la autoconcexión
 * con el dispostivo remoto
 * 
 * @author rcarventepc
 * 
 */
public class ApplicationManager extends Application {
	// Debug
	private static final String TAG = "ApplicationManager";
	public static final boolean D = true; // variable global para el debug

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

	@Override
	public void onCreate() {
		super.onCreate();

        // aplicamos el parche par ala corrección de la generación de números aleatorios
        PRNGFixes.apply();

	}

	@Override
	public void onTerminate() {
		if (D)
			Log.d(TAG, "Matando Servicio Persistente...");

		super.onTerminate();
	}

}
