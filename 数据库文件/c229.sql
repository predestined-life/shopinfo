/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : c229

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 25/06/2020 14:10:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for code
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code`  (
  `code_id` int(10) NOT NULL,
  `code_content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`code_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `G_id` int(10) NOT NULL AUTO_INCREMENT,
  `G_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `G_price` float(50, 2) NOT NULL,
  `G_class` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `G_date` int(11) NOT NULL,
  `G_num` int(10) NOT NULL,
  `G_sum` float(50, 2) NOT NULL,
  `Sup_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Sup_date` int(11) NOT NULL,
  `G_on_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`G_id`) USING BTREE,
  INDEX `G_price`(`G_price`) USING BTREE,
  INDEX `G_name`(`G_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '黄花菜', 1.20, '蔬菜', 20200617, 0, 0.00, '', 0, '');
INSERT INTO `goods` VALUES (2, '洋葱', 2.00, '蔬菜类', 123, 0, 0.00, '', 0, '');
INSERT INTO `goods` VALUES (39, '洋葱圈', 4.00, '零食', 20190601, 0, 0.00, '', 0, '');
INSERT INTO `goods` VALUES (44, '羊肉干', 10.00, '零食', 20190601, 0, 0.00, '', 0, '');
INSERT INTO `goods` VALUES (47, '泡椒风爪', 3.00, '零食', 20190601, 0, 0.00, '', 0, '');
INSERT INTO `goods` VALUES (48, '香蕉', 3.90, '水果', 20163412, 0, 0.00, '', 0, '');
INSERT INTO `goods` VALUES (49, '真巧饼干', 5.50, '饼干', 20163412, 5, 27.50, '真巧有限公司', 20190621, '123456');
INSERT INTO `goods` VALUES (52, '水果月饼', 3.00, '月饼', 20190623, 5, 15.00, '尚康食品有限公司', 20190623, '1002');

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `log_id` int(10) NOT NULL,
  `log_content` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people`  (
  `People_id` int(20) NOT NULL AUTO_INCREMENT,
  `People_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `People_sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `People_tel` int(20) NOT NULL,
  `People_job` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Pass` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`People_id`) USING BTREE,
  INDEX `On_id`(`Pass`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES (1, '王甜甜', '女', 123456789, '采购员', '1001', '1001');
INSERT INTO `people` VALUES (2, '王俊哲', '男', 987654321, '销售员', '1002', '1002');
INSERT INTO `people` VALUES (3, '彭于晏', '男', 456789123, '库管员', '1003', '1003');

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale`  (
  `Sale_id` int(20) NOT NULL AUTO_INCREMENT,
  `G_id` int(10) NOT NULL,
  `G_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Sale_num` int(20) NULL DEFAULT NULL,
  `G_price` float(50, 2) NOT NULL,
  `Sale_sum` float(20, 2) NULL DEFAULT NULL,
  `On_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Sale_id`, `G_id`) USING BTREE,
  INDEX `G_id`(`G_id`) USING BTREE,
  INDEX `G_name`(`G_name`) USING BTREE,
  CONSTRAINT `sale_ibfk_1` FOREIGN KEY (`G_id`) REFERENCES `goods` (`G_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `Stock_id` int(20) NOT NULL AUTO_INCREMENT,
  `Store_id` int(20) NOT NULL,
  `G_id` int(10) NOT NULL,
  `Stock_num` int(20) NOT NULL,
  PRIMARY KEY (`Stock_id`) USING BTREE,
  INDEX `G_id`(`G_id`) USING BTREE,
  CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`G_id`) REFERENCES `goods` (`G_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (1, 1, 1, 101);
INSERT INTO `stock` VALUES (2, 1, 2, 100);
INSERT INTO `stock` VALUES (3, 1, 39, 50);
INSERT INTO `stock` VALUES (4, 1, 44, 22);
INSERT INTO `stock` VALUES (7, 1, 47, 65);
INSERT INTO `stock` VALUES (8, 1, 48, 44);

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `Store_id` int(20) NOT NULL AUTO_INCREMENT,
  `Store_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `People_id` int(20) NOT NULL,
  PRIMARY KEY (`Store_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, '超市存储仓库', 3);

-- ----------------------------
-- Table structure for suppier
-- ----------------------------
DROP TABLE IF EXISTS `suppier`;
CREATE TABLE `suppier`  (
  `Sup_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Sup_id` int(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `Address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`Sup_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of suppier
-- ----------------------------
INSERT INTO `suppier` VALUES ('哇哈哈公司', 1, '宗庆后', '12346789', '北京');
INSERT INTO `suppier` VALUES ('可口可乐中国', 2, '马云', '456789123', '上海');
INSERT INTO `suppier` VALUES ('百事可乐', 3, '刘强东', '789123456', '深圳');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `On_id` int(20) NOT NULL AUTO_INCREMENT,
  `On_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `On_pass` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `On_job` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`On_id`, `On_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1002 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1001, '123456', '123456', '管理员');

SET FOREIGN_KEY_CHECKS = 1;
