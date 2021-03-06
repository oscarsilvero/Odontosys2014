package OdontoSysModelo;
// Generated 24/07/2014 08:45:38 PM by Hibernate Tools 3.6.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Diagnostico generated by hbm2java
 */
@Entity
@Table(name="diagnostico"
    ,catalog="odontosys"
)
public class Diagnostico  implements java.io.Serializable {


     private Integer idDiagnostico;
     private Odontograma odontograma;
     private Paciente paciente;
     private Doctor doctor;
     private Date fecha;
     private String resumenHallazgos;
     private String planTratamiento;
     private String tipo;
     private String empresa;
     private String observaciones;

    public Diagnostico() {
    }

	
    public Diagnostico(Paciente paciente, Doctor doctor, Date fecha, String resumenHallazgos, String planTratamiento, String tipo) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.resumenHallazgos = resumenHallazgos;
        this.planTratamiento = planTratamiento;
        this.tipo = tipo;
    }
    public Diagnostico(Odontograma odontograma, Paciente paciente, Doctor doctor, Date fecha, String resumenHallazgos, String planTratamiento, String tipo, String empresa, String observaciones) {
       this.odontograma = odontograma;
       this.paciente = paciente;
       this.doctor = doctor;
       this.fecha = fecha;
       this.resumenHallazgos = resumenHallazgos;
       this.planTratamiento = planTratamiento;
       this.tipo = tipo;
       this.empresa = empresa;
       this.observaciones = observaciones;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idDiagnostico", unique=true, nullable=false)
    public Integer getIdDiagnostico() {
        return this.idDiagnostico;
    }
    
    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_odontog_examen")
    public Odontograma getOdontograma() {
        return this.odontograma;
    }
    
    public void setOdontograma(Odontograma odontograma) {
        this.odontograma = odontograma;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_paciente", nullable=false)
    public Paciente getPaciente() {
        return this.paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_doctor", nullable=false)
    public Doctor getDoctor() {
        return this.doctor;
    }
    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable=false, length=10)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="resumen_hallazgos", nullable=false, length=1500)
    public String getResumenHallazgos() {
        return this.resumenHallazgos;
    }
    
    public void setResumenHallazgos(String resumenHallazgos) {
        this.resumenHallazgos = resumenHallazgos;
    }

    
    @Column(name="plan_tratamiento", nullable=false, length=1500)
    public String getPlanTratamiento() {
        return this.planTratamiento;
    }
    
    public void setPlanTratamiento(String planTratamiento) {
        this.planTratamiento = planTratamiento;
    }

    
    @Column(name="tipo", nullable=false, length=45)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    @Column(name="empresa", length=50)
    public String getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    
    @Column(name="observaciones", length=300)
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }




}


