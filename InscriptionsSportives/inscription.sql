-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 24 déc. 2017 à 21:41
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `inscription`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

DROP TABLE IF EXISTS `candidat`;
CREATE TABLE IF NOT EXISTS `candidat` (
  `id_cand` int(11) NOT NULL AUTO_INCREMENT,
  `nom_cand` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cand`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

DROP TABLE IF EXISTS `competition`;
CREATE TABLE IF NOT EXISTS `competition` (
  `id_comp` int(11) NOT NULL AUTO_INCREMENT,
  `nom_comp` varchar(255) DEFAULT NULL,
  `enEquipe` tinyint(4) DEFAULT NULL,
  `dateClosure` date DEFAULT NULL,
  PRIMARY KEY (`id_comp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
CREATE TABLE IF NOT EXISTS `equipe` (
  `id_p` int(11) NOT NULL AUTO_INCREMENT,
  `prenom_p` varchar(255) DEFAULT NULL,
  `mail_p` varchar(255) DEFAULT NULL,
  `id_cand` int(11) NOT NULL,
  PRIMARY KEY (`id_p`,`id_cand`),
  KEY `FK_Personne_id_cand` (`id_cand`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `id_cand` int(11) NOT NULL,
  `id_comp` int(11) NOT NULL,
  PRIMARY KEY (`id_cand`,`id_comp`),
  KEY `FK_Inscription_id_comp` (`id_comp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `FK_Equipe_id_cand` FOREIGN KEY (`id_cand`) REFERENCES `candidat` (`id_cand`),
  ADD CONSTRAINT `FK_Personne_id_cand` FOREIGN KEY (`id_cand`) REFERENCES `candidat` (`id_cand`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `FK_Inscription_id_cand` FOREIGN KEY (`id_cand`) REFERENCES `candidat` (`id_cand`),
  ADD CONSTRAINT `FK_Inscription_id_comp` FOREIGN KEY (`id_comp`) REFERENCES `competition` (`id_comp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
