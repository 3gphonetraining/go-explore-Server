-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_account` varchar(11) NOT NULL ,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(40) NOT NULL,
  `level` int(40) DEFAULT '1',
  `age` int(40)DEFAULT '0',
  `sex` varchar(20) DEFAULT '未填写',
  `experience` int(40) DEFAULT '0',
  `state` int(11)DEFAULT '0',
  PRIMARY KEY (`user_account`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `user`  VALUES ('18826075488','xingyingyue','945603130','1','20','男','1','0')

