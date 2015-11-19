/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendacoped.bean;

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

/**
 *
 * @author Edgar
 */
@Entity
@Table(name = "instrutores")
@NamedQueries({
    @NamedQuery(name = "Instrutores.findAll", query = "SELECT i FROM Instrutores i")})
public class Instrutores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "STATUS")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instrutoresId")
    private Set<AgendaAula> agendaAulaSet;
    @JoinColumn(name = "AREAS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Areas areasId;

    public Instrutores() {
    }

    public Instrutores(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<AgendaAula> getAgendaAulaSet() {
        return agendaAulaSet;
    }

    public void setAgendaAulaSet(Set<AgendaAula> agendaAulaSet) {
        this.agendaAulaSet = agendaAulaSet;
    }

    public Areas getAreasId() {
        return areasId;
    }

    public void setAreasId(Areas areasId) {
        this.areasId = areasId;
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
        if (!(object instanceof Instrutores)) {
            return false;
        }
        Instrutores other = (Instrutores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agendacoped.bean.Instrutores[ id=" + id + " ]";
    }
    
}
