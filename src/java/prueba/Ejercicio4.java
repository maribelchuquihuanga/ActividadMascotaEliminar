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

/**
 *
 * @author ASUS
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        List<Mascota> lista = new ArrayList<>();
        MascotaDao mascotadao = new MascotaDao();
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        lista = (ArrayList<Mascota>) mascotadao.listarRazaMascotas(sesion, "Pastor Aleman");
        for (Mascota mascota : lista) {
            System.out.println("Nombre de mascota es:: " + mascota.getNombreMascota() + " RAZA " + mascota.getRaza());

        }

    }
}
