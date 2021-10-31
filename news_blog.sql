-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 16, 2019 at 03:12 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `news_blog`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL,
  `body` longtext,
  `date_created` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL,
  `post_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `body`, `date_created`, `creator_id`, `post_id`) VALUES
(1, 'This is a good post', '2019-01-17 00:00:00', 2, 5),
(2, 'I didn\'t like it.', '2019-01-17 00:00:00', 2, 5),
(5, 'cfgvbhnjmgygjhjkhjm', '2019-01-15 11:54:53', 2, 4),
(8, 'dfhssdjfiosjafijsiafjiksjkfdsmdf sdfa', '2019-01-15 12:04:04', 2, 6),
(9, 'dsafjasdifjaiojfilkajsdkfjiodsajfklajksdnfmsdx', '2019-01-15 12:11:37', 2, 4),
(10, 'jasijfijalksdfkdsfmkasdjfkdjsaiojfsaidjfknds kf', '2019-01-15 12:37:57', 2, 3),
(11, 'jdsiajfijsdifjioasjdifjas', '2019-01-15 13:01:22', 2, 4),
(12, 'daisfjijdiofjiasjdifjiksdfljklsdjfka', '2019-01-15 13:01:30', 2, 4),
(13, 'dsjfijaiodjfijasiofjiajskfljdsfkl', '2019-01-15 13:01:37', 2, 4),
(14, 'sdjifoajidjifjaijfijsdaifjaiof', '2019-01-15 13:01:44', 2, 4),
(15, 'dsijfijijdsiflajidfjlkajfiokljfa', '2019-01-15 13:01:54', 2, 4),
(16, 'dsfsafsdfsafsdfadfsafsadffasfad', '2019-01-16 01:41:12', 2, 3);

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `body` longtext,
  `date_created` datetime DEFAULT NULL,
  `creator_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`id`, `title`, `body`, `date_created`, `creator_id`) VALUES
