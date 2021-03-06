package OdontoSysModelo;
// Generated 24/07/2014 08:45:38 PM by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DetalleRecibo generated by hbm2java
 */
@Entity
@Table(name="detalle_recibo"
    ,catalog="odontosys"
)
public class DetalleRecibo  implements java.io.Serializable {


     private Integer iddetalleRecibo;
     private Recibo recibo;
     private String formaPago;
     private int monto;

    public DetalleRecibo() {
    }

    public DetalleRecibo(Recibo recibo, String formaPago, int monto) {
       this.recibo = recibo;
       this.formaPago = formaPago;
       this.monto = monto;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="iddetalle_recibo", unique=true, nullable=false)
    public Integer getIddetalleRecibo() {
        return this.iddetalleRecibo;
    }
    
    public void setIddetalleRecibo(Integer iddetalleRecibo) {
        this.iddetalleRecibo = iddetalleRecibo;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_recibo", nullable=false)
    public Recibo getRecibo() {
        return this.recibo;
    }
    
    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    
    @Column(name="forma_pago", nullable=false, length=45)
    public String getFormaPago() {
        return this.formaPago;
    }
    
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    
    @Column(name="monto", nullable=false)
    public int getMonto() {
        return this.monto;
    }
    
    public void setMonto(int monto) {
        this.monto = monto;
    }




}


