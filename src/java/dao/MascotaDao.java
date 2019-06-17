/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utilitarios.HibernateUtil;
import entidades.Mascota;
import interfases.IMascota;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ASUS
 */
public class MascotaDao implements IMascota {

    @Override
    public void guardaraMascota(Mascota mascota) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();

        sesion.save(mascota);
        transaccion.commit();

        sesion.close();
    }

    @Override
    public ArrayList<Mascota> listarMascotas() {
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        ArrayList<Mascota> milista = new ArrayList<>();
        Query query = sesion.createQuery("FROM Mascota");

        milista = (ArrayList<Mascota>) query.list();
        return milista;

    }

    public List<Mascota> listarRazaMascotas(Session session, String raza) throws Exception {
        String mascota = " from Mascota where raza='" + raza + "'";
        Query query = session.createQuery(mascota);
        List<Mascota> lista = (List<Mascota>) query.list();
        return lista;
    }

    @Override
    public List<Mascota> listarNombreMascota(Session session, String nombreMascota) {
        String mascota = "from Mascota where nombreMascota='" + nombreMascota + "'";
        Query query = session.createQuery(mascota);
        List< Mascota> lista = (List< Mascota>) query.list();
        return lista;
    }

    @Override
    public Integer contarMascotas(Session sesion) throws Exception {
        String hql = "select count(*) from Mascota";
        Query query = sesion.createQuery(hql);
        Long FilasTab = (Long) query.uniqueResult();
        Integer cont = FilasTab.intValue();
        return cont;

    }

    @Override
    public void actualizarMascota(Mascota mascota) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        sesion.update(mascota);
        transaccion.commit();
        sesion.close();

    }

    @Override
    public boolean eliminarMascota(Mascota mascota) {

        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = sesion.beginTransaction();
        try {
            sesion.delete(mascota);
            transaccion.commit();
        } catch (Exception e) {
            sesion.close();
        }
        return false;
    }
}
