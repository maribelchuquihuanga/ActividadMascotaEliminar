/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;
import Utilitarios.HibernateUtil;
import dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
public class ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           Session sesion = HibernateUtil.getSessionFactory().openSession();
        MascotaDao mascotadao = new MascotaDao();
        List<Mascota> lista = mascotadao.listarNombreMascota(sesion, "Sandor");
        for (Mascota mascota : lista) {
            System.out.println(mascota.getNombreCliente() + " su mascota es: " + mascota.getNombreMascota());
        }

    }
    
}
