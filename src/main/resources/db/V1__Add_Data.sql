-- 1. LOCATIONS
INSERT INTO locations (city, country) VALUES ('Lyon', 'France');       -- ID 1
INSERT INTO locations (city, country) VALUES ('Paris', 'France');      -- ID 2
INSERT INTO locations (city, country) VALUES ('Athènes', 'Grèce');    -- ID 3
INSERT INTO locations (city, country) VALUES ('Berlin', 'Allemagne');  -- ID 4
INSERT INTO locations (city, country) VALUES ('Madrid', 'Espagne');    -- ID 5
INSERT INTO locations (city, country) VALUES ('Lisbonne', 'Portugal'); -- ID 6

-- 2. USERS
INSERT INTO users (last_name, first_name, username, password, mail, phone_numb, birthday, location_id)
VALUES
    ('Vallée', 'Suzanne', 'suzanne1', '#KfMo6tbq0', 'suzanne1@example.com', '+33 (0)8 00 21 84 13', '1973-06-25', 1),
    ('Rémy', 'Théodore', 'théodore2', '(73vRvr46w', 'théodore2@example.com', '+33 4 86 88 62 25', '1985-04-16', 2),
    ('Sanchez', 'Alexandre', 'alexandre3', '$qCTlBOQJ1', 'alexandre3@example.com', '0173719779', '1977-06-06', 3),
    ('Verdier', 'Claire', 'claire4', 'WEfAWoWB@5', 'claire4@example.com', '0315462469', '2005-08-12', 4),
    ('Le Roux', 'Rémy', 'rémy5', 'Gp^9)CeczF', 'rémy5@example.com', '03 21 83 26 73', '1978-06-24', 4),
    ('Auger', 'Océane', 'océane6', '6vyTlV5l%l', 'océane6@example.com', '+33 (0)8 07 53 43 82', '1995-04-06', 3),
    ('Diaz', 'Charlotte', 'charlotte7', '^2%MaDtWqz', 'charlotte7@example.com', '0533026345', '2001-10-08', 3),
    ('Collet', 'Anaïs', 'anaïs8', '^4Il^Ed^hy', 'anaïs8@example.com', '05 61 28 31 86', '1996-01-14', 3),
    ('Lévêque', 'Lucas', 'lucas9', 'u9jLe1Ia$S', 'lucas9@example.com', '08 05 55 56 80', '1978-12-29', 3),
    ('Chauvin', 'Geneviève', 'geneviève10', '3W6SvuvN@7', 'geneviève10@example.com', '0385517650', '1973-07-16', 2),
    ('Weiss', 'Océane', 'océane11', '!+85Rt3Hz^', 'océane11@example.com', '+33 1 70 14 14 24', '1987-12-08', 2),
    ('Ferreira', 'Denise', 'denise12', 'dHt4VN8r$C', 'denise12@example.com', '0188629772', '1991-06-11', 2),
    ('Pichon', 'Michèle', 'michèle13', '$%1jPRte#q', 'michèle13@example.com', '+33 6 58 27 37 96', '1986-01-28', 1),
    ('Fischer', 'Sabine', 'sabine14', '3VQA6BDd#(', 'sabine14@example.com', '0590967089', '2002-05-23', 1),
    ('Martinez', 'Laurent', 'laurent15', '*92L)Cpa2q', 'laurent15@example.com', '+33 (0)6 53 23 53 01', '1968-12-29', 1),
    ('Renault', 'Gilles', 'gilles16', '82QQ8MNg^y', 'gilles16@example.com', '0591563166', '1973-08-24', 1),
    ('Maréchal', 'Stéphanie', 'stéphanie17', '0502&Anr^H', 'stéphanie17@example.com', '+33 (0)5 81 34 92 15', '1991-05-07', 1),
    ('Monnier', 'Anaïs', 'anaïs18', 'z*fW68UevX', 'anaïs18@example.com', '03 24 10 58 00', '1996-06-24', 1),
    ('Mahe', 'Gabriel', 'gabriel19', '^(9sWj3urz', 'gabriel19@example.com', '01 37 49 73 90', '1975-12-09', 1),
    ('Evrard', 'Amélie', 'amélie20', ')3LApl&Nl7', 'amélie20@example.com', '06 60 46 07 11', '1968-07-22', 1),
    ('Humbert', 'Adélaïde', 'adélaïde21', '@h#P(hspW9', 'adélaïde21@example.com', '0146437671', '1990-10-24', 4),
    ('Carpentier', 'Alexandrie', 'alexandrie22', '*R7Yb2N8vP', 'alexandrie22@example.com', '08 02 88 91 10', '1997-12-23', 4),
    ('Lacroix', 'Éléonore', 'éléonore23', '2J5qvN)g@9', 'éléonore23@example.com', '0158776359', '1996-02-12', 4),
    ('Auger', 'Sylvie', 'sylvie24', 'n*1FQRP#Zz', 'sylvie24@example.com', '0168931864', '1984-07-12', 3),
    ('Benoit', 'Jacqueline', 'jacqueline25', '&AvZCxs258', 'jacqueline25@example.com', '0185248842', '1994-08-26', 3),
    ('Gros', 'Gabriel', 'gabriel26', 'O9R%3EYr$V', 'gabriel26@example.com', '+33 1 29 88 41 90', '1985-04-21', 3),
    ('Cohen', 'Xavier', 'xavier27', '#94Q#Yo$6%', 'xavier27@example.com', '+33 1 71 08 41 30', '1982-01-23', 3),
    ('Lebrun', 'Guillaume', 'guillaume28', '1U9RDz&J+*', 'guillaume28@example.com', '+33 4 09 58 27 26', '1970-12-10', 3),
    ('Valentin', 'Aurélie', 'aurélie29', 'a1sc6P%j^B', 'aurélie29@example.com', '+33 (0)5 02 68 97 91', '1994-04-27', 3),
    ('Briand', 'Thérèse', 'thérèse30', '@24B47Ose#', 'thérèse30@example.com', '06 04 85 40 45', '1969-09-17', 2),
    ('Doe', 'John', 'johndoe', '$2a$10$N/PwXoHCSv/kDVdV32mited/kjVLjjJ.Ler2XxOZPQYnJapFdFQ2C', 'john.doe@example.com', NULL, '1990-01-15', 2);

