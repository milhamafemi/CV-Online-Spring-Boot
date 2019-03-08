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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByReligion", query = "SELECT e FROM Employee e WHERE e.religion = :religion")
    , @NamedQuery(name = "Employee.findByPhone", query = "SELECT e FROM Employee e WHERE e.phone = :phone")
    , @NamedQuery(name = "Employee.findByMaritalStatus", query = "SELECT e FROM Employee e WHERE e.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "Employee.findByNationality", query = "SELECT e FROM Employee e WHERE e.nationality = :nationality")
    , @NamedQuery(name = "Employee.findByBirthDate", query = "SELECT e FROM Employee e WHERE e.birthDate = :birthDate")
    , @NamedQuery(name = "Employee.findByStartDate", query = "SELECT e FROM Employee e WHERE e.startDate = :startDate")
    , @NamedQuery(name = "Employee.findByEndDate", query = "SELECT e FROM Employee e WHERE e.endDate = :endDate")
    , @NamedQuery(name = "Employee.findByIsDelete", query = "SELECT e FROM Employee e WHERE e.isDelete = :isDelete")
    , @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Size(max = 10)
    @Column(name = "RELIGION")
    private String religion;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    @Basic(optional = false)
    @Column(name = "NATIONALITY")
    private String nationality;
    @Basic(optional = false)
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "IS_DELETE")
    private String isDelete;
    @Lob
    @Column(name = "PHOTO")
    private Byte[] photo;
    @Size(max = 10)
    @Column(name = "GENDER")
    private String gender;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<LanguageEmployee> languageEmployeeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<WorkAssignment> workAssignmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<ProjectEmployee> projectEmployeeList;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private UserMii userMii;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Certification> certificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Education> educationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Training> trainingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Organization> organizationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Achievement> achievementList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<QualificationEmployee> qualificationEmployeeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Experience> experienceList;

    public Employee() {
    }

    public Employee(String id) {
        this.id = id;
    }

    public Employee(String id, String phone, String maritalStatus, String nationality, Date birthDate, Date startDate, String isDelete) {
        this.id = id;
        this.phone = phone;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.startDate = startDate;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(Byte[] photo) {
        this.photo = photo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @XmlTransient
    public List<LanguageEmployee> getLanguageEmployeeList() {
        return languageEmployeeList;
    }

    public void setLanguageEmployeeList(List<LanguageEmployee> languageEmployeeList) {
        this.languageEmployeeList = languageEmployeeList;
    }

    @XmlTransient
    public List<WorkAssignment> getWorkAssignmentList() {
        return workAssignmentList;
    }

    public void setWorkAssignmentList(List<WorkAssignment> workAssignmentList) {
        this.workAssignmentList = workAssignmentList;
    }

    @XmlTransient
    public List<ProjectEmployee> getProjectEmployeeList() {
        return projectEmployeeList;
    }

    public void setProjectEmployeeList(List<ProjectEmployee> projectEmployeeList) {
        this.projectEmployeeList = projectEmployeeList;
    }

    public UserMii getUserMii() {
        return userMii;
    }

    public void setUserMii(UserMii userMii) {
        this.userMii = userMii;
    }

    @XmlTransient
    public List<Certification> getCertificationList() {
        return certificationList;
    }

    public void setCertificationList(List<Certification> certificationList) {
        this.certificationList = certificationList;
    }

    @XmlTransient
    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    @XmlTransient
    public List<Training> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(List<Training> trainingList) {
        this.trainingList = trainingList;
    }

    @XmlTransient
    public List<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<Organization> organizationList) {
        this.organizationList = organizationList;
    }

    @XmlTransient
    public List<Achievement> getAchievementList() {
        return achievementList;
    }

    public void setAchievementList(List<Achievement> achievementList) {
        this.achievementList = achievementList;
    }

    @XmlTransient
    public List<QualificationEmployee> getQualificationEmployeeList() {
        return qualificationEmployeeList;
    }

    public void setQualificationEmployeeList(List<QualificationEmployee> qualificationEmployeeList) {
        this.qualificationEmployeeList = qualificationEmployeeList;
    }

    @XmlTransient
    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.Employee[ id=" + id + " ]";
    }
    
}