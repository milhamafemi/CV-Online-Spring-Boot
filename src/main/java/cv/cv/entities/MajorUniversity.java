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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MAJOR_UNIVERSITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MajorUniversity.findAll", query = "SELECT m FROM MajorUniversity m")
    , @NamedQuery(name = "MajorUniversity.findById", query = "SELECT m FROM MajorUniversity m WHERE m.id = :id")
    , @NamedQuery(name = "MajorUniversity.findByDegree", query = "SELECT m FROM MajorUniversity m WHERE m.degree = :degree")
    , @NamedQuery(name = "MajorUniversity.findByDegreeLevel", query = "SELECT m FROM MajorUniversity m WHERE m.degreeLevel = :degreeLevel")})
public class MajorUniversity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "DEGREE")
    private String degree;
    @Basic(optional = false)
    @Column(name = "DEGREE_LEVEL")
    private String degreeLevel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "majorUniversity", fetch = FetchType.LAZY)
    private List<Education> educationList;
    @JoinColumn(name = "MAJOR", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Major major;
    @JoinColumn(name = "UNIVERSITY", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private University university;

    public MajorUniversity() {
    }

    public MajorUniversity(String id) {
        this.id = id;
    }

    public MajorUniversity(String id, String degree, String degreeLevel) {
        this.id = id;
        this.degree = degree;
        this.degreeLevel = degreeLevel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    public void setDegreeLevel(String degreeLevel) {
        this.degreeLevel = degreeLevel;
    }

    @XmlTransient
    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
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
        if (!(object instanceof MajorUniversity)) {
            return false;
        }
        MajorUniversity other = (MajorUniversity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.MajorUniversity[ id=" + id + " ]";
    }
    
}
