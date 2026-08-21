package com.duoc.semana2;

/**
 * Pedido de tipo encomienda. El tiempo estimado de entrega considera un
 * tiempo base mayor al de comida (por el proceso de manejo del paquete)
 * más un tiempo variable según la distancia, ajustado a un valor entero.
 * <p>
 * Fórmula: 20 minutos base + 1.5 minutos por kilómetro (ajustado a entero).
 *
 * @author Satcha Quispe
 */
public class PedidoEncomienda extends Pedido {

    private static final int TIEMPO_BASE_MIN = 20;
    private static final double MINUTOS_POR_KM = 1.5;

    public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Calcula el tiempo estimado de entrega para un pedido de encomienda.
     *
     * @return tiempo estimado en minutos (20 + 1.5 min por km, redondeado)
     */
    @Override
    public int calcularTiempoEntrega() {
        return TIEMPO_BASE_MIN + (int) Math.round(MINUTOS_POR_KM * distanciaKm);
    }

    @Override
    protected String getTipoPedido() {
        return "PedidoEncomienda";
    }
}
