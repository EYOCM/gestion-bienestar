/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.repository;

import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Para validar que no se registren clientes duplicados
    boolean existsByDpi(String dpi);     // true si existe un cliente con este DPI
    boolean existsByEmail(String email); // true si existe un cliente con este Email

    // Devuelve un Optional que contiene el Cliente si existe
    Optional<Cliente> findByEmail(String email);
}