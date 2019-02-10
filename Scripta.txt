-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema newdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema newdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `newdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `newdb` ;

-- -----------------------------------------------------
-- Table `newdb`.`file_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `newdb`.`file_info` (
  `file_id` INT(11) NOT NULL AUTO_INCREMENT,
  `file_name` VARCHAR(45) NOT NULL,
  `file_date` DATETIME NOT NULL,
  PRIMARY KEY (`file_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;