(3, 'Sample blog', '\r\n        <p>Cum sociis natoque penatibus et magnis <a href=\"#\">dis parturient montes</a>, nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum.</p>\r\n        <blockquote>\r\n          <p>Curabitur blandit tempus porttitor. <strong>Nullam quis risus eget urna mollis</strong> ornare vel eu leo. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>\r\n        </blockquote>\r\n        <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>\r\n        <p>Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>\r\n', '2019-01-25 00:00:00', 2),
(4, 'Politics', '\r\nLorem ipsum dolor, sit amet consectetur adipisicing elit. Suscipit modi vero, iure obcaecati architecto aliquam non cum assumenda dolorum! Magni deleniti possimus ut, id aut perspiciatis obcaecati aliquam deserunt eos modi quasi placeat saepe exercitationem autem voluptates consequuntur cum repellat architecto harum aspernatur quidem illum maxime labore vero! Suscipit facilis eveniet id sapiente voluptatem obcaecati ipsam. Velit itaque incidunt dolorem esse dolorum tenetur earum praesentium veniam. Adipisci, porro expedita? Veniam praesentium quos fugiat consectetur ut placeat, dolorem pariatur. Eos unde magnam expedita saepe maiores, reprehenderit ut sit eveniet placeat corrupti dolorum laboriosam reiciendis repellat minima quos architecto harum quod excepturi a labore nam illum doloremque autem officiis? Nam explicabo esse qui necessitatibus eveniet quisquam sit eum voluptate corrupti exercitationem veritatis excepturi laborum repellat molestias hic est iure, dolor fugiat rerum sequi expedita similique maiores ullam! Ad maiores ullam consequuntur fuga corrupti? Consectetur, consequatur sequi quae animi eligendi reiciendis omnis iure temporibus iste aut ex nostrum, placeat soluta tenetur ipsum, accusantium quo. Tempora veniam nemo dicta officiis et ex repellat accusamus recusandae, impedit enim quos expedita, nesciunt esse asperiores, quibusdam mollitia. Quia aut dolorum fugit accusantium error consequatur expedita veritatis quaerat beatae sed velit debitis repellat porro, repudiandae, atque facilis fugiat?', '2019-01-14 06:17:06', 1),
(5, 'Web Design Today', '<p class=\"lead\">This is the lead paragraph of the article. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget.</p>\r\n              <div id=\"post-content\">\r\n                <p class=\"text-sm\"><strong>Pellentesque habitant morbi tristique</strong> senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. <em>Aenean ultricies mi vitae est.</em> Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, <code>commodo vitae</code>, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. <a href=\"#\">Donec non enim</a> in turpis pulvinar facilisis. Ut felis.</p>\r\n                \r\n                <h2>Header Level 2</h2>\r\n                <ol>\r\n                  <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>\r\n                  <li>Aliquam tincidunt mauris eu risus.</li>\r\n                </ol>\r\n                <blockquote class=\"blockquote\">\r\n                  <p class=\"text-sm\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna. Cras in mi at felis aliquet congue. Ut a est eget ligula molestie gravida. Curabitur massa. Donec eleifend, libero at sagittis mollis, tellus est malesuada tellus, at luctus turpis elit sit amet quam. Vivamus pretium ornare est.</p>\r\n                </blockquote>\r\n                <h3>Header Level 3</h3>\r\n                <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>\r\n                <ul>\r\n                  <li>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</li>\r\n                  <li>Aliquam tincidunt mauris eu risus.</li>\r\n                </ul>\r\n                \r\n                <p>Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum tortor quam, feugiat vitae, ultricies eget, tempor sit amet, ante. Donec eu libero sit amet quam egestas semper. Aenean ultricies mi vitae est. Mauris placerat eleifend leo. Quisque sit amet est et sapien ullamcorper pharetra. Vestibulum erat wisi, condimentum sed, commodo vitae, ornare sit amet, wisi. Aenean fermentum, elit eget tincidunt condimentum, eros ipsum rutrum orci, sagittis tempus lacus enim ac dui. Donec non enim in turpis pulvinar facilisis. Ut felis. Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus</p>\r\n              ', '2019-01-14 08:38:11', 1),
(6, 'BAHRAIN GRAND PRIX : WILL SEBASTIAN VETTEL REGIN IN THE HEART OF THE DESERT', '<p class=\"mt-30\">Duis non volutpat arcu, eu mollis tellus. Sed finibus aliquam neque sit amet sodales. \r\n							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, \r\n							consectetur adipiscing elit. Nulla maximus pellentes que velit, quis consequat nulla effi \r\n							citur at.Maecenas sed massa tristique.Duis non volutpat arcu, eu mollis tellus.\r\n							Sed finibus aliquam neque sit amet sodales. Lorem ipsum dolor sit amet, \r\n							consectetur adipiscing elit. Nulla maximus pellentes que velit, quis consequat nulla \r\n							effi citur at. effi citur at.Maecenas sed massa tristique.\r\n							Duis non volutpat arcu, eu mollis tellus. Sed finibus aliquam neque sit amet sodales. \r\n							Lorem ipsum dolor sit amet, \r\n							consectetur adipiscing elit. Nulla maximus pellentes que velit, quis consequat nulla effi \r\n							citur at. Maecenas sed massa tristique.Duis non volutpat arcu, eu mollis tellus. </p>\r\n						<p class=\"mtb-15\">Sed finibus aliquam neque sit amet sodales. Lorem ipsum dolor sit amet, \r\n							consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. \r\n							Nulla maximus pellentes que velit, quis nulla effi citur at.Maecenas sed massa tristique.\r\n							consectetur adipiscing elit. Nulla maximus pellentes que velit, quis consequat nulla \r\n							effi citur at. effi citur at.Maecenas sed massa tristique.\r\n							Duis non volutpat arcu, eu mollis tellus. Sed finibus aliquam neque sit amet sodales. \r\n							Lorem ipsum dolor sit amet\r\n							consectetur adipiscing elit. Nulla maximus pellentes que velit, quis consequat nulla effi \r\n							citur at.Maecenas sed massa tristique.Duis non volutpat arcu, eu mollis tellus.\r\n						</p>\r\n<p class=\"mb-15\"><em>\"Pellentes que velit, quis nulla effi citur at.\r\n								Maecenas sed massa tristique.consectetur adipiscing elit. Nulla maximus pellentes que velit, quis \r\n								consequat nulla effi citur at. effi citur at.Maecenas sed massa tristique.\r\n								Duis non volutpat arcu, eu mollis tellus. Sed finibus aliquam neque sit amet sodales. \r\n								Lorem ipsum dolor si.\"</em>\r\n								\r\n							</p>\r\n							<h6><b>MICHEL JORDAN</b></h6>\r\n\r\n						<p class=\"mtb-15\">Liquam neque sit amet sodales. Lorem ipsum dolor sit amet, \r\n							consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. \r\n							Nulla maximus pellentes que velit, quis nulla effi citur at.Maecenas sed massa tristique.\r\n							consectetur adipiscing elit. Nulla maximus pellentes que velit, quis consequat nulla \r\n							effi citur at. effi citur at.Maecenas sed massa tristique.\r\n							Duis non volutpat arcu, eu mollis tellus. Sed finibus aliquam neque sit amet sodales. \r\n							Lorem ipsum dolor sit amet\r\n							consectetur adipiscing elit. Nulla maximus pellentes que velit, quis consequat nulla effi \r\n							citur at.Maecenas sed massa tristique.Duis non volutpat arcu, eu mollis tellus.\r\n						</p>\r\n						', '2019-01-14 11:39:15', 2);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 'USER'),
(2, 'STAFF');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `enabled` int(11) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `enabled`, `first_name`, `last_name`, `password`, `phone_number`, `username`) VALUES
(1, 1, 'Eyob', 'alex', '$2a$10$ddcsRajKAqdsKY4hWZIexuOnunjrEovsPgy75BpFdp2PqnktKxiZ.', '091-330-5247', 'eyobalex'),
(2, 1, 'Eyoba', 'alex', '$2a$10$OBjDBXAbeMHt6Ltotkj2o.M8Ve./tot2vjvn5XN4mgJ073mKFlW32', '091-330-5247', 'eyobalex2'),
(3, 1, 'jhon', 'doe', '$2a$10$akYc4qhSVAYE7DHvcpPbg.PBWX6o8ehLIIPzzy4vESm6EUMJGwx22', '091-111-1111', 'jhon'),
(4, 1, 'new', 'user', '$2a$10$gmtEzZBgFczba8670FzGWeQEbU4LxZtaGpYg.GSgan.bf58fQMUl.', '111-111-1111', 'newuser');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 2),
(2, 1),
(3, 1),
(4, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpv26vrgsh9237ufeforw5yfqu` (`creator_id`),
  ADD KEY `FKs1slvnkuemjsq2kj4h3vhx7i1` (`post_id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKko69comcms0m0mb60dprlj95r` (`creator_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FKpv26vrgsh9237ufeforw5yfqu` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKs1slvnkuemjsq2kj4h3vhx7i1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FKko69comcms0m0mb60dprlj95r` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
