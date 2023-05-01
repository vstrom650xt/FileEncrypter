package controler;

import javax.swing.*;
import java.io.File;

public class Logic {
    public  static  void dencrypFile(){
        String key;
        File eleccion = chooseFile();
        File desencriptado = quitarExtension(eleccion);
        //   key = JOptionPane.showInputDialog("put the secret key");
        try {
            CryptoUtils.decrypt("lapruebaaaaaaaaa",eleccion,desencriptado);
        } catch (CryptoException e) {
            throw new RuntimeException(e);
        }
        //  eleccion.delete();

    }



    public  static  void encrypFilesAndDelete(){
        File eleccion = chooseFile();
        File encriptado = new File(eleccion +".teEncrypta");
        try {
            CryptoUtils.encrypt("lapruebaaaaaaaaa",eleccion,encriptado);
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

    public static File quitarExtension(File fichero){
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
