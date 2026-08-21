# SpeedFast - Semana 2

**Desarrollo Orientado a Objetos II (PRY2203)**
**Actividad:** Definiendo una clase abstracta y su jerarquía
**Autora:** Satcha Belén Quispe Parada

## Descripción

Continuación del proyecto de la empresa **SpeedFast**, en la que se modela una solución orientada a objetos para el cálculo del tiempo estimado de entrega de distintos tipos de pedido, utilizando una **clase abstracta** y **herencia**.

## Estructura del proyecto

```
SpeedFastSemana2/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── duoc/
                    └── semana2/
                        ├── Pedido.java              (clase abstracta)
                        ├── PedidoComida.java        (hereda de Pedido)
                        ├── PedidoEncomienda.java    (hereda de Pedido)
                        ├── PedidoExpress.java       (hereda de Pedido)
                        └── Main.java                (clase principal)
```

## Diseño

### Pedido (clase abstracta)

Contiene los atributos comunes a todo pedido:

- `idPedido`
- `direccionEntrega`
- `distanciaKm`

Métodos:

- `mostrarResumen()` — método **concreto**, imprime los datos básicos del pedido.
- `calcularTiempoEntrega()` — método **abstracto**, cada subclase lo implementa con su propia lógica.

### Subclases y fórmulas de cálculo

| Clase              | Fórmula del tiempo estimado                              |
| ------------------- | --------------------------------------------------------- |
| `PedidoComida`      | 15 min base + 2 min por cada km                            |
| `PedidoEncomienda`  | 20 min base + 1.5 min por km (ajustado a entero)           |
| `PedidoExpress`     | 10 min base; si la distancia es mayor a 5 km, +5 min extra |

### Main

Crea un objeto de cada tipo de pedido, muestra su resumen, calcula el tiempo estimado de entrega de cada uno y presenta una comparativa final.

## Cómo ejecutar

### Con Maven

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.duoc.semana2.Main"
```

### Con javac/java directo

```bash
javac -d out $(find src -name "*.java")
java -cp out com.duoc.semana2.Main
```

## Salida esperada (consola)

```
PedidoComida #001
Dirección: Av. Italia 456
Distancia: 4 km
Tiempo estimado de entrega: 23 minutos

PedidoEncomienda #002
Dirección: Av. Independencia 123
Distancia: 6 km
Tiempo estimado de entrega: 29 minutos

PedidoExpress #003
Dirección: Av. Apoquindo 1500
Distancia: 7 km
Tiempo estimado de entrega: 15 minutos

=== Comparativa de tiempos estimados ===
PedidoComida         #001   -> 23 minutos
PedidoEncomienda     #002   -> 29 minutos
PedidoExpress        #003   -> 15 minutos
```

## Conceptos de POO aplicados

- **Abstracción**: la clase `Pedido` define un contrato común sin implementar el detalle de cada tipo de entrega.
- **Herencia**: `PedidoComida`, `PedidoEncomienda` y `PedidoExpress` heredan atributos y comportamiento de `Pedido`.
- **Polimorfismo**: cada subclase sobrescribe `calcularTiempoEntrega()` con su propia lógica, y `Main` las trata de forma uniforme a través de la referencia `Pedido`.
