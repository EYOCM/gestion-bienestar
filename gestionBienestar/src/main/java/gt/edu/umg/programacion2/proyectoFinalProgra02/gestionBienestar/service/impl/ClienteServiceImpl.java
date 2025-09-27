/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.service.impl;

import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RegistrarRespuesta;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RegistroClienteApp;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RespuestaCliente;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.SolicitudDeCreacionDeCliente;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.entity.Cliente;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.repository.ClienteRepository;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author JAED07
 */
@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;

    }

    @Override
public RespuestaCliente registrarPorRecepcionista(SolicitudDeCreacionDeCliente req) {
  if (clienteRepository.existsByDpi(req.getDpi()))   throw new ResponseStatusException(HttpStatus.CONFLICT, "DPI ya registrado");
  if (clienteRepository.existsByEmail(req.getEmail())) throw new ResponseStatusException(HttpStatus.CONFLICT, "Email ya registrado");

        Cliente c = new Cliente();
        c.setNombreCompleto(req.getNombreCompleto());
        c.setDpi(req.getDpi());
        c.setFechaNacimiento(req.getFechaNacimiento());
        c.setTelefono(req.getTelefono());
        c.setEmail(req.getEmail());

        Cliente saved = clienteRepository.save(c);
        return new RespuestaCliente(saved.getIdClientes(), saved.getNombreCompleto(), saved.getEmail());
    }

    @Override
    public RegistrarRespuesta registrarPorApp(RegistroClienteApp respuesta) {
        if (!respuesta.getPassword().equals(respuesta.getConfirmPassword())) {
            throw new IllegalArgumentException("La contraseña no coincide");

        }
        if (clienteRepository.existsByEmail(respuesta.getEmail())) {
            throw new IllegalArgumentException("Este email ya se encuentra registrado");
        }
        Cliente c = new Cliente();
        c.setNombreCompleto(respuesta.getNombreCompleto());
        c.setEmail(respuesta.getEmail());
        c.setPassword(respuesta.getPassword());
        Cliente saved = clienteRepository.save(c);
        String token = UUID.randomUUID().toString();
        RespuestaCliente cr = new RespuestaCliente(saved.getIdClientes(), saved.getNombreCompleto(), saved.getEmail());
        return new RegistrarRespuesta(cr, token);
    }

    @Override
    @Transactional(readOnly = true)
    public RespuestaCliente obtenerPorId(Long id) {
    Cliente c = clienteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("cliente no econtrado "));
    return new RespuestaCliente(c.getIdClientes(), c.getNombreCompleto(), c.getEmail());
    }

    @Override
    public List<RespuestaCliente> listarTodos() {
return clienteRepository.findAll().stream().map(c -> new RespuestaCliente(c.getIdClientes(), c.getNombreCompleto(), c.getEmail())).toList();
    }
}
