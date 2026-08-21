package com.duoc.semana2;

/**
 * Clase abstracta que representa un pedido genérico dentro del sistema
 * de la empresa SpeedFast.
 * <p>
 * Define los atributos comunes que comparten todos los tipos de pedido
 * (identificador, dirección de entrega y distancia en kilómetros), junto
 * con un método concreto para mostrar un resumen del pedido y un método
 * abstracto que cada subclase deberá implementar con su propia lógica
 * de cálculo del tiempo estimado de entrega.
 *
 * @author Satcha Quispe
 */
public abstract class Pedido {

    /** Identificador único del pedido. */
    protected String idPedido;

    /** Dirección donde debe realizarse la entrega. */
    protected String direccionEntrega;

    /** Distancia en kilómetros entre el origen y el destino del pedido. */
    protected double distanciaKm;

    /**
     * Construye un pedido con sus datos básicos.
     *
     * @param idPedido         identificador único del pedido
     * @param direccionEntrega dirección de entrega del pedido
     * @param distanciaKm      distancia en kilómetros a recorrer
     */
    public Pedido(String idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    /**
     * Muestra por consola los datos básicos del pedido: identificador,
     * dirección de entrega y distancia.
     */
    public void mostrarResumen() {
        System.out.println(getTipoPedido() + " #" + idPedido);
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + (int) distanciaKm + " km");
    }

    /**
     * Calcula el tiempo estimado de entrega, en minutos, según la lógica
     * particular de cada tipo de pedido. Cada subclase debe implementar
     * este método con sus propios factores de cálculo.
     *
     * @return tiempo estimado de entrega en minutos
     */
    public abstract int calcularTiempoEntrega();

    /**
     * Entrega el nombre legible del tipo de pedido, utilizado para
     * imprimir el resumen (por ejemplo: "PedidoComida").
     *
     * @return nombre del tipo de pedido
     */
    protected abstract String getTipoPedido();

    public String getIdPedido() {
        return idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }
}
