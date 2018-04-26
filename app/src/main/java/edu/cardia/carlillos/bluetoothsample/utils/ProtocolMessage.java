package edu.cardia.carlillos.bluetoothsample.utils;

import android.util.Log;

import edu.cardia.carlillos.bluetoothsample.ApplicationManager;

/**
 * Created by rcarventepc on 4/09/14.
 */
public class ProtocolMessage {

    // Debug
    private static final String TAG = "ProtocolMessage";

    // Contiene los datos de la trama.
    private byte[] tramaByte;
    // Bloque de datos de la trama.
    private String data;

    // variables del protocolo
    public static final char SOF = (char) 185;
    public static final char EOF = (char) 185;

    public byte[] getTramaByte() {
        return tramaByte;
    }

    public String getData() {
        return data;
    }

    /**
     * Formato de la trama para enviar al dispositivo indicado.
     * @param data
     */
    public ProtocolMessage(String data) {
        this.data = data;
        // construimos el mensaje a partir de los datos
        this.tramaByte = buildMessageTransmissionProtocol();
    }

    /**
     * Reconstruye la información de la trama.
     * @param tramaByte
     */
    public ProtocolMessage(byte[] tramaByte) {
        this.tramaByte = tramaByte;
        // procesamos el mensaje recibido
        getMessageTransmissionProtocol();
    }

    /**
     * Método encargado de construir la trama para comunicación con el
     * dispositivo
     *
     * @return
     */
    public byte[] buildMessageTransmissionProtocol() {
        if (ApplicationManager.D) {
            Log.d(TAG, "-> buildMessageTransmissionProtocol()");
        }
        String strDatos;
        byte[] trama = null;

        // Datos
        if (ApplicationManager.D) {
            Log.d(TAG, "data = " + data);
        }

        trama = FormatUtils.stringToByte(Character.toString(SOF));
        trama = FormatUtils.appendByteArray(trama,
                FormatUtils.stringToByte(data));
        trama = FormatUtils.appendByteArray(trama,
                FormatUtils.stringToByte(Character.toString(EOF)));

        if (ApplicationManager.D) {
            Log.d(TAG, "Mensaje = " + new String(trama));
        }
        return trama;
    }


    /**
     * Separa por bloques la trama recibida.
     *
     */
    public void getMessageTransmissionProtocol() {
        if (ApplicationManager.D) {
            Log.d(TAG, "-> getMessageTransmissionProtocol()");
        }
        String respuesta = new String(tramaByte);
        if (ApplicationManager.D) {
            Log.d(TAG, "respuesta = " + respuesta);
        }

    }

}
