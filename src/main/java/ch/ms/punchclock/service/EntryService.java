package ch.ms.punchclock.service;

import antlr.Token;
import ch.ms.punchclock.model.Entry;
import ch.ms.punchclock.repository.EntityRepository;
import ch.ms.punchclock.repository.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
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

    public void addEntry(Entry entry, String token){
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

    public boolean isTokenValid(String token) {
        try {
            JWT.require(Algorithm.HMAC256("123@abc"))
                    .build()
                    .verify(token);


        } catch (JWTVerificationException e) {
            throw new JWTVerificationException("Invalid Token");
        }

        return true;
    }


}
