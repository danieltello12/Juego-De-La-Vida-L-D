package es.uah.trabajo.juegodelavida.Clases.Json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLE;
import es.uah.trabajo.juegodelavida.Clases.Usuario;


public abstract class gson {
    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto) {
     Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método para cargar un objeto desde un archivo JSON
    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
