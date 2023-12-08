CREATE SCHEMA `alquileres` DEFAULT CHARACTER SET utf8 ;

use `alquileres`;

CREATE TABLE `alquileres`.`propiedad` (
  `idpropiedad` INT NOT NULL AUTO_INCREMENT,
  `preciobase` DOUBLE NULL,
  `direccion` VARCHAR(100) NULL,
  PRIMARY KEY (`idpropiedad`));

CREATE TABLE `alquileres`.`casa` (
  `idpropiedad` INT NOT NULL,
  `tienepatio` BIT(1) NULL,
  PRIMARY KEY (`idpropiedad`),
  CONSTRAINT `FK_PROP_CASA`
    FOREIGN KEY (`idpropiedad`)
    REFERENCES `alquileres`.`propiedad` (`idpropiedad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `alquileres`.`departamento` (
  `idpropiedad` INT NOT NULL,
  `cantidadambientes` INT NULL,
  `nropiso` INT NULL,
  `tieneascensor` BIT(1) NULL,
  PRIMARY KEY (`idpropiedad`));

ALTER TABLE `alquileres`.`departamento` 
ADD CONSTRAINT `FK_DEPTO_PROP`
  FOREIGN KEY (`idpropiedad`)
  REFERENCES `alquileres`.`propiedad` (`idpropiedad`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `alquileres`.`alquiler` (
  `idalquiler` INT NOT NULL AUTO_INCREMENT,
  `fechadesde` DATE NULL,
  `fechahasta` DATE NULL,
  `cantidadnoches` INT NULL,
  `idpropiedad` INT NULL,
  PRIMARY KEY (`idalquiler`),
  INDEX `FK_ALQ_PROP_idx` (`idpropiedad` ASC) VISIBLE,
  CONSTRAINT `FK_ALQ_PROP`
    FOREIGN KEY (`idpropiedad`)
    REFERENCES `alquileres`.`propiedad` (`idpropiedad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `alquileres`.`propiedad` (`preciobase`, `direccion`) VALUES (100, "calle 1");
INSERT INTO `alquileres`.`propiedad` (`preciobase`, `direccion`) VALUES (200, "calle 2");
INSERT INTO `alquileres`.`propiedad` (`preciobase`, `direccion`) VALUES (300, "calle 3");
INSERT INTO `alquileres`.`propiedad` (`preciobase`, `direccion`) VALUES (400, "calle 4");
INSERT INTO `alquileres`.`propiedad` (`preciobase`, `direccion`) VALUES (400, "calle 5");

INSERT INTO `alquileres`.`casa` (`idpropiedad`, `tienepatio`) VALUES (1, 0);
INSERT INTO `alquileres`.`casa` (`idpropiedad`, `tienepatio`) VALUES (2, 1);

INSERT INTO `alquileres`.`departamento` (`idpropiedad`, `cantidadambientes`, `nropiso`, `tieneascensor`) VALUES (3, 1, 4, 1);
INSERT INTO `alquileres`.`departamento` (`idpropiedad`, `cantidadambientes`, `nropiso`, `tieneascensor`) VALUES (4, 2, 1, 1);
INSERT INTO `alquileres`.`departamento` (`idpropiedad`, `cantidadambientes`, `nropiso`, `tieneascensor`) VALUES (5, 2, 1, 0);

INSERT INTO `alquileres`.`alquiler` (`fechadesde`, `fechahasta`, `cantidadnoches`, `idpropiedad`) VALUES("2022-03-01","2022-03-05", 4,1);
INSERT INTO `alquileres`.`alquiler` (`fechadesde`, `fechahasta`, `cantidadnoches`, `idpropiedad`) VALUES("2022-03-03","2022-03-05",2,2);
INSERT INTO `alquileres`.`alquiler` (`fechadesde`, `fechahasta`, `cantidadnoches`, `idpropiedad`) VALUES("2022-03-05","2022-03-09",4,3);
INSERT INTO `alquileres`.`alquiler` (`fechadesde`, `fechahasta`, `cantidadnoches`, `idpropiedad`) VALUES("2022-03-07","2022-03-10",2,4);

