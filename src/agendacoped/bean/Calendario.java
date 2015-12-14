/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacoped.bean;

import java.io.Serializable;
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

/**
 *
 * @author Edgar
 */
@Entity
@Table(name = "calendario")
@NamedQueries({
    @NamedQuery(name = "Calendario.findAll", query = "SELECT c FROM Calendario c")})
public class Calendario implements Serializable {
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

    public Calendario() {
    }

    public Calendario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDiaAula() {
        return diaAula;
    }

    public void setDiaAula(Date diaAula) {
        this.diaAula = diaAula;
    }

    public Integer getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(Integer horaAula) {
        this.horaAula = horaAula;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public SalasAula getSalasAulaId() {
        return salasAulaId;
    }

    public void setSalasAulaId(SalasAula salasAulaId) {
        this.salasAulaId = salasAulaId;
    }

    public AgendaAula getAgendaAulaId() {
        return agendaAulaId;
    }

    public void setAgendaAulaId(AgendaAula agendaAulaId) {
        this.agendaAulaId = agendaAulaId;
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
        return "agendacoped.bean.Calendario[ id=" + id + " ]";
    }
    
}
