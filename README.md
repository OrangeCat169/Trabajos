# Sistema de pedido de numeros para atencion al cliente
## ✅ Descripcion general del sistema
El ***Sistema de pedido de números para atención al cliente*** es una solución diseñada para gestionar de forma ordenada y eficiente la **atención a usuarios en entornos donde se requiere administrar turnos***, como bancos, centros médicos, oficinas gubernamentales y servicios al público en general.

Este sistema **permite a los clientes solicitar un número de atención a través de una interfaz física o digital**, integrándose con una pantalla o sistema de llamadas para informar cuándo y dónde serán atendidos. A su vez, permite al personal encargado visualizar y llamar al siguiente cliente en la cola, garantizando un flujo de atención justo, organizado y sin aglomeraciones.

El sistema también puede incluir funcionalidades adicionales como estadísticas de atención, reimpresión de números, múltiples tipos de servicio, lo que lo convierte en una herramienta flexible y adaptable a distintos contextos de atención al público.

## ⚙️ Funciones principales del sistema
### Solicitud de número de atención
- El cliente puede generar un número de turno mediante una interfaz sencilla (**pantalla táctil**).
### Impresión o visualización del número
- El sistema proporciona al cliente su número de atención, ya sea en forma impresa o en pantalla, junto con el tipo de servicio si corresponde.
### Gestión de la cola de espera
- El sistema organiza automáticamente a los clientes en una cola virtual, respetando el orden de llegada y clasificando por tipo de atención si es necesario.
### Llamado al siguiente cliente
- El personal de atención puede visualizar la lista de turnos pendientes y llamar al siguiente número disponible a través de un panel de control.
### Visualización del turno en pantalla
- El número llamado se muestra en una pantalla de atención junto con el módulo, ventanilla o agente que lo atenderá.
### Reimpresión 
- Permite al cliente recuperar su número si lo ha perdido

## 🔍 Objetivos del Modelado
- Desarrollar una transición completa desde la visión funcional hasta el despliegue físico.
- Aplicar patrones de diseño en el diseño lógico y reflejarlos en la arquitectura de implementación.
- Ejercitar el pensamiento arquitectónico en la separación de responsabilidades, modularidad y escalabilidad.

## 🔹 1. Diagrama de Caso de Uso UML
![DiagramaCasoDeUso](https://github.com/user-attachments/assets/e3f9a901-9d4e-444d-b91b-a0e8077f11e2)

### 🧾 Descripción general del Diagrama de Caso de Uso
El análisis funcional del sistema permitió identificar de manera precisa los actores clave y los casos de uso principales que intervienen en el proceso de atención al cliente mediante turnos. El diagrama representa de forma estructurada las interacciones entre los 
usuarios y el sistema, estableciendo los límites de la aplicación.

Asimismo, se utilizaron correctamente las relaciones `<<include>>` y `<<extend>>` para modelar:

Comportamientos obligatorios que forman parte de un flujo principal `<<include>>`, como solicitar el rut cada vez que se necesite interactuar con el usuario.

Comportamientos opcionales o condicionales `<<extend>>`, como la reimpresión del número en caso de pérdida o la selección de tipo de servicio cuando el sistema lo permite.

### 👤 Actores principales
- Cliente: Persona que solicita un número.
- Recepcionista: Persona que atiende a los clientes.
- Administrador del sistema: Persona encargada de configurar parámetros del sistema. 

## 🔹 2. Diagrama de Clases UML con Patrones Aplicados
![DiagramaDeClases](https://github.com/user-attachments/assets/32eae0f7-ad22-4adf-8b32-23eca03ccecd)
### 🧩 Justificación Arquitectónica y Patrones Aplicados
### Seleccion de patrones
Patrón Singleton (en SistemaGeneradorDeTurnos):

Este patrón garantiza que exista una única instancia de la clase encargada de generar los números de turnos. Esto es fundamental para evitar conflictos en la asignación de números duplicados y para mantener el estado global del último número generado, asegurando la coherencia y sincronización del sistema.

Patrón Prototype (en Ticket):
El patrón Prototype se usa para clonar objetos Ticket. Esto facilita la creación rápida de nuevos tickets basados en una plantilla inicial (ticketBase), asegurando que cada ticket tenga sus propios datos únicos (número, fecha/hora, cliente) sin tener que construir desde cero cada vez, mejorando la eficiencia y reduciendo errores.

Patrón Adapter (en AdapterWeb y AdapterAPP):
Este patrón se utiliza para adaptar la interfaz de visualización a distintos entornos (web y app móvil), permitiendo que ambos usen la misma lógica de negocio interna pero con diferentes mecanismos de entrada/salida. De esta manera, el sistema puede integrar fácilmente nuevas plataformas con mínimos cambios en la lógica central.
