-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema metrobus
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema metrobus
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `metrobus` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `metrobus` ;

-- -----------------------------------------------------
-- Table `metrobus`.`ct_alcaldias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `metrobus`.`ct_alcaldias` (
  `id_alcaldia` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  PRIMARY KEY (`id_alcaldia`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `metrobus`.`ct_cp`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `metrobus`.`ct_cp` (
  `id_codigo_postal` INT NOT NULL AUTO_INCREMENT,
  `rango_final` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `rango_inicial` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `id_alcaldia` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_codigo_postal`),
  INDEX `id_alcaldia` (`id_alcaldia` ASC) VISIBLE,
  CONSTRAINT `ct_cp_ibfk_1`
    FOREIGN KEY (`id_alcaldia`)
    REFERENCES `metrobus`.`ct_alcaldias` (`id_alcaldia`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


-- -----------------------------------------------------
-- Table `metrobus`.`tb_ubicaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `metrobus`.`tb_ubicaciones` (
  `id` INT NOT NULL,
  `date_updated` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `geographic_point` VARCHAR(255) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `position_latitude` DOUBLE NULL DEFAULT NULL,
  `position_longitude` DOUBLE NULL DEFAULT NULL,
  `position_odometer` INT NULL DEFAULT NULL,
  `position_speed` INT NULL DEFAULT NULL,
  `vehicle_current_status` INT NULL DEFAULT NULL,
  `vehicle_id` INT NULL DEFAULT NULL,
  `vehicle_label` INT NULL DEFAULT NULL,
  `id_alcaldia` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_alcaldia` (`id_alcaldia` ASC) VISIBLE,
  CONSTRAINT `tb_ubicaciones_ibfk_1`
    FOREIGN KEY (`id_alcaldia`)
    REFERENCES `metrobus`.`ct_alcaldias` (`id_alcaldia`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
