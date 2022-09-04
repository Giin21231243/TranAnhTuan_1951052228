/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tat.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.criteria.Fetch;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author dts
 */
@Entity
@Table(name = "recruitment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recruitment.findAll", query = "SELECT r FROM Recruitment r"),
    @NamedQuery(name = "Recruitment.findById", query = "SELECT r FROM Recruitment r WHERE r.id = :id"),
    @NamedQuery(name = "Recruitment.findByTitle", query = "SELECT r FROM Recruitment r WHERE r.title = :title"),
    @NamedQuery(name = "Recruitment.findByContent", query = "SELECT r FROM Recruitment r WHERE r.content = :content"),
    @NamedQuery(name = "Recruitment.findByPrice", query = "SELECT r FROM Recruitment r WHERE r.price = :price"),
    @NamedQuery(name = "Recruitment.findByCompany", query = "SELECT r FROM Recruitment r WHERE r.company = :company"),
    @NamedQuery(name = "Recruitment.findByImage", query = "SELECT r FROM Recruitment r WHERE r.image = :image"),
    @NamedQuery(name = "Recruitment.findByEducation", query = "SELECT r FROM Recruitment r WHERE r.education = :education"),
    @NamedQuery(name = "Recruitment.findByCreatedDate", query = "SELECT r FROM Recruitment r WHERE r.createdDate = :createdDate")})
public class Recruitment implements Serializable {


    @OneToMany(mappedBy = "recruitmentCommentId")
    @JsonIgnore
    private Set<Comment> commentSet;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 65535)
    @Column(name = "content")
    private String content;
    @Column(name = "image")
    private String image;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "company")
    private String company;
    @Column(name = "education")
    private String education;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_recruitment_id", referencedColumnName = "id")
    @NotNull(message = "{recruitment.category.nullErr}")
    private Category categoryRecruitmentId;
    @JoinColumn(name = "user_recruitment_id", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User userRecruitmentId;
    @Transient
    private MultipartFile file;

    public Recruitment() {
    }

    public Recruitment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getCategoryRecruitmentId() {
        return categoryRecruitmentId;
    }

    public void setCategoryRecruitmentId(Category categoryRecruitmentId) {
        this.categoryRecruitmentId = categoryRecruitmentId;
    }

    public User getUserRecruitmentId() {
        return userRecruitmentId;
    }

    public void setUserRecruitmentId(User userRecruitmentId) {
        this.userRecruitmentId = userRecruitmentId;
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
        if (!(object instanceof Recruitment)) {
            return false;
        }
        Recruitment other = (Recruitment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tat.pojo.Recruitment[ id=" + id + " ]";
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the education
     */
    public String getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(String education) {
        this.education = education;
    }

    

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
    
}
