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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id")
    , @NamedQuery(name = "Client.findByAddress", query = "SELECT c FROM Client c WHERE c.address = :address")
    , @NamedQuery(name = "Client.findByBusiness", query = "SELECT c FROM Client c WHERE c.business = :business")
    , @NamedQuery(name = "Client.findByIsDelete", query = "SELECT c FROM Client c WHERE c.isDelete = :isDelete")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "BUSINESS")
    private String business;
    @Basic(optional = false)
    @Column(name = "IS_DELETE")
    private String isDelete;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY)
    private List<Project> projectList;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private UserMii userMii;

    public Client() {
    }

    public Client(String id) {
        this.id = id;
    }

    public Client(String id, String address, String business, String isDelete) {
        this.id = id;
        this.address = address;
        this.business = business;
        this.isDelete = isDelete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @XmlTransient
    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public UserMii getUserMii() {
        return userMii;
    }

    public void setUserMii(UserMii userMii) {
        this.userMii = userMii;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.Client[ id=" + id + " ]";
    }
    
}
