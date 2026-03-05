# SISTEMA E-COMMERCE - TALLER 3

## Descripción
Sistema para gestionar productos, clientes y pedidos utilizando archivos CSV. Implementado en Java con un menú interactivo.

## Requisitos
- Java 8 o superior
- Los archivos CSV deben estar en el mismo directorio que el programa

## Archivos del Proyecto
```
Cliente.java              - Clase para gestionar clientes
Producto.java            - Clase para gestionar productos
Pedido.java              - Clase para gestionar pedidos
VentasProducto.java      - Clase para reportes de ventas
ManejadorArchivos.java   - Manejo de lectura/escritura CSV
main.java               - Programa principal
productos.csv           - Base de datos de productos
clientes.csv            - Base de datos de clientes
pedidos.csv             - Base de datos de pedidos
total_ventas.csv        - Generado automáticamente
```

## Compilación
```bash
javac *.java
```

## Ejecución
```bash
java main
```

## Opciones del Menú

### 1. Ver productos ordenados por precio
- Ordena todos los productos de menor a mayor precio
- Usa algoritmo Bubble Sort personalizado
- Muestra: ID, Nombre, Categoría, Precio y Stock

### 2. Agregar un nuevo cliente
- Solicita nombre y email
- Auto-genera el siguiente ID
- Actualiza clientes.csv automáticamente

### 3. Calcular total de ventas por producto
- Lee pedidos.csv para obtener cantidades
- Multiplica cantidad × precio
- Ordena por total de ventas (mayor a menor)
- Genera archivo total_ventas.csv

### 4. Ver clientes que han realizado compras
- Filtra clientes que aparecen en pedidos.csv
- Ordena alfabéticamente por nombre
- Muestra: ID, Nombre y Email

### 5. Salir
- Cierra el programa

## Estructura de Datos

### Cliente
- ID (incremento automático)
- Nombre
- Email

### Producto
- ID
- Nombre
- Categoría
- Precio
- Stock

### Pedido
- ID
- Cliente ID
- Producto ID
- Cantidad
- Fecha

## Notas Importantes
- Solo se utilizan librerías estándar de Java
- El ordenamiento se implementó con Bubble Sort personalizado
- Los cambios se guardan automáticamente en los archivos CSV
- El programa maneja excepciones básicas

## Ejemplo de Uso
1. Ejecutar: `java main`
2. Seleccionar opción 1 para ver productos
3. Seleccionar opción 2 para agregar cliente
4. Seleccionar opción 3 para ver ventas
5. Seleccionar opción 4 para ver clientes con compras
6. Seleccionar opción 5 para salir
