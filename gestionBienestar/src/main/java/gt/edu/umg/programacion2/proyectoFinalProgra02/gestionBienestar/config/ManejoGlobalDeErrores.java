/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.config;

import gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto.RespuestaCliente;
import jakarta.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 *
 * @author JAED07
 */
@RestControllerAdvice
public class ManejoGlobalDeErrores {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException ex ){
    Map<String, Object> body = new HashMap<>();
    body.put("message", ex.getMessage());
    body.put("status", 400);
    return ResponseEntity.badRequest().body(body);
    }
     @ExceptionHandler(EntityNotFoundException.class)
     public ResponseEntity<Map<String, Object>> handleNotFound(EntityNotFoundException ex){
     Map<String, Object> body = new HashMap<>();
     body.put("message", ex.getMessage());
     body.put("status", 404);
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body); 
     }
     @ExceptionHandler(MethodArgumentNotValidException.class)
     public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex){
     Map<String, Object> body = new HashMap<>();
     body.put("status", 400);
     Map<String, String> errors = new HashMap<>();
     ex.getBindingResult().getFieldErrors().forEach(fe -> errors.put(fe.getField(), fe.getDefaultMessage()));
     body.put("errors", errors);
     return ResponseEntity.badRequest().body(body);
     }
     
             
}
