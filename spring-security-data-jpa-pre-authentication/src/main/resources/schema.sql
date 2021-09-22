DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_name` varchar(30) NOT NULL,
  `user_pass` varchar(255) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_name`)
);
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_name` varchar(30) NOT NULL,
  `user_role` varchar(15) NOT NULL,
  FOREIGN KEY (`user_name`) REFERENCES `user` (`user_name`)
);