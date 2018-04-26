package edu.cardia.carlillos.bluetoothsample.utils;

/**
 * Created by sgcweb on 4/09/14.
 */
public class FormatUtils {

    // Debug
    private static final String TAG = "UtilsRi505";

    /**
     * Convierte una cadena a su representación en un arreglo de bytes
     *
     * @param str
     *            Cadena que sera convertida en byte[]
     * @return La cadena convertida en byte[]
     */
    public static byte[] stringToByte(String str) {
        try {
            byte[] byteArray = new byte[str.length()];

            for (int i = 0; i < str.length(); i++) {
                byteArray[i] = (byte) str.charAt(i);
            }
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Método utilizado para sumar dos arreglos de bytes
     *
     * @param a1
     *            arreglo de bytes
     * @param a2
     *            arreglo de bytes
     * @return suma de los arreglos de bytes
     */
    public static byte[] appendByteArray(byte[] a1, byte[] a2) {
        byte[] result = new byte[a1.length + a2.length];
        System.arraycopy(a1, 0, result, 0, a1.length);
        System.arraycopy(a2, 0, result, a1.length, a2.length);
        return result;
    }

}
