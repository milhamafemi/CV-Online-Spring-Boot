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
@Table(name = "WORK_ASSIGNMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkAssignment.findAll", query = "SELECT w FROM WorkAssignment w")
    , @NamedQuery(name = "WorkAssignment.findById", query = "SELECT w FROM WorkAssignment w WHERE w.id = :id")
    , @NamedQuery(name = "WorkAssignment.findByStartDate", query = "SELECT w FROM WorkAssignment w WHERE w.startDate = :startDate")
    , @NamedQuery(name = "WorkAssignment.findByEndDate", query = "SELECT w FROM WorkAssignment w WHERE w.endDate = :endDate")
    , @NamedQuery(name = "WorkAssignment.findByPosition", query = "SELECT w FROM WorkAssignment w WHERE w.position = :position")
    , @NamedQuery(name = "WorkAssignment.findByCompany", query = "SELECT w FROM WorkAssignment w WHERE w.company = :company")
    , @NamedQuery(name = "WorkAssignment.findByJobDescription", query = "SELECT w FROM WorkAssignment w WHERE w.jobDescription = :jobDescription")})
public class WorkAssignment implements Serializable {

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
    @Column(name = "POSITION")
    private String position;
    @Basic(optional = false)
    @Column(name = "COMPANY")
    private String company;
    @Basic(optional = false)
    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;

    public WorkAssignment() {
    }

    public WorkAssignment(String id) {
        this.id = id;
    }

    public WorkAssignment(String id, Date startDate, Date endDate, String position, String company, String jobDescription) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.company = company;
        this.jobDescription = jobDescription;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
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
        if (!(object instanceof WorkAssignment)) {
            return false;
        }
        WorkAssignment other = (WorkAssignment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.WorkAssignment[ id=" + id + " ]";
    }
    
}
