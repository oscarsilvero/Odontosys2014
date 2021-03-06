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
 * FacturaEmpresa generated by hbm2java
 */
@Entity
@Table(name="factura_empresa"
    ,catalog="odontosys"
)
public class FacturaEmpresa  implements java.io.Serializable {


     private Integer idfacturaEmpresa;
     private Empresa empresa;
     private Date fecha;
     private String tipo;
     private String timbrado;
     private String nroFactura;
     private Integer descuento;
     private String estado;
     private Integer saldo;
     private int montoTotal;
     private Set<NotaCreditoEmpresa> notaCreditoEmpresas = new HashSet<NotaCreditoEmpresa>(0);
     private Set<MovimientoEmpresa> movimientoEmpresas = new HashSet<MovimientoEmpresa>(0);
     private Set<FacturaConvenio> facturaConvenios = new HashSet<FacturaConvenio>(0);
     private Set<ReciboEmpresa> reciboEmpresas = new HashSet<ReciboEmpresa>(0);

    public FacturaEmpresa() {
    }

	
    public FacturaEmpresa(Empresa empresa, Date fecha, String tipo, String timbrado, String nroFactura, String estado, int montoTotal) {
        this.empresa = empresa;
        this.fecha = fecha;
        this.tipo = tipo;
        this.timbrado = timbrado;
        this.nroFactura = nroFactura;
        this.estado = estado;
        this.montoTotal = montoTotal;
    }
    public FacturaEmpresa(Empresa empresa, Date fecha, String tipo, String timbrado, String nroFactura, Integer descuento, String estado, Integer saldo, int montoTotal, Set<NotaCreditoEmpresa> notaCreditoEmpresas, Set<MovimientoEmpresa> movimientoEmpresas, Set<FacturaConvenio> facturaConvenios, Set<ReciboEmpresa> reciboEmpresas) {
       this.empresa = empresa;
       this.fecha = fecha;
       this.tipo = tipo;
       this.timbrado = timbrado;
       this.nroFactura = nroFactura;
       this.descuento = descuento;
       this.estado = estado;
       this.saldo = saldo;
       this.montoTotal = montoTotal;
       this.notaCreditoEmpresas = notaCreditoEmpresas;
       this.movimientoEmpresas = movimientoEmpresas;
       this.facturaConvenios = facturaConvenios;
       this.reciboEmpresas = reciboEmpresas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idfactura_empresa", unique=true, nullable=false)
    public Integer getIdfacturaEmpresa() {
        return this.idfacturaEmpresa;
    }
    
    public void setIdfacturaEmpresa(Integer idfacturaEmpresa) {
        this.idfacturaEmpresa = idfacturaEmpresa;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_empresa", nullable=false)
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="tipo", nullable=false, length=45)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    @Column(name="timbrado", nullable=false, length=45)
    public String getTimbrado() {
        return this.timbrado;
    }
    
    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    
    @Column(name="nroFactura", nullable=false, length=45)
    public String getNroFactura() {
        return this.nroFactura;
    }
    
    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    
    @Column(name="descuento")
    public Integer getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    
    @Column(name="estado", nullable=false, length=45)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Column(name="saldo")
    public Integer getSaldo() {
        return this.saldo;
    }
    
    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    
    @Column(name="montoTotal", nullable=false)
    public int getMontoTotal() {
        return this.montoTotal;
    }
    
    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="facturaEmpresa")
    public Set<NotaCreditoEmpresa> getNotaCreditoEmpresas() {
        return this.notaCreditoEmpresas;
    }
    
    public void setNotaCreditoEmpresas(Set<NotaCreditoEmpresa> notaCreditoEmpresas) {
        this.notaCreditoEmpresas = notaCreditoEmpresas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="facturaEmpresa")
    public Set<MovimientoEmpresa> getMovimientoEmpresas() {
        return this.movimientoEmpresas;
    }
    
    public void setMovimientoEmpresas(Set<MovimientoEmpresa> movimientoEmpresas) {
        this.movimientoEmpresas = movimientoEmpresas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="facturaEmpresa")
    public Set<FacturaConvenio> getFacturaConvenios() {
        return this.facturaConvenios;
    }
    
    public void setFacturaConvenios(Set<FacturaConvenio> facturaConvenios) {
        this.facturaConvenios = facturaConvenios;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="facturaEmpresa")
    public Set<ReciboEmpresa> getReciboEmpresas() {
        return this.reciboEmpresas;
    }
    
    public void setReciboEmpresas(Set<ReciboEmpresa> reciboEmpresas) {
        this.reciboEmpresas = reciboEmpresas;
    }




}


