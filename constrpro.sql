/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : constrpro

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 03/03/2019 12:48:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for monitoringalarm
-- ----------------------------
DROP TABLE IF EXISTS `monitoringalarm`;
CREATE TABLE `monitoringalarm`  (
  `alaid` int(11) NOT NULL AUTO_INCREMENT COMMENT '监测报警id',
  `alaname` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '监测报警项目名称',
  `alavalue` int(10) NULL DEFAULT NULL COMMENT '监测报警项目当前值',
  PRIMARY KEY (`alaid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of monitoringalarm
-- ----------------------------
INSERT INTO `monitoringalarm` VALUES (3, '横杆内力', 50);
INSERT INTO `monitoringalarm` VALUES (4, '立柱竖向位移', 70);
INSERT INTO `monitoringalarm` VALUES (5, '围护墙(边坡)顶部竖向位移', 40);
INSERT INTO `monitoringalarm` VALUES (6, '周边管线竖向位移', 61);
INSERT INTO `monitoringalarm` VALUES (7, '地下水位', 10);
INSERT INTO `monitoringalarm` VALUES (10, 'xxx', 69);

-- ----------------------------
-- Table structure for monitoringquality
-- ----------------------------
DROP TABLE IF EXISTS `monitoringquality`;
CREATE TABLE `monitoringquality`  (
  `quaid` int(11) NOT NULL AUTO_INCREMENT COMMENT '质量监测id',
  `quaname` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '质量监测名称',
  `maxvalue` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最大值',
  `alarmvalue` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报警值',
  `maxrate` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最大变化速率',
  PRIMARY KEY (`quaid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of monitoringquality
-- ----------------------------
INSERT INTO `monitoringquality` VALUES (2, '项目一', '-0.25', '0.6', '0.2');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '项目一', '10');
INSERT INTO `project` VALUES (2, '项目二', '20');
INSERT INTO `project` VALUES (3, '项目三', '30');
INSERT INTO `project` VALUES (4, '项目四', '20');
INSERT INTO `project` VALUES (5, '项目五', '22');
INSERT INTO `project` VALUES (6, '项目六', '29');

-- ----------------------------
-- Table structure for retaining
-- ----------------------------
DROP TABLE IF EXISTS `retaining`;
CREATE TABLE `retaining`  (
  `reid` int(11) NOT NULL AUTO_INCREMENT COMMENT '维护墙顶id',
  `rename` varchar(60) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '维护墙顶项目名称',
  `revalue` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护墙顶项目值',
  `retime` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护墙顶时间',
  PRIMARY KEY (`reid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of retaining
-- ----------------------------
INSERT INTO `retaining` VALUES (2, 'w21', '40', '2019-02-24 12:11:10');
INSERT INTO `retaining` VALUES (3, 'w22', '35', '2019-02-24 12:20:45');
INSERT INTO `retaining` VALUES (4, 'w20', '110', '2019-02-23 17:25:56');
INSERT INTO `retaining` VALUES (5, 'w21', '130', '2019-02-23 14:20:55');
INSERT INTO `retaining` VALUES (6, 'w22', '120', '2019-02-23 15:30:56');
INSERT INTO `retaining` VALUES (7, 'w20', '91', '2019-02-27 16:20:11');
INSERT INTO `retaining` VALUES (8, 'w21', '30', '2019-02-27 09:56:44');
INSERT INTO `retaining` VALUES (9, 'w20', '88', '2019-02-28 12:11:55');
INSERT INTO `retaining` VALUES (11, 'w21', '45', '2019-02-28 10:45:22');
INSERT INTO `retaining` VALUES (12, 'w22', '88', '2019-02-28 12:11:55');
INSERT INTO `retaining` VALUES (13, 'w20', '100', '2019-02-28 12:11:55');
INSERT INTO `retaining` VALUES (14, 'w21', '52', '2019-03-01 10:45:22');
INSERT INTO `retaining` VALUES (15, 'w22', '35', '2019-03-01 12:11:55');
INSERT INTO `retaining` VALUES (16, 'w23', '20', '2019-03-01 12:11:55');

SET FOREIGN_KEY_CHECKS = 1;
