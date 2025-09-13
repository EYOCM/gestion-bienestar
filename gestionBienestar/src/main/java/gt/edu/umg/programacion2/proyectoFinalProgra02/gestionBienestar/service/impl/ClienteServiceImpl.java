/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.service.impl;

import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RespuestaCliente;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.SolicitudDeCreacionDeCliente;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.repository.ClienteRepository;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.service.ClienteService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author JAED07
 */

 @Service
 @Transactional
public class ClienteServiceImpl implements ClienteService{
    
    private final ClienteRepository clienteRepository;
    
 
    public ClienteServiceImpl (ClienteRepository clienteRepository){
    this.clienteRepository = clienteRepository;
    }
    
       @Override
       public RespuestaCliente registrarPorRecepcioniste( SolicitudDeCreacionDeCliente request){
       //validaciones
       if(clienteRepository.existsByDpi(request.getDPI()))
       }
    
}
