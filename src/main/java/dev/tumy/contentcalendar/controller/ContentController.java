package dev.tumy.contentcalendar.controller;

import dev.tumy.contentcalendar.model.Content;
import dev.tumy.contentcalendar.model.Status;
import dev.tumy.contentcalendar.repository.ContentCollectionRepository;
import dev.tumy.contentcalendar.repository.ContentJdbcTemplateRepository;
import dev.tumy.contentcalendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {
    private final ContentRepository repository;

    //private final ContentJdbcTemplateRepository repository;
    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }
    @GetMapping("")    //tạo request và tìm kiếm tất cả content trong hệ thống
    public List<Content> findAll() {
        return repository.findAll();
    }
    //
    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found"));
    }
    @ResponseStatus(HttpStatus.CREATED) //new item is created
    @PostMapping("")
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Content content,@PathVariable Integer id) {
        if(!repository.existsById(id)) {
          throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/type/{type}")
    public List<Content> filterByType(@PathVariable String type) {
        return repository.findAllByContentType(type.toUpperCase());
    }


}
