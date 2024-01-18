CREATE TABLE IF NOT EXISTS`session` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course` enum('BScComputerScience','BCom','BBA','BCA') DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` enum('Planned','Ongoing','Completed','Cancelled','Postponed','Onhold') DEFAULT NULL,
  `trainer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn7bmr9pguwrevl2m7kxqojqdj` (`trainer_id`));
