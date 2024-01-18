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
  PRIMARY KEY (`id`));

CREATE TABLE `student` (
  `id` bigint NOT NULL AUTO_INCREMENT,
 `balanceFee` int DEFAULT NULL,
   `contact_number` int DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `dob` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` enum('Male','Female','Other') DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `start_date` datetime(6) DEFAULT NULL,
  `total_fee` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;