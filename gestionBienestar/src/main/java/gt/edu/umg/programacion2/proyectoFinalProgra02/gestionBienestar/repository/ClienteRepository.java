/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.repository;

import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.entity.Cliente;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JAED07
 */
//parámetro (Cliente) → El tipo de entidad que manejará el repositorio.
//parámetro (Long) → El tipo del ID primario de esa entidad (@Id en la clase Cliente).

public interface ClienteRepository  extends JpaRepository<Cliente, Long>{
    //Para validar que no se registren clientes duplicados
    boolean existsByDpi(String dpi); //Devuelve true si ya existe un cliente con ese dni, false si no.
    boolean esistsByEmail(String Email); //Devuelve true si ya existe un cliente con ese dni, false si no.
    // Optional clase contenedora la cual puede estar vacia, si existe un cliente con el email devolvera el optional con el objeto 
    Optional<Cliente>findByEmail(String email);
    
}
