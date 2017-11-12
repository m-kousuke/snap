-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2017 年 11 朁E12 日 06:33
-- サーバのバージョン： 5.7.13-log
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `snap`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `learning_files`
--

CREATE TABLE `learning_files` (
  `id` int(11) NOT NULL,
  `path` text NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `student_id` text NOT NULL,
  `file_name` text NOT NULL,
  `time` text NOT NULL,
  `kind` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `lessons`
--

CREATE TABLE `lessons` (
  `id` int(11) NOT NULL,
  `subject` text NOT NULL,
  `title` text NOT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `lessons`
--

INSERT INTO `lessons` (`id`, `subject`, `title`, `date`) VALUES
(1, '情報', 'システムを作ろう①', '2017/11/10(金)'),
(2, '情報', 'システムを作ろう②', '2017/11/17(金)'),
(3, '情報', 'システムを作ろう③', '2017/11/24(金)'),
(4, '情報', 'システムを作ろう④', '2017/12/01(金)');

-- --------------------------------------------------------

--
-- テーブルの構造 `response_data_peer_assessment`
--

CREATE TABLE `response_data_peer_assessment` (
  `id` int(11) NOT NULL,
  `student_id` text NOT NULL,
  `subject_student_id` text NOT NULL,
  `response` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `line` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `response_data_self_assessment`
--

CREATE TABLE `response_data_self_assessment` (
  `id` int(11) NOT NULL,
  `student_id` text NOT NULL,
  `response` int(11) NOT NULL,
  `lesson_id` int(11) NOT NULL,
  `line` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- テーブルの構造 `students`
--

CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `student_id` text NOT NULL,
  `password` text NOT NULL,
  `student_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `students`
--

INSERT INTO `students` (`id`, `student_id`, `password`, `student_name`) VALUES
(1, 'test', 'test', 'test_name'),
(2, 'sub_test1', 'sub_test1', 'sub_test1_name'),
(3, 'sub_test2', 'sub_test2', 'sub_test2_name'),
(4, 'sub_test3', 'sub_test3', 'sub_test3_name'),
(5, 'sub_test4', 'sub_test4', 'sub_test4_name'),
(6, 'sub_test5', 'sub_test5', 'sub_test5_name'),
(7, 'sub_test6', 'sub_test6', 'sub_test6_name'),
(8, 'sub_test7', 'sub_test7', 'sub_test7_name'),
(9, 'sub_test8', 'sub_test8', 'sub_test8_name'),
(10, 'sub_test9', 'sub_test9', 'sub_test9_name'),
(11, 'sub_test10', 'sub_test10', 'sub_test10_name'),
(12, 'sub_test11', 'sub_test11', 'sub_test11_name'),
(13, 'sub_test12', 'sub_test12', 'sub_test12_name'),
(14, 'sub_test13', 'sub_test13', 'sub_test13_name'),
(15, 'sub_test14', 'sub_test14', 'sub_test14_name'),
(16, 'sub_test15', 'sub_test15', 'sub_test15_name'),
(17, 'sub_test16', 'sub_test16', 'sub_test16_name'),
(18, 'sub_test17', 'sub_test17', 'sub_test17_name'),
(19, 'sub_test18', 'sub_test18', 'sub_test18_name'),
(20, 'sub_test19', 'sub_test19', 'sub_test19_name'),
(21, 'sub_test20', 'sub_test20', 'sub_test20_name'),
(22, 'sub_test21', 'sub_test21', 'sub_test21_name'),
(23, 'sub_test22', 'sub_test22', 'sub_test22_name'),
(24, 'sub_test23', 'sub_test23', 'sub_test23_name'),
(25, 'sub_test24', 'sub_test24', 'sub_test24_name'),
(26, 'sub_test25', 'sub_test25', 'sub_test25_name'),
(27, 'sub_test26', 'sub_test26', 'sub_test26_name'),
(28, 'sub_test27', 'sub_test27', 'sub_test27_name'),
(29, 'sub_test28', 'sub_test28', 'sub_test28_name'),
(30, 'sub_test29', 'sub_test29', 'sub_test29_name');

-- --------------------------------------------------------

--
-- テーブルの構造 `teachers`
--

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL,
  `teacher_id` text NOT NULL,
  `password` text NOT NULL,
  `teacher_name` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- テーブルのデータのダンプ `teachers`
--

INSERT INTO `teachers` (`id`, `teacher_id`, `password`, `teacher_name`) VALUES
(1, 'admin', 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `learning_files`
--
ALTER TABLE `learning_files`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `lessons`
--
ALTER TABLE `lessons`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `response_data_peer_assessment`
--
ALTER TABLE `response_data_peer_assessment`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `response_data_self_assessment`
--
ALTER TABLE `response_data_self_assessment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `learning_files`
--
ALTER TABLE `learning_files`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `lessons`
--
ALTER TABLE `lessons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `response_data_peer_assessment`
--
ALTER TABLE `response_data_peer_assessment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `response_data_self_assessment`
--
ALTER TABLE `response_data_self_assessment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT for table `teachers`
--
ALTER TABLE `teachers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
