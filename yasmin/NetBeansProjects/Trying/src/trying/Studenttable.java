/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trying;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author yasmin
 */
@Entity
@Table(name = "STUDENTTABLE", catalog = "", schema = "APP")
@NamedQueries({
    @NamedQuery(name = "Studenttable.findAll", query = "SELECT s FROM Studenttable s")
    , @NamedQuery(name = "Studenttable.findById", query = "SELECT s FROM Studenttable s WHERE s.id = :id")
    , @NamedQuery(name = "Studenttable.findByFname", query = "SELECT s FROM Studenttable s WHERE s.fname = :fname")
    , @NamedQuery(name = "Studenttable.findByLname", query = "SELECT s FROM Studenttable s WHERE s.lname = :lname")
    , @NamedQuery(name = "Studenttable.findByEmail", query = "SELECT s FROM Studenttable s WHERE s.email = :email")
    , @NamedQuery(name = "Studenttable.findByPhone", query = "SELECT s FROM Studenttable s WHERE s.phone = :phone")})
public class Studenttable implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FNAME")
    private String fname;
    @Column(name = "LNAME")
    private String lname;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private Integer phone;

    public Studenttable() {
    }

    public Studenttable(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        String oldFname = this.fname;
        this.fname = fname;
        changeSupport.firePropertyChange("fname", oldFname, fname);
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        String oldLname = this.lname;
        this.lname = lname;
        changeSupport.firePropertyChange("lname", oldLname, lname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        Integer oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studenttable)) {
            return false;
        }
        Studenttable other = (Studenttable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "trying.Studenttable[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
