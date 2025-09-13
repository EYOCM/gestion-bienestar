package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author JAED07
 */
@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    /*
    nullable = false → obligatorio.
    unique = true → no se repite.
    length = 50 → máximo 50 caracteres.
     */
    
    @Column(nullable = false, unique = true, length = 50)
    private String nombre;
    
    public Rol(){
    }
    public Rol(String nombre){
    this.nombre = nombre;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
