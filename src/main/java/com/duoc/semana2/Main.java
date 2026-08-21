package com.duoc.semana2;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal del sistema SpeedFast - Semana 2.
 * <p>
 * Crea al menos un objeto de cada tipo de pedido (comida, encomienda y
 * express), muestra el resumen de cada uno y calcula su tiempo estimado
 * de entrega, presentando los resultados de forma clara y comparativa.
 *
 * @author Satcha Quispe
 */
public class Main {

    public static void main(String[] args) {

        // Se crea al menos un objeto de cada tipo de pedido
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new PedidoComida("001", "Av. Italia 456", 4));
        pedidos.add(new PedidoEncomienda("002", "Av. Independencia 123", 6));
        pedidos.add(new PedidoExpress("003", "Av. Apoquindo 1500", 7));

        System.out.println("=== Sistema de Pedidos SpeedFast ===");
        System.out.println();

        // Se recorre la lista mostrando resumen y tiempo estimado de cada pedido
        for (Pedido pedido : pedidos) {
            pedido.mostrarResumen();
            System.out.println("Tiempo estimado de entrega: " + pedido.calcularTiempoEntrega() + " minutos");
            System.out.println();
        }

        // Comparativa final de todos los pedidos
        System.out.println("=== Comparativa de tiempos estimados ===");
        for (Pedido pedido : pedidos) {
            System.out.printf("%-20s #%-5s -> %d minutos%n",
                    pedido.getClass().getSimpleName(),
                    pedido.getIdPedido(),
                    pedido.calcularTiempoEntrega());
        }
    }
}
