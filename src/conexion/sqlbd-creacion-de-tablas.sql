-- Creacion de la Base de Datos
create database db_gestion_de_cursos_de_capacitacion;

-- Eliminacion de la Base de Datos
drop database db_gestion_de_cursos_de_capacitacion;

-- Creacion de Tablas
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
