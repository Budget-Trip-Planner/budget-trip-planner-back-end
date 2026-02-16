-- ============================================================
-- SEED DATA
-- Run after schema.sql
-- ============================================================

-- Locations
INSERT INTO Locations (id, city, country) OVERRIDING SYSTEM VALUE VALUES
                                                                      (1, 'Lyon', 'France'),
                                                                      (2, 'Lyon', 'France'),
                                                                      (3, 'Athènes', 'Grèce'),
                                                                      (4, 'Berlin', 'Allemagne'),
                                                                      (5, 'Madrid', 'Espagne'),
                                                                      (6, 'Lisbonne', 'Portugal'),
                                                                      (13, 'Paris', 'France'),
                                                                      (14, 'Marseille', 'France'),
                                                                      (15, 'Rome', 'Italie'),
                                                                      (16, 'Paris', 'France'),
                                                                      (17, 'Tokyo', 'Japan'),
                                                                      (39, 'Rome', 'Italy');

INSERT INTO Images (id, url, object_type, object_id) OVERRIDING SYSTEM VALUE VALUES
                                                                                 (1, 'https://cdn.example.com/images/hauteur.jpg', 'users', 18),
                                                                                 (2, 'https://cdn.example.com/images/cher.jpg', 'voyages', 8),
                                                                                 (3, 'https://cdn.example.com/images/travailler.jpg', 'users', 29),
                                                                                 (4, 'https://cdn.example.com/images/expliquer.jpg', 'users', 11),
                                                                                 (5, 'https://cdn.example.com/images/déchirer.jpg', 'users', 1),
                                                                                 (6, 'https://cdn.example.com/images/contre.jpg', 'users', 3),
                                                                                 (7, 'https://cdn.example.com/images/amener.jpg', 'users', 21),
                                                                                 (8, 'https://cdn.example.com/images/trou.jpg', 'voyages', 6),
                                                                                 (9, 'https://cdn.example.com/images/rejoindre.jpg', 'voyages', 7),
                                                                                 (10, 'https://cdn.example.com/images/menacer.jpg', 'users', 2),
                                                                                 (11, 'https://cdn.example.com/images/écraser.jpg', 'users', 16),
                                                                                 (12, 'https://cdn.example.com/images/accent.jpg', 'users', 14),
                                                                                 (13, 'https://cdn.example.com/images/milieu.jpg', 'voyages', 1),
                                                                                 (14, 'https://cdn.example.com/images/projet.jpg', 'users', 10),
                                                                                 (15, 'https://cdn.example.com/images/engager.jpg', 'users', 24),
                                                                                 (16, 'https://cdn.example.com/images/personne.jpg', 'users', 13),
                                                                                 (17, 'https://cdn.example.com/images/fou.jpg', 'users', 15),
                                                                                 (18, 'https://cdn.example.com/images/défaut.jpg', 'voyages', 4),
                                                                                 (19, 'https://cdn.example.com/images/suffire.jpg', 'users', 19),
                                                                                 (20, 'https://cdn.example.com/images/ensemble.jpg', 'users', 18),
                                                                                 (21, 'https://cdn.example.com/images/berlin.jpg', 'voyages', 1),
                                                                                 (22, 'https://cdn.example.com/images/madrid.jpg', 'voyages', 2),
                                                                                 (23, 'https://cdn.example.com/images/vienna.jpg', 'voyages', 3),
                                                                                 (24, 'https://cdn.example.com/images/amsterdam.jpg', 'voyages', 4),
                                                                                 (25, 'https://cdn.example.com/images/stockholm.jpg', 'voyages', 5),
                                                                                 (26, 'https://cdn.example.com/images/brussels.jpg', 'voyages', 6),
                                                                                 (27, 'https://cdn.example.com/images/copenhagen.jpg', 'voyages', 7),
                                                                                 (28, 'https://cdn.example.com/images/dubrovnik.jpg', 'voyages', 8),
                                                                                 (29, 'https://example.com/profile/johndoe.jpg', 'users', 31);

