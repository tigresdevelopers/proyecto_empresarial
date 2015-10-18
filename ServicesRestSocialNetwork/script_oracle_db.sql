-- Generado por Oracle SQL Developer Data Modeler 4.1.1.888
--   en:        2015-10-09 22:32:34 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE Actividad
  (
    idactividad     INTEGER NOT NULL ,
    descripcion     VARCHAR2 (50) ,
    idusuario      INTEGER NOT NULL ,
    idcomentario    INTEGER ,
    idpublicacion   INTEGER ,
    idlike          INTEGER ,
    fecha_actividad TIMESTAMP WITH LOCAL TIME ZONE
  ) ;
CREATE UNIQUE INDEX Actividad__IDX ON Actividad
  (
    idcomentario ASC
  )
  ;
CREATE UNIQUE INDEX Actividad__IDXv1 ON Actividad
  (
    idlike ASC
  )
  ;
CREATE UNIQUE INDEX Actividad__IDXv2 ON Actividad
  (
    idpublicacion ASC
  )
  ;
ALTER TABLE Actividad ADD CONSTRAINT Actividad_PK PRIMARY KEY ( idactividad ) ;


CREATE TABLE Album
  (
    idalbum INTEGER NOT NULL ,
    nombre  VARCHAR2 (50) ,
    descripcion CLOB ,
    likes         INTEGER ,
    idpublicacion INTEGER NOT NULL ,
    idusuario     INTEGER ,
    idgrupo       INTEGER
  ) ;
CREATE UNIQUE INDEX Album__IDX ON Album
  (
    idpublicacion ASC
  )
  ;
ALTER TABLE Album ADD CONSTRAINT Album_PK PRIMARY KEY ( idalbum ) ;


CREATE TABLE Comentario
  (
    idcomentario INTEGER NOT NULL ,
    contenido CLOB ,
    idusuario        INTEGER NOT NULL ,
    idmultimedia     INTEGER ,
    idpublicacion    INTEGER ,
    idalbum          INTEGER ,
    fecha_comentario TIMESTAMP WITH LOCAL TIME ZONE ,
    likes            INTEGER
  ) ;
ALTER TABLE Comentario ADD CONSTRAINT Comentario_PK PRIMARY KEY ( idcomentario ) ;


CREATE TABLE Contacto
  (
    idcontacto           INTEGER NOT NULL ,
    myid                 INTEGER NOT NULL ,
    idusuario            INTEGER NOT NULL ,
    fecha_inicio_amistad TIMESTAMP WITH LOCAL TIME ZONE NOT NULL ,
    seguidor             CHAR (1) NOT NULL ,
    bloqueado            CHAR (1) NOT NULL ,
    idlista_contactos    INTEGER ,
    idtipo_contacto      INTEGER
  ) ;
ALTER TABLE Contacto ADD CONSTRAINT Contacto_PK PRIMARY KEY ( idcontacto ) ;


CREATE TABLE Etiqueta
  (
    idetiqueta    INTEGER NOT NULL ,
    idusuario     INTEGER NOT NULL ,
    idcomentario  INTEGER ,
    idmultimedia  INTEGER ,
    idpublicacion INTEGER
  ) ;
ALTER TABLE Etiqueta ADD CONSTRAINT Etiqueta_PK PRIMARY KEY ( idetiqueta ) ;


CREATE TABLE Grupo
  (
    idgrupo INTEGER NOT NULL ,
    nombre  VARCHAR2 (100) ,
    descripcion CLOB ,
    fecha_creacion TIMESTAMP WITH LOCAL TIME ZONE
  ) ;
ALTER TABLE Grupo ADD CONSTRAINT Grupo_PK PRIMARY KEY ( idgrupo ) ;


CREATE TABLE Grupo_usuario
  (
    idgrupo        INTEGER NOT NULL ,
    idusuario      INTEGER NOT NULL ,
    admin          CHAR (1) NOT NULL ,
    fecha_registro TIMESTAMP WITH LOCAL TIME ZONE
  ) ;
ALTER TABLE Grupo_usuario ADD CONSTRAINT grupo_usuario_PK PRIMARY KEY ( idgrupo, idusuario ) ;


CREATE TABLE Idioma
  ( ididioma INTEGER NOT NULL , nombre VARCHAR2 (50)
  ) ;
ALTER TABLE Idioma ADD CONSTRAINT Idioma_PK PRIMARY KEY ( ididioma ) ;


