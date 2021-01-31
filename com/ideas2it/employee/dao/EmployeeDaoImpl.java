package com.ideas2it.employee.dao;

import com.ideas2it.employee.model.Employee;
import com.ideas2it.util.Datasource;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void addEmployeebyId(Employee employee) {

        try (Session session = Datasource.getInstance().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(employee);
            System.out.println("Employee is created  with Id::" + id);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Employee getEmployeebyId(int employeeId) {
        try (Session session = Datasource.getInstance().openSession()) {
            Employee employee = null;
            employee = session.get(Employee.class, employeeId);
            if (employee != null) {
                return employee;
            } else {
                System.out.println("Employee doesn't exist with providded Id..");
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEmployeeById(Employee employee) {
        try (Session session = Datasource.getInstance().openSession()) {

            employee = session.get(Employee.class, employee);
            if (employee != null) {
                employee.getEmployeeid();
                session.beginTransaction();
                session.update(employee);
                session.getTransaction().commit();
            } else {
                System.out.println("Employee doesn't exist with provideded Id..");
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }


        @Override
        public void deleteEmployeeById (Integer employeeId){

            try (Session session = Datasource.getInstance().openSession()) {
                employee = session.get(Employee.class, employeeId);
                if (employee != null) {
                    session.beginTransaction();

                    session.delete(employee);
                    session.getTransaction().commit();
                } else {
                    System.out.println("Employee doesn't exist with provideded Id..");
                }
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
    }
}