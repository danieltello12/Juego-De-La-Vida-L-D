package es.uah.trabajo.juegodelavida.Clases;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ElementoLE;
import es.uah.trabajo.juegodelavida.Clases.EstructurasDatos.ListaLE;
import es.uah.trabajo.juegodelavida.Clases.Json.gson;

import java.util.Objects;

public class ListaUsuarios extends gson {
   public ListaUsuarios() {

   }

   public void añadirusuario(Usuario nuevo) {
      ListaLE l = new ListaLE();
      l=l.cargar();
      l.add(nuevo);
      guardar(l);
   }

   public int esta(String usuario, String cotraseña) {
      ListaLE<Usuario> usuarios = new ListaLE<Usuario>();
      usuarios = usuarios.cargar();
      int encontrado = 0;
      Usuario u = new Usuario(usuario, cotraseña);
      ElementoLE<Usuario> el2 = new ElementoLE(u);
      ElementoLE<Usuario> el = usuarios.getPrimero();
      while (el != null && encontrado == 0) {
         if (Objects.equals((el.getDatos()).nombre, (el2.getDatos()).nombre)) {
            encontrado += 1;
         }
         if (Objects.equals(el.getDatos().contraseña, el2.getDatos().contraseña)) {
            encontrado += 1;

         } else {
            el = ((ElementoLE<Usuario>) el).getSiguiente();
         }

      }
      return encontrado;
   }

   public void guardar(ListaLE lista) {
      String rutaArchivo = "usuarios.json";
      //hola
      guardarObjetoEnArchivo(rutaArchivo, lista);
   }
}

