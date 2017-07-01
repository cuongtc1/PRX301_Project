/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "Author")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
  @NamedQuery(name = "Author.findById", query = "SELECT a FROM Author a WHERE a.id = :id"),
  @NamedQuery(name = "Author.findByName", query = "SELECT a FROM Author a WHERE a.name = :name")})
public class Author implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "Id")
  private Integer id;
  @Basic(optional = false)
  @Column(name = "Name")
  private String name;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "authorId")
  private List<BookAuthorMapping> bookAuthorMappingList;

  public Author() {
  }

  public Author(Integer id) {
    this.id = id;
  }

  public Author(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @XmlTransient
  public List<BookAuthorMapping> getBookAuthorMappingList() {
    return bookAuthorMappingList;
  }

  public void setBookAuthorMappingList(List<BookAuthorMapping> bookAuthorMappingList) {
    this.bookAuthorMappingList = bookAuthorMappingList;
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
    if (!(object instanceof Author)) {
      return false;
    }
    Author other = (Author) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entities.Author[ id=" + id + " ]";
  }
  
}
