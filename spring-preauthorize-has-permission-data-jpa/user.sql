CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int unsigned COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_pass` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `enable` tinyint COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_unique_key` (`user_name`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS `user_role` (
  `role_id` int unsigned COLLATE utf8mb4_unicode_ci NOT NULL AUTO_INCREMENT,
  `user_id` int unsigned COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_role` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `user_unique_key` (`user_id`, `user_role`),
  CONSTRAINT `user_role_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `user` (`user_id`, `user_name`, `user_pass`, `enable`) VALUES
	(1, 'admin', '$2a$10$dl8TemMlPH7Z/mpBurCX8O4lu0FoWbXnhsHTYXVsmgXyzagn..8rK', 1),
	(2, 'user', '$2a$10$9Xn39aPf4LhDpRGNWvDFqu.T5ZPHbyh8iNQDSb4aNSnLqE2u2efIu', 1);


INSERT INTO `user_role` (`role_id`, `user_id`, `user_role`) VALUES
	(1, 2, 'ROLE_USER'),
	(2, 1, 'ROLE_USER'),
	(3, 1, 'ROLE_ADMIN');
