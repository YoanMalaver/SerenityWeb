package starter.Utils;

import java.io.File;

public class PathDownloadsFiles {

    public static String getProjectDirectory() {
        return System.getProperty("user.dir");
    }

    //Se agrega ruta obteniendo el user del dispositivo para que sea funcional
    public static String getDownloadDirectory() {
        return getProjectDirectory() + File.separator + "src\\main\\java\\starter\\Utils";
    }

    // Obtiene el directorio de descargas del usuario
    public static String getDefaultDownloadDirectory() {
        return System.getProperty("user.home") + File.separator + "Downloads\\";
    }

    public static void main(String[] args) {
        System.out.println("Directorio del proyecto: " + getProjectDirectory());
        System.out.println("Directorio de descargas: " + getDefaultDownloadDirectory());
    }
}

