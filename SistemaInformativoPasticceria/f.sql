-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: mydb, fortino
-- Source Schemata: , fortino
-- Created: Thu Jul 23 17:56:13 2020
-- Workbench Version: 6.3.8
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema mydb
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;

-- ----------------------------------------------------------------------------
-- Schema fortino
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `fortino` ;
CREATE SCHEMA IF NOT EXISTS `fortino` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

-- ----------------------------------------------------------------------------
-- Table fortino.assenzalavoro
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`assenzalavoro` (
  `dipendente_cf` VARCHAR(16) NOT NULL,
  `giorno_inizio` VARCHAR(10) NOT NULL,
  `giorni_totali` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`dipendente_cf`, `giorno_inizio`),
  CONSTRAINT `fk_assenzalavoro_dipendente1`
    FOREIGN KEY (`dipendente_cf`)
    REFERENCES `fortino`.`dipendente` (`cf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.attrezzatura
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`attrezzatura` (
  `seriale` INT(11) NOT NULL,
  `descrizione` VARCHAR(45) NULL DEFAULT NULL,
  `data_acquisto` VARCHAR(10) NULL DEFAULT NULL,
  `periodicita_intervento` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`seriale`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.cliente
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`cliente` (
  `piva` VARCHAR(16) NOT NULL,
  `nome` VARCHAR(80) NULL DEFAULT NULL,
  `telefono` VARCHAR(10) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `sede` VARCHAR(45) NULL DEFAULT NULL,
  `username` VARCHAR(20) NULL DEFAULT NULL,
  `password` VARCHAR(16) NULL DEFAULT NULL,
  `tipo` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`piva`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.consegna
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`consegna` (
  `id` INT(11) NOT NULL,
  `data` VARCHAR(10) NULL DEFAULT NULL,
  `addetto_consegne_cf` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_consegna_dipendente1_idx` (`addetto_consegne_cf` ASC),
  CONSTRAINT `fk_consegna_dipendente1`
    FOREIGN KEY (`addetto_consegne_cf`)
    REFERENCES `fortino`.`dipendente` (`cf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.contrattopubblicitario
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`contrattopubblicitario` (
  `fornitore_extra_piva` VARCHAR(16) NOT NULL,
  `data` VARCHAR(10) NOT NULL,
  `descrizione` VARCHAR(45) NULL DEFAULT NULL,
  `durata` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`fornitore_extra_piva`, `data`),
  CONSTRAINT `fk_contrattopubblicitario_fornitore1`
    FOREIGN KEY (`fornitore_extra_piva`)
    REFERENCES `fortino`.`fornitore` (`piva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.dettagliofornituramateriaprima
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`dettagliofornituramateriaprima` (
  `quantita` INT(11) NULL DEFAULT NULL,
  `fornitura_id` INT(11) NOT NULL,
  `materiaprima_codice` INT(11) NOT NULL,
  `prezzo_unitario` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`fornitura_id`, `materiaprima_codice`),
  INDEX `fk_dettagliofornituramateriaprima_materiaprima1_idx` (`materiaprima_codice` ASC),
  CONSTRAINT `fk_dettagliofornituramateriaprima_fornitura1`
    FOREIGN KEY (`fornitura_id`)
    REFERENCES `fortino`.`fornitura` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dettagliofornituramateriaprima_materiaprima1`
    FOREIGN KEY (`materiaprima_codice`)
    REFERENCES `fortino`.`materiaprima` (`codice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.dettaglioforniturautenza
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`dettaglioforniturautenza` (
  `fornitura_id` INT(11) NOT NULL,
  `utenza_codice` INT(11) NOT NULL,
  `quantita` DOUBLE NULL DEFAULT NULL,
  `prezzo_unitario` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`fornitura_id`, `utenza_codice`),
  INDEX `fk_dettaglioforniturautenza_utenza1_idx` (`utenza_codice` ASC),
  CONSTRAINT `fk_dettaglioforniturautenza_fornitura1`
    FOREIGN KEY (`fornitura_id`)
    REFERENCES `fortino`.`fornitura` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dettaglioforniturautenza_utenza1`
    FOREIGN KEY (`utenza_codice`)
    REFERENCES `fortino`.`utenza` (`codice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.dettaglioordine
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`dettaglioordine` (
  `quantita` INT(11) NULL DEFAULT NULL,
  `ordine_id` INT(11) NOT NULL,
  `magazzinouscita_prodottofinito_codice` INT(11) NOT NULL,
  INDEX `fk_dettaglioordine_ordine1_idx` (`ordine_id` ASC),
  INDEX `fk_dettaglioordine_magazzinouscita1_idx` (`magazzinouscita_prodottofinito_codice` ASC),
  CONSTRAINT `fk_dettaglioordine_magazzinouscita1`
    FOREIGN KEY (`magazzinouscita_prodottofinito_codice`)
    REFERENCES `fortino`.`magazzinouscita` (`prodottofinito_codice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dettaglioordine_ordine1`
    FOREIGN KEY (`ordine_id`)
    REFERENCES `fortino`.`ordine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.dipendente
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`dipendente` (
  `cf` VARCHAR(16) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `cognome` VARCHAR(45) NULL DEFAULT NULL,
  `telefono` VARCHAR(10) NULL DEFAULT NULL,
  `tipo` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`cf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.fatturaacquisto
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`fatturaacquisto` (
  `n_protocollo` INT(11) NOT NULL,
  `numero` INT(11) NULL DEFAULT NULL,
  `anno` INT(11) NULL DEFAULT NULL,
  `data` VARCHAR(10) NULL DEFAULT NULL,
  `importo` DOUBLE NULL DEFAULT NULL,
  `fornitura_id` INT(11) NOT NULL,
  `tipo` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`n_protocollo`),
  INDEX `fk_fatturaacquisto_fornitura1_idx` (`fornitura_id` ASC),
  CONSTRAINT `fk_fatturaacquisto_fornitura1`
    FOREIGN KEY (`fornitura_id`)
    REFERENCES `fortino`.`fornitura` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.fatturavendita
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`fatturavendita` (
  `numero` INT(11) NOT NULL,
  `anno` INT(11) NOT NULL,
  `data` VARCHAR(10) NULL DEFAULT NULL,
  `importo` DOUBLE NULL DEFAULT NULL,
  `ordine_id` INT(11) NOT NULL,
  `consegna_id` INT(11) NOT NULL,
  PRIMARY KEY (`numero`, `anno`),
  INDEX `fk_fatturavendita_ordine1_idx` (`ordine_id` ASC),
  INDEX `fk_fatturavendita_consegna1_idx` (`consegna_id` ASC),
  CONSTRAINT `fk_fatturavendita_consegna1`
    FOREIGN KEY (`consegna_id`)
    REFERENCES `fortino`.`consegna` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_fatturavendita_ordine1`
    FOREIGN KEY (`ordine_id`)
    REFERENCES `fortino`.`ordine` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.fornitore
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`fornitore` (
  `piva` VARCHAR(16) NOT NULL,
  `nome` VARCHAR(80) NULL DEFAULT NULL,
  `telefono` VARCHAR(10) NULL DEFAULT NULL,
  `sede` VARCHAR(45) NULL DEFAULT NULL,
  `tipo` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`piva`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.fornitura
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`fornitura` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(10) NULL DEFAULT NULL,
  `tipo` CHAR(1) NULL DEFAULT NULL,
  `fornitore_piva` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fornitura_fornitore_idx` (`fornitore_piva` ASC),
  CONSTRAINT `fk_fornitura_fornitore`
    FOREIGN KEY (`fornitore_piva`)
    REFERENCES `fortino`.`fornitore` (`piva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.magazzinoingresso
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`magazzinoingresso` (
  `quantita` INT(11) NOT NULL,
  `materiaprima_codice` INT(11) NOT NULL,
  PRIMARY KEY (`materiaprima_codice`),
  INDEX `fk_magazzinoingresso_materiaprima1_idx` (`materiaprima_codice` ASC),
  CONSTRAINT `fk_magazzinoingresso_materiaprima1`
    FOREIGN KEY (`materiaprima_codice`)
    REFERENCES `fortino`.`materiaprima` (`codice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.magazzinouscita
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`magazzinouscita` (
  `quantita` INT(11) NULL DEFAULT NULL,
  `prodottofinito_codice` INT(11) NOT NULL,
  PRIMARY KEY (`prodottofinito_codice`),
  CONSTRAINT `fk_magazzinouscita_prodottofinito1`
    FOREIGN KEY (`prodottofinito_codice`)
    REFERENCES `fortino`.`prodottofinito` (`codice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.manutenzione
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`manutenzione` (
  `data` VARCHAR(10) NOT NULL,
  `descrizione` VARCHAR(80) NULL DEFAULT NULL,
  `tipo` VARCHAR(1) NULL DEFAULT NULL,
  `fornitore_extra_piva` VARCHAR(16) NOT NULL,
  `dipendente_cf` VARCHAR(16) NOT NULL,
  `attrezzatura_seriale` INT(11) NOT NULL,
  PRIMARY KEY (`data`),
  INDEX `fk_manutenzione_fornitore1_idx` (`fornitore_extra_piva` ASC),
  INDEX `fk_manutenzione_dipendente1_idx` (`dipendente_cf` ASC),
  INDEX `fk_manutenzione_attrezzatura1_idx` (`attrezzatura_seriale` ASC),
  CONSTRAINT `fk_manutenzione_attrezzatura1`
    FOREIGN KEY (`attrezzatura_seriale`)
    REFERENCES `fortino`.`attrezzatura` (`seriale`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_manutenzione_dipendente1`
    FOREIGN KEY (`dipendente_cf`)
    REFERENCES `fortino`.`dipendente` (`cf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_manutenzione_fornitore1`
    FOREIGN KEY (`fornitore_extra_piva`)
    REFERENCES `fortino`.`fornitore` (`piva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.materiaprima
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`materiaprima` (
  `codice` INT(11) NOT NULL AUTO_INCREMENT,
  `descrizione` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`codice`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.orariolavoro
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`orariolavoro` (
  `inizio` INT(11) NOT NULL,
  `quantita` INT(11) NOT NULL,
  PRIMARY KEY (`inizio`, `quantita`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.ordine
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`ordine` (
  `id` INT(11) NOT NULL,
  `data` VARCHAR(10) NULL DEFAULT NULL,
  `tipo` VARCHAR(1) NULL DEFAULT NULL,
  `cliente_piva` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ordine_cliente1_idx` (`cliente_piva` ASC),
  CONSTRAINT `fk_ordine_cliente1`
    FOREIGN KEY (`cliente_piva`)
    REFERENCES `fortino`.`cliente` (`piva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.prodottofinito
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`prodottofinito` (
  `codice` INT(11) NOT NULL,
  `descrizione` VARCHAR(45) NULL DEFAULT NULL,
  `durata_freschezza` INT(11) NULL DEFAULT NULL,
  `tipo` VARCHAR(1) NULL DEFAULT NULL,
  `prezzo_unitario` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`codice`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.produzione
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`produzione` (
  `num_lotto` INT(11) NOT NULL,
  `data` VARCHAR(10) NULL DEFAULT NULL,
  `quantita` VARCHAR(45) NULL DEFAULT NULL,
  `capoproduzione_cf` VARCHAR(16) NOT NULL,
  `dipendente_cf` VARCHAR(16) NOT NULL,
  `prodottofinito_codice` INT(11) NOT NULL,
  `tipo` VARCHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`num_lotto`),
  INDEX `fk_produzione_dipendente1_idx` (`capoproduzione_cf` ASC),
  INDEX `fk_produzione_dipendente2_idx` (`dipendente_cf` ASC),
  INDEX `fk_produzione_prodottofinito1_idx` (`prodottofinito_codice` ASC),
  CONSTRAINT `fk_produzione_dipendente1`
    FOREIGN KEY (`capoproduzione_cf`)
    REFERENCES `fortino`.`dipendente` (`cf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produzione_dipendente2`
    FOREIGN KEY (`dipendente_cf`)
    REFERENCES `fortino`.`dipendente` (`cf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_produzione_prodottofinito1`
    FOREIGN KEY (`prodottofinito_codice`)
    REFERENCES `fortino`.`prodottofinito` (`codice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.ricetta
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`ricetta` (
  `quantita` INT(11) NULL DEFAULT NULL,
  `prodottofinito_codice` INT(11) NOT NULL,
  `magazzinoingresso_materiaprima_codice` INT(11) NOT NULL,
  PRIMARY KEY (`prodottofinito_codice`, `magazzinoingresso_materiaprima_codice`),
  INDEX `fk_ricetta_magazzinoingresso1_idx` (`magazzinoingresso_materiaprima_codice` ASC),
  CONSTRAINT `fk_ricetta_magazzinoingresso1`
    FOREIGN KEY (`magazzinoingresso_materiaprima_codice`)
    REFERENCES `fortino`.`magazzinoingresso` (`materiaprima_codice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ricetta_prodottofinito1`
    FOREIGN KEY (`prodottofinito_codice`)
    REFERENCES `fortino`.`prodottofinito` (`codice`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.turnolavoro
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`turnolavoro` (
  `dipendente_cf` VARCHAR(16) NOT NULL,
  `orariolavoro_inizio` INT(11) NOT NULL,
  `orariolavoro_quantita` INT(11) NOT NULL,
  `giorno` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`dipendente_cf`, `orariolavoro_inizio`, `orariolavoro_quantita`, `giorno`),
  INDEX `fk_turnolavoro_orariolavoro1_idx` (`orariolavoro_inizio` ASC, `orariolavoro_quantita` ASC),
  CONSTRAINT `fk_turnolavoro_dipendente1`
    FOREIGN KEY (`dipendente_cf`)
    REFERENCES `fortino`.`dipendente` (`cf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_turnolavoro_orariolavoro1`
    FOREIGN KEY (`orariolavoro_inizio` , `orariolavoro_quantita`)
    REFERENCES `fortino`.`orariolavoro` (`inizio` , `quantita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.utente
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`utente` (
  `username` VARCHAR(16) NOT NULL,
  `password` VARCHAR(16) NULL DEFAULT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

-- ----------------------------------------------------------------------------
-- Table fortino.utenza
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `fortino`.`utenza` (
  `codice` INT(11) NOT NULL AUTO_INCREMENT,
  `descrizione` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`codice`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;
SET FOREIGN_KEY_CHECKS = 1;
