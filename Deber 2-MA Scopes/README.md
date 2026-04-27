# pa2_api_ui_p6_ct

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.


# Ejemplos de Ámbitos (Scopes) en Quarkus - CDI


## 1. @ApplicationScoped (Servicios de Negocio Globales)
*Exclusivo para servicios de negocio que deben vivir a lo largo de toda la aplicación. Su estado es compartido por todos los usuarios y procesos.*

1. **`GestorInventarioCentral`**: Mantiene en memoria el stock global de los productos de una tienda. Si un cliente compra, el stock disminuye para todos los demás.
2. **`RegistroVentasDiarias`**: Acumula los ingresos generados por todas las transacciones del día para emitir un reporte al cierre.
3. **`AdministradorTurnosAtencion`**: Asigna de manera secuencial los números de turno (ej. A-01, A-02) a los clientes que ingresan a una sucursal virtual.
4. **`MonitorTransaccionesActivas`**: Lleva un conteo en tiempo real de cuántas compras se están procesando simultáneamente en la plataforma.
5. **`ServicioListaNegraClientes`**: Mantiene un registro en memoria de usuarios bloqueados temporalmente por intentos de fraude, evitando que cualquier parte del sistema les permita operar.
6. **`GestorPromocionesGlobales`**: Administra los cupones de descuento generales (ej. "CYBERMONDAY") validando si aún no se ha superado el límite total de usos permitidos.
7. **`CalculadoraImpuestosAnual`**: Mantiene el consolidado acumulado de impuestos retenidos durante el ejercicio fiscal en curso para toda la empresa.

---

## 2. @Dependent (Servicios de Negocio Temporales)
*Para servicios de negocio que cambian en cada lugar donde se los necesite. Viven el tiempo en el que dura la inyección, garantizando un estado limpio por proceso.*

1. **`CarritoComprasCliente`**: Crea un carrito vacío y único cada vez que un usuario inicia un proceso de compra. No se mezcla con los productos de otros usuarios.
2. **`SimuladorPrestamoHipotecario`**: Realiza los cálculos de amortización y cuotas basados exclusivamente en los datos que el cliente ingresa en esa petición específica.
3. **`LiquidadorRolPagosIndividual`**: Procesa las horas extras, multas y sueldo líquido de un solo empleado a la vez durante la generación de la nómina.
4. **`ValidadorTarjetaCreditoTemporal`**: Verifica los fondos y vigencia de una tarjeta específica ingresada durante un intento de pago, descartándose inmediatamente después.
5. **`ConstructorFacturaIndividual`**: Acumula temporalmente los ítems, calcula el IVA y genera el detalle de una única factura para una transacción concreta.
6. **`AnalistaRiesgoCrediticio`**: Evalúa el puntaje de crédito temporal de un usuario consultando su historial, usando variables que solo aplican a esa evaluación.
7. **`CalculadoraRutaEnvio`**: Determina el costo de envío y la ruta óptima basándose únicamente en la dirección de origen y destino de un pedido individual.

---

## 3. @Singleton (Beans Utilitarios)
*Se crea una sola instancia durante toda la aplicación, pero se utiliza exclusivamente para BEANS UTILITARIOS que asisten a otras clases, sin contener lógica ni estado de negocio.*

1. **`GeneradorTokensUtilitario`**: Genera cadenas alfanuméricas aleatorias o UUIDs para ser usados como tokens de sesión o recuperación de contraseñas.
2. **`ConversorFechasUtil`**: Proporciona métodos estáticos o compartidos para parsear fechas de un formato `String` a `LocalDate` entre diferentes zonas horarias.
3. **`EncriptadorSeguridadUtil`**: Recibe una cadena de texto (como una contraseña) y devuelve su valor hasheado usando algoritmos matemáticos como SHA-256.
4. **`ValidadorRegexUtil`**: Contiene expresiones regulares para comprobar rápidamente si un texto tiene formato de correo electrónico, cédula ecuatoriana o número de teléfono.
5. **`FormateadorMonedaUtil`**: Recibe un valor decimal (`BigDecimal` o `Double`) y lo devuelve formateado como una cadena de texto con el símbolo de dólares y dos decimales.
6. **`LectorConfiguracionEntorno`**: Lee y expone variables estáticas del sistema (como rutas de carpetas temporales o IPs permitidas) cargadas al arrancar la aplicación.
7. **`SanitizadorCadenasUtil`**: Limpia los textos ingresados por los usuarios, eliminando espacios extra, caracteres especiales no permitidos o etiquetas HTML maliciosas.


## Conclusión: Buenas Prácticas para el Uso de Scopes

Elegir el ámbito correcto en Quarkus no solo optimiza el uso de memoria, sino que define la arquitectura y la seguridad de los datos de la aplicación. Como regla general para un desarrollo limpio:

* **Usamos `@ApplicationScoped` cuando pienses en el "Corazón del Negocio".**
    Es la opción predeterminada para casi todos los servicios, repositorios y manejadores de base de datos. Úsalo cuando necesites que la información, las reglas de negocio o las conexiones sean compartidas globalmente por todos los usuarios de forma segura y centralizada. 

* **Usamos `@Dependent` cuando pienses en "Aislamiento y Temporalidad".**
    Úsalo estrictamente cuando la clase maneje datos sensibles o cálculos temporales que **no deben cruzarse** con otros procesos o usuarios (como el cálculo del carrito de un cliente o la validación de una tarjeta). Al nacer y morir con la clase que lo llama, te asegura un lienzo en blanco libre de datos residuales.

* **Usamos `@Singleton` cuando pienses en "Herramientas de Apoyo".**
    Resérvalo exclusivamente para clases utilitarias (`Utils`, `Helpers`, `Generators`). Úsalo para funciones que procesan datos de entrada y devuelven un resultado (como dar formato a una fecha o encriptar una clave) pero que **no guardan información del negocio**. Al ser una instancia única sin un proxy de por medio, ofrece un rendimiento ligeramente superior ideal para herramientas de uso masivo.