-- 3. VOYAGE
INSERT INTO voyages (object_type, object_id, destination_id, budget_total, duration_days, start_date)
VALUES
    ('users', 1, 4, 950.00, 3, '2025-11-12'),         -- ID 1 (Berlin)
    ('users', 2, 5, 820.00, 3, '2025-11-20'),         -- ID 2 (Madrid)
    ('users', 3, 3, 1100.00, 3, '2025-12-01'),        -- ID 3 (Athènes)
    ('travel_groups', 1, 2, 3000.00, 3, '2025-12-15'), -- ID 4 (Paris)
    ('travel_groups', 2, 3, 3500.00, 3, '2025-12-20'), -- ID 5 (Athènes)
    ('travel_groups', 3, 4, 2800.00, 3, '2026-01-05'), -- ID 6 (Berlin)
    ('travel_groups', 4, 1, 4000.00, 3, '2026-01-10'), -- ID 7 (Lyon)
    ('travel_groups', 5, 6, 3700.00, 3, '2026-01-15'); -- ID 8 (Lisbonne)

-- 4. TRAVEL GROUPS
INSERT INTO travel_groups (name, created_at, voyage_id) VALUES ('Voyage France', '2025-10-23T10:30:06.443958', 4);
INSERT INTO travel_groups (name, created_at, voyage_id) VALUES ('Voyage Italie', '2025-10-23T10:30:06.443968', 5);
INSERT INTO travel_groups (name, created_at, voyage_id) VALUES ('Voyage Allemagne', '2025-10-23T10:30:06.443975', 6);
INSERT INTO travel_groups (name, created_at, voyage_id) VALUES ('Voyage Espagne', '2025-10-23T10:30:06.443981', 7);
INSERT INTO travel_groups (name, created_at, voyage_id) VALUES ('Voyage Portugal', '2025-10-23T10:30:06.443987', 8);

