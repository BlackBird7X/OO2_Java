CREATE SCHEMA `bd_sueldos`;

use bd_sueldos;

CREATE TABLE `bd_sueldos`.`empleado` (
  `idempleado` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` INT NOT NULL,
  `sueldobase` DOUBLE NOT NULL,
  `horainiciojornada` INT NOT NULL,
  `horafinjornada` INT NOT NULL,
  PRIMARY KEY (`idempleado`));

CREATE TABLE `bd_sueldos`.`operario` (
  `idoperario` INT NOT NULL,
  `plushoraextra` DOUBLE NOT NULL,
  PRIMARY KEY (`idoperario`),
  CONSTRAINT `fk_operario_empleado`
    FOREIGN KEY (`idoperario`)
    REFERENCES `bd_sueldos`.`empleado` (`idempleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bd_sueldos`.`supervisor` (
  `idsupervisor` INT NOT NULL,
  `pluspresentismo` DOUBLE NOT NULL,
  PRIMARY KEY (`idsupervisor`),
  CONSTRAINT `fk_supervisor_empleado`
    FOREIGN KEY (`idsupervisor`)
    REFERENCES `bd_sueldos`.`empleado` (`idempleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `bd_sueldos`.`fichada` (
  `idfichada` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NOT NULL,
  `hora` TIME NOT NULL,
  `entrada` BIT NOT NULL,
  `idempleado` INT NOT NULL,
  PRIMARY KEY (`idfichada`),
  INDEX `fk_fichada_empleado_idx` (`idempleado` ASC) VISIBLE,
  CONSTRAINT `fk_fichada_empleado`
    FOREIGN KEY (`idempleado`)
    REFERENCES `bd_sueldos`.`empleado` (`idempleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `bd_sueldos`.`empleado` (`nombre`, `apellido`, `dni`, `sueldobase`, `horainiciojornada`, `horafinjornada`) 
VALUES ("Nom1", "Ape1", 11111111, 100000, 9, 18);
INSERT INTO `bd_sueldos`.`empleado` (`nombre`, `apellido`, `dni`, `sueldobase`, `horainiciojornada`, `horafinjornada`) 
VALUES ("Nom2", "Ape2",22222222, 101000, 12, 18);
INSERT INTO `bd_sueldos`.`empleado` (`nombre`, `apellido`, `dni`, `sueldobase`, `horainiciojornada`, `horafinjornada`) 
VALUES ("Nom3", "Ape3", 33333333, 120000, 10, 18);

INSERT INTO `bd_sueldos`.`operario` (`idoperario`, `plushoraextra`) VALUES (1, 20);
INSERT INTO `bd_sueldos`.`operario` (`idoperario`, `plushoraextra`) VALUES (2, 10);
INSERT INTO `bd_sueldos`.`supervisor` (`idsupervisor`, `pluspresentismo`) VALUES (3, 15);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-04', '09:00:00', 1, 1);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-04', '12:00:00', 1, 2);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-04', '10:00:00', 1, 3);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-04', '18:00:00', 0, 1);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-04', '18:00:00', 0, 2);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-04', '18:00:00', 0, 3);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-05', '09:00:00', 1, 1);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-05', '12:00:00', 1, 2);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-05', '10:00:00', 1, 3);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-05', '20:30:00', 0, 1);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-05', '18:00:00', 0, 2);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-05', '18:00:00', 0, 3);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-06', '09:00:00', 1, 1);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-06', '12:00:00', 1, 2);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-06', '10:00:00', 1, 3);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-06', '18:00:00', 0, 1);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-06', '18:00:00', 0, 2);

INSERT INTO `bd_sueldos`.`fichada` (`fecha`, `hora`, `entrada`, `idempleado`)
VALUES ('2023-09-06', '18:00:00', 0, 3);