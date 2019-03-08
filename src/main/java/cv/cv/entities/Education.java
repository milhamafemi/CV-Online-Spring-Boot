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
@Table(name = "EDUCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e")
    , @NamedQuery(name = "Education.findById", query = "SELECT e FROM Education e WHERE e.id = :id")
    , @NamedQuery(name = "Education.findByStartDate", query = "SELECT e FROM Education e WHERE e.startDate = :startDate")
    , @NamedQuery(name = "Education.findByEndDate", query = "SELECT e FROM Education e WHERE e.endDate = :endDate")
    , @NamedQuery(name = "Education.findByIp", query = "SELECT e FROM Education e WHERE e.ip = :ip")})
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "IP")
    private String ip;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    @JoinColumn(name = "MAJOR_UNIVERSITY", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MajorUniversity majorUniversity;

    public Education() {
    }

    public Education(String id) {
        this.id = id;
    }

    public Education(String id, Date startDate, Date endDate, String ip) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ip = ip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public MajorUniversity getMajorUniversity() {
        return majorUniversity;
    }

    public void setMajorUniversity(MajorUniversity majorUniversity) {
        this.majorUniversity = majorUniversity;
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
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.Education[ id=" + id + " ]";
    }
    
}
