-- ===============================
--   INSERT LOCATIONS (15 rows)
-- ===============================

INSERT INTO Location (city, country) VALUES
                                         ('Paris','France'),
                                         ('Lyon','France'),
                                         ('Marseille','France'),
                                         ('Berlin','Allemagne'),
                                         ('Munich','Allemagne'),
                                         ('Madrid','Espagne'),
                                         ('Barcelone','Espagne'),
                                         ('Lisbonne','Portugal'),
                                         ('Rome','Italie'),
                                         ('Milan','Italie'),
                                         ('Londres','Royaume-Uni'),
                                         ('Dublin','Irlande'),
                                         ('Zurich','Suisse'),
                                         ('Genève','Suisse'),
                                         ('Amsterdam','Pays-Bas');

-- ===============================
--   INSERT USERS (30 random)
-- ===============================

INSERT INTO Users (
    last_name,
    first_name,
    username,
    password,
    mail,
    phone_numb,
    birthday,
    pp,
    location_id
)
SELECT
    ln,
    fn,
    LOWER(fn || '.' || ln)                                       AS username,
    fn || '123'                                                  AS password,  -- mot de passe en clair
    LOWER(fn || '.' || ln || '@mail.com')                        AS mail,
    '+33' || (100000000 + FLOOR(RANDOM()*900000000))::int        AS phone_numb,
    DATE '1980-01-01' + ((RANDOM() * ((DATE '2005-12-31' - DATE '1980-01-01')))::int) AS birthday,
    'pp_' || LOWER(fn || '_' || ln) || '.jpg'                    AS pp,
    (SELECT id FROM Location ORDER BY RANDOM() LIMIT 1)        AS location_id
FROM (VALUES
    ('Martin','Lucas'),
    ('Dupont','Emma'),
    ('Bernard','Noah'),
    ('Petit','Léa'),
    ('Robert','Adam'),
    ('Richard','Manon'),
    ('Durand','Tom'),
    ('Dubois','Inès'),
    ('Moreau','Jules'),
    ('Laurent','Chloé'),
    ('Simon','Hugo'),
    ('Michel','Camille'),
    ('Lefebvre','Arthur'),
    ('Leroy','Sarah'),
    ('Roux','Nathan'),
    ('David','Louise'),
    ('Bertrand','Alice'),
    ('Morel','Gabriel'),
    ('Fournier','Eva'),
    ('Girard','Louis'),
    ('Bonnet','Jade'),
    ('Dupuis','Lucas'),
    ('Lambert','Emma'),
    ('Fontaine','Noé'),
    ('Rousseau','Lina'),
    ('Vincent','Ethan'),
    ('Muller','Zoé'),
    ('Lefevre','Oscar'),
    ('Faure','Mila'),
    ('Andre','Léo')
    ) AS t(ln, fn);

-- ===============================
--   INSERT USERS "titi/toto"
-- ===============================

INSERT INTO UserS (
    last_name,
    first_name,
    username,
    password,
    mail,
    phone_numb,
    birthday,
    pp,
    location_id
)
VALUES (
           'titi',
           'toto',
           'titi',
           'toto',                     -- mot de passe en clair (API le chiffrera)
           'titi@mail.com',
           '+33123456789',
           DATE '1995-04-10',
           'pp_toto.jpg',
           (SELECT id FROM Location ORDER BY RANDOM() LIMIT 1)
    );

INSERT INTO Friends (id, friends_ids)
VALUES (
           (SELECT id FROM Users WHERE username = 'titi'),
           ARRAY[
               (SELECT id FROM Users WHERE username = 'emma.dupont'),
           (SELECT id FROM Users WHERE username = 'noah.bernard')
               ]
       );

UPDATE Friends
SET friends_ids = friends_ids || ARRAY[
    (SELECT id FROM Users WHERE username = 'inès.dubois')
    ]
WHERE id = (SELECT id FROM Users WHERE username = 'titi');

INSERT INTO TravelGroup (name, member_ids)
SELECT
    'Séjour à Zurich',
    ARRAY[
        (SELECT id FROM Users WHERE username = 'titi')
        ] || (
        SELECT friends_ids
        FROM Friends
        WHERE id = (SELECT id FROM Users WHERE username = 'titi')
    );
