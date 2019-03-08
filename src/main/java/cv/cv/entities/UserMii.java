/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.entities;

import java.io.Serializable;
import java.util.Calendar;
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
 * @author kresna92
 */
@Entity
@Table(name = "USER_MII")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserMii.findAll", query = "SELECT u FROM UserMii u")
    , @NamedQuery(name = "UserMii.findById", query = "SELECT u FROM UserMii u WHERE u.id = :id")
    , @NamedQuery(name = "UserMii.findByPassword", query = "SELECT u FROM UserMii u WHERE u.password = :password")
    , @NamedQuery(name = "UserMii.findByName", query = "SELECT u FROM UserMii u WHERE u.name = :name")
    , @NamedQuery(name = "UserMii.findByEmail", query = "SELECT u FROM UserMii u WHERE u.email = :email")
    , @NamedQuery(name = "UserMii.findByToken", query = "SELECT u FROM UserMii u WHERE u.token = :token")
    , @NamedQuery(name = "UserMii.findByExpiryDate", query = "SELECT u FROM UserMii u WHERE u.expiryDate = :expiryDate")})
public class UserMii implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TOKEN")
    private String token;
    @Column(name = "EXPIRY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;
    @JoinColumn(name = "ROLE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RoleMii role;

    public UserMii() {
    }

    public UserMii(String id) {
        this.id = id;
    }

    public UserMii(String id, String password, String name, String email) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public UserMii(String id, String password, String name, String email, RoleMii role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public UserMii(String id, String password, String name, String email, String token, Date expiryDate, RoleMii role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.token = token;
        this.expiryDate = expiryDate;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setExpiryDate(int minutes) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiryDate = now.getTime();
    }

    public RoleMii getRole() {
        return role;
    }

    public void setRole(RoleMii role) {
        this.role = role;
    }

    public boolean isExpired() {
        return new Date().after(this.expiryDate);
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
        if (!(object instanceof UserMii)) {
            return false;
        }
        UserMii other = (UserMii) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cv.cv.entities.UserMii[ id=" + id + " ]";
    }

}
