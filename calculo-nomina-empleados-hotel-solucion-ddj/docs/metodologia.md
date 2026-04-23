---

## `docs/metodologia.md`

```md
# Metodología de Desarrollo

## Introducción

Para el desarrollo del aplicativo "Cálculo de la Nómina de Empleados - Hotel Solución DDJ" se empleó una metodología incremental, la cual permitió dividir el proyecto en módulos pequeños, controlables y fáciles de integrar. Esta metodología fue adecuada debido a que el trabajo fue realizado por tres integrantes, quienes asumieron responsabilidades de diseño, implementación, pruebas, documentación y control de versiones.

## Fases de desarrollo

### 1. Análisis de requerimientos

En esta fase se estudió el enunciado de la actividad con el fin de identificar las reglas de negocio relacionadas con los diferentes tipos de empleados, beneficios, deducciones, validaciones, pruebas unitarias y uso de principios de programación orientada a objetos.

### 2. Diseño del sistema

Se definió una arquitectura basada en clases y paquetes. Se creó una clase abstracta llamada Empleado como base del sistema, y se derivaron clases específicas para cada tipo de trabajador: EmpleadoAsalariado, EmpleadoPorHoras, EmpleadoPorComision y EmpleadoTemporal.

También se diseñó una interfaz gráfica local usando JavaFX, buscando una apariencia elegante, minimalista y fluida, con una pantalla de inicio de sesión y acceso a las vistas principales del sistema.

### 3. Implementación

Cada módulo fue desarrollado de forma separada:

- autenticación
- modelos del dominio
- lógica de cálculo de nómina
- interfaz gráfica
- pruebas unitarias

Se aplicaron principios SOLID, código limpio, nombres descriptivos y separación por responsabilidades.

### 4. Pruebas unitarias

Se implementaron pruebas unitarias con JUnit 5 para verificar:

- cálculo correcto del salario bruto
- aplicación de beneficios
- cálculo de comisiones
- horas extras
- validación de ventas negativas
- validación de horas negativas
- autenticación de usuarios

### 5. Integración

Una vez construidos los módulos, se integraron en un único sistema ejecutable dentro de Visual Studio Code. Se validó el flujo de inicio de sesión, registro de empleados y cálculo de nómina.

### 6. Documentación

Se documentó el código mediante comentarios técnicos y además se redactaron archivos de apoyo como README, distribución del CIPA e informe de entrega.

## Justificación de la metodología

La metodología incremental fue apropiada porque permitió:

- distribuir el trabajo entre los tres integrantes
- avanzar por módulos independientes
- realizar pruebas tempranas
- facilitar la integración final
- mantener control sobre errores y mejoras

## Conclusión

La metodología aplicada permitió desarrollar un sistema de nómina funcional, organizado y alineado con los requerimientos académicos, integrando programación orientada a objetos, pruebas unitarias, documentación y control de versiones.
```
