package ch.ms.punchclock.controller;

import ch.ms.punchclock.model.Entry;
import ch.ms.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntryController {

    EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }


    @GetMapping("/entries")
    public List<Entry> getEntry() {
        return entryService.getEntries();
    }

    @PostMapping("/entry")
    public ResponseEntity postEntry(@RequestBody Entry entry) {
        if (entry.getCheckIn().isBefore(entry.getCheckOut())) {
            entryService.addEntry(entry);
            return new ResponseEntity(entry, HttpStatus.OK);
        }else {
            return new ResponseEntity("Error: Check in time must be before checkout Time" , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/entry/{id}")
    public ResponseEntity putEntry(@PathVariable Long id, @RequestBody Entry entry) {
        if (entry.getCheckIn().isBefore(entry.getCheckOut())) {
            entry.setId(id);
            entryService.updateEntry(id, entry);
            return new ResponseEntity(entry, HttpStatus.OK);
        }else {
            return new ResponseEntity("Error: Check in time must be before checkout Time" , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/entry/{id}")
    public void deleteEntry(@PathVariable Long id) {
        entryService.deleteEntry(id);
    }


}
