import javax.swing.*;
import java.io.File;

public class Logica {
    public static void dencrypFile() {
        String key;
        File eleccion = chooseFile();
        File desencriptado = quitarExtension(eleccion);
        //   key = JOptionPane.showInputDialog("put the secret key");
        try {
            CryptoUtils.decrypt(askKey(), eleccion, desencriptado);
        } catch (CryptoException e) {
            throw new RuntimeException(e);
        }
        //  eleccion.delete();

    }

    public static void verCarpeta() {

        // Ruta de la carpeta a mostrar el contenido
        String rutaCarpeta = "/home/gg/EncriptarCArpeta";

        // Crear un objeto File con la ruta de la carpeta
        File carpeta = new File(rutaCarpeta);

        // Verificar si la carpeta existe y es una carpeta
        if (carpeta.exists() && carpeta.isDirectory()) {
            // Obtener la lista de archivos y carpetas dentro de la carpeta
            File[] archivos = carpeta.listFiles();

            // Mostrar la lista de archivos y carpetas
            for (File archivo : archivos) {
                try {
                    File archivo2 = new File(archivo+".todoEncriptado");
                    CryptoUtils.encrypt("LapruebaaskKey()", archivo, archivo2);
                    archivo.delete();
                } catch (CryptoException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(archivo.getName());
            }
        } else {
            System.out.println("La carpeta no existe o no es una carpeta.");
        }
    }

    public static String askKey() {

        String key = JOptionPane.showInputDialog("SET key");
        while (key.length() < 7) {

            key = JOptionPane.showInputDialog("SET key");
        }

        return key;

    }
//LapruebaaskKey()

    public static void encrypFilesAndDelete() {
        File eleccion = chooseFile();
        File encriptado = new File(eleccion + ".teEncrypta");
        //    String s=askKey();
        try {
            CryptoUtils.encrypt("LapruebaaskKey()", eleccion, encriptado);
        } catch (CryptoException e) {
            throw new RuntimeException(e);
        }
        eleccion.delete();

    }

    public static File chooseFile() {
        File archivo2 = null;
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showSaveDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            archivo2 = fileChooser.getSelectedFile();
            System.out.println(archivo2);
        }
        return archivo2;
    }

    public static File quitarExtension(File fichero) {
        // Obtener el nombre del fichero
        String nombreFichero = fichero.getName();
        // Quitar la extensión del nombre del fichero
        int posicionPunto = nombreFichero.lastIndexOf(".");
        if (posicionPunto > 0) {
            nombreFichero = nombreFichero.substring(0, posicionPunto);
        }

        // Mostrar el nombre del fichero sin la extensión
        System.out.println("El nombre del fichero sin la extensión es: " + nombreFichero);

        return new File(nombreFichero);
    }

}
