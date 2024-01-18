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