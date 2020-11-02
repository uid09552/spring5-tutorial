package de.mh.demo.domain;

import javax.persistence.*;

@Entity
public class Email {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "employee_id")
        private Employee employee;

        private String Email;

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", employee=" + employee +
                ", Email='" + Email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (id != null ? !id.equals(email.id) : email.id != null) return false;
        if (employee != null ? !employee.equals(email.employee) : email.employee != null) return false;
        return Email != null ? Email.equals(email.Email) : email.Email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        result = 31 * result + (Email != null ? Email.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
