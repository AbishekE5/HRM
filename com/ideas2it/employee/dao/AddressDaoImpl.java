package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Address;
import com.ideas2it.employee.model.Employee;
import com.ideas2it.util.Datasource;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class AddressDaoImpl implements AddressDao {
    @Override
    public void addressId(Address address) {
        try (Session session = Datasource.getInstance().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(address);
            System.out.println("Employee is created  with Id::" + id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Address getAddressbyId(int addressId) {
        try (Session session = Datasource.getInstance().openSession()) {
            Address address = null;
            address = session.get(Address.class, addressId);
            if (address != null) {
                return addressId;
            } else {
                System.out.println("Employee doesn't exist with provided Id..");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
        return null;
    }

    @Override
    public void updateAddressById(Address address) {
        try (Session session = Datasource.getInstance().openSession()) {

            address = session.get(Address.class, address);
            if (address != null) {
                address.getAddressId();
                session.beginTransaction();
                session.update(address);
                session.getTransaction().commit();
            } else {
                System.out.println("Employee doesn't exist with provideded Id..");
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteAddressById(Integer addressId) {
        try (Session session = Datasource.getInstance().openSession()) {
            Address address = null;
            address = session.get(Employee.class, employeeId);
            if (address != null) {
                session.beginTransaction();

                session.delete(address);
                session.getTransaction().commit();
            } else {
                System.out.println("Employee doesn't exist with provideded Id..");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }
}
