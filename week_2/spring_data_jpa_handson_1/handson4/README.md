# Hands on 4
# Difference between JPA, Hibernate and Spring Data JPA

## Objective
To understand the difference between JPA, Hibernate and Spring Data JPA and compare how database operations are performed.

---

## Java Persistence API (JPA)

- JPA (Java Persistence API) is a specification for persisting, reading and managing data from Java objects.
- It defines standard interfaces for Object Relational Mapping (ORM).
- JPA itself does not contain any implementation.
- Hibernate is one of the most popular implementations of JPA.

---

## Hibernate

- Hibernate is an ORM framework that implements the JPA specification.
- It maps Java objects to database tables.
- It manages database operations like insert, update, delete and fetch.
- Hibernate uses SessionFactory, Session and Transaction to communicate with the database.

---

## Spring Data JPA

- Spring Data JPA is built on top of JPA.
- It does not implement JPA itself.
- It reduces boilerplate code by providing ready-made repository interfaces.
- It automatically manages transactions and database operations.
- It simplifies CRUD operations using JpaRepository.

---

# Difference between JPA, Hibernate and Spring Data JPA

| JPA | Hibernate | Spring Data JPA |
|-----|-----------|-----------------|
| Specification | ORM Framework | Spring Module |
| Defines standard APIs | Implements JPA | Uses JPA/Hibernate |
| No implementation | Concrete implementation | Higher abstraction over JPA |
| Requires implementation provider | Uses Session API | Uses Repository API |
| More coding required | Less coding | Minimum boilerplate code |

---

# Hibernate Example

```java
/* Method to CREATE an employee in the database */

public Integer addEmployee(Employee employee) {

    Session session = factory.openSession();
    Transaction tx = null;
    Integer employeeID = null;

    try {

        tx = session.beginTransaction();

        employeeID = (Integer) session.save(employee);

        tx.commit();

    } catch (HibernateException e) {

        if (tx != null)
            tx.rollback();

        e.printStackTrace();

    } finally {

        session.close();

    }

    return employeeID;
}
```

---

# Spring Data JPA Example

### EmployeeRepository.java

```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
```

### EmployeeService.java

```java
@Autowired
private EmployeeRepository employeeRepository;

@Transactional
public void addEmployee(Employee employee) {

    employeeRepository.save(employee);

}
```

---

# Comparison

### Hibernate

- Uses SessionFactory to create Session.
- Requires manual transaction management.
- Requires explicit commit() and rollback().
- More code is required.

### Spring Data JPA

- Uses JpaRepository.
- Transaction management is handled by Spring using @Transactional.
- CRUD methods are already available.
- Requires very little code.

---

# Conclusion

JPA is a specification that defines how Java objects are mapped to relational databases. Hibernate is an implementation of JPA that provides ORM functionality using Session and Transaction APIs. Spring Data JPA is built on top of JPA and Hibernate and simplifies database access by reducing boilerplate code through JpaRepository and automatic transaction management.