# LA INMOBILIARIA

El sistema trata de la informatización de la gestión de alquileres de propiedades inmuebles que realiza una agencia inmobiliaria.

## RELACIONES

* En la inmobiliaria se alquilan inmuebles para un uso tal como departamentos, locales, depósitos, oficinas individuales, etc.
* Los propietarios de los inmuebles los ofrecen a la agencia para que ésta les busque inquilinos y hacer un contrato de alquiler por un tiempo determinado. Claro está que el propietario está obligado a aceptar el Inquilino que proponga la agencia si cumple las condiciones estipuladas.
* Se sabe que un propietario es dueño de una o varios inmuebles. Cada Inmueble será propiedad de un único propietario.
* Un Inquilino puede llegar a participar de varios contratos de alquiler, pero cada inquilino es único responsable de su contrato.
* Así mismo, cada contrato de alquiler tiene asociado a un solo inmueble. Aunque a lo largo del tiempo ese inmueble aparece en varios otros contratos de alquiler no vigentes.
* Cada contrato de alquiler tiene asociados pagos con información sobre: el número de pago, fecha de pago e importe.

## Propietario entrega inmueble

* Cuando un propietario entrega un inmueble, la agencia le pide la dirección, uso (comercial o residencial), tipo (local, depósito, casa, departamento, etc), cantidad de ambientes y precio del inmueble. Su estado inicial es disponible.
* Si el propietario no estaba ingresado desde antes, hay que agregarlo al sistema solicitando su DNI, apellido, nombre y sus datos de contacto. A partir de entonces el propietario espera a que la Inmobiliaria le avise telefónicamente del contrato con la otra parte.

## Inquilino alquila inmueble

* Cuando el inquilino viene a alquilar un local se lo entrevista solicitando sus datos personales. ABM inquilino. DNI, nombre completo, lugar de trabajo, nombre garante, dni del garante y datos de contacto de ambos.
* Luego indica las características del inmueble (uso de local, tipo, ambientes y precio aproximado). La agencia lleva a cabo un método para búsqueda de inmuebles "disponibles", si encuentra algunos adecuados, se entrega una lista de inmuebles, si al nuevo inquilino le interesa algún inmueble se marcará el mismo como "no disponible", y se crea el contrato de alquiler. Si entre los locales que la agencia ofrece, no hay ninguno que quiera el inquilino, se informa en pantalla que no hay locales alquilables de esas características y no se efectúa contrato.
* Se deben registrar la fecha de inicio y fecha de finalización del presente contrato (se deben controlar las fechas), el monto de alquiler en pesos y un vínculo entre la propiedad inmueble y el inquilino. Luego se avisa al propietario que venga a firmar.
* El inquilino puede terminar antes el contrato si lo desea, pero pagando una multa. En caso de terminar el alquiler, se debe actualizar la fecha de fin del contrato y calcular la multa. Si se cumplió menos de la mitad del tiempo original de alquiler, deberá pagar 2 (dos) meses extra de alquiler. Caso contrario, sólo uno. Además se debe revisar que no deba meses de alquiler. El sistema no registra el pago de la multa, pero si debe informar ese valor.
* El sistema debe permitir fácilmente renovar un contrato de alquiler. Esto generará un nuevo alquiler, con un nuevo monto y fechas pero con los mismos datos de inquilino e inmueble.
* Se debe poder obtener listados de propiedades que estén disponibles y su dueño.

## Listados e Informes Requeridos
* Listar todas las propiedades que le correspondan a un propietario.
* Listar todos los contratos de alquiler que se encuentren vigentes (por fechas).
* Dado como parámetro un inmueble en particular, listar todos sus contratos y nombre del inquilino.
* Listar los pagos realizados para un alquiler en particular.

## Inquilino paga alquiler

* Cuando el inquilino viene a pagar el alquiler, quedará registrado el nro de pago, la fecha en la que se realizó el pago y el importe.

---

## APP Móvil

La inmobiliaria dispone de una aplicación móvil para los propietarios, los que podrán acceder previo registro.

