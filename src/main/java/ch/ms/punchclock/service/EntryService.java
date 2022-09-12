package ch.ms.punchclock.service;

import ch.ms.punchclock.model.Entry;
import ch.ms.punchclock.repository.EntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {

    EntityRepository entityRepository;

    public EntryService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public List<Entry> getEntries(){
        return (List<Entry>) entityRepository.findAll();
    }

    public void addEntry(Entry entry){
        entityRepository.save(entry);
    }

    public void updateEntry(Long id, Entry entry) {
        Entry entryToUpdate = entityRepository.findById(id).get();
        entryToUpdate.setCheckIn(entry.getCheckIn());
        entryToUpdate.setCheckOut(entry.getCheckOut());
        entityRepository.save(entryToUpdate);
    }

    public void deleteEntry(Long id) {
        entityRepository.deleteById(id);
    }




}
