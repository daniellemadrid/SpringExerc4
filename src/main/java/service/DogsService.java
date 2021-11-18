package service;


import model.Dog;
import model.MockDogProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DogsService {
    @Autowired
    private final MockDogProvider mockDogProvider;

    public void add (Dog dto){
        mockDogProvider.add(dto);
    }

    public void delete (long id){
        mockDogProvider.delete(id);
    }

    public List<Dog> getDogs(){
        return mockDogProvider.getDogs();
    }

    public Dog getDogById(long id){
        return mockDogProvider.findDogById(id);
    }
}
