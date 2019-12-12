/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50145
Source Host           : 127.0.0.1:3306
Source Database       : shirotest

Target Server Type    : MYSQL
Target Server Version : 50145
File Encoding         : 65001

Date: 2019-12-12 19:13:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for perms
-- ----------------------------
DROP TABLE IF EXISTS `perms`;
CREATE TABLE `perms` (
  `permId` int(11) NOT NULL,
  `permName` varchar(255) DEFAULT NULL,
  `permString` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of perms
-- ----------------------------
INSERT INTO `perms` VALUES ('1', 'add', 'user:add');
INSERT INTO `perms` VALUES ('2', 'update', 'user:update');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin');
INSERT INTO `role` VALUES ('2', 'user');

-- ----------------------------
-- Table structure for role_vs_perm
-- ----------------------------
DROP TABLE IF EXISTS `role_vs_perm`;
CREATE TABLE `role_vs_perm` (
  `role_perm_id` int(11) NOT NULL,
  `rid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_perm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_vs_perm
-- ----------------------------
INSERT INTO `role_vs_perm` VALUES ('1', '1', '1');
INSERT INTO `role_vs_perm` VALUES ('2', '1', '2');
INSERT INTO `role_vs_perm` VALUES ('3', '2', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `perm` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Lhant', '123456', 'admin', 'user:add');
INSERT INTO `user` VALUES ('2', 'Asber', '123456', 'user', 'user:update');

-- ----------------------------
-- Table structure for user_vs_role
-- ----------------------------
DROP TABLE IF EXISTS `user_vs_role`;
CREATE TABLE `user_vs_role` (
  `user_role_id` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_vs_role
-- ----------------------------
INSERT INTO `user_vs_role` VALUES ('1', '1', '1');
INSERT INTO `user_vs_role` VALUES ('2', '2', '2');
