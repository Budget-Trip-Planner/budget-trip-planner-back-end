-- ============================================================
-- FUNCTIONS & TRIGGERS
-- ============================================================

CREATE FUNCTION enforce_friendship_order() RETURNS trigger
    LANGUAGE plpgsql
AS $$
DECLARE
temp INT;
BEGIN
    IF NEW.user_id > NEW.friend_id THEN
        temp := NEW.user_id;
        NEW.user_id := NEW.friend_id;
        NEW.friend_id := temp;
END IF;
RETURN NEW;
END;
$$;

CREATE TRIGGER trg_enforce_friendship_order
    BEFORE INSERT OR UPDATE ON Friends
                         FOR EACH ROW
                         EXECUTE FUNCTION enforce_friendship_order();

CREATE FUNCTION update_object_image() RETURNS trigger
    LANGUAGE plpgsql
AS $$
BEGIN
    -- Mise à jour de l'image de profil d'un utilisateur
    IF NEW.object_type = 'users' THEN
UPDATE Users
SET profile_image_id = NEW.id
WHERE id = NEW.object_id;

-- Mise à jour de l'image de couverture d'un voyage
ELSIF NEW.object_type = 'voyages' THEN
UPDATE Voyages
SET cover_image_id = NEW.id
WHERE id = NEW.object_id;
END IF;

RETURN NEW;
END;
$$;

CREATE TRIGGER trg_update_object_image
    AFTER INSERT ON Images
    FOR EACH ROW
    EXECUTE FUNCTION update_object_image();

CREATE FUNCTION update_travel_group_voyage_id() RETURNS trigger
    LANGUAGE plpgsql
AS $$
BEGIN
    -- Si le voyage est lié à un groupe, on met à jour la colonne voyage_id du groupe
    IF NEW.object_type = 'travel_groups' THEN
UPDATE Travel_groups
SET voyage_id = NEW.id
WHERE id = NEW.object_id;
END IF;

RETURN NEW;
END;
$$;

CREATE TRIGGER trg_update_travel_group_voyage_id
    AFTER INSERT ON Voyages
    FOR EACH ROW
    EXECUTE FUNCTION update_travel_group_voyage_id();