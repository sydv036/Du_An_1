/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import domainmodel.Ca;
import repository.ICaRepository;
import utill.HibernateConfig;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class CaRepository implements ICaRepository {

    @Override
    public List<Ca> getAll() {
        String hql = "From Ca";
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            Query q = session.createQuery(hql);
            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean saveOrUpdate(Ca ca) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(ca);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }

    @Override
    public boolean deleteCa(Ca ca) {
        boolean check;
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(ca);
            check = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            check = false;
            transaction.rollback();
        }
        return check;
    }

    public static void main(String[] args) {
        System.out.println(new CaRepository().getAll());
    }

    @Override
    public List<Ca> searchByName(String ten) {
        List<Ca> listNuocUong = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            String hql = "From Ca Where tenCa like :ten ";
            TypedQuery<Ca> query = session.createQuery(hql, Ca.class);
            query.setParameter("ten", "%" + ten + "%");
            listNuocUong = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listNuocUong;
    }

    @Override
    public String saveCaNew(Ca ca) {
        Transaction transaction = null;
        try ( Session session = new HibernateConfig().getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(ca);
            transaction.commit();
            return "Thêm thành công";
        } catch (Exception e) {
            e.printStackTrace(System.out);
            transaction.rollback();
            return "Thêm thất bại";
        }
    }
}
