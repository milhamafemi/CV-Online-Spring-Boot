/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author NINDA
 */
@Entity
@Table(name = "CERTIFICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certification.findAll", query = "SELECT c FROM Certification c")
    , @NamedQuery(name = "Certification.findById", query = "SELECT c FROM Certification c WHERE c.id = :id")
    , @NamedQuery(name = "Certification.findByName", query = "SELECT c FROM Certification c WHERE c.name = :name")
    , @NamedQuery(name = "Certification.findByExpiredDate", query = "SELECT c FROM Certification c WHERE c.expiredDate = :expiredDate")
    , @NamedQuery(name = "Certification.findByDescription", query = "SELECT c FROM Certification c WHERE c.description = :description")})
public class Certification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "EXPIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public Certification() {
    }

    public Certification(String id) {
        this.id = id;
    }

    public Certification(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Certification)) {
            return false;
        }
        Certification other = (Certification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.Certification[ id=" + id + " ]";
    }
    
}
