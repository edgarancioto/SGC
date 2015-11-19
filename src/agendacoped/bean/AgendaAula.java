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
@Table(name = "agenda_aula")
@NamedQueries({
    @NamedQuery(name = "AgendaAula.findAll", query = "SELECT a FROM AgendaAula a")})
public class AgendaAula implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "STATUS")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendaAulaId")
    private Set<Calendario> calendarioSet;
    @JoinColumn(name = "UNIDADE_CURRICULAR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private UnidadeCurricular unidadeCurricularId;
    @JoinColumn(name = "INSTRUTORES_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Instrutores instrutoresId;
    @JoinColumn(name = "EVENTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Evento eventoId;

    public AgendaAula() {
    }

    public AgendaAula(Integer id) {
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        Boolean oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public Set<Calendario> getCalendarioSet() {
        return calendarioSet;
    }

    public void setCalendarioSet(Set<Calendario> calendarioSet) {
        this.calendarioSet = calendarioSet;
    }

    public UnidadeCurricular getUnidadeCurricularId() {
        return unidadeCurricularId;
    }

    public void setUnidadeCurricularId(UnidadeCurricular unidadeCurricularId) {
        UnidadeCurricular oldUnidadeCurricularId = this.unidadeCurricularId;
        this.unidadeCurricularId = unidadeCurricularId;
        changeSupport.firePropertyChange("unidadeCurricularId", oldUnidadeCurricularId, unidadeCurricularId);
    }

    public Instrutores getInstrutoresId() {
        return instrutoresId;
    }

    public void setInstrutoresId(Instrutores instrutoresId) {
        Instrutores oldInstrutoresId = this.instrutoresId;
        this.instrutoresId = instrutoresId;
        changeSupport.firePropertyChange("instrutoresId", oldInstrutoresId, instrutoresId);
    }

    public Evento getEventoId() {
        return eventoId;
    }

    public void setEventoId(Evento eventoId) {
        Evento oldEventoId = this.eventoId;
        this.eventoId = eventoId;
        changeSupport.firePropertyChange("eventoId", oldEventoId, eventoId);
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
        if (!(object instanceof AgendaAula)) {
            return false;
        }
        AgendaAula other = (AgendaAula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendacoped.bean.AgendaAula[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
