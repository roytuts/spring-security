CREATE TABLE IF NOT EXISTS `user` (
  `user_name` varchar(30) NOT NULL,
  `user_pass` varchar(255) NOT NULL,
  `enable` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_name`, `user_pass`, `enable`) VALUES
	('admin', '$2a$10$dl8TemMlPH7Z/mpBurCX8O4lu0FoWbXnhsHTYXVsmgXyzagn..8rK', 1),
	('user', '$2a$10$9Xn39aPf4LhDpRGNWvDFqu.T5ZPHbyh8iNQDSb4aNSnLqE2u2efIu', 1);

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_name` varchar(30) NOT NULL,
  `user_role` varchar(15) NOT NULL,
  KEY `user_name` (`user_name`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user_role` (`user_name`, `user_role`) VALUES
	('user', 'ROLE_USER'),
	('admin', 'ROLE_USER'),
	('admin', 'ROLE_ADMIN');
