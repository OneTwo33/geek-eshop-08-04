package ru.onetwo33.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.onetwo33.persist.model.Picture;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
