package dev.tumy.contentcalendar.repository;

import dev.tumy.contentcalendar.model.Content;
import dev.tumy.contentcalendar.model.Status;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author TuMy
 */
    public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    //List<Content> findAllByTitleContains(String keyword);

    List<Content> findAllByContentType(String type);
}
