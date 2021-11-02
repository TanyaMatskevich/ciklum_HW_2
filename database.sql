CREATE DATABASE ciklumdb IF NOT EXISTS;

CREATE TABLE IF NOT EXISTS `ciklumdb`.`products` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `price` INT NOT NULL,
    `status` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;

    INSERT INTO products VALUES (1,"monitor", 115, "IN_STOCK");
    INSERT INTO products VALUES (2,"keyboard", 65, "IN_STOCK");
    INSERT INTO products VALUES (3,"cup", 16, "IN_STOCK");
    INSERT INTO products VALUES (4,"pen", 5, "IN_STOCK");