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
@Table(name = "PROJECT_EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectEmployee.findAll", query = "SELECT p FROM ProjectEmployee p")
    , @NamedQuery(name = "ProjectEmployee.findById", query = "SELECT p FROM ProjectEmployee p WHERE p.id = :id")
    , @NamedQuery(name = "ProjectEmployee.findByStartDate", query = "SELECT p FROM ProjectEmployee p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "ProjectEmployee.findByEndDate", query = "SELECT p FROM ProjectEmployee p WHERE p.endDate = :endDate")
    , @NamedQuery(name = "ProjectEmployee.findByJobDescription", query = "SELECT p FROM ProjectEmployee p WHERE p.jobDescription = :jobDescription")
    , @NamedQuery(name = "ProjectEmployee.findByProjectEmployeeStatus", query = "SELECT p FROM ProjectEmployee p WHERE p.projectEmployeeStatus = :projectEmployeeStatus")})
public class ProjectEmployee implements Serializable {

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
    @Size(min = 1, max = 100)
    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "PROJECT_EMPLOYEE_STATUS")
    private String projectEmployeeStatus;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee;
    @JoinColumn(name = "PROJECT", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Project project;

    public ProjectEmployee() {
    }

    public ProjectEmployee(String id) {
        this.id = id;
    }

    public ProjectEmployee(String id, Date startDate, Date endDate, String jobDescription, String projectEmployeeStatus) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobDescription = jobDescription;
        this.projectEmployeeStatus = projectEmployeeStatus;
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

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getProjectEmployeeStatus() {
        return projectEmployeeStatus;
    }

    public void setProjectEmployeeStatus(String projectEmployeeStatus) {
        this.projectEmployeeStatus = projectEmployeeStatus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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
        if (!(object instanceof ProjectEmployee)) {
            return false;
        }
        ProjectEmployee other = (ProjectEmployee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.ProjectEmployee[ id=" + id + " ]";
    }
    
}
