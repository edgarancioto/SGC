/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacoped.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Edgar
 */
@Entity
@Table(name = "areas")
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a")})
public class Areas implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areasId")
    private Set<Cursos> cursosSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areasId")
    private Set<Instrutores> instrutoresSet;

    public Areas() {
    }

    public Areas(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Set<Cursos> getCursosSet() {
        return cursosSet;
    }

    public void setCursosSet(Set<Cursos> cursosSet) {
        this.cursosSet = cursosSet;
    }

    public Set<Instrutores> getInstrutoresSet() {
        return instrutoresSet;
    }

    public void setInstrutoresSet(Set<Instrutores> instrutoresSet) {
        this.instrutoresSet = instrutoresSet;
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
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendacoped.bean.Areas[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
