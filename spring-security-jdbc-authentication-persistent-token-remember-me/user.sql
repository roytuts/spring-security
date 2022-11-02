USE `roytuts`;

/*Table structure for table `user` */
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_pass` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `enable` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*Data for the table `user` */
insert  into `user`(`user_name`,`user_pass`,`enable`) values ('roy','$2a$12$PN0MjtyNGWW.AjWdIuYKxe4.4Grjs4K7oanuAnt/WSDSvFlUc3eQi',1);

/*Table structure for table `user_role` */
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_role` varchar(15) COLLATE utf8mb4_unicode_ci NOT NULL,
  KEY `fk_user` (`user_name`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*Data for the table `user_role` */
insert  into `user_role`(`user_name`,`user_role`) values ('roy','ROLE_ADMIN');

/*Table structure for table `persistent_logins` */
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `series` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
