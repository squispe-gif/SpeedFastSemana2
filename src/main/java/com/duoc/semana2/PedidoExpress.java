package com.duoc.semana2;

/**
 * Pedido de tipo express. Prioriza la rapidez de entrega, con un tiempo
 * base fijo que aumenta solo si la distancia supera un umbral definido.
 * <p>
 * Fórmula: 10 minutos base; si la distancia es mayor a 5 km, se agregan
 * 5 minutos extra.
 *
 * @author Satcha Quispe
 */
public class PedidoExpress extends Pedido {

    private static final int TIEMPO_BASE_MIN = 10;
    private static final double UMBRAL_KM = 5.0;
    private static final int MINUTOS_EXTRA = 5;

    public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    /**
     * Calcula el tiempo estimado de entrega para un pedido express.
     *
     * @return tiempo estimado en minutos (10, o 15 si la distancia supera 5 km)
     */
    @Override
    public int calcularTiempoEntrega() {
        int tiempo = TIEMPO_BASE_MIN;
        if (distanciaKm > UMBRAL_KM) {
            tiempo += MINUTOS_EXTRA;
        }
        return tiempo;
    }

    @Override
    protected String getTipoPedido() {
        return "PedidoExpress";
    }
}
