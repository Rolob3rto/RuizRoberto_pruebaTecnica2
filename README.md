# Turnero - Aplicación de Gestión de Turnos

Esta aplicación de gestión de turnos ha sido desarrollada para satisfacer las necesidades de una entidad gubernamental que busca administrar eficientemente los turnos de trámites asignados a ciudadanos. A continuación, se detallan las principales funcionalidades y cómo utilizar la aplicación.

## Funcionalidades

### 1. Agregar un Nuevo Turno

Los usuarios pueden agregar un nuevo turno proporcionando la siguiente información:

- Número de turno.
- Fecha del turno.
- Descripción del trámite a realizar.
- Ciudadano asignado al turno.

Es importante destacar que cada turno es exclusivo para un ciudadano, pero un ciudadano puede tener más de un turno en diferentes ocasiones.

### 2. Listar Turnos

La aplicación permite visualizar la lista completa de todos los turnos junto con los detalles de los ciudadanos asignados. Los usuarios pueden filtrar la lista según una fecha específica proporcionada.

Se sugiere el uso de una tabla para mejorar la distribución de los datos y facilitar la lectura.

### 3. Filtrado de Turnos

Los usuarios tienen la capacidad de filtrar los turnos según dos criterios principales:

- **Fecha:** Seleccionan una fecha específica para ver los turnos programados en ese día.
- **Estado del Turno:** Pueden optar por ver los turnos "En Espera" (aún no atendidos) o los "Ya Atendidos".

## Tecnologías Utilizadas

El backend lógico de esta aplicación se ha desarrollado utilizando las siguientes tecnologías:

- Java
- JSP (JavaServer Pages)
- Servlets
- JPA (Java Persistence API)
- Base de Datos MySQL

## Configuración del Proyecto

Para configurar el proyecto en tu entorno de desarrollo:

1. Clona este repositorio.
2. Importa el proyecto en tu IDE de preferencia.
3. Configura la base de datos MySQL y ajusta las propiedades de conexión en el archivo de configuración correspondiente.
```
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2" xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd"> 
  <persistence-unit name="my_persistence_unit">
    <class>com.roberto.pruebatecnica2.logic.Ciudadano</class>
    <class>com.roberto.pruebatecnica2.logic.Turno</class>
  </persistence-unit>
  <persistence-unit name="pruebaTecnica2PU" transaction-type="RESOURCE_LOCAL">
    <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
    <exclude-unlisted-classes>false</exclude-unlisted-classes>
    <properties>
      <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/pruebatecnica2?zeroDateTimeBehavior=CONVERT_TO_NULL"/>
      <property name="javax.persistence.jdbc.user" value="root"/>
      <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
      <property name="javax.persistence.jdbc.password" value=""/>
      <property name="javax.persistence.schema-generation.database.action" value="create"/>
    </properties>
  </persistence-unit>
</persistence>
```

4. Ejecuta el archivo sql con los datos de ejemplo

5. Ejecuta la aplicación en tu servidor de aplicaciones Java.
