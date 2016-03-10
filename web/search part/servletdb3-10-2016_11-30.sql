SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `servletsdb` DEFAULT CHARACTER SET utf8 ;
CREATE SCHEMA IF NOT EXISTS `biddingschema` DEFAULT CHARACTER SET utf8 ;
USE `servletsdb` ;

-- -----------------------------------------------------
-- Table `servletsdb`.`permission`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `servletsdb`.`permission` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `servletsdb`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `servletsdb`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `fname` VARCHAR(45) NOT NULL ,
  `lname` VARCHAR(45) NULL DEFAULT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(100) NULL DEFAULT NULL ,
  `birthdate` DATE NULL DEFAULT NULL ,
  `paypal` INT(11) NULL DEFAULT NULL ,
  `image_url` VARCHAR(150) NULL DEFAULT NULL ,
  `phone` VARCHAR(30) NULL DEFAULT NULL ,
  `address` VARCHAR(100) NULL DEFAULT NULL ,
  `permission_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_user_permission1` (`permission_id` ASC) ,
  CONSTRAINT `fk_user_permission1`
    FOREIGN KEY (`permission_id` )
    REFERENCES `servletsdb`.`permission` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `servletsdb`.`bill`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `servletsdb`.`bill` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `total_price` DOUBLE NOT NULL DEFAULT '0' ,
  `buy_date` DATE NOT NULL ,
  `user_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_bill_user1` (`user_id` ASC) ,
  CONSTRAINT `fk_bill_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `servletsdb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `servletsdb`.`category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `servletsdb`.`category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `image_url` VARCHAR(150) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `servletsdb`.`interests`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `servletsdb`.`interests` (
  `user_id` INT(11) NOT NULL ,
  `category_id` INT(11) NOT NULL ,
  PRIMARY KEY (`user_id`, `category_id`) ,
  INDEX `fk_interests_user` (`user_id` ASC) ,
  INDEX `fk_interests_category1` (`category_id` ASC) ,
  CONSTRAINT `fk_interests_category1`
    FOREIGN KEY (`category_id` )
    REFERENCES `servletsdb`.`category` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_interests_user`
    FOREIGN KEY (`user_id` )
    REFERENCES `servletsdb`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `servletsdb`.`product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `servletsdb`.`product` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `quantity` INT(11) NULL DEFAULT NULL ,
  `image_url` VARCHAR(100) NULL DEFAULT NULL ,
  `price` INT(11) NULL DEFAULT NULL ,
  `category_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_product_category1` (`category_id` ASC) ,
  CONSTRAINT `fk_product_category1`
    FOREIGN KEY (`category_id` )
    REFERENCES `servletsdb`.`category` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `servletsdb`.`order`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `servletsdb`.`order` (
  `bill_id` INT(11) NOT NULL ,
  `product_id` INT(11) NOT NULL ,
  `quantity` INT(11) NOT NULL ,
  PRIMARY KEY (`bill_id`, `product_id`) ,
  INDEX `fk_order_bill1` (`bill_id` ASC) ,
  INDEX `fk_order_product1` (`product_id` ASC) ,
  CONSTRAINT `fk_order_bill1`
    FOREIGN KEY (`bill_id` )
    REFERENCES `servletsdb`.`bill` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_product1`
    FOREIGN KEY (`product_id` )
    REFERENCES `servletsdb`.`product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `servletsdb`.`page`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `servletsdb`.`page` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL DEFAULT '/*' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `servletsdb`.`page_permission`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `servletsdb`.`page_permission` (
  `page_id` INT(11) NOT NULL ,
  `permission_id` INT(11) NOT NULL ,
  PRIMARY KEY (`page_id`, `permission_id`) ,
  INDEX `fk_page_permission_page1` (`page_id` ASC) ,
  INDEX `fk_page_permission_permission1` (`permission_id` ASC) ,
  CONSTRAINT `fk_page_permission_page1`
    FOREIGN KEY (`page_id` )
    REFERENCES `servletsdb`.`page` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_page_permission_permission1`
    FOREIGN KEY (`permission_id` )
    REFERENCES `servletsdb`.`permission` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `servletsdb`.`admin`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `servletsdb`.`admin` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `email` VARCHAR(100) NOT NULL ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(30) NULL DEFAULT NULL ,
  `address` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `biddingschema` ;

-- -----------------------------------------------------
-- Table `biddingschema`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `biddingschema`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `email` VARCHAR(50) NOT NULL ,
  `address` VARCHAR(150) NOT NULL ,
  `phone` VARCHAR(45) NULL DEFAULT NULL ,
  `mobile` VARCHAR(45) NULL DEFAULT NULL ,
  `date_of_birth` DATE NULL DEFAULT NULL ,
  `registration_date` DATE NOT NULL ,
  `user_name` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `full_name` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biddingschema`.`buyer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `biddingschema`.`buyer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `value` VARCHAR(150) NOT NULL ,
  `user_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) ,
  INDEX `fk_buyer_user1_idx` (`user_id` ASC) ,
  CONSTRAINT `fk_buyer_user1`
    FOREIGN KEY (`user_id` )
    REFERENCES `biddingschema`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biddingschema`.`seller`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `biddingschema`.`seller` (
  `id` INT(11) NOT NULL ,
  `value` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_email_user_idx` (`id` ASC) ,
  CONSTRAINT `fk_email_user`
    FOREIGN KEY (`id` )
    REFERENCES `biddingschema`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biddingschema`.`product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `biddingschema`.`product` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(150) NULL DEFAULT NULL ,
  `manufacturing_name` VARCHAR(100) NOT NULL ,
  `manufacturing_date` DATE NOT NULL ,
  `expiration_date` DATE NULL DEFAULT NULL ,
  `seller_id` INT(11) NULL DEFAULT NULL ,
  `quantity` INT(11) NOT NULL ,
  `offered_date` DATE NOT NULL ,
  `finish_date` DATE NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_product_seller1_idx` (`seller_id` ASC) ,
  CONSTRAINT `fk_product_seller1`
    FOREIGN KEY (`seller_id` )
    REFERENCES `biddingschema`.`seller` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biddingschema`.`buyer_bid_product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `biddingschema`.`buyer_bid_product` (
  `buyer_id` INT(11) NOT NULL ,
  `product_id` INT(11) NOT NULL ,
  `date` DATE NOT NULL ,
  `amount` FLOAT NOT NULL ,
  `quantity` INT(11) NOT NULL ,
  PRIMARY KEY (`buyer_id`, `product_id`) ,
  INDEX `fk_buyer_has_product_product1_idx` (`product_id` ASC) ,
  INDEX `fk_buyer_has_product_buyer1_idx` (`buyer_id` ASC) ,
  CONSTRAINT `fk_buyer_has_product_buyer1`
    FOREIGN KEY (`buyer_id` )
    REFERENCES `biddingschema`.`buyer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_buyer_has_product_product1`
    FOREIGN KEY (`product_id` )
    REFERENCES `biddingschema`.`product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biddingschema`.`buyer_buy_product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `biddingschema`.`buyer_buy_product` (
  `buyer_id` INT(11) NOT NULL ,
  `product_id` INT(11) NOT NULL ,
  `payment_date` DATE NOT NULL ,
  `amount` FLOAT NOT NULL ,
  `quantity` INT(11) NOT NULL ,
  PRIMARY KEY (`buyer_id`, `product_id`) ,
  INDEX `fk_buyer_has_product_product2_idx` (`product_id` ASC) ,
  INDEX `fk_buyer_has_product_buyer2_idx` (`buyer_id` ASC) ,
  CONSTRAINT `fk_buyer_has_product_buyer2`
    FOREIGN KEY (`buyer_id` )
    REFERENCES `biddingschema`.`buyer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_buyer_has_product_product2`
    FOREIGN KEY (`product_id` )
    REFERENCES `biddingschema`.`product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biddingschema`.`category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `biddingschema`.`category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `value` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(150) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `biddingschema`.`product_has_category`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `biddingschema`.`product_has_category` (
  `product_id` INT(11) NOT NULL ,
  `category_id` INT(11) NOT NULL ,
  PRIMARY KEY (`product_id`, `category_id`) ,
  INDEX `fk_product_has_category_category1_idx` (`category_id` ASC) ,
  INDEX `fk_product_has_category_product1_idx` (`product_id` ASC) ,
  CONSTRAINT `fk_product_has_category_category1`
    FOREIGN KEY (`category_id` )
    REFERENCES `biddingschema`.`category` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_has_category_product1`
    FOREIGN KEY (`product_id` )
    REFERENCES `biddingschema`.`product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
