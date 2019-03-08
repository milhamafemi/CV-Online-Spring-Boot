/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NINDA
 */
@Entity
@Table(name = "QUALIFICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Qualification.findAll", query = "SELECT q FROM Qualification q")
    , @NamedQuery(name = "Qualification.findById", query = "SELECT q FROM Qualification q WHERE q.id = :id")
    , @NamedQuery(name = "Qualification.findByName", query = "SELECT q FROM Qualification q WHERE q.name = :name")
    , @NamedQuery(name = "Qualification.findBySpecialization", query = "SELECT q FROM Qualification q WHERE q.specialization = :specialization")})
public class Qualification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "SPECIALIZATION")
    private String specialization;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualification", fetch = FetchType.LAZY)
    private List<QualificationEmployee> qualificationEmployeeList;

    public Qualification() {
    }

    public Qualification(String id) {
        this.id = id;
    }

    public Qualification(String id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @XmlTransient
    public List<QualificationEmployee> getQualificationEmployeeList() {
        return qualificationEmployeeList;
    }

    public void setQualificationEmployeeList(List<QualificationEmployee> qualificationEmployeeList) {
        this.qualificationEmployeeList = qualificationEmployeeList;
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
        if (!(object instanceof Qualification)) {
            return false;
        }
        Qualification other = (Qualification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.Qualification[ id=" + id + " ]";
    }
    
}
