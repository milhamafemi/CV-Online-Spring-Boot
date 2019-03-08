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
@Table(name = "ROLE_MII")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleMii.findAll", query = "SELECT r FROM RoleMii r")
    , @NamedQuery(name = "RoleMii.findById", query = "SELECT r FROM RoleMii r WHERE r.id = :id")
    , @NamedQuery(name = "RoleMii.findByName", query = "SELECT r FROM RoleMii r WHERE r.name = :name")})
public class RoleMii implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role", fetch = FetchType.LAZY)
    private List<UserMii> userMiiList;

    public RoleMii() {
    }

    public RoleMii(String id) {
        this.id = id;
    }

    public RoleMii(String id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public List<UserMii> getUserMiiList() {
        return userMiiList;
    }

    public void setUserMiiList(List<UserMii> userMiiList) {
        this.userMiiList = userMiiList;
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
        if (!(object instanceof RoleMii)) {
            return false;
        }
        RoleMii other = (RoleMii) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.RoleMii[ id=" + id + " ]";
    }
    
}
