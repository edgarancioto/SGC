/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgc.bean;

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
@Table(name = "cursos")
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")})
public class Cursos implements Serializable {
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
    @Column(name = "MODALIDADE")
    private String modalidade;
    @Column(name = "STATUS")
    private Boolean status;
    @JoinColumn(name = "AREAS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Areas areasId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursosId")
    private Collection<UnidadeCurricular> unidadeCurricularCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursosId")
    private Collection<Evento> eventoCollection;

    public Cursos() {
    }

    public Cursos(Integer id) {
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

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        String oldModalidade = this.modalidade;
        this.modalidade = modalidade;
        changeSupport.firePropertyChange("cargaH", oldModalidade, modalidade);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Areas getAreasId() {
        return areasId;
    }

    public void setAreasId(Areas areasId) {
        this.areasId = areasId;
    }

    public Collection<UnidadeCurricular> getUnidadeCurricularCollection() {
        return unidadeCurricularCollection;
    }

    public void setUnidadeCurricularCollection(Collection<UnidadeCurricular> unidadeCurricularCollection) {
        this.unidadeCurricularCollection = unidadeCurricularCollection;
    }

    public Collection<Evento> getEventoCollection() {
        return eventoCollection;
    }

    public void setEventoCollection(Collection<Evento> eventoCollection) {
        this.eventoCollection = eventoCollection;
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
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
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
}
