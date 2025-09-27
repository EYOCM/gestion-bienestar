/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.controller;

import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RegistrarRespuesta;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RegistroClienteApp;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RespuestaCliente;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.SolicitudDeCreacionDeCliente;
import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.service.ClienteService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JAED07
 */
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RespuestaCliente> registrar(
            @Valid @RequestBody SolicitudDeCreacionDeCliente req) {
        RespuestaCliente res = service.registrarPorRecepcionista(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<RegistrarRespuesta> registrarPorApp(
            @Valid @RequestBody RegistroClienteApp req) {
        RegistrarRespuesta res = service.registrarPorApp(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaCliente> obtener(@PathVariable("id") Long id) {
        RespuestaCliente res = service.obtenerPorId(id);
        return ResponseEntity.ok(res);
    }
    @GetMapping
    public ResponseEntity<List<RespuestaCliente>> listarTodos(){
    List<RespuestaCliente> lista = service.listarTodos();
    return ResponseEntity.ok(lista);
    }
}