-- Users
INSERT INTO Users (id, last_name, first_name, username, password, mail, phone_numb, birthday, profile_image_id, location_id) OVERRIDING SYSTEM VALUE VALUES
                                                                                                                                                         (3, 'Sanchez', 'Alexandre', 'alexandre3', '$qCTlBOQJ1', 'alexandre3@example.com', '0173719779', '1977-06-06', NULL, 3),
                                                                                                                                                         (4, 'Verdier', 'Claire', 'claire4', 'WEfAWoWB@5', 'claire4@example.com', '0315462469', '2005-08-12', NULL, 4),
                                                                                                                                                         (5, 'Le Roux', 'Rémy', 'rémy5', 'Gp^9)CeczF', 'rémy5@example.com', '03 21 83 26 73', '1978-06-24', NULL, 4),
                                                                                                                                                         (6, 'Auger', 'Océane', 'océane6', '6vyTlV5l%l', 'océane6@example.com', '+33 (0)8 07 53 43 82', '1995-04-06', NULL, 3),
                                                                                                                                                         (7, 'Diaz', 'Charlotte', 'charlotte7', '^2%MaDtWqz', 'charlotte7@example.com', '0533026345', '2001-10-08', NULL, 3),
                                                                                                                                                         (8, 'Collet', 'Anaïs', 'anaïs8', '^4Il^Ed^hy', 'anaïs8@example.com', '05 61 28 31 86', '1996-01-14', NULL, 3),
                                                                                                                                                         (9, 'Lévêque', 'Lucas', 'lucas9', 'u9jLe1Ia$S', 'lucas9@example.com', '08 05 55 56 80', '1978-12-29', NULL, 3),
                                                                                                                                                         (12, 'Ferreira', 'Denise', 'denise12', 'dHt4VN8r$C', 'denise12@example.com', '0188629772', '1991-06-11', NULL, 2),
                                                                                                                                                         (13, 'Pichon', 'Michèle', 'michèle13', '$%1jPRte#q', 'michèle13@example.com', '+33 6 58 27 37 96', '1986-01-28', NULL, 1),
                                                                                                                                                         (15, 'Martinez', 'Laurent', 'laurent15', '*92L)Cpa2q', 'laurent15@example.com', '+33 (0)6 53 23 53 01', '1968-12-29', NULL, 1),
                                                                                                                                                         (16, 'Renault', 'Gilles', 'gilles16', '82QQ8MNg^y', 'gilles16@example.com', '0591563166', '1973-08-24', NULL, 1),
                                                                                                                                                         (17, 'Maréchal', 'Stéphanie', 'stéphanie17', '0502&Anr^H', 'stéphanie17@example.com', '+33 (0)5 81 34 92 15', '1991-05-07', NULL, 1),
                                                                                                                                                         (18, 'Monnier', 'Anaïs', 'anaïs18', 'z*fW68UevX', 'anaïs18@example.com', '03 24 10 58 00', '1996-06-24', NULL, 1),
                                                                                                                                                         (19, 'Mahe', 'Gabriel', 'gabriel19', '^(9sWj3urz', 'gabriel19@example.com', '01 37 49 73 90', '1975-12-09', NULL, 1),
                                                                                                                                                         (20, 'Evrard', 'Amélie', 'amélie20', ')3LApl&Nl7', 'amélie20@example.com', '06 60 46 07 11', '1968-07-22', NULL, 1),
                                                                                                                                                         (21, 'Humbert', 'Adélaïde', 'adélaïde21', '@h#P(hspW9', 'adélaïde21@example.com', '0146437671', '1990-10-24', NULL, 4),
                                                                                                                                                         (22, 'Carpentier', 'Alexandrie', 'alexandrie22', '*R7Yb2N8vP', 'alexandrie22@example.com', '08 02 88 91 10', '1997-12-23', NULL, 4),
                                                                                                                                                         (23, 'Lacroix', 'Éléonore', 'éléonore23', '2J5qvN)g@9', 'éléonore23@example.com', '0158776359', '1996-02-12', NULL, 4),
                                                                                                                                                         (24, 'Auger', 'Sylvie', 'sylvie24', 'n*1FQRP#Zz', 'sylvie24@example.com', '0168931864', '1984-07-12', NULL, 3),
                                                                                                                                                         (25, 'Benoit', 'Jacqueline', 'jacqueline25', '&AvZCxs258', 'jacqueline25@example.com', '0185248842', '1994-08-26', NULL, 3),
                                                                                                                                                         (26, 'Gros', 'Gabriel', 'gabriel26', 'O9R%3EYr$V', 'gabriel26@example.com', '+33 1 29 88 41 90', '1985-04-21', NULL, 3),
                                                                                                                                                         (27, 'Cohen', 'Xavier', 'xavier27', '#94Q#Yo$6%', 'xavier27@example.com', '+33 1 71 08 41 30', '1982-01-23', NULL, 3),
                                                                                                                                                         (28, 'Lebrun', 'Guillaume', 'guillaume28', '1U9RDz&J+*', 'guillaume28@example.com', '+33 4 09 58 27 26', '1970-12-10', NULL, 3),
                                                                                                                                                         (29, 'Valentin', 'Aurélie', 'aurélie29', 'a1sc6P%j^B', 'aurélie29@example.com', '+33 (0)5 02 68 97 91', '1994-04-27', NULL, 3),
                                                                                                                                                         (30, 'Briand', 'Thérèse', 'thérèse30', '@24B47Ose#', 'thérèse30@example.com', '06 04 85 40 45', '1969-09-17', NULL, 2),
                                                                                                                                                         (1, 'Vallée', 'Suzanne', 'suzanne1', '#KfMo6tbq0', 'suzanne1@example.com', '+33 (0)8 00 21 84 13', '1973-06-25', 5, 1),
                                                                                                                                                         (2, 'Rémy', 'Théodore', 'théodore2', '(73vRvr46w', 'théodore2@example.com', '+33 4 86 88 62 25', '1985-04-16', 10, 2),
                                                                                                                                                         (10, 'Chauvin', 'Geneviève', 'geneviève10', '3W6SvuvN@7', 'geneviève10@example.com', '0385517650', '1973-07-16', 14, 2),
                                                                                                                                                         (11, 'Weiss', 'Océane', 'océane11', '!+85Rt3Hz^', 'océane11@example.com', '+33 1 70 14 14 24', '1987-12-08', 4, 2),
                                                                                                                                                         (14, 'Fischer', 'Sabine', 'sabine14', '3VQA6BDd#(', 'sabine14@example.com', '0590967089', '2002-05-23', 12, 1),
                                                                                                                                                         (31, 'Doe', 'John', 'johndoe', '$2a$10$N/PwXoHCSv/kDVdV32mited/kjVLjjJ.Ler2XxOZPQYnJapFdFQ2C', 'john.doe@example.com', '0612345678', '1990-01-15', 29, 2);

