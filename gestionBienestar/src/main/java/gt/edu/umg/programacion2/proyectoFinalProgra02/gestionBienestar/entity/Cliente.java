package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author JAED07
 */
@Entity //Marca la clase como una entidad (se convierte en tabla en la BD).
@Table(name = "clientes") // Permite especificar el nombre de la tabla
public class Cliente {

    @Id //Define la clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClientes; 
    
    @Column(nullable = false)
    private String nombreCompleto;
    
    @Column(unique = true, nullable = false, length = 15)
    private String dpi;
    
    private LocalDate fechaNacimiento;
    
    @Column(length = 20)
    private String telefono;
    
    @Column(unique = true)
    private String email;
    private String password;

    public Cliente() {
    }

    public Cliente(String nombreCompleto, String dni,
            String email) {
        this.nombreCompleto = nombreCompleto;
        this.dpi = dni;
        this.email = email;
    }

    public Long getIdClientes() {
        return idClientes;
    }

    public void setIdClientes(Long idClientes) {
        this.idClientes = idClientes;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dni) {
        if (dni.length() < 8) {
            throw new IllegalArgumentException("El DPI debe tener al menos 13 digitos");
        }
        this.dpi = dpi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Formato de correo invalido");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + idClientes + ", nombre='" + nombreCompleto + '\'' + '}';
    }

}
