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
  `type` enum('PERMANENT','FREELANCER') DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `student_lead` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `course` enum('JAVA','PYTHON') DEFAULT NULL,
  `date_of_enquiry` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `next_call_date` date DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `source` enum('SOCIAL_MEDIA','GOOGLE','FRIENDS') DEFAULT NULL,
  `status` enum('NEW','ONGOING','CLOSED','LOST','ENROLLED') DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `student` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `balance_fee` int DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `course` enum('JAVA','PYTHON') DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` enum('MALE','FEMALE','OTHER') DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `total_fee` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `session` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course` enum('JAVA','PYTHON') DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` enum('PLANNED','ONGOING','COMPLETED','CANCELLED','POSTPONED','ON_HOLD') DEFAULT NULL,
  `trainer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`id`)
);

CREATE TABLE IF NOT EXISTS `payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` int DEFAULT NULL,
  `pay_date` date DEFAULT NULL,
  `payment_mode` enum('CASH','BANK_TRANSFER','CREDIT_CARD','DEBIT_CARD') DEFAULT NULL,
  `student_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
);
