package OdontoSysModelo;
// Generated 24/07/2014 08:45:38 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Servicio generated by hbm2java
 */
@Entity
@Table(name="servicio"
    ,catalog="odontosys"
)
public class Servicio  implements java.io.Serializable {


     private Integer idservicio;
     private String descripcion;
     private int precio;
     private String estado;
     private Set<DetalleOrden> detalleOrdens = new HashSet<DetalleOrden>(0);
     private Set<Convenio> convenios = new HashSet<Convenio>(0);
     private Set<Agenda> agendas = new HashSet<Agenda>(0);
     private Set<Tratamiento> tratamientos = new HashSet<Tratamiento>(0);

    public Servicio() {
    }

	
    public Servicio(String descripcion, int precio, String estado) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }
    public Servicio(String descripcion, int precio, String estado, Set<DetalleOrden> detalleOrdens, Set<Convenio> convenios, Set<Agenda> agendas, Set<Tratamiento> tratamientos) {
       this.descripcion = descripcion;
       this.precio = precio;
       this.estado = estado;
       this.detalleOrdens = detalleOrdens;
       this.convenios = convenios;
       this.agendas = agendas;
       this.tratamientos = tratamientos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idservicio", unique=true, nullable=false)
    public Integer getIdservicio() {
        return this.idservicio;
    }
    
    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    
    @Column(name="descripcion", nullable=false)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="precio", nullable=false)
    public int getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    @Column(name="estado", nullable=false, length=20)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="servicio")
    public Set<DetalleOrden> getDetalleOrdens() {
        return this.detalleOrdens;
    }
    
    public void setDetalleOrdens(Set<DetalleOrden> detalleOrdens) {
        this.detalleOrdens = detalleOrdens;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="servicio")
    public Set<Convenio> getConvenios() {
        return this.convenios;
    }
    
    public void setConvenios(Set<Convenio> convenios) {
        this.convenios = convenios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="servicio")
    public Set<Agenda> getAgendas() {
        return this.agendas;
    }
    
    public void setAgendas(Set<Agenda> agendas) {
        this.agendas = agendas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="servicio")
    public Set<Tratamiento> getTratamientos() {
        return this.tratamientos;
    }
    
    public void setTratamientos(Set<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }




}


