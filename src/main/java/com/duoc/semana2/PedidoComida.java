package com.duoc.semana2;

/**
 * Pedido de tipo comida. El tiempo estimado de entrega considera un
 * tiempo base de preparación más un tiempo variable según la distancia
 * a recorrer.
 * <p>
 * Fórmula: 15 minutos base + 2 minutos por cada kilómetro.
 *
 * @author Satcha Quispe
 */
public class PedidoComida extends Pedido {

    private static final int TIEMPO_BASE_MIN = 15;
    private static final int MINUTOS_POR_KM = 2;

    public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Calcula el tiempo estimado de entrega para un pedido de comida.
     *
     * @return tiempo estimado en minutos (15 + 2 min por km)
     */
    @Override
    public int calcularTiempoEntrega() {
        return TIEMPO_BASE_MIN + (int) Math.round(MINUTOS_POR_KM * distanciaKm);
    }

    @Override
    protected String getTipoPedido() {
        return "PedidoComida";
    }
}
