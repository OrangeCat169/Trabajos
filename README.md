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
***Patrón Singleton (en SistemaGeneradorDeTurnos)***:
Este patrón garantiza que exista una única instancia de la clase encargada de generar los números de turnos. Esto es fundamental para evitar conflictos en la asignación de números duplicados y para mantener el estado global del último número generado, asegurando la coherencia y sincronización del sistema.

***Patrón Prototype (en Ticket)***:
El patrón Prototype se usa para clonar objetos Ticket. Esto facilita la creación rápida de nuevos tickets basados en una plantilla inicial (ticketBase), asegurando que cada ticket tenga sus propios datos únicos (número, fecha/hora, cliente) sin tener que construir desde cero cada vez, mejorando la eficiencia y reduciendo errores.

***Patrón Adapter (en AdapterWeb y AdapterAPP)***:
Este patrón se utiliza para adaptar la interfaz de visualización a distintos entornos (web y app móvil), permitiendo que ambos usen la misma lógica de negocio interna pero con diferentes mecanismos de entrada/salida. De esta manera, el sistema puede integrar fácilmente nuevas plataformas con mínimos cambios en la lógica central.
### 1. Singleton (ServicioTurnos)
**Justificación**:
Se seleccionó Singleton para la gestión centralizada de la generación y asignación de números de espera, garantizando que solo exista una instancia única que controle el orden y la secuencia de turnos asignados. Esto evita la duplicación o conflicto en la asignación de números, asegurando la integridad y consistencia del sistema.

**Intención arquitectónica**:

Centralizar el control de la generación de turnos para evitar inconsistencias.

Facilitar la sincronización de estados y datos entre diferentes módulos del sistema.

Evitar múltiples instancias que pudieran provocar errores en la secuencia de turnos.
### 2. Prototype (Ticket)
**Justificación**:
El sistema debe generar rápidamente tickets con información personalizada (número, fecha, cliente), y el patrón Prototype permite clonar un ticket base para crear nuevas instancias sin necesidad de construirlas desde cero, mejorando la eficiencia y reduciendo la complejidad en la generación de turnos.

**Intención arquitectónica**:

Permitir la creación rápida de nuevas instancias de tickets basadas en un prototipo.

Reducir la complejidad y tiempo en la generación de números de espera.

Mantener flexibilidad para personalizar cada ticket sin afectar el objeto base.
### 3.Adapter (AdapterWeb y AdapterAPP)
**Justificación**:
El sistema debe interactuar con diferentes tipos de dispositivos (web y app móvil) que requieren interfaces distintas. El uso del patrón Adapter desacopla la lógica de negocio del sistema de las interfaces específicas, permitiendo que se adapten distintos clientes sin modificar el núcleo del sistema.

**Intención arquitectónica**:

Asegurar independencia tecnológica entre la lógica central y las interfaces de usuario.

Facilitar la integración de nuevas plataformas o dispositivos en el futuro.

Permitir mantener y evolucionar el sistema de manera modular y escalable.
## 🔹 3. Diagrama de Implementación UML
![DiagramaDeImplementacion](https://github.com/user-attachments/assets/48881646-286d-4c3a-803d-86e9c5e0e52e)
### 🏗️ Despliegue Físico y Decisiones Técnicas:
La arquitectura física del sistema ha sido diseñada teniendo en cuenta principios clave de seguridad, escalabilidad y disponibilidad. A continuación, se detallan las decisiones técnicas adoptadas:

**Nodos físicos diferenciados**

**Se han identificado y distribuido componentes en nodos físicos independientes para**:
Reforzar la seguridad mediante el privamiento datos
Aumentar la escalabilidad, permitiendo escalar servicios específicos según demanda.

**Separación de responsabilidades**

**Cada tipo de servidor cumple un rol específico, permitiendo una arquitectura más limpia y mantenible**:
**Servidor de Aplicaciones**: Gestión de lógica de negocio, patrones de diseño y controladores.
**Servidor de Configuración**: Aislamiento del módulo ConfiguracionSistema para tener control centralizado de parámetros del sistema.
**Servidor de Integración ERP**: Aislamiento del middleware que se comunica con sistemas externos (ERP).
**Servidor de Base de Datos**: Optimizado exclusivamente para el almacenamiento y recuperación de datos, con políticas de respaldo y alta disponibilidad.


**Protocolos estándar**

**Para facilitar la interoperabilidad y la integración con otros sistemas**:
Se utilizo la conexion a la api de un sistema medico para saber los nombres de los usuarios

**Aislamiento de componentes críticos**

Componentes como ConfiguracionSistema están desplegados en nodos dedicados, permitiendo:
Control de acceso más estricto.
Gestión independiente de actualizaciones/configuraciones.
Minimización de riesgos ante cambios inadvertidos.

## 🧩 Reflexiones Finales del Modelado

**Este ejercicio refleja** , buenas prácticas y uso justificado de patrones de diseño.
**Selección consciente de patrones**: Cada patrón fue elegido en función de necesidades concretas (Adapter, Singleton, Prototype)
**Trazabilidad completa**: Se estableció un hilo conductor desde los casos de uso → diseño de clases → implementación técnica, asegurando coherencia con los requerimientos
**Modularización efectiva**: La separación lógica de responsabilidades y el uso de componentes desacoplados fortalecen la mantenibilidad y escalabilidad del sistema.
**Enfoque profesional**: Este repositorio sirve como referencia arquitectónica alineada a estándares de la industria y puede ser reutilizado o ampliado en proyectos futuros.

## ⚠️ Nota
Este repositorio es exclusivamente documental.
No se incluye código fuente, ya que el foco es el modelado arquitectónico.
