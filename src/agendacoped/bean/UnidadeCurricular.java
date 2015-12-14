/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacoped.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "unidade_curricular")
@NamedQueries({
    @NamedQuery(name = "UnidadeCurricular.findAll", query = "SELECT u FROM UnidadeCurricular u")})
public class UnidadeCurricular implements Serializable {
    @Column(name = "PERIODO")
    private Integer periodo;
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
    @Column(name = "CARGA_H")
    private Integer cargaH;
    @Column(name = "STATUS")
    private Boolean status;
    @JoinColumn(name = "CURSOS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cursos cursosId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadeCurricularId")
    private Collection<AgendaAula> agendaAulaCollection;

    public UnidadeCurricular() {
    }

    public UnidadeCurricular(Integer id) {
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

    public Integer getCargaH() {
        return cargaH;
    }

    public void setCargaH(Integer cargaH) {
        Integer oldCargaH = this.cargaH;
        this.cargaH = cargaH;
        changeSupport.firePropertyChange("cargaH", oldCargaH, cargaH);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        Boolean oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Cursos getCursosId() {
        return cursosId;
    }

    public void setCursosId(Cursos cursosId) {
        Cursos oldCursosId = this.cursosId;
        this.cursosId = cursosId;
        changeSupport.firePropertyChange("cursosId", oldCursosId, cursosId);
    }

    public Collection<AgendaAula> getAgendaAulaCollection() {
        return agendaAulaCollection;
    }

    public void setAgendaAulaCollection(Collection<AgendaAula> agendaAulaCollection) {
        this.agendaAulaCollection = agendaAulaCollection;
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
        if (!(object instanceof UnidadeCurricular)) {
            return false;
        }
        UnidadeCurricular other = (UnidadeCurricular) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }
    
}
