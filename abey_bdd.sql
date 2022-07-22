-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           10.4.24-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Listage de la structure de la base pour abey_bdd
DROP DATABASE IF EXISTS `abey_bdd`;
CREATE DATABASE IF NOT EXISTS `abey_bdd` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `abey_bdd`;

-- Listage de la structure de table abey_bdd. address
DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `id_address` int(11) NOT NULL AUTO_INCREMENT,
  `street_number` varchar(250) DEFAULT NULL,
  `street_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_address`),
  KEY `FK_address_street` (`street_id`),
  CONSTRAINT `FK_address_street` FOREIGN KEY (`street_id`) REFERENCES `street` (`id_street`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. application
DROP TABLE IF EXISTS `application`;
CREATE TABLE IF NOT EXISTS `application` (
  `id_application` int(11) NOT NULL AUTO_INCREMENT,
  `date_start_traffic` date DEFAULT NULL,
  `date_end_traffic` date DEFAULT NULL,
  `typical_day_id` int(11) DEFAULT NULL,
  `timetable_stop_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_application`),
  KEY `FK_application_typical_day` (`typical_day_id`) USING BTREE,
  KEY `FK_application_timetable_stop` (`timetable_stop_id`) USING BTREE,
  CONSTRAINT `FK_application_timetable_stop` FOREIGN KEY (`timetable_stop_id`) REFERENCES `timetable_stop` (`id_timetable_stop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_application_typical_day` FOREIGN KEY (`typical_day_id`) REFERENCES `typical_day` (`id_typical_day`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. attribution
DROP TABLE IF EXISTS `attribution`;
CREATE TABLE IF NOT EXISTS `attribution` (
  `id_attribution` int(11) NOT NULL AUTO_INCREMENT,
  `date_start_attribution` date DEFAULT NULL,
  `date_end_attribution` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `line_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_attribution`),
  KEY `FK_attribution_user` (`user_id`),
  KEY `FK_attribution_line` (`line_id`),
  CONSTRAINT `FK_attribution_line` FOREIGN KEY (`line_id`) REFERENCES `line` (`id_line`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_attribution_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. bank_holiday
DROP TABLE IF EXISTS `bank_holiday`;
CREATE TABLE IF NOT EXISTS `bank_holiday` (
  `id_bank_holiday` int(11) NOT NULL AUTO_INCREMENT,
  `date_bank_holiday` date DEFAULT NULL,
  `label_bank_holiday` varchar(250) DEFAULT NULL,
  `school_year_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_bank_holiday`),
  KEY `FK_bank_holiday_school_year` (`school_year_id`),
  CONSTRAINT `FK_bank_holiday_school_year` FOREIGN KEY (`school_year_id`) REFERENCES `school_year` (`id_school_year`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. booking
DROP TABLE IF EXISTS `booking`;
CREATE TABLE IF NOT EXISTS `booking` (
  `id_booking` int(11) NOT NULL AUTO_INCREMENT,
  `date_start_travel_booking` date DEFAULT NULL,
  `date_end_travel_booking` date DEFAULT NULL,
  `child_id` int(11) DEFAULT NULL,
  `trip_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_booking`) USING BTREE,
  KEY `FK_booking_child` (`child_id`),
  KEY `FK_booking_trip` (`trip_id`),
  CONSTRAINT `FK_booking_child` FOREIGN KEY (`child_id`) REFERENCES `child` (`id_child`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_booking_trip` FOREIGN KEY (`trip_id`) REFERENCES `booking` (`id_booking`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. child
DROP TABLE IF EXISTS `child`;
CREATE TABLE IF NOT EXISTS `child` (
  `id_child` int(11) NOT NULL AUTO_INCREMENT,
  `name_child` varchar(250) DEFAULT NULL,
  `firstname_child` varchar(250) DEFAULT NULL,
  `birthdate_child` date DEFAULT NULL,
  `child_unavaibility_id` int(11) DEFAULT NULL,
  `user_id_1` int(11) DEFAULT NULL,
  `user_id_2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_child`),
  KEY `FK_child_child_unavaibility` (`child_unavaibility_id`),
  KEY `FK_child_user_1` (`user_id_1`),
  KEY `FK_child_user_2` (`user_id_2`),
  CONSTRAINT `FK_child_child_unavaibility` FOREIGN KEY (`child_unavaibility_id`) REFERENCES `child_unavaibility` (`id_child_unavaibility`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_child_user_1` FOREIGN KEY (`user_id_1`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_child_user_2` FOREIGN KEY (`user_id_2`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. child_unavaibility
DROP TABLE IF EXISTS `child_unavaibility`;
CREATE TABLE IF NOT EXISTS `child_unavaibility` (
  `id_child_unavaibility` int(11) NOT NULL AUTO_INCREMENT,
  `date_start_child_unaivability` date DEFAULT NULL,
  `date_end_child_unaivability` date DEFAULT NULL,
  PRIMARY KEY (`id_child_unavaibility`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. city
DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `id_city` int(11) NOT NULL AUTO_INCREMENT,
  `name_city` varchar(250) DEFAULT NULL,
  `zip_code` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_city`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. line
DROP TABLE IF EXISTS `line`;
CREATE TABLE IF NOT EXISTS `line` (
  `id_line` int(11) NOT NULL AUTO_INCREMENT,
  `name_line` varchar(250) DEFAULT NULL,
  `date_creation_line` date DEFAULT NULL,
  `date_end_line` date DEFAULT NULL,
  PRIMARY KEY (`id_line`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. participation
DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `id_participation` int(11) NOT NULL AUTO_INCREMENT,
  `date_request` date DEFAULT NULL,
  `date_attribution` date DEFAULT NULL,
  `date_termination` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_participation`),
  KEY `FK_participation_role` (`role_id`),
  KEY `FK_participation_user` (`user_id`),
  CONSTRAINT `FK_participation_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id_role`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_participation_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. preference_line
DROP TABLE IF EXISTS `preference_line`;
CREATE TABLE IF NOT EXISTS `preference_line` (
  `id_preference_line` int(11) NOT NULL AUTO_INCREMENT,
  `date_attribution_preference_line` date DEFAULT NULL,
  `date_canceling_preference_line` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `line_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_preference_line`),
  KEY `FK_preference_line_user` (`user_id`),
  KEY `FK_prefrence_line_line` (`line_id`),
  CONSTRAINT `FK_preference_line_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_prefrence_line_line` FOREIGN KEY (`line_id`) REFERENCES `line` (`id_line`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. preference_td
DROP TABLE IF EXISTS `preference_td`;
CREATE TABLE IF NOT EXISTS `preference_td` (
  `id_preference_td` int(11) NOT NULL AUTO_INCREMENT,
  `date_preference_td` date DEFAULT NULL,
  `date_cancelation_preference_td` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `typical_day_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_preference_td`),
  KEY `FK_preference_td_user` (`user_id`),
  KEY `FK_preference_td_typical_day` (`typical_day_id`),
  CONSTRAINT `FK_preference_td_typical_day` FOREIGN KEY (`typical_day_id`) REFERENCES `typical_day` (`id_typical_day`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_preference_td_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. preference_timeslot
DROP TABLE IF EXISTS `preference_timeslot`;
CREATE TABLE IF NOT EXISTS `preference_timeslot` (
  `id_preference_timeslot` int(11) NOT NULL AUTO_INCREMENT,
  `date_validation_preference_timeslot` date DEFAULT NULL,
  `date_cancelation_preference_timeslot` date DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `timeslot_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_preference_timeslot`),
  KEY `FK_preference_timeslot_user` (`user_id`),
  KEY `FK_preference_timeslot_timeslot` (`timeslot_id`),
  CONSTRAINT `FK_preference_timeslot_timeslot` FOREIGN KEY (`timeslot_id`) REFERENCES `timeslot` (`id_timeslot`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_preference_timeslot_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. restrict
DROP TABLE IF EXISTS `restrict`;
CREATE TABLE IF NOT EXISTS `restrict` (
  `id_restrict` int(11) NOT NULL AUTO_INCREMENT,
  `attribution_id` int(11) DEFAULT NULL,
  `timeslot_id` int(11) DEFAULT NULL,
  `typical_day` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_restrict`),
  KEY `FK_restrict_attribution` (`attribution_id`),
  KEY `FK_restrict_timeslot` (`timeslot_id`),
  KEY `FK_restrict_typical_day` (`typical_day`),
  CONSTRAINT `FK_restrict_attribution` FOREIGN KEY (`attribution_id`) REFERENCES `attribution` (`id_attribution`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_restrict_timeslot` FOREIGN KEY (`timeslot_id`) REFERENCES `timeslot` (`id_timeslot`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_restrict_typical_day` FOREIGN KEY (`typical_day`) REFERENCES `typical_day` (`id_typical_day`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. role
DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id_role` int(11) NOT NULL AUTO_INCREMENT,
  `label_role` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. school
DROP TABLE IF EXISTS `school`;
CREATE TABLE IF NOT EXISTS `school` (
  `id_school` int(11) NOT NULL AUTO_INCREMENT,
  `name_school` varchar(250) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_school`) USING BTREE,
  KEY `FK_school_address` (`address_id`),
  CONSTRAINT `FK_school_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id_address`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. schooling
DROP TABLE IF EXISTS `schooling`;
CREATE TABLE IF NOT EXISTS `schooling` (
  `id_schooling` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) DEFAULT NULL,
  `school_year_id` int(11) DEFAULT NULL,
  `school_level_id` int(11) DEFAULT NULL,
  `child_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_schooling`),
  KEY `FK_schooling_school_level` (`school_level_id`),
  KEY `FK_schooling_school_year` (`school_year_id`),
  KEY `FK_schooling_school` (`school_id`),
  KEY `FK_schooling_child` (`child_id`),
  CONSTRAINT `FK_schooling_child` FOREIGN KEY (`child_id`) REFERENCES `child` (`id_child`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_schooling_school` FOREIGN KEY (`school_id`) REFERENCES `school` (`id_school`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_schooling_school_level` FOREIGN KEY (`school_level_id`) REFERENCES `school_level` (`id_school_level`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_schooling_school_year` FOREIGN KEY (`school_year_id`) REFERENCES `school_year` (`id_school_year`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. school_holidays
DROP TABLE IF EXISTS `school_holidays`;
CREATE TABLE IF NOT EXISTS `school_holidays` (
  `id_school_holidays` int(11) NOT NULL AUTO_INCREMENT,
  `date_start_school_holidays` date DEFAULT NULL,
  `date_end_school_holidays` date DEFAULT NULL,
  `label_school_holidays` varchar(250) DEFAULT NULL,
  `school_year_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_school_holidays`),
  KEY `FK_school_holidays_school_year` (`school_year_id`),
  CONSTRAINT `FK_school_holidays_school_year` FOREIGN KEY (`school_year_id`) REFERENCES `school_year` (`id_school_year`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. school_level
DROP TABLE IF EXISTS `school_level`;
CREATE TABLE IF NOT EXISTS `school_level` (
  `id_school_level` int(11) NOT NULL AUTO_INCREMENT,
  `label_school_level` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_school_level`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. school_year
DROP TABLE IF EXISTS `school_year`;
CREATE TABLE IF NOT EXISTS `school_year` (
  `id_school_year` int(11) NOT NULL AUTO_INCREMENT,
  `date_start_school_year` date DEFAULT NULL,
  `date_end_school_year` date DEFAULT NULL,
  PRIMARY KEY (`id_school_year`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. stop
DROP TABLE IF EXISTS `stop`;
CREATE TABLE IF NOT EXISTS `stop` (
  `id_stop` int(11) NOT NULL AUTO_INCREMENT,
  `name_stop` varchar(250) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_stop`),
  KEY `FK_stop_address` (`address_id`),
  CONSTRAINT `FK_stop_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id_address`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. street
DROP TABLE IF EXISTS `street`;
CREATE TABLE IF NOT EXISTS `street` (
  `id_street` int(11) NOT NULL AUTO_INCREMENT,
  `name_street` varchar(250) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_street`),
  KEY `FK_street_city` (`city_id`),
  CONSTRAINT `FK_street_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`id_city`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. timeslot
DROP TABLE IF EXISTS `timeslot`;
CREATE TABLE IF NOT EXISTS `timeslot` (
  `id_timeslot` int(11) NOT NULL AUTO_INCREMENT,
  `label_timeslot` varchar(250) DEFAULT NULL,
  `time_start_timeslot` time DEFAULT NULL,
  `time_end_timeslot` time DEFAULT NULL,
  PRIMARY KEY (`id_timeslot`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. timetable_stop
DROP TABLE IF EXISTS `timetable_stop`;
CREATE TABLE IF NOT EXISTS `timetable_stop` (
  `id_timetable_stop` int(11) NOT NULL AUTO_INCREMENT,
  `time_stop` time DEFAULT NULL,
  `date_start_validation_timetable_stop` time DEFAULT NULL,
  `date_end_validation_timetable_stop` time DEFAULT NULL,
  `trip_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_timetable_stop`),
  KEY `FK_timetable_stop_trip` (`trip_id`),
  CONSTRAINT `FK_timetable_stop_trip` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id_trip`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. travel
DROP TABLE IF EXISTS `travel`;
CREATE TABLE IF NOT EXISTS `travel` (
  `id_travel` int(11) NOT NULL AUTO_INCREMENT,
  `date_travel` date DEFAULT NULL,
  `child_id` int(11) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  `trip_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_travel`),
  KEY `Fk_travel_child` (`child_id`),
  KEY `FK_travel_school` (`school_id`),
  KEY `FK_travel_trip` (`trip_id`),
  CONSTRAINT `FK_travel_school` FOREIGN KEY (`school_id`) REFERENCES `school` (`id_school`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_travel_trip` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id_trip`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_travel_child` FOREIGN KEY (`child_id`) REFERENCES `child` (`id_child`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. trip
DROP TABLE IF EXISTS `trip`;
CREATE TABLE IF NOT EXISTS `trip` (
  `id_trip` int(11) NOT NULL AUTO_INCREMENT,
  `date_attribution_trip` date DEFAULT NULL,
  `date_cancelation_trip` date DEFAULT NULL,
  `line_id` int(11) DEFAULT NULL,
  `stop_id` int(11) DEFAULT NULL,
  `trip_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_trip`),
  KEY `FK_trip_line` (`line_id`),
  KEY `FK_trip_stop` (`stop_id`),
  KEY `FK_trip_trip` (`trip_id`),
  CONSTRAINT `FK_trip_line` FOREIGN KEY (`line_id`) REFERENCES `line` (`id_line`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_trip_stop` FOREIGN KEY (`stop_id`) REFERENCES `stop` (`id_stop`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_trip_trip` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`id_trip`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. typical_day
DROP TABLE IF EXISTS `typical_day`;
CREATE TABLE IF NOT EXISTS `typical_day` (
  `id_typical_day` int(11) NOT NULL AUTO_INCREMENT,
  `label_typical_day` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_typical_day`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

-- Listage de la structure de table abey_bdd. user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `login_user` varchar(250) DEFAULT NULL,
  `password_user` varchar(250) DEFAULT NULL,
  `name_user` varchar(250) DEFAULT NULL,
  `firstname_user` varchar(250) DEFAULT NULL,
  `birthdate_user` date DEFAULT NULL,
  `phone_user` varchar(50) DEFAULT NULL,
  `mail_user` varchar(250) DEFAULT NULL,
  `date_creation_account` date DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `FK_user_adress` (`address_id`) USING BTREE,
  CONSTRAINT `FK_user_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id_address`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Les données exportées n'étaient pas sélectionnées.

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
