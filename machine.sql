/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 100119
 Source Host           : localhost:3306
 Source Schema         : mine

 Target Server Type    : MySQL
 Target Server Version : 100119
 File Encoding         : 65001

 Date: 13/02/2019 18:33:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fea_draw
-- ----------------------------
DROP TABLE IF EXISTS `fea_draw`;
CREATE TABLE `fea_draw`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `unit_num` int(20) NOT NULL,
  `fea_unm` int(20) NOT NULL,
  `draw_num` int(20) NOT NULL,
  `point_num` int(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `unit_num`(`unit_num`) USING BTREE,
  INDEX `fea_unm`(`fea_unm`) USING BTREE,
  INDEX `point_num`(`point_num`) USING BTREE,
  CONSTRAINT `fea_draw_ibfk_1` FOREIGN KEY (`unit_num`) REFERENCES `jizu` (`jizi_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fea_draw_ibfk_2` FOREIGN KEY (`fea_unm`) REFERENCES `feature` (`fea_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fea_draw_ibfk_3` FOREIGN KEY (`point_num`) REFERENCES `mea_point` (`point_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for fea_opera
-- ----------------------------
DROP TABLE IF EXISTS `fea_opera`;
CREATE TABLE `fea_opera`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `opera_num` int(20) NOT NULL,
  `opera_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `opera_class` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `opera_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for feature
-- ----------------------------
DROP TABLE IF EXISTS `feature`;
CREATE TABLE `feature`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `unit_num` int(20) NOT NULL,
  `fea_num` int(20) NOT NULL,
  `get_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fea_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fea_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fea_num`(`fea_num`) USING BTREE,
  INDEX `unit_num`(`unit_num`) USING BTREE,
  CONSTRAINT `feature_ibfk_1` FOREIGN KEY (`unit_num`) REFERENCES `jizu` (`jizi_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for get_auto
-- ----------------------------
DROP TABLE IF EXISTS `get_auto`;
CREATE TABLE `get_auto`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `unit_num` int(20) NOT NULL,
  `fea_unm` int(20) NOT NULL,
  `value_unm` int(20) NOT NULL,
  `value_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `value_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `quantization_condition` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `value_weight` double NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `unit_num`(`unit_num`) USING BTREE,
  INDEX `fea_unm`(`fea_unm`) USING BTREE,
  CONSTRAINT `get_auto_ibfk_1` FOREIGN KEY (`unit_num`) REFERENCES `jizu` (`jizi_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `get_auto_ibfk_2` FOREIGN KEY (`fea_unm`) REFERENCES `feature` (`fea_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for get_dia
-- ----------------------------
DROP TABLE IF EXISTS `get_dia`;
CREATE TABLE `get_dia`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `unit_num` int(20) NOT NULL,
  `fea_num` int(20) NOT NULL,
  `value_unm` int(20) NOT NULL,
  `value_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `value_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `unit_num`(`unit_num`) USING BTREE,
  INDEX `fea_num`(`fea_num`) USING BTREE,
  CONSTRAINT `get_dia_ibfk_1` FOREIGN KEY (`unit_num`) REFERENCES `jizu` (`jizi_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `get_dia_ibfk_2` FOREIGN KEY (`fea_num`) REFERENCES `feature` (`fea_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for jizu
-- ----------------------------
DROP TABLE IF EXISTS `jizu`;
CREATE TABLE `jizu`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `jizi_num` int(20) NOT NULL,
  `jizu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jizu_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `unit_num`(`jizi_num`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for jzpeizhi
-- ----------------------------
DROP TABLE IF EXISTS `jzpeizhi`;
CREATE TABLE `jzpeizhi`  (
  `jizuID` int(11) NOT NULL,
  `peizhiID` int(11) NOT NULL,
  `ZhenHZ` int(11) NOT NULL,
  `JianHZ` int(11) NOT NULL,
  `JianCF` int(11) NOT NULL,
  `rpmlin1` int(11) NOT NULL,
  `rpmlin2` int(11) NOT NULL,
  `rotorgo` int(11) NOT NULL,
  `bearnum` int(11) NOT NULL,
  `tui` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `weiyi` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `yacha` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MW` int(11) NOT NULL,
  `Wtempstop` int(11) NOT NULL,
  `edHPpressout` int(11) NOT NULL,
  `numvalve` int(11) NOT NULL,
  `numhpvalve` int(11) NOT NULL,
  `waterpowermax` int(11) NOT NULL,
  PRIMARY KEY (`peizhiID`) USING BTREE,
  CONSTRAINT `jzpeizhi_ibfk_1` FOREIGN KEY (`peizhiID`) REFERENCES `jizu` (`jizi_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for mea_point
-- ----------------------------
DROP TABLE IF EXISTS `mea_point`;
CREATE TABLE `mea_point`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `unit_num` int(20) NOT NULL,
  `point_num` int(20) NOT NULL,
  `point_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `point_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `point_num`(`point_num`) USING BTREE,
  INDEX `unit_num`(`unit_num`) USING BTREE,
  CONSTRAINT `mea_point_ibfk_1` FOREIGN KEY (`unit_num`) REFERENCES `jizu` (`jizi_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for pro_rule
-- ----------------------------
DROP TABLE IF EXISTS `pro_rule`;
CREATE TABLE `pro_rule`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `rule_num` int(20) NOT NULL,
  `pro_num` int(20) NOT NULL,
  `rule_express` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `confidence_level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `enable` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pro_num`(`pro_num`) USING BTREE,
  INDEX `pro_rule_ibfk_2`(`rule_num`) USING BTREE,
  CONSTRAINT `pro_rule_ibfk_1` FOREIGN KEY (`pro_num`) REFERENCES `problem` (`pro_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pro_rule_ibfk_2` FOREIGN KEY (`rule_num`) REFERENCES `rule` (`rule_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for problem
-- ----------------------------
DROP TABLE IF EXISTS `problem`;
CREATE TABLE `problem`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `unit_num` int(20) NOT NULL,
  `pro_num` int(20) NOT NULL,
  `pro_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pro_des` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `pro_deal` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `unit_num`(`unit_num`) USING BTREE,
  INDEX `pro_num`(`pro_num`) USING BTREE,
  CONSTRAINT `problem_ibfk_1` FOREIGN KEY (`unit_num`) REFERENCES `jizu` (`jizi_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for problem_record
-- ----------------------------
DROP TABLE IF EXISTS `problem_record`;
CREATE TABLE `problem_record`  (
  `time` datetime(0) NOT NULL,
  `jizi_num` int(11) NOT NULL,
  `pro_num` int(11) NOT NULL,
  `changes` tinyint(255) NOT NULL,
  INDEX `jizi_num`(`jizi_num`) USING BTREE,
  INDEX `pro_num`(`pro_num`) USING BTREE,
  CONSTRAINT `problem_record_ibfk_1` FOREIGN KEY (`jizi_num`) REFERENCES `jizu` (`jizi_num`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `problem_record_ibfk_2` FOREIGN KEY (`pro_num`) REFERENCES `problem` (`pro_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule`  (
  `unit_num` int(11) NOT NULL,
  `rule_num` int(11) NOT NULL,
  `rule_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `rule_expression` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `rule_dec` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  INDEX `unit_num`(`unit_num`) USING BTREE,
  INDEX `rule_num`(`rule_num`) USING BTREE,
  CONSTRAINT `rule_ibfk_1` FOREIGN KEY (`unit_num`) REFERENCES `jizu` (`jizi_num`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for server
-- ----------------------------
DROP TABLE IF EXISTS `server`;
CREATE TABLE `server`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `server_ip` int(20) NOT NULL,
  `server_port` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_num` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
