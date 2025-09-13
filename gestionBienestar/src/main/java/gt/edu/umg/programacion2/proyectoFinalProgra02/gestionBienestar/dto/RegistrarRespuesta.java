/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.edu.umg.programacion2.proyectoFinalProgra02.gestionBienestar.dto;

/**
 *
 * @author JAED07
 */
public class RegistrarRespuesta {

    private RespuestaCliente cliente;
    private String token; 

    public RegistrarRespuesta() {
    }

    public RegistrarRespuesta(RespuestaCliente cliente, String token) {
        this.cliente = cliente;
        this.token = token;
    }

    public RespuestaCliente getCliente() {
        return cliente;
    }

    public void setCliente(RespuestaCliente cliente) {
        this.cliente = cliente;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
