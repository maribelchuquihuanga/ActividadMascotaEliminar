/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import dao.MascotaDao;
import entidades.Mascota;

/**
 *
 * @author ASUS
 */
public class Ejemplo1 {

    public static void main(String[] args) {

        MascotaDao mascota = new MascotaDao();
        Mascota mimascota = new Mascota(8, "Sandor", "juan", "pitbull");
        mascota.guardaraMascota(mimascota);

    }

}
