/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.self.memoapp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "PUSH_SEND")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PushSend.findAll", query = "SELECT p FROM PushSend p"),
    @NamedQuery(name = "PushSend.findById", query = "SELECT p FROM PushSend p WHERE p.id = :id"),
    @NamedQuery(name = "PushSend.findByEmployeeId", query = "SELECT p FROM PushSend p WHERE p.employeeId = :employeeId"),
    @NamedQuery(name = "PushSend.findByMessage", query = "SELECT p FROM PushSend p WHERE p.message = :message")})
public class PushSend implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "EMPLOYEE_ID")
    private String employeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "MESSAGE")
    private String message;

    public PushSend() {
    }

    public PushSend(Integer id) {
        this.id = id;
    }

    public PushSend(Integer id, String employeeId, String message) {
        this.id = id;
        this.employeeId = employeeId;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
        if (!(object instanceof PushSend)) {
            return false;
        }
        PushSend other = (PushSend) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.self.memoapp.entity.PushSend[ id=" + id + " ]";
    }
    
}