-- 5. GROUP MEMBERSHIPS
INSERT INTO group_memberships (group_id, user_id) VALUES (1, 7), (1, 13), (1, 20), (1, 21), (1, 28);
INSERT INTO group_memberships (group_id, user_id) VALUES (2, 3), (2, 4), (2, 6), (2, 11), (2, 24), (2, 26), (2, 27), (2, 29);
INSERT INTO group_memberships (group_id, user_id) VALUES (3, 8), (3, 11), (3, 12), (3, 13), (3, 17), (3, 19), (3, 20), (3, 22), (3, 23), (3, 25), (3, 27), (3, 29);
INSERT INTO group_memberships (group_id, user_id) VALUES (4, 6), (4, 10), (4, 30);
INSERT INTO group_memberships (group_id, user_id) VALUES (5, 1), (5, 2), (5, 3), (5, 5), (5, 9), (5, 14), (5, 15), (5, 16), (5, 18), (5, 22), (5, 26);

-- 6. FRIENDS
INSERT INTO friends (user_id, friend_id) VALUES (2, 1), (1, 3), (1, 15), (2, 11), (3, 6), (3, 12), (3, 30), (4, 10), (4, 12), (4, 16), (5, 27), (6, 14), (6, 20), (6, 23), (6, 24), (6, 30), (7, 18), (8, 10), (8, 16), (8, 24), (8, 25), (9, 15), (9, 20), (9, 21), (10, 24), (11, 12), (11, 21), (13, 24), (14, 20), (16, 20), (16, 26), (17, 18), (19, 21), (20, 29), (21, 27), (24, 25), (24, 26), (24, 27), (24, 29), (27, 29);

-- 7. IMAGES
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/hauteur.jpg', 'users', 18);    -- ID 1
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/cher.jpg', 'voyages', 8);     -- ID 2
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/travailler.jpg', 'users', 29); -- ID 3
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/expliquer.jpg', 'users', 11);  -- ID 4
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/déchirer.jpg', 'users', 1);    -- ID 5
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/contre.jpg', 'users', 3);     -- ID 6
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/amener.jpg', 'users', 21);    -- ID 7
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/trou.jpg', 'voyages', 6);     -- ID 8
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/rejoindre.jpg', 'voyages', 7);  -- ID 9
INSERT INTO images ( url, object_type, object_id) VALUES ('https://cdn.example.com/images/menacer.jpg', 'users', 2);     -- ID 10
INSERT INTO images ( url, object_type, object_id) VALUES ('https://cdn.example.com/images/écraser.jpg', 'users', 16);    -- ID 11
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/accent.jpg', 'users', 14);    -- ID 12
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/milieu.jpg', 'voyages', 1);   -- ID 13
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/projet.jpg', 'users', 10);    -- ID 14
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/engager.jpg', 'users', 24);   -- ID 15
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/personne.jpg', 'users', 13);  -- ID 16
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/fou.jpg', 'users', 15);       -- ID 17
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/défaut.jpg', 'voyages', 4);    -- ID 18
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/suffire.jpg', 'users', 19);    -- ID 19
INSERT INTO images ( url, object_type, object_id) VALUES ( 'https://cdn.example.com/images/ensemble.jpg', 'users', 18);   -- ID 20
INSERT INTO images (url, object_type, object_id) VALUES ('https://cdn.example.com/images/berlin.jpg', 'voyages', 1);     -- ID 21
INSERT INTO images (url, object_type, object_id) VALUES ('https://cdn.example.com/images/madrid.jpg', 'voyages', 2);     -- ID 22
INSERT INTO images (url, object_type, object_id) VALUES ('https://cdn.example.com/images/vienna.jpg', 'voyages', 3);     -- ID 23
INSERT INTO images (url, object_type, object_id) VALUES ('https://cdn.example.com/images/amsterdam.jpg', 'voyages', 4);  -- ID 24
INSERT INTO images (url, object_type, object_id) VALUES ('https://cdn.example.com/images/stockholm.jpg', 'voyages', 5);   -- ID 25
INSERT INTO images (url, object_type, object_id) VALUES ('https://cdn.example.com/images/brussels.jpg', 'voyages', 6);    -- ID 26
INSERT INTO images (url, object_type, object_id) VALUES ('https://cdn.example.com/images/copenhagen.jpg', 'voyages', 7); -- ID 27
INSERT INTO images (url, object_type, object_id) VALUES ('https://cdn.example.com/images/dubrovnik.jpg', 'voyages', 8);  -- ID 28

