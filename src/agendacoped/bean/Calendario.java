/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacoped.bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Edgar
 */
@Entity
@Table(name = "calendario")
@NamedQueries({
    @NamedQuery(name = "Calendario.findAll", query = "SELECT c FROM Calendario c")})
public class Calendario implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DIA_AULA")
    @Temporal(TemporalType.DATE)
    private Date diaAula;
    @Column(name = "HORA_AULA")
    private Integer horaAula;
    @Column(name = "HORA_INICIO")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "PERIODO")
    private Integer periodo;
    @Column(name = "STATUS")
    private Boolean status;
    @JoinColumn(name = "SALAS_AULA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private SalasAula salasAulaId;
    @JoinColumn(name = "AGENDA_AULA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AgendaAula agendaAulaId;
    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM");
    
    public Calendario() {
    }

    public Calendario(Integer id) {
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

    public Date getDiaAula() {
        return diaAula;
    }

    public void setDiaAula(Date diaAula) {
        Date oldDiaAula = this.diaAula;
        this.diaAula = diaAula;
        changeSupport.firePropertyChange("diaAula", oldDiaAula, diaAula);
    }

    public Integer getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(Integer horaAula) {
        Integer oldHoraAula = this.horaAula;
        this.horaAula = horaAula;
        changeSupport.firePropertyChange("horaAula", oldHoraAula, horaAula);
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        Date oldHoraInicio = this.horaInicio;
        this.horaInicio = horaInicio;
        changeSupport.firePropertyChange("horaInicio", oldHoraInicio, horaInicio);
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        Integer oldPeriodo = this.periodo;
        this.periodo = periodo;
        changeSupport.firePropertyChange("periodo", oldPeriodo, periodo);
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        Boolean oldStatus = this.status;
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    public SalasAula getSalasAulaId() {
        return salasAulaId;
    }

    public void setSalasAulaId(SalasAula salasAulaId) {
        SalasAula oldSalasAulaId = this.salasAulaId;
        this.salasAulaId = salasAulaId;
        changeSupport.firePropertyChange("salasAulaId", oldSalasAulaId, salasAulaId);
    }

    public AgendaAula getAgendaAulaId() {
        return agendaAulaId;
    }

    public void setAgendaAulaId(AgendaAula agendaAulaId) {
        AgendaAula oldAgendaAulaId = this.agendaAulaId;
        this.agendaAulaId = agendaAulaId;
        changeSupport.firePropertyChange("agendaAulaId", oldAgendaAulaId, agendaAulaId);
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
        if (!(object instanceof Calendario)) {
            return false;
        }
        Calendario other = (Calendario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+format.format(diaAula)+"-"+agendaAulaId.getInstrutoresId().getNome()+"-"+agendaAulaId.getUnidadeCurricularId().getNome()+"-"+salasAulaId.getNome();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
