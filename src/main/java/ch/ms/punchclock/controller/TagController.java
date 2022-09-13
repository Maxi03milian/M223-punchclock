package ch.ms.punchclock.controller;

import ch.ms.punchclock.model.Tag;
import ch.ms.punchclock.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tags")
    public List<Tag> getTags() {
        return tagService.getTags();
    }

    @PostMapping("/tag")
    public ResponseEntity postTag(@RequestBody Tag tag) {
        tagService.addTag(tag);
        return new ResponseEntity(tag, HttpStatus.OK);
    }

    @PutMapping("/tag/{id}")
    public ResponseEntity putTag(@PathVariable Long id, @RequestBody Tag tag) {
        tagService.updateTag(id, tag);
        return new ResponseEntity(tag, HttpStatus.OK);

    }

    @DeleteMapping("/tag/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }

}
