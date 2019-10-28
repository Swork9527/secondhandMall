/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : campus_second-hand_mall

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2019-10-25 16:50:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `goodId` int(11) NOT NULL AUTO_INCREMENT,
  `goodName` varchar(50) NOT NULL,
  `userId` int(11) NOT NULL,
  `price` float(10,2) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `catelog_id` int(1) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`goodId`),
  KEY `userId` (`userId`),
  CONSTRAINT `good_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tab_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('1', 'u盘', '17', '50.00', '闪迪u盘', '1', '0');
INSERT INTO `good` VALUES ('2', '洗发水', '20', '40.00', '正品阿道夫800ml', '6', '0');
INSERT INTO `good` VALUES ('3', '吹风机', '24', '80.00', '静音大功率', '3', '0');
INSERT INTO `good` VALUES ('4', '食用油', '26', '30.00', '金龙鱼', '6', '0');
INSERT INTO `good` VALUES ('5', '口红', '22', '100.00', '阿玛尼', '6', '0');
INSERT INTO `good` VALUES ('6', '洗面奶', '20', '60.00', '雅诗兰黛', '6', '0');
INSERT INTO `good` VALUES ('7', '手机', '17', '1900.00', '荣耀20', '5', '0');
INSERT INTO `good` VALUES ('8', '鼠标', '18', '70.00', '机械键盘配套', '5', '1');
INSERT INTO `good` VALUES ('9', '书包', '27', '50.00', '蓝色小书包', '6', '0');

-- ----------------------------
-- Table structure for pictures
-- ----------------------------
DROP TABLE IF EXISTS `pictures`;
CREATE TABLE `pictures` (
  `pictureId` int(11) NOT NULL AUTO_INCREMENT,
  `goodId` int(11) NOT NULL,
  `pictureUrl` varchar(255) NOT NULL,
  PRIMARY KEY (`pictureId`),
  KEY `goodId` (`goodId`),
  CONSTRAINT `pictures_ibfk_1` FOREIGN KEY (`goodId`) REFERENCES `good` (`goodId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pictures
-- ----------------------------
INSERT INTO `pictures` VALUES ('1', '1', 'U盘.jpg');
INSERT INTO `pictures` VALUES ('2', '2', '洗发水.jpg');
INSERT INTO `pictures` VALUES ('3', '3', '吹风机.jpg');
INSERT INTO `pictures` VALUES ('4', '4', '食用油.jpg');
INSERT INTO `pictures` VALUES ('5', '5', '口红.jpg');
INSERT INTO `pictures` VALUES ('6', '6', '洗面奶.jpg');
INSERT INTO `pictures` VALUES ('7', '7', '手机.jpg');
INSERT INTO `pictures` VALUES ('8', '8', '鼠标.jpg');
INSERT INTO `pictures` VALUES ('9', '9', '书包.jpg');
INSERT INTO `pictures` VALUES ('10', '1', 'U盘2.jpg');

-- ----------------------------
-- Table structure for tab_user
-- ----------------------------
DROP TABLE IF EXISTS `tab_user`;
CREATE TABLE `tab_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(300) DEFAULT NULL,
  `password` varchar(96) DEFAULT NULL,
  `name` varchar(300) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` char(3) DEFAULT NULL,
  `telephone` varchar(33) DEFAULT NULL,
  `email` varchar(300) DEFAULT NULL,
  `status` char(3) DEFAULT NULL,
  `code` varchar(150) DEFAULT NULL,
  KEY `uid` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tab_user
-- ----------------------------
INSERT INTO `tab_user` VALUES ('17', 'huangzefeng', '123456', '黄泽锋', '2019-08-15', '男', '15220468560', 'huangzefeng99@163.com', 'Y', '96df347796574512832bfa09a62846e0');
INSERT INTO `tab_user` VALUES ('18', 'zhangsan', 'dsasds', '黄泽锋', null, '男', '111111', 'huangzefeng99@163.com', null, null);
INSERT INTO `tab_user` VALUES ('20', 'zhang', 'dsasds', '黄泽锋', '2019-10-03', '男', '111111', 'huangzefeng99@163.com', null, null);
INSERT INTO `tab_user` VALUES ('22', 'zhangsan111', '1', null, null, null, null, null, null, null);
INSERT INTO `tab_user` VALUES ('23', 'zhang11111111', 'dsasds', '黄泽锋', '2019-10-03', '男', '111111', 'huangzefeng99@163.com', null, null);
INSERT INTO `tab_user` VALUES ('24', 'zhangsan2222222222222', 'dsasds', '黄泽锋', '2019-10-10', '男', '111111', '283229125@qq.com', null, null);
INSERT INTO `tab_user` VALUES ('25', 'a', '123456', '黄泽锋', '2019-10-03', '男', '15220468560', '283229125@qq.com', 'N', null);
INSERT INTO `tab_user` VALUES ('26', 'dasdss', '123456', '黄泽锋', '2019-10-17', '男', '111111', '283229125@qq.com', 'N', null);
INSERT INTO `tab_user` VALUES ('27', 'zhangsan122', '123456', '黄泽锋', '2019-10-17', '男', '15220468560', 'huangzefeng99@163.com', 'N', null);
INSERT INTO `tab_user` VALUES ('28', 'dasd23231123', '123456', '黄泽锋', '2019-10-16', '男', '15220468560', 'huangzefeng99@163.com', 'N', 'db6d5bb15b6d4721b30adb4fa740a982');
INSERT INTO `tab_user` VALUES ('29', 'dasdsadas', 'dsasds', '黄泽锋', '2019-10-08', '男', '15220468560', 'huangzefeng99@163.com', 'N', '5b1959c45d0f4a0d9c98705db4063193');
INSERT INTO `tab_user` VALUES ('30', 'hzf321232', '123456', '黄泽锋', '2019-10-17', '男', '15220468560', 'huangzefeng99@163.com', 'N', 'ef49f0c46faf4cac8b9c0afbce0aaf9c');
INSERT INTO `tab_user` VALUES ('31', 'hzf2321312', 'dsasds', '黄泽锋', '2019-10-10', '男', '15220468560', 'huangzefeng99@163.com', 'N', 'b1b2f9f5688d470795662db8f2550c98');
INSERT INTO `tab_user` VALUES ('32', 'hzf213213', 'dsasds', '黄泽锋', '2019-10-10', '男', '15220468560', 'huangzefeng99@163.com', 'N', 'e1de397fbd9e44b6930d53ec04d139b7');
INSERT INTO `tab_user` VALUES ('33', 'zhangsan2132', '123456', '黄泽锋', '2019-10-19', '男', '111111', 'huangzefeng99@163.com', 'N', '6df0532327094e509da7d061d00d95e3');
INSERT INTO `tab_user` VALUES ('34', 'zhangsan233', 'dsasds', '黄泽锋', '2019-10-03', '男', '15220468560', 'huangzefeng99@163.com', 'Y', '79bf326e9a2644f9b9bd5f17c8394644');
INSERT INTO `tab_user` VALUES ('35', 'zhangsan232', 'dsasds', '黄泽锋', '2019-10-05', '男', '15220468560', 'huangzefeng99@163.com', 'Y', 'ba3717b0cff3451eba13b706d40acd09');
INSERT INTO `tab_user` VALUES ('36', '531233', '1234343', '黄泽锋', '2019-10-01', '男', '15220468560', 'huangzefeng99@163.com', 'Y', 'cb894250cf824df5a543fb0e5852d44d');
