# API REST - Documentación de Endpoints

**Base URL:** https://capacitacion.alwaysdata.net/

---

## Autenticación

### Login
* **Método:** POST
* **Ruta:** /api/Propietarios/login
* **Tipo de envío:** application/x-www-form-urlencoded
* **Parámetros:** Usuario: string (luisprofessor@gmail.com), Clave: string (DEEKQW)
* **Respuesta:** String (token JWT)
* **Descripción:** Inicia sesión del propietario y devuelve un token de autorización.

---

## Propietario

### Obtener Perfil
* **Método:** GET
* **Ruta:** /api/Propietarios
* **Headers:** Authorization: Bearer <token>
* **Respuesta:** Propietario
* **Descripción:** Devuelve los datos del propietario autenticado.

### Actualizar Perfil
* **Método:** PUT
* **Ruta:** /api/Propietarios/actualizar
* **Headers:** Authorization: Bearer <token>
* **Cuerpo:** Objeto Propietario (JSON)
* **Respuesta:** Propietario
* **Descripción:** Actualiza la información del propietario.

### Resetear Contraseña
* **Método:** POST
* **Ruta:** /api/Propietarios/email
* **Tipo de envío:** application/x-www-form-urlencoded
* **Parámetros:** email: string
* **Respuesta:** String (mensaje de estado)
* **Descripción:** Envía un correo para reestablecer la contraseña.

### Cambiar Contraseña
* **Método:** PUT
* **Ruta:** /api/Propietarios/changePassword
* **Tipo de envío:** application/x-www-form-urlencoded
* **Headers:** Authorization: Bearer <token>
* **Parámetros:** current Password: string, newPassword: string
* **Respuesta:** Void
* **Descripción:** Cambia la contraseña del propietario autenticado.

---

## Inmuebles

### Obtener Todos los Inmuebles
* **Método:** GET
* **Ruta:** /api/Inmuebles
* **Headers:** Authorization: Bearer <token>
* **Respuesta:** List<Inmueble>
* **Descripción:** Obtiene todos los inmuebles registrados del propietario autenticado.

### Obtener Inmuebles Alquilados
* **Método:** GET
* **Ruta:** /api/Inmuebles/GetContratoVigente
* **Headers:** Authorization: Bearer <token>
* **Respuesta:** List<Inmueble>
* **Descripción:** Devuelve los inmuebles que se encuentran actualmente alquilados.

### Cargar Inmueble (con imagen)
* **Método:** POST
* **Ruta:** /api/Inmuebles/cargar
* **Tipo de envío:** multipart/form-data
* **Headers:** Authorization: Bearer <token>
* **Partes:** imagen: archivo (imagen del inmueble), inmueble: RequestBody con JSON del inmueble
* **Respuesta:** Inmueble
* **Descripción:** Registra un nuevo inmueble con imagen.

### Actualizar Inmueble
* **Método:** PUT
* **Ruta:** /api/Inmuebles/actualizar
* **Headers:** Authorization: Bearer <token>
* **Cuerpo:** Objeto Inmueble (JSON)
* **Respuesta:** Inmueble
* **Descripción:** Actualiza la información de un inmueble existente.

---

## Contratos

### Obtener Contrato por Inmueble
* **Método:** GET
* **Ruta:** /api/contratos/inmueble/{id}
* **Headers:** Authorization: Bearer <token>
* **Path Param:** id: ID del inmueble
* **Respuesta:** Contrato
* **Descripción:** Devuelve el contrato asociado a un inmueble específico.

---

## Pagos

### Obtener Pagos por Contrato
* **Método:** GET
* **Ruta:** /api/pagos/contrato/{id}
* **Headers:** Authorization: Bearer <token>
* **Path Param:** id: ID del contrato
* **Respuesta:** List<Pago>
* **Descripción:** Devuelve todos los pagos realizados correspondientes a un contrato.
