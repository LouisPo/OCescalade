-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 08 Novembre 2020 à 17:14
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ocescalade`
--

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `comment_id` int(11) NOT NULL,
  `textarea` varchar(100) NOT NULL,
  `user` int(11) NOT NULL,
  `parcoursidentifiant` int(11) NOT NULL,
  `identite` varchar(30) NOT NULL,
  `date` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commentaire`
--

INSERT INTO `commentaire` (`comment_id`, `textarea`, `user`, `parcoursidentifiant`, `identite`, `date`) VALUES
(519, 'j aime pas la siberie', 15, 2051, 'durand', '2020-10-28'),
(518, 'durand adore adventurland', 15, 48, 'durand', '2020-10-28'),
(516, 'super ', 7, 48, 'macron', '2020-10-28'),
(509, 'poirot 19', 13, 8, 'poirot', '2020-10-28'),
(510, 'poirot 20', 13, 8, 'poirot', '2020-10-28'),
(514, 'bien', 7, 48, 'macron', '2020-10-28'),
(513, 'no', 13, 8, 'poirot', '2020-10-28'),
(503, 'macron aime bien les parcs', 7, 8, 'macron', '2020-10-28'),
(500, 'nullisime', 15, 8, 'durand', '2020-10-28'),
(511, 'yes', 13, 8, 'poirot', '2020-10-28'),
(502, 'macron aime bien le parc', 7, 8, 'macron', '2020-10-28'),
(499, 'fantastique', 15, 8, 'durand', '2020-10-28'),
(422, 'pas mal', 13, 2042, 'poirot', '2020-08-30'),
(523, 'macron adore la siberie', 7, 2051, 'macron', '2020-10-28'),
(505, 'durand 19', 15, 8, 'durand', '2020-10-28'),
(497, 'genial', 15, 8, 'durand', '2020-10-28'),
(430, 'bon', 13, 2044, 'poirot', '2020-09-17'),
(432, 'sympa', 13, 2020, 'poirot', '2020-10-06'),
(517, 'genial', 7, 48, 'macron', '2020-10-28'),
(440, 'bien', 13, 2050, 'poirot', '2020-10-18'),
(525, 'macron aime la siberieeeee\r\n', 7, 2051, 'macron', '2020-10-28'),
(521, 'les temperatures sont de - 50 degres', 15, 2051, 'durand', '2020-10-28'),
(495, 'covid 22', 13, 2, 'poirot', '2020-10-28'),
(531, 'bien', 13, 2, 'poirot', '2020-10-30');

-- --------------------------------------------------------

--
-- Structure de la table `parcours`
--

