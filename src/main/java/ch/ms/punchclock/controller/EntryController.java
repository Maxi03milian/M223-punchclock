package ch.ms.punchclock.controller;

import ch.ms.punchclock.model.Entry;
import ch.ms.punchclock.service.EntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntryController {

    EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/")
    public List<Entry> getEntry() {
        return entryService.getEntries();
    }

    @PostMapping("/entry")
    public void postEntry(@RequestBody Entry entry) {
        entryService.addEntry(entry);
    }

    @PutMapping("/entry/{id}")
    public void putEntry(@PathVariable Long id, @RequestBody Entry entry) {
        entryService.updateEntry(id, entry);
    }

    @DeleteMapping("/entry/{id}")
    public void deleteEntry(@PathVariable Long id) {
        entryService.deleteEntry(id);
    }


}