INSERT INTO Voyages (id, object_type, object_id, destination_id, budget_total, duration_days, start_date, hotel, created_at, cover_image_id, user_id, departure_id) OVERRIDING SYSTEM VALUE VALUES
                                                                                                                                                                                                (1, 'users', 1, 4, 950.00, 3, '2025-11-12', NULL, '2025-12-20 21:31:37.748922+01', 21, NULL, NULL),
                                                                                                                                                                                                (2, 'users', 2, 5, 820.00, 3, '2025-11-20', NULL, '2025-12-20 21:31:37.748922+01', 22, NULL, NULL),
                                                                                                                                                                                                (3, 'users', 3, 3, 1100.00, 3, '2025-12-01', NULL, '2025-12-20 21:31:37.748922+01', 23, NULL, NULL),
                                                                                                                                                                                                (4, 'travel_groups', 1, 2, 3000.00, 3, '2025-12-15', NULL, '2025-12-20 21:31:37.748922+01', 24, NULL, NULL),
                                                                                                                                                                                                (5, 'travel_groups', 2, 3, 3500.00, 3, '2025-12-20', NULL, '2025-12-20 21:31:37.748922+01', NULL, NULL, NULL),
                                                                                                                                                                                                (6, 'travel_groups', 3, 4, 2800.00, 3, '2026-01-05', NULL, '2025-12-20 21:31:37.748922+01', NULL, NULL, NULL),
                                                                                                                                                                                                (7, 'travel_groups', 4, 1, 4000.00, 3, '2026-01-10', NULL, '2025-12-20 21:31:37.748922+01', NULL, NULL, NULL),
                                                                                                                                                                                                (8, 'travel_groups', 5, 6, 3700.00, 3, '2026-01-15', NULL, '2025-12-20 21:31:37.748922+01', 28, NULL, NULL),
                                                                                                                                                                                                (9, 'users', 1, 5, 1200.00, 5, '2025-09-15', NULL, '2025-12-20 21:48:23.031987+01', NULL, NULL, 2),
                                                                                                                                                                                                (10, 'users', 1, 15, 800.00, 4, '2025-10-01', NULL, '2025-12-20 21:48:23.138145+01', NULL, NULL, 14),
                                                                                                                                                                                                (11, 'users', 31, 17, 2500.00, 14, '2025-09-01', NULL, '2025-12-20 21:59:03.509048+01', NULL, NULL, 16),
                                                                                                                                                                                                (12, 'users', 31, 2, 1200.00, 7, '2025-10-15', NULL, '2025-12-20 21:59:03.59903+01', NULL, NULL, 1),
                                                                                                                                                                                                (37, 'users', 31, 39, 850.00, 5, '2025-04-15', NULL, '2026-01-22 12:21:08.666766+01', NULL, NULL, 13);