CREATE TABLE `parcours` (
  `parcours_id` int(10) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `taille` int(10) NOT NULL,
  `difficulte` varchar(3) NOT NULL,
  `localisation` varchar(20) NOT NULL,
  `validation` varchar(3) NOT NULL DEFAULT 'NON',
  `voie` int(11) NOT NULL,
  `secteur` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `parcours`
--

INSERT INTO `parcours` (`parcours_id`, `nom`, `taille`, `difficulte`, `localisation`, `validation`, `voie`, `secteur`) VALUES
(2, 'disneyparis', 12, '3', 'marne', 'OUI', 2, 48),
(7, 'disney', 20, '4a', 'mereville', 'OUI', 0, 0),
(3, 'pont', 23, '4b', 'etampes', 'OUI', 4, 48),
(4, 'chateau', 36, '4c', 'etampes', '', 0, 0),
(5, 'carriere', 65, '4a', 'etampes', 'OUI', 0, 0),
(6, 'disney', 89, '4b', 'mereville', '', 0, 0),
(25, 'essai2', 26, '4c', 'bretz', '', 0, 0),
(8, 'parc', 60, '3', 'etampes', 'OUI', 2, 48),
(9, 'parc', 30, '3', 'etampes', 'OUI', 1, 48),
(10, 'parc', 30, '3', 'etampes', 'OUI', 25, 0),
(11, 'parc', 30, '3', 'etampes', '', 25, 0),
(12, 'parc', 30, '5b', 'etampes', '', 0, 0),
(13, 'parc', 20, '5c', 'etampes', '', 0, 0),
(14, 'toile', 48, '5c', 'etampes', '', 0, 0),
(15, 'toile', 48, '6a', 'mereville', '', 0, 0),
(16, '25', 35, '6a', 'etampes', '', 0, 0),
(17, 'qsdsqd', 25, '6b', 'etampes', '', 0, 0),
(1, 'disney', 25, '6b', 'etampes', 'OUI', 0, 0),
(18, 'essai2', 25, '6c', 'etampes', '', 0, 0),
(19, 'toile', 30, '6c', 'etampes', '', 5, 75),
(20, 'essai2', 15, '7a', 'marseille', '', 0, 0),
(21, 'mereville', 45, '7a', 'etampes', 'OUI', 0, 0),
(22, 'sdsd', 25, '7b', 'etampes', '', 0, 0),
(23, 'sdsd', 15, '7b', 'etampes', '', 0, 0),
(39, 'mac', 24, '7c', 'mereville', '', 0, 0),
(24, 'etampes', 25, '7c', 'etampes', 'OUI', 0, 0),
(36, 'essai15', 30, '8a', 'bretz', '', 0, 0),
(37, 'carriere', 25, '8a', 'essonne', '', 0, 0),
(38, 'bienetre', 26, '8b', 'lardy', '', 0, 0),
(40, 'disney', 2000, '8b', 'marne', '', 0, 0),
(41, 'disney', 25, '8c', 'marne', '', 0, 0),
(42, 'adventureland', 26, '8c', 'marne', 'OUI', 0, 0),
(43, 'adventurland', 23, '9a', 'marne', '', 0, 0),
(44, 'avendurland', 25, '9a', 'marne', 'OUI', 0, 0),
(45, 'avendurland', 25, '9b', 'marne', '', 0, 0),
(46, 'avendurland', 25, '9b', 'marne', '', 0, 0),
(47, 'parcour1', 25, '4c', 'marne', '', 0, 0),
(48, 'adventurland', 30, '4a', 'marne', '', 0, 0),
(2013, 'frontierland', 48, '5b', 'etampes', '', 0, 0),
(2014, 'mac', 20, '5c', 'bretz', '', 0, 0),
(2026, 'babyland', 25, '6a', 'moscou', '', 0, 0),
(2016, 'gare', 21, '6c', 'paris', '', 0, 0),
(2017, 'parc', 90, '7b', 'etampes', '', 0, 0),
(2018, 'parc', 91, '7a', 'etampes', '', 0, 0),
(2020, 'parc', 26, '3', 'bretz', 'OUI', 0, 0),
(2021, 'parc', 69, '8c', 'bretz', '', 0, 0),
(2022, 'parc', 78, '8b', 'marne', '', 0, 0),
(2023, 'disney', 89, '9a', 'etampes', '', 0, 0),
(2024, 'parc', 23, '9c', 'paris', '', 0, 0),
(2025, 'disneyland', 49, '3', 'japon', 'OUI', 0, 0),
(2027, 'foret', 5, '9b', 'paris', '', 0, 0),
(2028, 'station', 6, '3', 'paris', 'OUI', 0, 0),
(2029, 'ubex', 26, '6c', 'paris', '', 0, 0),
(2030, 'station', 1, '6c', 'londre', '', 0, 0),
(2045, 'chemin', 23, '5a', 'tours', 'NON', 0, 0),
(2044, 'montagne', 14, '6b', 'voges', 'NON', 0, 0),
(2043, 'montagne', 14, '6b', 'voges', 'NON', 0, 0),
(2042, 'plage', 12, '3 ', 'marseille', 'NON', 0, 0),
(2041, 'parc', 42, '3 ', 'marseille', 'NON', 0, 0),
(2046, 'parc', 21, '6c', 'paris', 'NON', 0, 0),
(2047, 'champ', 12, '3 ', 'paris', 'NON', 0, 0),
(2048, 'parc', 12, '3 ', 'orleans', 'NON', 0, 0),
(2049, 'parc', 42, '3 ', 'paris', 'NON', 3, 26),
(2050, 'centre', 3, '3 ', 'marseille', 'OUI', 6, 12),
(2051, 'siberie', 25, '3a', 'russie', 'NON', 26, 48),
(2052, 'parc', 12, '3 ', 'paris', 'NON', 15, 2),
(2053, 'lac', 12, '3 ', 'marseille', 'NON', 3, 5);

-- --------------------------------------------------------

--
-- Structure de la table `topo`
--

CREATE TABLE `topo` (
  `topo_id` int(2) NOT NULL,
  `nomtopo` varchar(30) NOT NULL,
  `user_id` int(2) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `dispo` varchar(5) NOT NULL,
  `textarea` varchar(200) NOT NULL,
  `identifiantpret` int(5) NOT NULL,
  `datedecreation` varchar(20) NOT NULL,
  `lieu` varchar(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `topo`
--

INSERT INTO `topo` (`topo_id`, `nomtopo`, `user_id`, `nom`, `prenom`, `dispo`, `textarea`, `identifiantpret`, `datedecreation`, `lieu`) VALUES
(72, 'topoPisac', 54, 'Pisac', 'jacque', 'PRETE', 'topo jp', 56, '', 'paris'),
(58, 'topoDupont', 53, 'Dupont', 'Jean', 'PRETE', 'Ceci est le topo de Dupont jean', 55, '', 'california'),
(55, 'topodurand', 15, 'durand', 'ADhenri', 'OUI', 'topo durand', 0, '2020-11-01', 'di'),
(81, 'topomacron', 7, 'macron', 'jean', 'REFUS', 'gros ', 0, '2020-11-01', 'espagne'),
(73, 'topoBlia', 55, 'Blia', 'Paul', 'OUI', 'topo paul', 0, '2020-11-01', 'marseille'),
(101, 'topoJean', 56, 'Jean', 'marc', 'REFUS', 'topo jean', 0, '2020-11-07', 'france'),
(84, 'topopoirot', 13, 'poirot', 'ADeric', '', '', 0, '2020-11-07', ''),
(100, 'topotrump', 41, 'trump', 'donald', 'OUI', 'trump topo', 0, '2020-11-07', 'usa');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `mail` varchar(40) NOT NULL,
  `tel` int(10) NOT NULL,
  `mdp` varchar(150) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`user_id`, `nom`, `prenom`, `mail`, `tel`, `mdp`) VALUES
(15, 'durand', 'ADhenri', 'durand@gmail.com', 615108987, '$2a$10$ik4XHIc/WqjZaUf1q2FQrO3wrfYrf0TkaQpItPVd67zb9dG/GAf7G'),
(13, 'poirot', 'ADeric', 'eoirot@gmail.com', 6489999, '$2a$10$ik4XHIc/WqjZaUf1q2FQrO3wrfYrf0TkaQpItPVd67zb9dG/GAf7G'),
(12, 'henri', 'ADdes', 'toto@gmail.com', 61540222, '$2a$10$ik4XHIc/WqjZaUf1q2FQrO3wrfYrf0TkaQpItPVd67zb9dG/GAf7G'),
(7, 'macron', 'jean', 'macron@toto.com', 7896936, '$2a$10$ik4XHIc/WqjZaUf1q2FQrO3wrfYrf0TkaQpItPVd67zb9dG/GAf7G'),
(52, 'plua', 'charle', 'charle@gmail.com', 651248471, '$2a$10$Fppsv8LasF5MAK8/jyn3IO6xV7GcQe/V0z/8A4jGd/fAjpywnPaYy'),
(53, 'dupont', 'Jean', 'Dupontj@gmail.com', 652101596, '$2a$10$ik4XHIc/WqjZaUf1q2FQrO3wrfYrf0TkaQpItPVd67zb9dG/GAf7G'),
(54, 'Pisac', 'jacque', 'JP@gmail.com', 625147892, '$2a$10$TyyUpHjOVkTiI9iY4MsLuO/vs/zBoj5yCrDNzduPu3Z6nwVXl4VNm'),
(56, 'Jean', 'marc', 'JM@gmail.com', 621487895, '$2a$10$xUYVDA.BOhY7kv0WrvraNO0NtvD2W.pGo7rmwfjndJZ7yLf4Gclr6'),
(55, 'Blia', 'Paul', 'paul@gmail.com', 635987456, '$2a$10$b4NomhE6c2.TSvDFIv4UrOF6HSGdE1PF.zwHcLgp7sbeT1/CHz1/.'),
(41, 'trump', 'donald', 'donald@gmail.com', 7896666, '$2a$10$ZUIiw6W4TFkHNDAWTAY7lOHn2ejGJkCl2eAfgdstIEkSh2lM5c0hK'),
(51, 'duval', 'louis', 'louis@gmail.com', 6789956, '$2a$10$v2ozlOk0xqo2fD2T69q8m.kluqpO1TCB9kyzG84KPA9xgzyVRvcE6');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD KEY `comment_id` (`comment_id`);

--
-- Index pour la table `parcours`
--
ALTER TABLE `parcours`
  ADD PRIMARY KEY (`parcours_id`);

--
-- Index pour la table `topo`
--
ALTER TABLE `topo`
  ADD PRIMARY KEY (`topo_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `commentaire`
--
ALTER TABLE `commentaire`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=535;
--
-- AUTO_INCREMENT pour la table `parcours`
--
ALTER TABLE `parcours`
  MODIFY `parcours_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2054;
--
-- AUTO_INCREMENT pour la table `topo`
--
ALTER TABLE `topo`
  MODIFY `topo_id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
