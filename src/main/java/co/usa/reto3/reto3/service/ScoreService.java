package co.usa.reto3.reto3.service;

import co.usa.reto3.reto3.model.Score;
import co.usa.reto3.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save (Score s){
        if(s.getId()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> saux = getScore(s.getId());
            if(saux.isEmpty()){
                return scoreRepository.save(s);
            }else{
                return s;
            }
        }
    }
}
