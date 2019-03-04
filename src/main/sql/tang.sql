/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50515
Source Host           : 127.0.0.1:3306
Source Database       : tang

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-03-04 22:10:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `c_name` varchar(255) DEFAULT NULL,
  `simple_name` varchar(255) DEFAULT NULL,
  `trade` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
