CREATE SCHEMA IF NOT EXISTS edu_manager_db;
USE edu_manager_db;

CREATE TABLE IF NOT EXISTS `trainer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `experience` int DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `termination_date` date DEFAULT NULL,
  `type` enum('permanent','freelancer') DEFAULT NULL,
  PRIMARY KEY (`id`)
);
