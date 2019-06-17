/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import dao.MascotaDao;
import entidades.Mascota;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ASUS
 */
@ManagedBean
@ViewScoped
public class MascotaBean {
    private Mascota mascota;

    public MascotaBean() {
        mascota=new Mascota();
    }
    public String limpiar(){
        mascota= new Mascota();
        return "/RegistroMascota";
    }
    

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    public String guardar(){
        MascotaDao dao = new MascotaDao();
        dao.guardaraMascota(mascota);
        return "/RegistroMascota";
    }
    
    public ArrayList<Mascota> listar(){
        ArrayList<Mascota> milista = new ArrayList<>();
        MascotaDao dao=new MascotaDao();
        milista=dao.listarMascotas();
        return milista;
    }
    public String actualizarMascota(){
         MascotaDao dao = new MascotaDao();
        dao.actualizarMascota(mascota);//mascota es el atributo de tipo objeto  dicha clase
        limpiar();
        return "/RegistroMascota";
    }

    public String eliminarMacota(){
        MascotaDao dao = new MascotaDao();
       dao.eliminarMascota(mascota);
         return "/RegistroMascota";
    }
    }

