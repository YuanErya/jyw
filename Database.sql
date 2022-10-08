DROP DATABASE IF EXISTS jyw;
CREATE DATABASE IF NOT EXISTS jyw;
USE jyw;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `recruitment`;
CREATE TABLE `recruitment`  (
                                `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '招聘id',
                                `type` int NOT NULL COMMENT '类型',
                                `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                                `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                                `create_time` datetime NOT NULL COMMENT '发布时间',
                                PRIMARY KEY (`id`) USING BTREE,
                                INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '招聘实习表' ROW_FORMAT = DYNAMIC;

INSERT INTO `recruitment` VALUES (1,1001,'招聘岗位1','测试内容1','2020-01-02 19:06:51');
INSERT INTO `recruitment` VALUES (2,1003,'实习岗位1','测试内容2','2019-04-29 19:54:23');
INSERT INTO `recruitment` VALUES (3,1001,'招聘岗位2','测试内容3','2019-01-01 14:53:04');
INSERT INTO `recruitment` VALUES (4,1001,'招聘岗位3','测试内容4','2018-06-21 08:05:43');


DROP TABLE IF EXISTS `speech`;
CREATE TABLE `speech`  (
                           `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '宣讲会id',
                           `type` int NOT NULL COMMENT '类型',
                           `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                           `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '地址',
                           `start_date` datetime NOT NULL COMMENT '开始日期',
                           `start_time` datetime NOT NULL COMMENT '开始时间',
                           `end_time` datetime NOT NULL COMMENT '结束时间',
                           `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                           `create_time` datetime NOT NULL COMMENT '发布时间',
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `title`(`title`) USING BTREE,
                           INDEX `create_time`(`create_time`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '宣讲会表' ROW_FORMAT = DYNAMIC;

INSERT INTO `speech` VALUES (1,10021,'极氪汽车（宁波杭州湾新区）有限公司2022届春季校园招聘宣讲会','老图书馆学术报告厅','2022-07-08 19:00:00','2022-07-08 19:00:00','2022-07-08 21:00:00','测试内容1','2022-01-02 19:06:51');
INSERT INTO `speech` VALUES (2,10021,'xxxxx宣讲会','xxxx学术报告厅','2022-12-25 19:00:00','2022-12-25 19:00:00','2022-12-25 21:00:00','测试内容2','2022-07-05 19:06:51');
INSERT INTO `speech` VALUES (3,10022,'测试宣讲会1','测试内容3','2022-10-12 19:00:00','2022-10-12 19:00:00','2022-10-12 21:00:00','测试内容2','2022-09-05 19:06:51');
INSERT INTO `speech` VALUES (4,10022,'测试宣讲会2','测试内容4','2022-11-23 19:00:00','2022-11-23 19:00:00','2022-11-23 21:00:00','测试内容2','2022-08-05 19:06:51');
DROP TABLE IF EXISTS `job_guide`;
CREATE TABLE `job_guide`  (
                              `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '就业指导id',
                              `type` int NOT NULL COMMENT '类型',
                              `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                              `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                              `create_time` datetime NOT NULL COMMENT '发布时间',
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '就业指导表' ROW_FORMAT = DYNAMIC;

INSERT INTO `job_guide` VALUES (1,2000,'就业直通车第51期','测试内容1','2020-01-02 19:06:51');
INSERT INTO `job_guide` VALUES (2,2000,'就业直通车第50期','测试内容2','2019-04-29 19:54:23');
INSERT INTO `job_guide` VALUES (3,2000,'就业直通车第49期','测试内容3','2019-01-01 14:53:04');
INSERT INTO `job_guide` VALUES (4,2000,'就业直通车第48期','测试内容4','2018-06-21 08:05:43');



DROP TABLE IF EXISTS `workplace_activity`;
CREATE TABLE `workplace_activity`  (
                                       `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '职场活动id',
                                       `type` int NOT NULL COMMENT '类型',
                                       `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                                       `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                                       `create_time` datetime NOT NULL COMMENT '发布时间',
                                       PRIMARY KEY (`id`) USING BTREE,
                                       INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '职场活动表' ROW_FORMAT = DYNAMIC;

INSERT INTO `workplace_activity` VALUES (1,4000,'重庆邮电大学“走进职场”系列讲座（总第76期）——面试礼仪讲座','测试内容1','2019-05-16 10:46:57');
INSERT INTO `workplace_activity` VALUES (2,4000,'重庆邮电大学“走进职场”系列讲座（总第75期）——无领导小组面试技巧讲座','测试内容2','2019-05-10 19:21:35');
INSERT INTO `workplace_activity` VALUES (3,4000,'重庆邮电大学“走进职场”系列讲座（总第74期）——简历撰写技巧讲座','测试内容3','2019-04-30 11:35:47');
INSERT INTO `workplace_activity` VALUES (4,4000,'重庆邮电大学“走进职场”系列讲座（总第73期）——公务员（选调生）考试备考讲座','测试内容4','2019-03-19 16:08:14');



DROP TABLE IF EXISTS `news_trends`;
CREATE TABLE `news_trends`  (
                                `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '新闻动态id',
                                `type` int NOT NULL COMMENT '类型',
                                `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                                `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                                `create_time` datetime NOT NULL COMMENT '发布时间',
                                PRIMARY KEY (`id`) USING BTREE,
                                INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '新闻动态表' ROW_FORMAT = DYNAMIC;

INSERT INTO `news_trends` VALUES (1,5000,'重庆邮电大学第76期“走进职场”系列讲座——面试礼仪专场讲座成功举办','测试内容1','2019-05-23 17:37:32');
INSERT INTO `news_trends` VALUES (2,5000,'重庆邮电大学2019年就业服务月系列活动开幕式顺利举行','测试内容2','2019-05-10 19:20:17');
INSERT INTO `news_trends` VALUES (3,5000,'重庆邮电大学第74期“走进职场”系列讲座——简历撰写技巧讲座成功举办','测试内容3','2019-05-09 17:59:33');
INSERT INTO `news_trends` VALUES (4,5000,'重庆邮电大学第73期“走进职场”系列讲座——公务员（选调生）考试备考讲座成功举办','测试内容4','2019-03-26 08:59:11');

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE `bulletin`  (
                             `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '公告id',
                             `type` int NOT NULL COMMENT '公告类型',
                             `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '标题',
                             `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                             `create_time` datetime NOT NULL COMMENT '发布时间',
                             PRIMARY KEY (`id`) USING BTREE,
                             INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告表' ROW_FORMAT = DYNAMIC;

INSERT INTO `bulletin` VALUES (1,3001,'重庆邮电大学2022年秋季学期用人单位线下校园招聘服务安排','测试内容1','2022-09-20 09:45:44');
INSERT INTO `bulletin` VALUES (2,3002,'2019年大学生志愿服务西部计划招募公告','测试内容2','2019-05-13 10:01:27');
INSERT INTO `bulletin` VALUES (3,3002,'重庆邮电大学2019年征兵公告','测试内容3','2019-05-13 09:22:56');
INSERT INTO `bulletin` VALUES (4,3001,'【用人单位邀请函】重庆邮电大学2023届毕业生秋季空中双选会(首场)','测试内容4','2022-09-02 16:31:52');

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
                              `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '学院id',
                              `type` int NOT NULL COMMENT '类型',
                              `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '学院',
                              `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                              `create_time` datetime NOT NULL COMMENT '发布时间',
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学院风采表' ROW_FORMAT = DYNAMIC;

INSERT INTO `department` VALUES (1,8000,'通信与信息工程','测试内容1','2020-01-02 19:06:51');
INSERT INTO `department` VALUES (2,8000,'计算机科学与技术','测试内容2','2019-04-29 19:54:23');
INSERT INTO `department` VALUES (3,8000,'自动化学院','测试内容3','2019-01-01 14:53:04');
INSERT INTO `department` VALUES (4,8000,'先进制造学院','测试内容4','2018-06-21 08:05:43');


DROP TABLE IF EXISTS `enterprises`;
CREATE TABLE `enterprises`  (
                              `id` int UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '企业id',
                              `type` int NOT NULL COMMENT '类型',
                              `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '企业',
                              `content` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
                              `create_time` datetime NOT NULL COMMENT '发布时间',
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `title`(`title`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '知名企业表' ROW_FORMAT = DYNAMIC;

INSERT INTO `enterprises` VALUES (1,6000,'知名企业1','测试内容1','2020-01-02 19:06:51');
INSERT INTO `enterprises` VALUES (2,6000,'知名企业2','测试内容2','2019-04-29 19:54:23');
INSERT INTO `enterprises` VALUES (3,6000,'知名企业3','测试内容3','2019-01-01 14:53:04');
INSERT INTO `enterprises` VALUES (4,6000,'知名企业4','测试内容4','2018-06-21 08:05:43');


