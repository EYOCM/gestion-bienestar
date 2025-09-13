/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.service;

import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RegistrarRespuesta;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RegistroClienteApp;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RespuestaCliente;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.SolicitudDeCreacionDeCliente;

/**
 *
 * @author JAED07
 */
public interface ClienteService {
    RespuestaCliente registrarPorRecepcionista (SolicitudDeCreacionDeCliente respuesta);
    RegistrarRespuesta registrarPorApp ( RegistroClienteApp respuesta);
    RespuestaCliente obtenerPorId (Long id);
}
    