CREATE TABLE "Like"
  (
    idlike         INTEGER NOT NULL ,
    fecha_registro TIMESTAMP WITH LOCAL TIME ZONE NOT NULL ,
    idusuario      INTEGER NOT NULL ,
    idmultimedia   INTEGER ,
    idalbum        INTEGER ,
    idpublicacion  INTEGER ,
    idcomentario   INTEGER
  ) ;
ALTER TABLE "Like" ADD CONSTRAINT Like_PK PRIMARY KEY ( idlike ) ;


CREATE TABLE Lista_contactos
  (
    idlista_contactos INTEGER NOT NULL ,
    nombre            VARCHAR2 (100) ,
    fecha_creacion    TIMESTAMP WITH LOCAL TIME ZONE ,
    idusuario         INTEGER NOT NULL
  ) ;
ALTER TABLE Lista_contactos ADD CONSTRAINT Lista_contactos_PK PRIMARY KEY ( idlista_contactos ) ;


CREATE TABLE Multimedia
  (
    idmultimedia   INTEGER NOT NULL ,
    nombre_archivo VARCHAR2 (200) NOT NULL ,
    descripcion CLOB ,
    tipo              INTEGER ,
    likes             INTEGER ,
    idpublicacion     INTEGER NOT NULL ,
    idalbum           INTEGER NOT NULL ,
    idtipo_contacto   INTEGER ,
    idlista_contactos INTEGER
  ) ;
ALTER TABLE Multimedia ADD CONSTRAINT Multimedia_PK PRIMARY KEY ( idmultimedia ) ;


CREATE TABLE Notificaciones
  (
    idnotificacion INTEGER NOT NULL ,
    leido          CHAR (1) ,
    descripcion    VARCHAR2 (300) ,
    idpublicacion  INTEGER ,
    idcomentario   INTEGER ,
    idlike         INTEGER
  ) ;
CREATE UNIQUE INDEX Notificaciones__IDX ON Notificaciones
  (
    idcomentario ASC
  )
  ;
CREATE UNIQUE INDEX Notificaciones__IDXv1 ON Notificaciones
  (
    idlike ASC
  )
  ;
CREATE UNIQUE INDEX Notificaciones__IDXv2 ON Notificaciones
  (
    idpublicacion ASC
  )
  ;
ALTER TABLE Notificaciones ADD CONSTRAINT Notificaciones_PK PRIMARY KEY ( idnotificacion ) ;


CREATE TABLE Publicacion
  (
    idpublicacion INTEGER NOT NULL ,
    idusuario     INTEGER ,
    contenido CLOB ,
    nombre_archivo     VARCHAR2 (200) ,
    idusuario_receiver INTEGER ,
    idgrupo            INTEGER ,
    likes              INTEGER ,
    idtipo_contacto    INTEGER ,
    idlista_contactos  INTEGER
  ) ;
ALTER TABLE Publicacion ADD CONSTRAINT Publicacion_PK PRIMARY KEY ( idpublicacion ) ;


CREATE TABLE Situacion_sentimental
  (
    idsituacion INTEGER NOT NULL ,
    descripcion VARCHAR2 (50)
  ) ;
ALTER TABLE Situacion_sentimental ADD CONSTRAINT Situacion_sentimental_PK PRIMARY KEY ( idsituacion ) ;


CREATE TABLE Solicitud
  (
    idsolicitud        INTEGER NOT NULL ,
    idusuario          INTEGER NOT NULL ,
    fecha_solicitud    TIMESTAMP WITH LOCAL TIME ZONE ,
    estado             INTEGER NOT NULL ,
    idusuario_receiver INTEGER NOT NULL
  ) ;
ALTER TABLE Solicitud ADD CONSTRAINT Solicitud_PK PRIMARY KEY ( idsolicitud ) ;


CREATE TABLE Tipo_contacto
  (
    idtipo_contacto INTEGER NOT NULL ,
    nombre          VARCHAR2 (50)
  ) ;
ALTER TABLE Tipo_contacto ADD CONSTRAINT Tipo_contacto_PK PRIMARY KEY ( idtipo_contacto ) ;


