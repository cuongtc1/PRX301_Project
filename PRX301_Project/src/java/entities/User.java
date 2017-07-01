/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "User")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
  @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
  @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
  @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
  @NamedQuery(name = "User.findByDateOfBirth", query = "SELECT u FROM User u WHERE u.dateOfBirth = :dateOfBirth"),
  @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
  @NamedQuery(name = "User.findByGender", query = "SELECT u FROM User u WHERE u.gender = :gender"),
  @NamedQuery(name = "User.findByRoleType", query = "SELECT u FROM User u WHERE u.roleType = :roleType"),
  @NamedQuery(name = "User.findByAddress", query = "SELECT u FROM User u WHERE u.address = :address"),
  @NamedQuery(name = "User.findByImageUrl", query = "SELECT u FROM User u WHERE u.imageUrl = :imageUrl")})
public class User implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;
  @Basic(optional = false)
  @Column(name = "Username")
  private String username;
  @Basic(optional = false)
  @Column(name = "Password")
  private String password;
  @Column(name = "DateOfBirth")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateOfBirth;
  @Column(name = "Email")
  private String email;
  @Column(name = "Gender")
  private Boolean gender;
  @Basic(optional = false)
  @Column(name = "RoleType")
  private int roleType;
  @Column(name = "Address")
  private String address;
  @Column(name = "ImageUrl")
  private String imageUrl;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
  private List<Comment> commentList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
  private List<Bookmark> bookmarkList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
  private List<Rating> ratingList;

  public User() {
  }

  public User(Integer id) {
    this.id = id;
  }

  public User(Integer id, String username, String password, int roleType) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.roleType = roleType;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Boolean getGender() {
    return gender;
  }

  public void setGender(Boolean gender) {
    this.gender = gender;
  }

  public int getRoleType() {
    return roleType;
  }

  public void setRoleType(int roleType) {
    this.roleType = roleType;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @XmlTransient
  public List<Comment> getCommentList() {
    return commentList;
  }

  public void setCommentList(List<Comment> commentList) {
    this.commentList = commentList;
  }

  @XmlTransient
  public List<Bookmark> getBookmarkList() {
    return bookmarkList;
  }

  public void setBookmarkList(List<Bookmark> bookmarkList) {
    this.bookmarkList = bookmarkList;
  }

  @XmlTransient
  public List<Rating> getRatingList() {
    return ratingList;
  }

  public void setRatingList(List<Rating> ratingList) {
    this.ratingList = ratingList;
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
    if (!(object instanceof User)) {
      return false;
    }
    User other = (User) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entities.User[ id=" + id + " ]";
  }
  
}
