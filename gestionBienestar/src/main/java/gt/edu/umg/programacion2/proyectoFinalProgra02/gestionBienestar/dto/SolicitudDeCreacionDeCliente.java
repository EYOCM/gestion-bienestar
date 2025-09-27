/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;

/**
 *
 * @author JAED07
 */
@Data
public class SolicitudDeCreacionDeCliente {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombreCompleto;

    @NotBlank(message = "El DPI es obligatorio")
    @Size(min = 13, max = 13, message = "El DPI debe tener al menos 13 dijitos")
    private String dpi;
    @NotNull
    private LocalDate fechaNacimiento;

    @NotBlank
    @Size(max = 15, message = "telefono demasiado largo")
    private String telefono;

    @Email(message = "Formato de Email invalido")
    private String email;
    
    @NotBlank private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