-- 8. EXPENSES
INSERT INTO expenses (voyage_id, transport_amount, hotel_amount, restaurant_amount, activities_amount, currency)
VALUES
    (1, 150.00, 400.00, 220.00, 100.00, 'EUR'),
    (2, 180.00, 350.00, 260.00, 140.00, 'EUR'),
    (3, 200.00, 300.00, 150.00, 100.00, 'EUR'),
    (4, 300.00, 600.00, 400.00, 200.00, 'EUR'),
    (8, 250.00, 500.00, 300.00, 150.00, 'EUR');

-- 9. ITINERARY
INSERT INTO itinerary (voyage_id, day_number, activity) VALUES
                                                            (1, 1, 'Arrivée à Berlin, visite de la Porte de Brandebourg.'),
                                                            (1, 2, 'Visite du mémorial du Mur de Berlin et Checkpoint Charlie.'),
                                                            (1, 3, 'Soirée dans le quartier de Friedrichshain.'),
                                                            (2, 1, 'Arrivée à Madrid, visite du Palais Royal.'),
                                                            (2, 2, 'Promenade au Parc du Retiro et Musée du Prado.'),
                                                            (2, 3, 'Dégustation de tapas à la Plaza Mayor.'),
                                                            (3, 1, 'Arrivée à Athènes, montée à l’Acropole.'),
                                                            (3, 2, 'Visite du Parthénon et du quartier de Plaka.'),
                                                            (3, 3, 'Excursion au Cap Sounion pour le coucher du soleil.'),
                                                            (4, 1, 'Arrivée à Paris, installation près de la Tour Eiffel.'),
                                                            (4, 2, 'Visite du Louvre et croisière sur la Seine.'),
                                                            (4, 3, 'Balade à Montmartre et Sacré-Cœur.'),
                                                            (8, 1, 'Arrivée à Lisbonne, balade à Alfama.'),
                                                            (8, 2, 'Visite de la Tour de Belém et dégustation de Pastéis.'),
                                                            (8, 3, 'Soirée Fado dans le centre historique.');

-- Update Users with Profile Images
UPDATE users SET profile_image_id = 5 WHERE id = 1;   -- Suzanne gets Image ID 5
UPDATE users SET profile_image_id = 10 WHERE id = 2;  -- Théodore gets Image ID 10
UPDATE users SET profile_image_id = 4 WHERE id = 11;  -- Océane gets Image ID 4
UPDATE users SET profile_image_id = 14 WHERE id = 10; -- Geneviève gets Image ID 14
UPDATE users SET profile_image_id = 12 WHERE id = 14; -- Sabine gets Image ID 12

-- Update Voyages with Cover Images
UPDATE voyages SET cover_image_id = 21 WHERE id = 1; -- Berlin gets Image ID 21
UPDATE voyages SET cover_image_id = 22 WHERE id = 2; -- Madrid gets Image ID 22
UPDATE voyages SET cover_image_id = 23 WHERE id = 3; -- Athens gets Image ID 23
UPDATE voyages SET cover_image_id = 24 WHERE id = 4; -- Paris gets Image ID 24
UPDATE voyages SET cover_image_id = 28 WHERE id = 8; -- Lisbon gets Image ID 28