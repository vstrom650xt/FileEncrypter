import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

import java.io.IOException;

public class CambiarFondoPantalla {
    public interface User32 extends Library {
        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
        boolean SystemParametersInfo (int uiAction, int uiParam, String pvParam, int fWinIni);
    }

    public static void main(String[] args) {
        // Ruta de la imagen a establecer como fondo de pantalla
        String rutaImagen = "C:\\carpeta\\imagen.jpg";

        // Establecer la imagen como fondo de pantalla
        User32.INSTANCE.SystemParametersInfo(0x0014, 0, rutaImagen, 1);
    }

    public  static void linuxFondo(){
        // Ruta de la imagen a establecer como fondo de pantalla
        String rutaImagen = "/home/usuario/imagenes/fondo.jpg";

        // Comando para cambiar el fondo de pantalla en Gnome
        String comando = "gsettings set org.gnome.desktop.background picture-uri file://" + rutaImagen;

        try {
            // Ejecutar el comando en la terminal
            Process proceso = Runtime.getRuntime().exec(comando);

            // Esperar a que termine el proceso
            proceso.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}