CREATE TABLE Usuario
  (
    idusuario        INTEGER NOT NULL ,
    nombre           VARCHAR2 (50) NOT NULL ,
    ape_paterno      VARCHAR2 (50) NOT NULL ,
    ape_materno      VARCHAR2 (50) NOT NULL ,
    fecha_nacimiento TIMESTAMP WITH LOCAL TIME ZONE NOT NULL ,
    email            VARCHAR2 (50) NOT NULL ,
    clave            VARCHAR2 (60) ,
    celular          VARCHAR2 (11) ,
    sexo             INTEGER NOT NULL ,
    fecha_registro   TIMESTAMP WITH LOCAL TIME ZONE NOT NULL ,
    estado           CHAR (1) NOT NULL ,
    theme            VARCHAR2 (20) ,
    idsituacion      INTEGER NOT NULL
  ) ;
ALTER TABLE Usuario ADD CONSTRAINT Usuario_PK PRIMARY KEY ( idusuario ) ;


CREATE TABLE Usuario_idioma
  (
    ididioma  INTEGER NOT NULL ,
    idusuario INTEGER NOT NULL
  ) ;
ALTER TABLE Usuario_idioma ADD CONSTRAINT usuario_idioma_PK PRIMARY KEY ( ididioma, idusuario ) ;


ALTER TABLE Actividad ADD CONSTRAINT Actividad_Comentario_FK FOREIGN KEY ( idcomentario ) REFERENCES Comentario ( idcomentario ) ON
DELETE CASCADE ;

ALTER TABLE Actividad ADD CONSTRAINT Actividad_Like_FK FOREIGN KEY ( idlike ) REFERENCES "Like" ( idlike ) ;

ALTER TABLE Actividad ADD CONSTRAINT Actividad_Publicacion_FK FOREIGN KEY ( idpublicacion ) REFERENCES Publicacion ( idpublicacion ) ;

