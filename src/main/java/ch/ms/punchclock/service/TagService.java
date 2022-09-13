package ch.ms.punchclock.service;

import ch.ms.punchclock.model.Entry;
import ch.ms.punchclock.model.Tag;
import ch.ms.punchclock.repository.EntityRepository;
import ch.ms.punchclock.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTags(){
        return (List<Tag>) tagRepository.findAll();
    }

    public void addTag(Tag tag){
        tagRepository.save(tag);
    }

    public void updateTag(Long id, Tag tag) {
        Tag tagToUpdate = tagRepository.findById(id).get();
        tagToUpdate.setTitle(tag.getTitle());
        tagRepository.save(tagToUpdate);
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }




}
