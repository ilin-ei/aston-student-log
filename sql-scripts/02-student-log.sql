CREATE DATABASE IF NOT EXISTS `aston-student-log`;
USE `aston-student-log`;

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `student` VALUES 
	(1,'Frank Grimes'),
	(2,'Moe Szyslak'),
	(3,'Edna Krabappel'),
	(4,'Otto Mann'),
	(5,'Hank Scorpio'),
	(6,'Luann Van Houten'),
	(7,'Apu Nahasapeemapetilon'),
	(8,'Duffman'),
	(9,'Clancy Wiggum'),
	(10,'Montgomery Burns');

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(45) DEFAULT NULL,
  `message` varchar(45) DEFAULT NULL, 
  `student_id` int(11) DEFAULT NULL,
    
  PRIMARY KEY (`id`),
  FOREIGN KEY (`student_id`)
  REFERENCES `student` (`id`)
  
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `log` VALUES 
	(1,'19.05.2010','Oh, yeah!',8),
    (2,'07.07.1999','hello',4),
    (3,'07.09.2011','Oh, yeah!',8),
    (4,'01.01.1936','Excellent',10);
