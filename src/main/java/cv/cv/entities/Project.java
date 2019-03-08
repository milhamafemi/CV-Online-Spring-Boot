/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author NINDA
 */
@Entity
@Table(name = "PROJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p")
    , @NamedQuery(name = "Project.findById", query = "SELECT p FROM Project p WHERE p.id = :id")
    , @NamedQuery(name = "Project.findByName", query = "SELECT p FROM Project p WHERE p.name = :name")
    , @NamedQuery(name = "Project.findByStartDate", query = "SELECT p FROM Project p WHERE p.startDate = :startDate")
    , @NamedQuery(name = "Project.findByEndDate", query = "SELECT p FROM Project p WHERE p.endDate = :endDate")
    , @NamedQuery(name = "Project.findByAssessment", query = "SELECT p FROM Project p WHERE p.assessment = :assessment")
    , @NamedQuery(name = "Project.findByProjectSpecification", query = "SELECT p FROM Project p WHERE p.projectSpecification = :projectSpecification")
    , @NamedQuery(name = "Project.findByProjectStatus", query = "SELECT p FROM Project p WHERE p.projectStatus = :projectStatus")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Size(max = 100)
    @Column(name = "ASSESSMENT")
    private String assessment;
    @Basic(optional = false)
    @Column(name = "PROJECT_SPECIFICATION")
    private String projectSpecification;
    @Basic(optional = false)
    @Column(name = "PROJECT_STATUS")
    private String projectStatus;
    @JoinColumn(name = "CLIENT", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Client client;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project", fetch = FetchType.LAZY)
    private List<ProjectEmployee> projectEmployeeList;

    public Project() {
    }

    public Project(String id) {
        this.id = id;
    }

    public Project(String id, String name, Date startDate, Date endDate, String projectSpecification, String projectStatus) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectSpecification = projectSpecification;
        this.projectStatus = projectStatus;
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

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getProjectSpecification() {
        return projectSpecification;
    }

    public void setProjectSpecification(String projectSpecification) {
        this.projectSpecification = projectSpecification;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @XmlTransient
    public List<ProjectEmployee> getProjectEmployeeList() {
        return projectEmployeeList;
    }

    public void setProjectEmployeeList(List<ProjectEmployee> projectEmployeeList) {
        this.projectEmployeeList = projectEmployeeList;
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.Project[ id=" + id + " ]";
    }
    
}
