package OdontoSysModelo;
// Generated 24/07/2014 08:45:38 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Factura generated by hbm2java
 */
@Entity
@Table(name="factura"
    ,catalog="odontosys"
)
public class Factura  implements java.io.Serializable {


     private Integer idfactura;
     private OrdenServicio ordenServicio;
     private Paciente paciente;
     private Date fecha;
     private String tipoFactura;
     private int timbrado;
     private String nroFactura;
     private int descuento;
     private String estado;
     private int montoTotal;
     private int saldo;
     private Set<Movimiento> movimientos = new HashSet<Movimiento>(0);
     private Set<NotaCredito> notaCreditos = new HashSet<NotaCredito>(0);
     private Set<Recibo> recibos = new HashSet<Recibo>(0);
     private Set<FacturaConvenio> facturaConvenios = new HashSet<FacturaConvenio>(0);

    public Factura() {
    }

	
    public Factura(OrdenServicio ordenServicio, Paciente paciente, Date fecha, String tipoFactura, int timbrado, String nroFactura, int descuento, String estado, int montoTotal, int saldo) {
        this.ordenServicio = ordenServicio;
        this.paciente = paciente;
        this.fecha = fecha;
        this.tipoFactura = tipoFactura;
        this.timbrado = timbrado;
        this.nroFactura = nroFactura;
        this.descuento = descuento;
        this.estado = estado;
        this.montoTotal = montoTotal;
        this.saldo = saldo;
    }
    public Factura(OrdenServicio ordenServicio, Paciente paciente, Date fecha, String tipoFactura, int timbrado, String nroFactura, int descuento, String estado, int montoTotal, int saldo, Set<Movimiento> movimientos, Set<NotaCredito> notaCreditos, Set<Recibo> recibos, Set<FacturaConvenio> facturaConvenios) {
       this.ordenServicio = ordenServicio;
       this.paciente = paciente;
       this.fecha = fecha;
       this.tipoFactura = tipoFactura;
       this.timbrado = timbrado;
       this.nroFactura = nroFactura;
       this.descuento = descuento;
       this.estado = estado;
       this.montoTotal = montoTotal;
       this.saldo = saldo;
       this.movimientos = movimientos;
       this.notaCreditos = notaCreditos;
       this.recibos = recibos;
       this.facturaConvenios = facturaConvenios;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idfactura", unique=true, nullable=false)
    public Integer getIdfactura() {
        return this.idfactura;
    }
    
    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_orden", nullable=false)
    public OrdenServicio getOrdenServicio() {
        return this.ordenServicio;
    }
    
    public void setOrdenServicio(OrdenServicio ordenServicio) {
        this.ordenServicio = ordenServicio;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_paciente", nullable=false)
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="tipo_factura", nullable=false, length=20)
    public String getTipoFactura() {
        return this.tipoFactura;
    }
    
    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    
    @Column(name="timbrado", nullable=false)
    public int getTimbrado() {
        return this.timbrado;
    }
    
    public void setTimbrado(int timbrado) {
        this.timbrado = timbrado;
    }

    
    @Column(name="nro_factura", nullable=false, length=15)
    public String getNroFactura() {
        return this.nroFactura;
    }
    
    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    
    @Column(name="descuento", nullable=false)
    public int getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    
    @Column(name="estado", nullable=false, length=20)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Column(name="monto_total", nullable=false)
    public int getMontoTotal() {
        return this.montoTotal;
    }
    
    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

    
    @Column(name="saldo", nullable=false)
    public int getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="factura")
    public Set<Movimiento> getMovimientos() {
        return this.movimientos;
    }
    
    public void setMovimientos(Set<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="factura")
    public Set<NotaCredito> getNotaCreditos() {
        return this.notaCreditos;
    }
    
    public void setNotaCreditos(Set<NotaCredito> notaCreditos) {
        this.notaCreditos = notaCreditos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="factura")
    public Set<Recibo> getRecibos() {
        return this.recibos;
    }
    
    public void setRecibos(Set<Recibo> recibos) {
        this.recibos = recibos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="factura")
    public Set<FacturaConvenio> getFacturaConvenios() {
        return this.facturaConvenios;
    }
    
    public void setFacturaConvenios(Set<FacturaConvenio> facturaConvenios) {
        this.facturaConvenios = facturaConvenios;
    }




}


