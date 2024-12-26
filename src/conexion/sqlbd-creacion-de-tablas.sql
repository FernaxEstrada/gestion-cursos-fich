-- Creacion de la Base de Datos
create database db_gestion_de_cursos_de_capacitacion;

drop database db_gestion_de_cursos_de_capacitacion;

drop table if exists persona;

drop table if exists usuario;

drop table if exists especialidad;

drop table if exists capacitador_especialidad;

drop table if exists ubicacion;

drop table if exists categoria;

drop table if exists curso;

drop table if exists carrera;

drop table if exists curso_carrera;

drop table if exists dia;

drop table if exists curso_dia;

drop table if exists capacitador_curso;

drop table if exists inscripcion;

create table persona (
    perci varchar(12) primary key,
    perapellidos varchar(100) not null,
    pernombres varchar(100) not null,
    persexo char(1) not null,
    pertelefono varchar(20) not null,
    perdireccion varchar(100) not null,
    estnumregistro varchar(12),
    tipoe char(1),
    tipop char(1),
    tipoa char(1),
    tipoc char(1)
);

create table usuario (
    perci varchar(12) primary key,
    usucontrasena varchar(100) not null,
    foreign key (perci) references persona (perci) on delete cascade on update cascade
);

create table especialidad (
    espeid serial primary key,
    espenombre varchar(100) not null
);

create table capacitador_especialidad (
    perci varchar(12),
    espeid int,
    primary key (perci, espeid),
    foreign key (perci) references persona (perci) on delete cascade on update cascade,
    foreign key (espeid) references especialidad (espeid) on delete cascade on update cascade
);

create table ubicacion (
    ubiid serial primary key,
    ubinombre varchar(100) not null
);

create table categoria (
    catid serial primary key,
    catnombre varchar(100) not null
);

create table curso (
    curid serial primary key,
    curtitulo varchar(100) not null,
    curdescripcion varchar(200) not null,
    curfechainicio date not null,
    curfechafin date not null,
    curcupomaximo int,
    curcostoestudiante float default 0,
    curcostoprofesional float default 0,
    ubiid int not null,
    catid int not null,
    foreign key (ubiid) references ubicacion (ubiid) on delete cascade on update cascade,
    foreign key (catid) references categoria (catid) on delete cascade on update cascade
);

create table carrera (
    carcodigo varchar(5),
    carplan char(1),
    carnombre varchar(100) not null,
    primary key (carcodigo, carplan)
);

create table curso_carrera (
    carcodigo varchar(5),
    carplan char(1),
    curid int,
    primary key (carcodigo, carplan, curid),
    foreign key (carcodigo, carplan) references carrera (carcodigo, carplan) on delete cascade on update cascade,
    foreign key (curid) references curso (curid) on delete cascade on update cascade
);

create table dia (
    diaid serial primary key,
    dianombre varchar(50) not null
);

create table curso_dia (
    curid int,
    diaid int,
    curdiahorainicio time not null,
    curdiahorafin time not null,
    primary key (curid, diaid),
    foreign key (curid) references curso (curid) on delete cascade on update cascade,
    foreign key (diaid) references dia (diaid) on delete cascade on update cascade
);

create table capacitador_curso (
    perci varchar(12),
    curid int,
    primary key (perci, curid),
    foreign key (perci) references persona (perci) on delete cascade on update cascade,
    foreign key (curid) references curso (curid) on delete cascade on update cascade
);

create table inscripcion (
    curid int,
    perci varchar(12),
    insfecha date default current_date,
    inspago float default 0,
    primary key (curid, perci),
    foreign key (curid) references curso (curid) on delete cascade on update cascade,
    foreign key (perci) references persona (perci) on delete cascade on update cascade
);

/*CREACION DE UN PERSONAL ADMINISTRADOR Y SU CUENTA DE USUARIO */
insert into
    personal (
        ci,
        nombre,
        sexo,
        celular,
        direccion
    )
values (
        '86343',
        'Administrador del Sistema por defecto',
        'M',
        '8987443',
        'Calle Guzman #23'
    );

insert into administrador (ci) values ('86343');

insert into
    usuario (
        username,
        password,
        ci_personal
    )
values (
        'admin',
        md5('admin'),
        '86343'
    );

--CONSULTA PARA VERIFICACION DE USUARIO
select *
from usuario
where
    username = 'admin'
    and password = md5('admin');

--VENDEDOR
insert into
    personal (
        ci,
        nombre,
        sexo,
        celular,
        direccion
    )
values (
        '83874',
        'Hector Rodriguez de la Cuenca',
        'M',
        '8692555',
        'Calle Rivadavia #28'
    );

insert into vendedor (ci, comision) values ('83874', '25');
--su cuenta de usuario
insert into
    usuario (
        username,
        password,
        ci_personal
    )
values ('ven', md5('ven'), '83874');

--SECRETARIA
insert into
    personal (
        ci,
        nombre,
        sexo,
        celular,
        direccion
    )
values (
        '86353',
        'Yamile Higueroa Quiñonez',
        'F',
        '8635234',
        'Sin # calle'
    );

insert into secretaria (ci) values ('86353');
--su cuenta de usuario
insert into
    usuario (
        username,
        password,
        ci_personal
    )
values ('sec', md5('sec'), '86353');

--GERENTE
insert into
    personal (
        ci,
        nombre,
        sexo,
        celular,
        direccion
    )
values (
        '986353',
        'Wilma Torrez W.',
        'F',
        '8673244',
        'Barrio Lindo #28'
    );

insert into
    gerente (ci, profesion)
values (
        '986353',
        'Administrador de Empresas'
    );

--CLIENTE
insert into
    cliente
values (
        '1010',
        'Ricardo Shilishali G.',
        'Calle #53 B/Linido',
        'M',
        '3'
    ),
    (
        '1011',
        'Juana Roldan W.',
        'Calle #35 B/Los cascos',
        'F',
        '23'
    ),
    (
        '1012',
        'Yobana Guzman Arteaga.',
        'Calle #12 ',
        'F',
        '8'
    );

--UNIDAD MEDIDA
insert into
    unidad_medida (descripcion, abrev)
values ('Metros', 'Mts'),
    ('Litros', 'Lts'),
    ('Unidad', 'Und'),
    ('Kilógramo', 'Kg');

--PRODUCTOS
insert into
    producto
values (
        'PROD001',
        'Arroz',
        '7.50',
        '4'
    ),
    ('PROD002', 'Fideo', '9', '4'),
    (
        'PROD003',
        'Aceite',
        '10',
        '2'
    );

--PROVEEDOR
insert into
    proveedor (nombre, direccion)
values (
        'Guillermo Terrazas E.',
        'Calle #35'
    );