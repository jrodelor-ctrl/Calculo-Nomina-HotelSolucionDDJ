# 🏨 Cálculo de la Nómina de Empleados – Hotel Solución DDJ

## 📌 Descripción
Este proyecto consiste en el desarrollo de una aplicación de escritorio para el cálculo de la nómina de empleados del **Hotel Solución DDJ**, implementada en Java utilizando el paradigma de **Programación Orientada a Objetos (POO)**.

El sistema permite gestionar diferentes tipos de empleados, calcular salarios, beneficios, deducciones y salario neto, cumpliendo con las reglas de negocio establecidas.

---

## 🎯 Objetivo
Desarrollar un sistema que permita calcular la nómina de empleados aplicando:
- Programación orientada a objetos
- Principios SOLID
- Buenas prácticas de codificación
- Pruebas unitarias
- Control de versiones con GitHub

---

## ⚙️ Tecnologías utilizadas
- Java 17
- JavaFX (interfaz gráfica)
- Maven
- JUnit 5
- Visual Studio Code
- GitHub

---

## 👥 Integrantes del CIPA
Distribucion del proyecto
- Jaime:
  Responsable de la base del sistema:
  Estructura del proyecto en NetBeans
  Clase abstracta Empleado
  Modelos Usuario y Rol
  Servicio de autenticación
  Navegación (AppNavigator)
  Interfaz de inicio de sesión (LoginView)
  Configuración del proyecto (Maven)
  Pruebas unitarias de autenticación
- Daniel
  Responsable de la gestión de empleados:
  Clase EmpleadoAsalariado
  Clase EmpleadoPorHoras
  Lógica de cálculo de salarios y beneficios
  Validaciones de datos
  Vista de registro (RegistroEmpleadoView)
  Pruebas unitarias de cálcul
- Daniela
  Responsable del cálculo de nómina:
  Clase EmpleadoPorComision
  Clase EmpleadoTemporal
  Servicio de deducciones (DeduccionService)
  Servicio de beneficios (BeneficioService)
  Servicio principal (NominaService)
  Repositorio de empleados
  Vista de cálculo (NominaView)
  Pruebas unitarias

---

## 🔐 Funcionalidades principales

### 1. Inicio de sesión
- Autenticación de usuarios
- Roles:
  - Gerente
  - Recurso Humano

---

### 2. Gestión de empleados
Tipos de empleados implementados:
- Empleado Asalariado
- Empleado por Horas
- Empleado por Comisión
- Empleado Temporal

---

### 3. Cálculo de nómina
El sistema permite calcular:
- Salario bruto
- Beneficios
- Deducciones
- Salario neto

---

## 📊 Reglas de negocio

### ✔ Tipos de empleados

**Empleado Asalariado**
- Salario fijo mensual
- Bono del 10% si tiene más de 5 años
- Bono de alimentación

**Empleado por Horas**
- Pago por horas trabajadas
- Horas extra al 1.5
- Fondo de ahorro (2% si aplica)

**Empleado por Comisión**
- Salario base + comisión
- Bono adicional del 3% si ventas > 20.000.000
- Bono de alimentación

**Empleado Temporal**
- Salario fijo
- No recibe beneficios adicionales

---

### ✔ Deducciones
- 4% seguridad social y pensión
- ARL

---

### ✔ Validaciones
- No se permiten salarios negativos
- No se permiten horas negativas
- No se permiten ventas negativas

---

## 🖥️ Interfaz de usuario
- Diseño elegante y minimalista
- Fondo con degradado
- Paneles translúcidos
- Navegación fluida entre vistas
- Aplicación de escritorio (no web)

---

## 🧪 Pruebas unitarias
Se implementaron pruebas unitarias para:
- Cálculo de salarios
- Validación de reglas de negocio
- Autenticación de usuarios

---

## ▶️ Ejecución del proyecto

### Ejecutar la aplicación
```bash
mvn clean javafx:run

Usuarios de prueba
Usuario: gerente
Contraseña: 1234
Usuario: rrhh
Contraseña: 1234