**Funcionalidad:**
* Habilitar/Deshabilitar la disponibilidad de una propiedad.
* Recibir notificaciones de pagos de alquiler.
* Visualizar información personal del inquilino. Visualizar información de contratos.
* Editar su información personal.

---

## Modelo Relacional

*[Imagen: Diagrama del modelo relacional mostrando las tablas interconectadas]* * **Inmobiliaria propietario**
* idPropietario: int(11)
* #dni: int(20)
* apellido: varchar(40)
* nombre: varchar(40)
* #telefono: int(30)
* mail: varchar(320)
* password: varchar(8)

* **Inmobiliaria inmueble**
    * idinmueble: int(11)
    * direccion: varchar(40)
    * #ambientes: int(4)
    * tipo: varchar(15)
    * uso: varchar(15)
    * #precio: double
    * #disponible: tinyint(1)
    * idPropietario: int(11)

* **inmobiliaria pagos**
    * idPago: int(11)
    * #nroPago: int(11)
    * idAlquiler: int(11)
    * fecha: date
    * #importe: double

* **inmobiliaria alquiler**
    * idAlquiler: int(11)
    * #precio: double
    * fecha_inicio: datetime
    * fechaFin: datetime
    * #idinquilino: int(11)
    * #idinmueble: int(11)

* **inmobiliaria inquilino**
    * Idinquilino: int(11)
    * #dni: int(8)
    * apellido: varchar(40)
    * #nombre: int(40)
    * direccion: varchar(50)
    * #telefono: int(30)

---

## Prototipos APP (Sugeridos)

**Funcionalidad Global:** Mientras el usuario esté en la Activity de Login, si agita el teléfono hará una llamada a la inmobiliaria.

### 1. Pantalla de Login e Inicio
*[Imagen: Captura de pantalla de Login con usuario, contraseña y logo]*
*[Imagen: Captura de pantalla del menú lateral (Drawer) con las opciones Inicio, Perfil, Inmuebles, Inquilinos, Contratos, Logout]*
*[Imagen: Captura de pantalla de un mapa de Google Maps mostrando la ubicación]*
* **Fragment Inicio:** Mostrando ubicación de la Inmobiliaria.

### 2. Pantalla de Perfil
*[Imagen: Captura de pantalla mostrando datos del perfil del propietario (Código, DNI, Nombre, Apellido, E-mail, Contraseña, Teléfono) y botón Editar]*
* **Fragment Perfil:** Este fragment muestra toda la información del Propietario logueado. Al hacer clic en el Botón "Editar" podrá modificar cualquiera de sus datos, menos el código o id del Propietario. Este botón cuando está en modo "edición" cambiará a guardar para que cuando el usuario haga clic en el mismo pueda almacenar sus datos.

### 3. Pantalla de Inmuebles
*[Imagen: Captura de pantalla con lista de inmuebles y sus precios, y pantalla de detalle de un inmueble específico con foto]*
* **Fragment Inmuebles:** Muestra una lista con los datos más relevantes de las propiedades del usuario logueado. Cuando tocamos sobre uno de estos ítems, navegamos a un fragment donde se visualizará el detalle del inmueble seleccionado. También existe la opción de "Agregar Inmueble".

### 4. Pantallas de Inquilinos y Contratos
*[Imagen: Captura de pantalla mostrando un inmueble alquilado con el botón "VER" para acceder al detalle del inquilino y otra pantalla similar para ver los contratos vigentes]*
*[Imagen: Capturas de pantalla con la información detallada del inquilino (nombre, DNI, garante) y del contrato (fechas, monto, pagos)]*
* **Fragment Inquilinos:** Este fragment, mostrará una lista de los inmuebles actualmente alquilados del propietario que inició sesión. Al hacer clic en uno de los items, mostrará información del inquilino del mismo.
* **Fragment Contratos:** Al igual que el fragment anterior, muestra una lista de los inmuebles actualmente alquilados (o sea que tienen un contrato) y al hacer clic en uno de los ítems, mostrará detalle del contrato.