ALTER TABLE Actividad ADD CONSTRAINT Actividad_Usuario_FK FOREIGN KEY ( idusuario1 ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Album ADD CONSTRAINT Album_Grupo_FK FOREIGN KEY ( idgrupo ) REFERENCES Grupo ( idgrupo ) ;

ALTER TABLE Album ADD CONSTRAINT Album_Publicacion_FK FOREIGN KEY ( idpublicacion ) REFERENCES Publicacion ( idpublicacion ) ;

ALTER TABLE Album ADD CONSTRAINT Album_Usuario_FK FOREIGN KEY ( idusuario ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Comentario ADD CONSTRAINT Comentario_Album_FK FOREIGN KEY ( idalbum ) REFERENCES Album ( idalbum ) ;

ALTER TABLE Comentario ADD CONSTRAINT Comentario_Multimedia_FK FOREIGN KEY ( idmultimedia ) REFERENCES Multimedia ( idmultimedia ) ;

ALTER TABLE Comentario ADD CONSTRAINT Comentario_Publicacion_FK FOREIGN KEY ( idpublicacion ) REFERENCES Publicacion ( idpublicacion ) ;

ALTER TABLE Comentario ADD CONSTRAINT Comentario_Usuario_FK FOREIGN KEY ( idusuario ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Contacto ADD CONSTRAINT Contacto_Lista_contactos_FK FOREIGN KEY ( idlista_contactos ) REFERENCES Lista_contactos ( idlista_contactos ) ;

ALTER TABLE Contacto ADD CONSTRAINT Contacto_Tipo_contacto_FK FOREIGN KEY ( idtipo_contacto ) REFERENCES Tipo_contacto ( idtipo_contacto ) ;

ALTER TABLE Contacto ADD CONSTRAINT Contacto_Usuario_FK FOREIGN KEY ( myid ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Contacto ADD CONSTRAINT Contacto_Usuario_FKv1 FOREIGN KEY ( idusuario ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Etiqueta ADD CONSTRAINT Etiqueta_Comentario_FK FOREIGN KEY ( idcomentario ) REFERENCES Comentario ( idcomentario ) ;

ALTER TABLE Etiqueta ADD CONSTRAINT Etiqueta_Multimedia_FK FOREIGN KEY ( idmultimedia ) REFERENCES Multimedia ( idmultimedia ) ;

ALTER TABLE Etiqueta ADD CONSTRAINT Etiqueta_Publicacion_FK FOREIGN KEY ( idpublicacion ) REFERENCES Publicacion ( idpublicacion ) ;

ALTER TABLE Etiqueta ADD CONSTRAINT Etiqueta_Usuario_FK FOREIGN KEY ( idusuario ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Grupo_usuario ADD CONSTRAINT FK_ASS_41 FOREIGN KEY ( idgrupo ) REFERENCES Grupo ( idgrupo ) ;

ALTER TABLE Grupo_usuario ADD CONSTRAINT FK_ASS_42 FOREIGN KEY ( idusuario ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Usuario_idioma ADD CONSTRAINT FK_ASS_43 FOREIGN KEY ( ididioma ) REFERENCES Idioma ( ididioma ) ;

ALTER TABLE Usuario_idioma ADD CONSTRAINT FK_ASS_44 FOREIGN KEY ( idusuario ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE "Like" ADD CONSTRAINT Like_Album_FK FOREIGN KEY ( idalbum ) REFERENCES Album ( idalbum ) ;

ALTER TABLE "Like" ADD CONSTRAINT Like_Comentario_FK FOREIGN KEY ( idcomentario ) REFERENCES Comentario ( idcomentario ) ;

ALTER TABLE "Like" ADD CONSTRAINT Like_Multimedia_FK FOREIGN KEY ( idmultimedia ) REFERENCES Multimedia ( idmultimedia ) ;

ALTER TABLE "Like" ADD CONSTRAINT Like_Publicacion_FK FOREIGN KEY ( idpublicacion ) REFERENCES Publicacion ( idpublicacion ) ;

ALTER TABLE "Like" ADD CONSTRAINT Like_Usuario_FK FOREIGN KEY ( idusuario ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Lista_contactos ADD CONSTRAINT Lista_contactos_Usuario_FK FOREIGN KEY ( idusuario ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Multimedia ADD CONSTRAINT Multimedia_Album_FK FOREIGN KEY ( idalbum ) REFERENCES Album ( idalbum ) ;

ALTER TABLE Multimedia ADD CONSTRAINT Multimedia_Lista_contactos_FK FOREIGN KEY ( idlista_contactos ) REFERENCES Lista_contactos ( idlista_contactos ) ;

ALTER TABLE Multimedia ADD CONSTRAINT Multimedia_Publicacion_FK FOREIGN KEY ( idpublicacion ) REFERENCES Publicacion ( idpublicacion ) ;

ALTER TABLE Multimedia ADD CONSTRAINT Multimedia_Tipo_contacto_FK FOREIGN KEY ( idtipo_contacto ) REFERENCES Tipo_contacto ( idtipo_contacto ) ;

ALTER TABLE Notificaciones ADD CONSTRAINT Notificaciones_Comentario_FK FOREIGN KEY ( idcomentario ) REFERENCES Comentario ( idcomentario ) ;

ALTER TABLE Notificaciones ADD CONSTRAINT Notificaciones_Like_FK FOREIGN KEY ( idlike ) REFERENCES "Like" ( idlike ) ;

ALTER TABLE Notificaciones ADD CONSTRAINT Notificaciones_Publicacion_FK FOREIGN KEY ( idpublicacion ) REFERENCES Publicacion ( idpublicacion ) ;

ALTER TABLE Publicacion ADD CONSTRAINT Publicacion_Grupo_FK FOREIGN KEY ( idgrupo ) REFERENCES Grupo ( idgrupo ) ;

ALTER TABLE Publicacion ADD CONSTRAINT Publicacion_Lista_contactos_FK FOREIGN KEY ( idlista_contactos ) REFERENCES Lista_contactos ( idlista_contactos ) ;

ALTER TABLE Publicacion ADD CONSTRAINT Publicacion_Tipo_contacto_FK FOREIGN KEY ( idtipo_contacto ) REFERENCES Tipo_contacto ( idtipo_contacto ) ;

ALTER TABLE Publicacion ADD CONSTRAINT Publicacion_Usuario_FK FOREIGN KEY ( idusuario_receiver ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Publicacion ADD CONSTRAINT Publicacion_Usuario_FKv1 FOREIGN KEY ( idusuario ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Solicitud ADD CONSTRAINT Solicitud_Usuario_FK FOREIGN KEY ( idusuario ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Solicitud ADD CONSTRAINT Solicitud_Usuario_FKv1 FOREIGN KEY ( idusuario_receiver ) REFERENCES Usuario ( idusuario ) ;

ALTER TABLE Usuario ADD CONSTRAINT Usuario_Situacion_FK FOREIGN KEY ( idsituacion ) REFERENCES Situacion_sentimental ( idsituacion ) ;


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            18
-- CREATE INDEX                             7
-- ALTER TABLE                             62
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