-- Travel groups
INSERT INTO Travel_groups (id, voyage_id, name, created_at) OVERRIDING SYSTEM VALUE VALUES
                                                                                        (1, 4, 'Voyage France', '2025-10-23 10:30:06.443958+02'),
                                                                                        (2, 5, 'Voyage Italie', '2025-10-23 10:30:06.443968+02'),
                                                                                        (3, 6, 'Voyage Allemagne', '2025-10-23 10:30:06.443975+02'),
                                                                                        (4, 7, 'Voyage Espagne', '2025-10-23 10:30:06.443981+02'),
                                                                                        (5, 8, 'Voyage Portugal', '2025-10-23 10:30:06.443987+02');

-- Group memberships
INSERT INTO Group_memberships (group_id, user_id) VALUES
                                                      (1, 7), (1, 13), (1, 20), (1, 21), (1, 28),
                                                      (2, 3), (2, 4), (2, 6), (2, 11), (2, 24), (2, 26), (2, 27), (2, 29),
                                                      (3, 8), (3, 11), (3, 12), (3, 13), (3, 17), (3, 19), (3, 20), (3, 22), (3, 23), (3, 25), (3, 27), (3, 29),
                                                      (4, 6), (4, 10), (4, 30),
                                                      (5, 1), (5, 2), (5, 3), (5, 5), (5, 9), (5, 14), (5, 15), (5, 16), (5, 18), (5, 22), (5, 26);

-- Friends
INSERT INTO Friends (user_id, friend_id) VALUES
                                             (2, 1), (1, 3), (1, 15), (2, 11), (3, 6), (3, 12), (3, 30),
                                             (4, 10), (4, 12), (4, 16), (5, 27), (6, 14), (6, 20), (6, 23), (6, 24), (6, 30),
                                             (7, 18), (8, 10), (8, 16), (8, 24), (8, 25), (9, 15), (9, 20), (9, 21),
                                             (10, 24), (11, 12), (11, 21), (13, 24), (14, 20), (16, 20), (16, 26),
                                             (17, 18), (19, 21), (20, 29), (21, 27), (24, 25), (24, 26), (24, 27), (24, 29), (27, 29);

-- Expenses
INSERT INTO Expenses (id, voyage_id, transport_amount, hotel_amount, restaurant_amount, activities_amount, currency, created_at) OVERRIDING SYSTEM VALUE VALUES
                                                                                                                                                             (1, 1, 150.00, 400.00, 220.00, 100.00, 'EUR', '2025-12-20 21:31:37.748922+01'),
                                                                                                                                                             (2, 2, 180.00, 350.00, 260.00, 140.00, 'EUR', '2025-12-20 21:31:37.748922+01'),
                                                                                                                                                             (3, 3, 200.00, 300.00, 150.00, 100.00, 'EUR', '2025-12-20 21:31:37.748922+01'),
                                                                                                                                                             (4, 4, 300.00, 600.00, 400.00, 200.00, 'EUR', '2025-12-20 21:31:37.748922+01'),
                                                                                                                                                             (5, 8, 250.00, 500.00, 300.00, 150.00, 'EUR', '2025-12-20 21:31:37.748922+01'),
                                                                                                                                                             (6, 37, 212.50, 255.00, 170.00, 212.50, 'EUR', '2026-01-22 12:21:08.655246+01');

