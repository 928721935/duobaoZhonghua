/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : jianghu

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2021-02-18 10:57:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chat_record
-- ----------------------------
DROP TABLE IF EXISTS `chat_record`;
CREATE TABLE `chat_record` (
  `id` bigint(20) DEFAULT NULL,
  `msg` varchar(1000) DEFAULT NULL,
  `senderID` bigint(20) DEFAULT NULL,
  `receiverID` bigint(20) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL COMMENT '0公共1私人2帮派',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  KEY `senderID` (`senderID`),
  KEY `receiverID` (`receiverID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chat_record
-- ----------------------------
INSERT INTO `chat_record` VALUES ('147691190450524160', '666', '888', null, '0', '2021-02-11 13:12:03');
INSERT INTO `chat_record` VALUES ('147691310663471104', '5', '888', null, '0', '2021-02-11 13:12:32');
INSERT INTO `chat_record` VALUES ('147691387561840640', '9888', '888', null, '0', '2021-02-11 13:12:50');
INSERT INTO `chat_record` VALUES ('147691958612135936', '999', '888', null, '0', '2021-02-11 13:15:06');
INSERT INTO `chat_record` VALUES ('147713251252244480', '2', '888', null, '0', '2021-02-11 14:39:43');
INSERT INTO `chat_record` VALUES ('147713268163678208', '9', '888', null, '0', '2021-02-11 14:39:47');
INSERT INTO `chat_record` VALUES ('147713299432214528', '6', '888', null, '0', '2021-02-11 14:39:54');
INSERT INTO `chat_record` VALUES ('147713324296048640', '9999', '888', null, '0', '2021-02-11 14:40:00');
INSERT INTO `chat_record` VALUES ('147715284764069888', '999', '888', null, '0', '2021-02-11 14:47:48');
INSERT INTO `chat_record` VALUES ('147715297854492672', '222', '888', null, '0', '2021-02-11 14:47:51');
INSERT INTO `chat_record` VALUES ('147715310487736320', '88', '888', null, '0', '2021-02-11 14:47:54');
INSERT INTO `chat_record` VALUES ('147715337100595200', '9966', '888', null, '0', '2021-02-11 14:48:00');
INSERT INTO `chat_record` VALUES ('147715365353426944', '88', '888', null, '0', '2021-02-11 14:48:07');
INSERT INTO `chat_record` VALUES ('147715605410222080', '55', '888', null, '0', '2021-02-11 14:49:04');
INSERT INTO `chat_record` VALUES ('147715623185682432', '1', '888', null, '0', '2021-02-11 14:49:08');
INSERT INTO `chat_record` VALUES ('147715635252695040', '2', '888', null, '0', '2021-02-11 14:49:11');
INSERT INTO `chat_record` VALUES ('147715646141108224', '3', '888', null, '0', '2021-02-11 14:49:14');
INSERT INTO `chat_record` VALUES ('147715659835510784', '40000', '888', null, '0', '2021-02-11 14:49:17');
INSERT INTO `chat_record` VALUES ('147715673299226624', '5', '888', null, '0', '2021-02-11 14:49:20');
INSERT INTO `chat_record` VALUES ('147715691263430656', '+', '888', null, '0', '2021-02-11 14:49:25');
INSERT INTO `chat_record` VALUES ('147715710251044864', '78', '888', null, '0', '2021-02-11 14:49:29');
INSERT INTO `chat_record` VALUES ('147715723295330304', '5', '888', null, '0', '2021-02-11 14:49:32');
INSERT INTO `chat_record` VALUES ('147715734636728320', '66', '888', null, '0', '2021-02-11 14:49:35');
INSERT INTO `chat_record` VALUES ('147715744988270592', '66', '888', null, '0', '2021-02-11 14:49:38');
INSERT INTO `chat_record` VALUES ('147715761866149888', '44', '888', null, '0', '2021-02-11 14:49:42');
INSERT INTO `chat_record` VALUES ('147715932192641024', '889', '888', null, '0', '2021-02-11 14:50:22');
INSERT INTO `chat_record` VALUES ('147715959707275264', '88899', '888', null, '0', '2021-02-11 14:50:29');

-- ----------------------------
-- Table structure for forum_post
-- ----------------------------
DROP TABLE IF EXISTS `forum_post`;
CREATE TABLE `forum_post` (
  `id` bigint(20) NOT NULL,
  `title` varchar(30) DEFAULT NULL,
  `content` varchar(1000) NOT NULL,
  `senderID` bigint(20) NOT NULL,
  `replyNum` int(11) NOT NULL DEFAULT '0',
  `readNum` int(11) NOT NULL DEFAULT '0',
  `top` tinyint(2) NOT NULL DEFAULT '0',
  `essence` tinyint(2) NOT NULL DEFAULT '0',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastReplyTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `senderID` (`senderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_post
-- ----------------------------
INSERT INTO `forum_post` VALUES ('1', '标题', '内容', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('2', '标题2', '内容2', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('3', '标题3', '内容3', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('4', '标题4', '内容4', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('5', '标题5', '内容5', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('6', '标题6', '内容6', '888', '4', '14', '1', '0', '2021-02-12 22:49:51', '2021-02-15 21:26:41');
INSERT INTO `forum_post` VALUES ('7', '标题7', '内容7', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('8', '标题8', '内容8', '888', '0', '12', '1', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('9', '标题9', '内容9', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('10', '标题10', '内容10', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('11', '标题11', '内容11', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('12', '标题12', '内容12', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('13', '标题13', '内容13', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('14', '标题14', '内容14', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('15', '标题15', '内容15', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('16', '标题16', '内容16', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('17', '标题17', '内容17', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 21:04:18');
INSERT INTO `forum_post` VALUES ('18', '标题18', '内容18', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 21:04:29');
INSERT INTO `forum_post` VALUES ('19', '标题19', '内容19', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 21:05:19');
INSERT INTO `forum_post` VALUES ('20', '标题20', '内容20', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('21', '标题21', '内容11', '888', '3', '27', '0', '0', '2021-02-12 22:49:51', '2021-02-15 22:12:04');
INSERT INTO `forum_post` VALUES ('22', '标题22', '内容12', '888', '0', '14', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('23', '标题23', '内容13', '888', '0', '12', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('24', '标题24', '内容14', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('25', '标题25', '内容15', '888', '0', '11', '0', '0', '2021-02-12 22:49:51', '2021-02-15 20:54:24');
INSERT INTO `forum_post` VALUES ('148578303870111744', '6655', '55555633', '888', '0', '11', '0', '0', '2021-02-13 23:57:08', '2021-02-15 20:54:24');

-- ----------------------------
-- Table structure for forum_reply
-- ----------------------------
DROP TABLE IF EXISTS `forum_reply`;
CREATE TABLE `forum_reply` (
  `id` bigint(20) NOT NULL,
  `postID` bigint(20) NOT NULL,
  `replyerID` bigint(20) NOT NULL,
  `msg` varchar(1000) DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of forum_reply
-- ----------------------------
INSERT INTO `forum_reply` VALUES ('1', '1', '888', '我的回复1', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('2', '1', '888', '我的回复2', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('3', '1', '888', '我的回复3', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('4', '1', '888', '我的回复4', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('5', '1', '888', '我的回复5', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('6', '1', '888', '我的回复6', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('7', '1', '888', '我的回复7', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('8', '1', '888', '我的回复8', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('9', '1', '888', '我的回复9', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('10', '1', '888', '我的回复10', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('11', '1', '888', '我的回复11', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('12', '1', '888', '我的回复12', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('13', '1', '888', '我的回复13', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('14', '1', '888', '我的回复14', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('15', '1', '888', '我的回15', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('16', '1', '888', '我的回复16', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('17', '1', '888', '我的回复17', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('18', '1', '888', '我的回复18', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('19', '1', '888', '我的回复9', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('20', '1', '888', '我的回复20', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('21', '1', '888', '我的回复21', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('22', '1', '888', '我的回复22', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('23', '1', '888', '我的回复23', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('24', '1', '888', '我的回复24', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('25', '1', '888', '我的回复25', '2021-02-13 01:07:11');
INSERT INTO `forum_reply` VALUES ('148568410396168192', '9', '888', 'gjjb好看就好看', '2021-02-13 23:17:49');
INSERT INTO `forum_reply` VALUES ('148568461872861184', '9', '888', '556647计划经济', '2021-02-13 23:18:01');
INSERT INTO `forum_reply` VALUES ('148569184106844160', '9', '888', '52223', '2021-02-13 23:20:53');
INSERT INTO `forum_reply` VALUES ('148574007300591616', '12', '888', '33\r\n', '2021-02-13 23:40:03');
INSERT INTO `forum_reply` VALUES ('148574077739732992', '11', '888', '33', '2021-02-13 23:40:20');
INSERT INTO `forum_reply` VALUES ('148574869297172480', '11', '888', '杀杀杀', '2021-02-13 23:43:29');
INSERT INTO `forum_reply` VALUES ('149254175253991424', '148578303870111744', '888', '455\r\n', '2021-02-15 20:42:48');
INSERT INTO `forum_reply` VALUES ('149254471011143680', '148578303870111744', '888', 'ss', '2021-02-15 20:43:58');
INSERT INTO `forum_reply` VALUES ('149254523154731008', '148578303870111744', '888', 'ss', '2021-02-15 20:44:11');
INSERT INTO `forum_reply` VALUES ('149254543463550976', '148578303870111744', '888', '44', '2021-02-15 20:44:16');
INSERT INTO `forum_reply` VALUES ('149254587805732864', '148578303870111744', '888', '5', '2021-02-15 20:44:26');
INSERT INTO `forum_reply` VALUES ('149254617052614656', '148578303870111744', '888', '6', '2021-02-15 20:44:33');
INSERT INTO `forum_reply` VALUES ('149254683142262784', '148578303870111744', '888', '7', '2021-02-15 20:44:49');
INSERT INTO `forum_reply` VALUES ('149254701194547200', '148578303870111744', '888', '8', '2021-02-15 20:44:53');
INSERT INTO `forum_reply` VALUES ('149254718567354368', '148578303870111744', '888', '9', '2021-02-15 20:44:57');
INSERT INTO `forum_reply` VALUES ('149254737605300224', '148578303870111744', '888', '10', '2021-02-15 20:45:02');
INSERT INTO `forum_reply` VALUES ('149254752843206656', '148578303870111744', '888', '11', '2021-02-15 20:45:06');
INSERT INTO `forum_reply` VALUES ('149255144670892032', '148578303870111744', '888', '12', '2021-02-15 20:46:39');
INSERT INTO `forum_reply` VALUES ('149255653154754560', '148578303870111744', '888', '13\r\n', '2021-02-15 20:48:40');
INSERT INTO `forum_reply` VALUES ('149256420141961216', '148578303870111744', '888', '14\r\n', '2021-02-15 20:51:43');
INSERT INTO `forum_reply` VALUES ('149259585969065984', '17', '888', '33\r\n', '2021-02-15 21:04:18');
INSERT INTO `forum_reply` VALUES ('149259631196246016', '18', '888', '999', '2021-02-15 21:04:29');
INSERT INTO `forum_reply` VALUES ('149259840554930176', '19', '888', '999\r\n', '2021-02-15 21:05:19');
INSERT INTO `forum_reply` VALUES ('149262604139892736', '6', '888', '99\r\n', '2021-02-15 21:16:17');
INSERT INTO `forum_reply` VALUES ('149264892950614016', '6', '888', '99', '2021-02-15 21:25:23');
INSERT INTO `forum_reply` VALUES ('149265180864417792', '6', '888', '999', '2021-02-15 21:26:32');
INSERT INTO `forum_reply` VALUES ('149265218147586048', '6', '888', '966', '2021-02-15 21:26:41');
INSERT INTO `forum_reply` VALUES ('149265676152999936', '21', '888', '', '2021-02-15 21:28:30');
INSERT INTO `forum_reply` VALUES ('149271577106714624', '21', '888', '你妈逼', '2021-02-15 21:51:57');
INSERT INTO `forum_reply` VALUES ('149276637756788736', '21', '888', '傻逼', '2021-02-15 22:12:03');

-- ----------------------------
-- Table structure for good_detail_book
-- ----------------------------
DROP TABLE IF EXISTS `good_detail_book`;
CREATE TABLE `good_detail_book` (
  `id` bigint(20) NOT NULL,
  `funcType` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good_detail_book
-- ----------------------------

-- ----------------------------
-- Table structure for good_detail_equipment
-- ----------------------------
DROP TABLE IF EXISTS `good_detail_equipment`;
CREATE TABLE `good_detail_equipment` (
  `id` bigint(20) NOT NULL,
  `funcType` int(5) NOT NULL,
  `gong` int(7) DEFAULT NULL,
  `fang` int(7) DEFAULT NULL,
  `shan` int(7) DEFAULT NULL,
  `mingZhong` int(7) DEFAULT NULL,
  `maxNaiJiu` int(7) DEFAULT NULL,
  `currNaiJiu` int(7) DEFAULT NULL,
  `growValue` int(7) DEFAULT NULL,
  `basicGrowValue` int(7) DEFAULT NULL,
  `level` int(7) DEFAULT NULL,
  `maxLevel` int(7) DEFAULT NULL,
  `currExperience` bigint(20) DEFAULT NULL,
  `maxExperience` bigint(20) DEFAULT NULL,
  `isGrow` tinyint(2) NOT NULL,
  `canDamage` tinyint(2) NOT NULL,
  `canDrop` tinyint(2) NOT NULL,
  `canDiscard` tinyint(2) NOT NULL,
  `canSell` tinyint(2) NOT NULL,
  `canGive` tinyint(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good_detail_equipment
-- ----------------------------
INSERT INTO `good_detail_equipment` VALUES ('11', '3', '100', '100', '100', '100', '100', '11', '10', '8', '1', '111', '1111', '1550', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for role_skill
-- ----------------------------
DROP TABLE IF EXISTS `role_skill`;
CREATE TABLE `role_skill` (
  `userID` bigint(20) NOT NULL,
  `skillID` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `studyPercent` int(11) NOT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY `skillID` (`skillID`,`userID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_skill
-- ----------------------------
INSERT INTO `role_skill` VALUES ('888', '1', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '2', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '3', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '4', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '5', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '6', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '7', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '8', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '9', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '10', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '11', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '12', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '13', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '14', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '15', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '16', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '17', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '18', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '19', '1000', '12', '2021-02-11 20:55:26');
INSERT INTO `role_skill` VALUES ('888', '20', '1000', '12', '2021-02-11 20:55:26');

-- ----------------------------
-- Table structure for serial
-- ----------------------------
DROP TABLE IF EXISTS `serial`;
CREATE TABLE `serial` (
  `type` int(11) DEFAULT NULL,
  `value` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of serial
-- ----------------------------

-- ----------------------------
-- Table structure for template_book
-- ----------------------------
DROP TABLE IF EXISTS `template_book`;
CREATE TABLE `template_book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(30) NOT NULL,
  `unit` varchar(4) DEFAULT NULL,
  `description` varchar(500) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=525 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of template_book
-- ----------------------------
INSERT INTO `template_book` VALUES ('500', '刀法精要', '本', '');
INSERT INTO `template_book` VALUES ('501', '刀法精要外篇', '本', '');
INSERT INTO `template_book` VALUES ('502', '刀法秘要', '本', '');
INSERT INTO `template_book` VALUES ('503', '胡家刀谱', '本', '');
INSERT INTO `template_book` VALUES ('504', '剑法指南', '本', '这是一本书籍。封面上写著「剑法指南」');
INSERT INTO `template_book` VALUES ('505', '高级剑术', '本', '');
INSERT INTO `template_book` VALUES ('506', '羊皮书', '本', '');
INSERT INTO `template_book` VALUES ('507', '无名剑谱', '本', '');
INSERT INTO `template_book` VALUES ('508', '拳脚入门', '本', '这是一本书籍。封面上写著「拳脚入门」');
INSERT INTO `template_book` VALUES ('509', '拳脚详解', '本', '');
INSERT INTO `template_book` VALUES ('510', '拳谱总诀', '本', '');
INSERT INTO `template_book` VALUES ('511', '武穆遗书', '本', '');
INSERT INTO `template_book` VALUES ('512', '丝罗巾', '条', '这本秘笈由上等丝绸编成，绣了一幅幅美女图。个个体态轻盈，翩然起舞。每一曲舞步姿态美妙迷人，旁题著舞曲名称与步法。');
INSERT INTO `template_book` VALUES ('513', '踏雪无痕', '本', '');
INSERT INTO `template_book` VALUES ('514', '羊皮卷轴', '本', '');
INSERT INTO `template_book` VALUES ('515', '玉佩', '个', '上面刻著一些字:行气, 深则蓄, 蓄则伸, 伸则下, 下则定, 定则固, 固则萌, 萌则长, 长则退,退则天. 天几舂在上, 地几舂在下, 顺则生, 逆则死。');
INSERT INTO `template_book` VALUES ('516', '石板', '个', '');
INSERT INTO `template_book` VALUES ('517', '薄绢', '件', '');
INSERT INTO `template_book` VALUES ('518', '易筋经', '本', '');
INSERT INTO `template_book` VALUES ('519', '招架要旨', '本', '这是一本书籍。封面上写著「招架要旨」');
INSERT INTO `template_book` VALUES ('520', '拆招之术', '本', '');
INSERT INTO `template_book` VALUES ('521', '铁手掌', '本', '');
INSERT INTO `template_book` VALUES ('522', '降龙十八章秘籍', '本', '');
INSERT INTO `template_book` VALUES ('523', '九阴真经(上)', '本', '');
INSERT INTO `template_book` VALUES ('524', '九阴真经(下)', '本', '');

-- ----------------------------
-- Table structure for template_equipment
-- ----------------------------
DROP TABLE IF EXISTS `template_equipment`;
CREATE TABLE `template_equipment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `equipmentName` varchar(255) NOT NULL,
  `funcType` tinyint(4) NOT NULL DEFAULT '6' COMMENT '装备类型1刀2剑3爪4鞋5甲6衣',
  `description` varchar(500) NOT NULL DEFAULT '',
  `gong` int(5) DEFAULT NULL,
  `fang` int(5) DEFAULT NULL,
  `shan` int(5) DEFAULT NULL,
  `basicGrowValue` int(3) DEFAULT NULL,
  `unit` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of template_equipment
-- ----------------------------
INSERT INTO `template_equipment` VALUES ('1', '十方封魔斩', '1', '十方封魔斩乃是用后羿当年射下天帝九子，并射杀无数上古众神那只十只乌铁射日箭锻造而成。', '470', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('2', '大夏龙雀', '1', '刀长三尺九寸，背上就铭刻了古之利器，吴楚湛卢，大夏龙雀，名冠神都，可以怀远，可以柔迩，如风靡草，威服九区。', '450', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('3', '割玉', '1', '', '440', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('4', '流采', '1', '', '430', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('5', '天罡', '1', '', '420', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('6', '鸣鸿', '1', '', '410', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('7', '吞日斩', '1', '', '400', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('8', '参商', '1', '', '390', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('9', '天舞轮回', '1', '', '380', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('10', '戳冥丸', '1', '', '370', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('11', '流爆', '1', '', '360', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('12', '轩辕菜刀', '1', '', '350', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('13', '漏影刀', '1', '', '340', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('14', '沉虹斩', '1', '', '330', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('15', '胭脂宝刀', '1', '', '320', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('16', '血刀', '1', '', '310', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('17', '闯王宝刀', '1', '', '300', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('18', '庖丁菜刀', '1', '', '290', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('19', '屠龙刀', '1', '', '280', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('20', '悬翦之刀', '1', '', '270', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('21', '转魂刀', '1', '', '260', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('22', '圆月弯刀', '1', '', '250', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('23', '掩日神刀', '1', '', '240', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('24', '断水刀', '1', '', '230', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('25', '出跸刀', '1', '', '220', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('26', '妖刀狗屠', '1', '', '210', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('27', '泣血刀', '1', '', '200', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('28', '割鹿刀', '1', '', '190', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('29', '地煞潜龙刀', '1', '', '180', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('30', '天竺弯刀', '1', '', '170', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('31', '秋鱼刀', '1', '', '160', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('32', '青龙偃月刀', '1', '', '160', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('33', '温柔刀', '1', '', '150', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('34', '七杀刀', '1', '', '150', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('35', '破风刀', '1', '挥刀相向，势如破竹。刀气犹如狂风一般。', '140', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('36', '无情刀', '1', '', '130', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('37', '鸳鸯刀', '1', '', '120', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('38', '九怀刀', '1', '', '110', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('39', '紫金刀', '1', '', '100', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('40', '银刀', '1', '', '90', null, null, '3', '把');
INSERT INTO `template_equipment` VALUES ('41', '卜刀', '1', '', '80', null, null, '3', '把');
INSERT INTO `template_equipment` VALUES ('42', '铜刀', '1', '', '70', null, null, '3', '把');
INSERT INTO `template_equipment` VALUES ('43', '单刀', '1', '', '50', null, null, '3', '把');
INSERT INTO `template_equipment` VALUES ('44', '钢刀', '1', '', '30', null, null, null, '把');
INSERT INTO `template_equipment` VALUES ('45', '竹刀', '1', '', '10', null, null, null, '把');
INSERT INTO `template_equipment` VALUES ('46', '乘风万里伏', '2', '王莽铸，铭曰乘胜万里伏小篆书，三尺六寸，莽造威斗及神剑皆链五色石为之。', '490', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('47', '九天龙魂剑', '2', '', '480', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('48', '不动明王剑', '2', '佛门神器。不动明王的佩剑。此剑所到之处万佛朝宗，瑞气升腾。', '470', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('49', '八荒六合剑', '2', '', '460', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('50', '轩辕夏禹剑', '2', '这是一把黄金色的千年古剑，剑身刻日月星辰。传说是天界诸神赐于轩辕黄帝击败蚩尤的旷世神剑，其内蕴藏着无穷的力量，为斩妖除魔的神剑。', '450', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('51', '七星龙渊剑', '2', '', '440', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('52', '赤宵', '2', '', '430', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('53', '泰阿', '2', '', '420', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('54', '纯钧', '2', '', '410', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('55', '承影', '2', '', '400', null, null, '7', '把');
INSERT INTO `template_equipment` VALUES ('56', '腾空', '2', '', '390', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('57', '天地合一剑', '2', '', '380', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('58', '乾坤', '2', '', '370', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('59', '湛卢', '2', '', '360', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('60', '干将', '2', '', '350', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('61', '莫邪', '2', '', '350', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('62', '真武剑', '2', '', '340', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('63', '银月飞霜剑', '2', '', '330', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('64', '九天玄冰剑', '2', '', '320', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('65', '神剑', '2', '', '310', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('66', '伽蓝剑', '2', '', '300', null, null, '6', '把');
INSERT INTO `template_equipment` VALUES ('67', '倚天剑', '2', '', '290', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('68', '离别钩', '2', '', '280', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('69', '长生剑', '2', '', '270', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('70', '风泉之剑', '2', '', '260', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('71', '咒王剑', '2', '', '250', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('72', '碧血照丹青', '2', '', '240', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('73', '玄苏剑', '2', '', '210', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('74', '寒星剑', '2', '', '200', null, null, '5', '把');
INSERT INTO `template_equipment` VALUES ('75', '邪剑穿灵', '2', '', '190', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('76', '游龙剑', '2', '', '180', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('77', '七星剑', '2', '', '180', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('78', '冰弦剑', '2', '', '170', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('79', '紫微软剑', '2', '', '160', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('80', '七星绝命剑', '2', '', '150', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('81', '红袖剑', '2', '', '140', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('82', '夺命剑', '2', '', '140', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('83', '銮鱼衡冰剑', '2', '', '130', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('84', '泪痕剑', '2', '', '130', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('85', '青锋剑', '2', '', '120', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('86', '烟雨剑', '2', '', '110', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('87', '柔情剑', '2', '', '100', null, null, '4', '把');
INSERT INTO `template_equipment` VALUES ('88', '银剑', '2', '', '90', null, null, '3', '把');
INSERT INTO `template_equipment` VALUES ('89', '风回雪舞剑', '2', '', '80', null, null, '3', '把');
INSERT INTO `template_equipment` VALUES ('90', '铜剑', '2', '', '70', null, null, '3', '把');
INSERT INTO `template_equipment` VALUES ('91', '秦剑', '2', '', '40', null, null, '3', '把');
INSERT INTO `template_equipment` VALUES ('92', '钢剑', '2', '', '30', null, null, null, '把');
INSERT INTO `template_equipment` VALUES ('93', '竹剑', '2', '', '10', null, null, null, '把');
INSERT INTO `template_equipment` VALUES ('94', '钓鱼竿', '2', '', '1', null, null, null, '把');
INSERT INTO `template_equipment` VALUES ('95', '破邪爪', '3', '专门铲除妖魔的神爪，盘古开天时天地灵气孕育而成，积聚着宇宙一切的精华，没人能够估测它的威力。', '420', null, null, '7', '个');
INSERT INTO `template_equipment` VALUES ('96', '失魂爪', '3', '', '390', null, null, '6', '个');
INSERT INTO `template_equipment` VALUES ('97', '火焰爪', '3', '', '360', null, null, '6', '个');
INSERT INTO `template_equipment` VALUES ('98', '玄冰爪', '3', '', '330', null, null, '6', '个');
INSERT INTO `template_equipment` VALUES ('99', '邪神爪', '3', '', '300', null, null, '6', '个');
INSERT INTO `template_equipment` VALUES ('100', '飞虎爪', '3', '', '270', null, null, '5', '个');
INSERT INTO `template_equipment` VALUES ('101', '魔牙刺', '3', '', '240', null, null, '5', '个');
INSERT INTO `template_equipment` VALUES ('102', '龙牙指剑', '3', '', '210', null, null, '5', '个');
INSERT INTO `template_equipment` VALUES ('103', '金色臂环', '3', '', '180', null, null, '4', '个');
INSERT INTO `template_equipment` VALUES ('104', '白虎爪', '3', '', '140', null, null, '4', '个');
INSERT INTO `template_equipment` VALUES ('105', '金鳞铁手', '3', '一副黄金制成的手套，上面雕琢有龙鳞的纹络，价格不菲。', '100', null, null, '4', '个');
INSERT INTO `template_equipment` VALUES ('106', '指爪', '3', '', '90', null, null, '3', '个');
INSERT INTO `template_equipment` VALUES ('107', '豹牙手环', '3', '', '60', null, null, '3', '个');
INSERT INTO `template_equipment` VALUES ('108', '青鳞铁手', '3', '', '40', null, null, '3', '个');
INSERT INTO `template_equipment` VALUES ('109', '铁爪', '3', '', '10', null, null, null, '个');
INSERT INTO `template_equipment` VALUES ('110', '汤魔战靴', '4', '神界的宝物，神将们斩妖除魔时穿的战靴。', null, null, '300', null, '双');
INSERT INTO `template_equipment` VALUES ('111', '混天神鞋', '4', '', null, null, '180', null, '双');
INSERT INTO `template_equipment` VALUES ('112', '凌波软履', '4', '', null, null, '170', null, '双');
INSERT INTO `template_equipment` VALUES ('113', '冰蚕鞋', '4', '', null, null, '160', null, '双');
INSERT INTO `template_equipment` VALUES ('114', '雪虹鞋', '4', '', null, null, '150', null, '双');
INSERT INTO `template_equipment` VALUES ('115', '真武战靴', '4', '', null, null, '150', null, '双');
INSERT INTO `template_equipment` VALUES ('116', '魅影神靴', '4', '', null, null, '140', null, '双');
INSERT INTO `template_equipment` VALUES ('117', '王升仙履', '4', '', null, null, '130', null, '双');
INSERT INTO `template_equipment` VALUES ('118', '踏云靴', '4', '', null, null, '120', null, '双');
INSERT INTO `template_equipment` VALUES ('119', '金缕鞋', '4', '', null, null, '110', null, '双');
INSERT INTO `template_equipment` VALUES ('120', '蹙金云履', '4', '', null, null, '100', null, '双');
INSERT INTO `template_equipment` VALUES ('121', '赤玉履', '4', '', null, null, '90', null, '双');
INSERT INTO `template_equipment` VALUES ('122', '钩镰鞋', '4', '', null, null, '80', null, '双');
INSERT INTO `template_equipment` VALUES ('123', '望仙鞋', '4', '', null, null, '70', null, '双');
INSERT INTO `template_equipment` VALUES ('124', '五彩屐', '4', '', null, null, '60', null, '双');
INSERT INTO `template_equipment` VALUES ('125', '铁履', '4', '', null, null, '50', null, '双');
INSERT INTO `template_equipment` VALUES ('126', '鸳鸯履', '4', '', null, null, '40', null, '双');
INSERT INTO `template_equipment` VALUES ('127', '鹿皮短靴', '4', '', null, null, '30', null, '双');
INSERT INTO `template_equipment` VALUES ('128', '草鞋', '4', '', null, null, '20', null, '双');
INSERT INTO `template_equipment` VALUES ('129', '布靴', '4', '', null, null, '10', null, '双');
INSERT INTO `template_equipment` VALUES ('130', '软猥甲', '5', '是黄药师送给妻子冯氏的定情之物，冯衡死后转交黄蓉。软猬甲刀枪不入，可防御内家拳掌。', null, '300', null, null, '件');
INSERT INTO `template_equipment` VALUES ('131', '锦麟甲', '5', '', null, '290', null, null, '件');
INSERT INTO `template_equipment` VALUES ('132', '怒龙锦胄', '5', '', null, '280', null, null, '件');
INSERT INTO `template_equipment` VALUES ('133', '碧鳞披', '5', '', null, '270', null, null, '件');
INSERT INTO `template_equipment` VALUES ('134', '乌蚕衣', '5', '', null, '260', null, null, '件');
INSERT INTO `template_equipment` VALUES ('135', '地龙甲', '5', '', null, '250', null, null, '件');
INSERT INTO `template_equipment` VALUES ('136', '天仇甲', '5', '', null, '250', null, null, '件');
INSERT INTO `template_equipment` VALUES ('137', '真丝宝甲', '5', '', null, '240', null, null, '件');
INSERT INTO `template_equipment` VALUES ('138', '蛇鳞甲', '5', '', null, '230', null, null, '件');
INSERT INTO `template_equipment` VALUES ('139', '幽魂甲', '5', '', null, '230', null, null, '件');
INSERT INTO `template_equipment` VALUES ('140', '金背心', '5', '', null, '220', null, null, '件');
INSERT INTO `template_equipment` VALUES ('141', '寒霜甲', '5', '', null, '210', null, null, '件');
INSERT INTO `template_equipment` VALUES ('142', '金环锁子甲', '5', '', null, '200', null, null, '件');
INSERT INTO `template_equipment` VALUES ('143', '月影甲', '5', '', null, '190', null, null, '件');
INSERT INTO `template_equipment` VALUES ('144', '黑犀甲', '5', '', null, '180', null, null, '件');
INSERT INTO `template_equipment` VALUES ('145', '灵光甲', '5', '', null, '170', null, null, '件');
INSERT INTO `template_equipment` VALUES ('146', '赤银甲', '5', '', null, '160', null, null, '件');
INSERT INTO `template_equipment` VALUES ('147', '虎子甲', '5', '', null, '150', null, null, '件');
INSERT INTO `template_equipment` VALUES ('148', '红鹤甲', '5', '', null, '140', null, null, '件');
INSERT INTO `template_equipment` VALUES ('149', '青天甲', '5', '', null, '130', null, null, '件');
INSERT INTO `template_equipment` VALUES ('150', '白皮甲', '5', '', null, '120', null, null, '件');
INSERT INTO `template_equipment` VALUES ('151', '铁网甲', '5', '', null, '110', null, null, '件');
INSERT INTO `template_equipment` VALUES ('152', '皮甲', '5', '', null, '100', null, null, '件');
INSERT INTO `template_equipment` VALUES ('153', '藤甲', '5', '', null, '30', null, null, '件');
INSERT INTO `template_equipment` VALUES ('154', '天蚕衣', '6', '', null, '200', null, null, '件');
INSERT INTO `template_equipment` VALUES ('155', '九阴穹光衣', '6', '', null, '190', null, null, '件');
INSERT INTO `template_equipment` VALUES ('156', '玄武战袍', '6', '', null, '180', null, null, '件');
INSERT INTO `template_equipment` VALUES ('157', '乌蚕背心', '6', '', null, '170', null, null, '件');
INSERT INTO `template_equipment` VALUES ('158', '鬼针胄', '6', '', null, '160', null, null, '件');
INSERT INTO `template_equipment` VALUES ('159', '金缕衣', '6', '', null, '150', null, null, '件');
INSERT INTO `template_equipment` VALUES ('160', '银狐氅', '6', '', null, '140', null, null, '件');
INSERT INTO `template_equipment` VALUES ('161', '紫鲛衫', '6', '', null, '130', null, null, '件');
INSERT INTO `template_equipment` VALUES ('162', '吹雪残云衣', '6', '', null, '120', null, null, '件');
INSERT INTO `template_equipment` VALUES ('163', '火浣衣', '6', '', null, '110', null, null, '件');
INSERT INTO `template_equipment` VALUES ('164', '雪羽披风', '6', '', null, '100', null, null, '件');
INSERT INTO `template_equipment` VALUES ('165', '松绿锦袍', '6', '', null, '90', null, null, '件');
INSERT INTO `template_equipment` VALUES ('166', '流索醉花衣', '6', '', null, '80', null, null, '件');
INSERT INTO `template_equipment` VALUES ('167', '英雄氅', '6', '', null, '70', null, null, '件');
INSERT INTO `template_equipment` VALUES ('168', '马甲', '6', '', null, '60', null, null, '件');
INSERT INTO `template_equipment` VALUES ('169', '燕行衣', '6', '', null, '50', null, null, '件');
INSERT INTO `template_equipment` VALUES ('170', '披风', '6', '', null, '40', null, null, '件');
INSERT INTO `template_equipment` VALUES ('171', '布衣', '6', '', null, '30', null, null, '件');

-- ----------------------------
-- Table structure for template_items
-- ----------------------------
DROP TABLE IF EXISTS `template_items`;
CREATE TABLE `template_items` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(20) NOT NULL,
  `unit` varchar(4) DEFAULT NULL,
  `description` varchar(500) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=704 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of template_items
-- ----------------------------
INSERT INTO `template_items` VALUES ('700', '无极仙丹', '颗', '武林至宝，史载乃秦始皇帝求长生不老之术，令仙客研制的仙丹，可使低于1500级的武功提升一级');
INSERT INTO `template_items` VALUES ('701', '玉菩提', '颗', '通体透明的小果，传说乃麒麟滴血地上所生之旷世异果，可使低于1000级的武功提升一级。');
INSERT INTO `template_items` VALUES ('702', '千年肉佛', '颗', '状若肉柱，粗如人臂，色呈肉红，阴凉滑软，生于深山古洞，为可遇不可求之物，可使低于700级的武功提升一级。');
INSERT INTO `template_items` VALUES ('703', '天元丹', '颗', '服用此药可增加一个甲子以上功力，武功大进，可使低于480级的武功提升一级。');

-- ----------------------------
-- Table structure for template_medicine
-- ----------------------------
DROP TABLE IF EXISTS `template_medicine`;
CREATE TABLE `template_medicine` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `medicineName` varchar(255) NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `description` varchar(500) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=311 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of template_medicine
-- ----------------------------
INSERT INTO `template_medicine` VALUES ('300', '金创药', '包', '这是一包武林人士必备的金创药。');
INSERT INTO `template_medicine` VALUES ('301', '养精丹', '粒', '这是一粒养精丹，可以用来恢复精神的良药。');
INSERT INTO `template_medicine` VALUES ('302', '贯气通脉丹', '粒', '这是一粒药丸，看上去银光闪闪，实是效果极佳疗伤圣药。');
INSERT INTO `template_medicine` VALUES ('303', '固元镇定丹', '包', '你一张嘴，吞下了返精散，不一会儿你只觉得精神为之一振。');
INSERT INTO `template_medicine` VALUES ('304', '凝血丸', '粒', '这是一粒药丸，呈现出淡淡的粉色，疗伤效果颇为不错。');
INSERT INTO `template_medicine` VALUES ('305', '返精散', '包', '这是一小包白色的粉末，具有镇定养精的效果。');
INSERT INTO `template_medicine` VALUES ('306', '双倍修为丹', '颗', '这是一颗暗红发亮的药丸，听说吃下去后一个时辰内（两个小时），战斗中所获得的修行翻两倍。');
INSERT INTO `template_medicine` VALUES ('307', '双倍潜能丹', '颗', '这是一颗暗红发亮的药丸，听说吃下去后一个时辰内（两个小时），战斗中所获得的潜能翻两倍。');
INSERT INTO `template_medicine` VALUES ('308', '银蛇胆', '颗', '这是一颗红冬冬的银蛇胆。');
INSERT INTO `template_medicine` VALUES ('309', '异蛇胆', '颗', '这是一颗红冬冬的异蛇胆。');
INSERT INTO `template_medicine` VALUES ('310', '金蛇胆', '颗', '这是一颗红冬冬的金蛇胆。');

-- ----------------------------
-- Table structure for type_skill
-- ----------------------------
DROP TABLE IF EXISTS `type_skill`;
CREATE TABLE `type_skill` (
  `userID` bigint(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `skillID` int(11) DEFAULT NULL,
  UNIQUE KEY `type` (`type`,`userID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_skill
-- ----------------------------
INSERT INTO `type_skill` VALUES ('888', '5', '4');
INSERT INTO `type_skill` VALUES ('888', '6', '10');
INSERT INTO `type_skill` VALUES ('888', '4', '8');
INSERT INTO `type_skill` VALUES ('888', '3', '9');
INSERT INTO `type_skill` VALUES ('888', '2', '19');
INSERT INTO `type_skill` VALUES ('888', '1', '7');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `peopleName` varchar(255) DEFAULT NULL,
  `sex` tinyint(2) DEFAULT NULL,
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `xiuXing` decimal(20,3) NOT NULL DEFAULT '0.000',
  `qianNeng` bigint(20) NOT NULL DEFAULT '0',
  `neiLi` int(10) NOT NULL DEFAULT '0',
  `onLineTimeLong` bigint(20) NOT NULL DEFAULT '0',
  `neiLiMax` bigint(20) DEFAULT NULL,
  `jingShen` bigint(20) DEFAULT NULL,
  `shengMing` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('888', '928721935', '492857c857c4de60b1aea8040c8ad3cd392e108b', '龙吟天下', '1', '2021-02-11 16:02:53', '2021-02-11 16:02:56', '156565601.223', '10009', '5000', '0', '0', '0', '0');
INSERT INTO `t_user` VALUES ('141205885119762432', '666666', '42f014110f3664ba190c89336d3a418cce16a025', '无名氏', null, '2021-02-11 16:03:02', '2021-02-11 16:03:00', '0.000', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for user_good
-- ----------------------------
DROP TABLE IF EXISTS `user_good`;
CREATE TABLE `user_good` (
  `userId` bigint(20) NOT NULL,
  `goodName` varchar(20) NOT NULL,
  `goodCount` int(11) NOT NULL,
  `unit` varchar(4) DEFAULT NULL,
  `goodType` int(5) DEFAULT NULL,
  `goodID` bigint(20) DEFAULT NULL,
  `description` varchar(500) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_good
-- ----------------------------
INSERT INTO `user_good` VALUES ('888', '破邪爪', '1', '个', '1', '11', '专门铲除妖魔的神爪，盘古开天时天地灵气孕育而成，积聚着宇宙一切的精华，没人能够估测它的威力。');
INSERT INTO `user_good` VALUES ('888', '软猬甲', '1', '件', '1', null, '是黄药师送给妻子冯氏的定情之物，冯衡死后转交黄蓉。软猬甲刀枪不入，可防御内家拳掌。');
INSERT INTO `user_good` VALUES ('888', '天蚕衣', '1', '件', '1', null, '用天蚕丝编织而成的衣服。');
INSERT INTO `user_good` VALUES ('888', '汤魔战靴', '1', '双', '1', null, '神界的宝物，神将们斩妖除魔时穿的战靴。');
INSERT INTO `user_good` VALUES ('888', '金创药', '34', '包', '2', null, '金创药');
INSERT INTO `user_good` VALUES ('888', '银蛇胆', '56', '颗', '2', null, '银蛇胆');
INSERT INTO `user_good` VALUES ('888', '无极仙丹', '152', '颗', '4', null, '无极仙丹');
INSERT INTO `user_good` VALUES ('888', '降龙十八章秘籍', '1', '本', '3', null, '一本降龙十八掌秘籍。');
INSERT INTO `user_good` VALUES ('888', '剑法指南', '1', '本', '3', null, '剑法指南');
INSERT INTO `user_good` VALUES ('888', '十方封魔斩', '1', '把', '1', null, '十方封魔斩乃是用后羿当年射下天帝九子，并射杀无数上古众神那只十只乌铁射日箭锻造而成。');
INSERT INTO `user_good` VALUES ('888', '乘风万里伏', '1', '把', '1', null, '王莽铸，铭曰乘胜万里伏小篆书，三尺六寸，莽造威斗及神剑皆链五色石为之。');
