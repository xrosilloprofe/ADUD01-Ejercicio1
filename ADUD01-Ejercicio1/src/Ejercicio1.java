import java.io.File;
import java.util.Date;

public class Ejercicio1 {

    public static void main(String[] args) {        
    	
        String ruta="C:\\Users\\xrosi\\Documents";
        if(args.length>=1) ruta=args[0];
        File fich=new File(ruta);        
        if(!fich.exists()) {
            System.out.println("No existe el fichero o directorio ("+ruta+").");
        }
        else {
            if(fich.isFile()) {
                System.out.println(ruta+" es un fichero.");
                System.out.println("Tamaño: " + fich.length());
                extracted(fich);
            }
            else {
                System.out.println(ruta+" es un directorio. Contenidos: ");
                File[] ficheros=fich.listFiles(); // Ojo, ficheros o directorios
                for(File f : ficheros) {
                    String textoDescr=f.isDirectory() ? "/" :
                            f.isFile() ? "_" : "?";
                    System.out.println("("+textoDescr+") "+f.getName());
                    if (f.isFile())
                    	System.out.println("      Tamaño: " + fich.length());
                    extracted(f);
                }
            }
        }
    }

	/**
	 * @param f
	 */
	private static void extracted(File f) {
		String permisos;
		permisos = f.canRead() ? "r" : "-";
		permisos += f.canWrite() ? "w" : "-";
		permisos += f.canExecute() ? "x" : "-";
		System.out.println("      Permisos: " + permisos);
		Date d = new Date(f.lastModified());
		System.out.println("      Fecha última modificación: " + d);
	}
}