-- Itinerary
INSERT INTO Itinerary (id, voyage_id, day_number, activity, created_at) VALUES
                                                                            (1, 1, 1, 'Arrivée à Berlin, visite de la Porte de Brandebourg.', '2025-12-20 21:31:37.748922+01'),
                                                                            (2, 1, 2, 'Visite du mémorial du Mur de Berlin et Checkpoint Charlie.', '2025-12-20 21:31:37.748922+01'),
                                                                            (3, 1, 3, 'Soirée dans le quartier de Friedrichshain.', '2025-12-20 21:31:37.748922+01'),
                                                                            (4, 2, 1, 'Arrivée à Madrid, visite du Palais Royal.', '2025-12-20 21:31:37.748922+01'),
                                                                            (5, 2, 2, 'Promenade au Parc du Retiro et Musée du Prado.', '2025-12-20 21:31:37.748922+01'),
                                                                            (6, 2, 3, 'Dégustation de tapas à la Plaza Mayor.', '2025-12-20 21:31:37.748922+01'),
                                                                            (7, 3, 1, 'Arrivée à Athènes, montée à l''Acropole.', '2025-12-20 21:31:37.748922+01'),
                                                                            (8, 3, 2, 'Visite du Parthénon et du quartier de Plaka.', '2025-12-20 21:31:37.748922+01'),
                                                                            (9, 3, 3, 'Excursion au Cap Sounion pour le coucher du soleil.', '2025-12-20 21:31:37.748922+01'),
                                                                            (10, 4, 1, 'Arrivée à Paris, installation près de la Tour Eiffel.', '2025-12-20 21:31:37.748922+01'),
                                                                            (11, 4, 2, 'Visite du Louvre et croisière sur la Seine.', '2025-12-20 21:31:37.748922+01'),
                                                                            (12, 4, 3, 'Balade à Montmartre et Sacré-Cœur.', '2025-12-20 21:31:37.748922+01'),
                                                                            (13, 8, 1, 'Arrivée à Lisbonne, balade à Alfama.', '2025-12-20 21:31:37.748922+01'),
                                                                            (14, 8, 2, 'Visite de la Tour de Belém et dégustation de Pastéis.', '2025-12-20 21:31:37.748922+01'),
                                                                            (15, 8, 3, 'Soirée Fado dans le centre historique.', '2025-12-20 21:31:37.748922+01'),
                                                                            (16, 37, 1, 'Arrivee et installation a Rome | Experience Culture | Soiree gastronomique', '2026-01-22 12:21:08.671278+01'),
                                                                            (17, 37, 2, 'Decouverte du quartier | Experience Gastronomie | Soiree gastronomique', '2026-01-22 12:21:08.67328+01'),
                                                                            (18, 37, 3, 'Visite du Colisee | Forum Romain', '2026-01-22 12:21:08.67428+01'),
                                                                            (19, 37, 4, 'Vatican et Chapelle Sixtine | Place Saint-Pierre', '2026-01-22 12:21:08.67428+01'),
                                                                            (20, 37, 5, 'Shopping et souvenirs | Depart', '2026-01-22 12:21:08.675279+01');

-- ============================================================
-- RESET SEQUENCES
-- ============================================================

SELECT setval('locations_id_seq', (SELECT MAX(id) FROM Locations));
SELECT setval('images_id_seq', (SELECT MAX(id) FROM Images));
SELECT setval('users_id_seq', (SELECT MAX(id) FROM Users));
SELECT setval('voyages_id_seq', (SELECT MAX(id) FROM Voyages));
SELECT setval('travel_groups_id_seq', (SELECT MAX(id) FROM Travel_groups));
SELECT setval('expenses_id_seq', (SELECT MAX(id) FROM Expenses));
SELECT setval('itinerary_id_seq', (SELECT MAX(id) FROM Itinerary));