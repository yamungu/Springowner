package spice.tech.hub.alannoorrestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spice.tech.hub.alannoorrestaurant.models.Owners;
import spice.tech.hub.alannoorrestaurant.repositories.OwnerRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/owner")
public class OwnerAPI {

//    @GetMapping("/spice")
//    public ResponseEntity<?> index(){
//        return new ResponseEntity<>("asdfasdf", HttpStatus.OK);
//    }
    @Autowired
    private OwnerRepo ownerRepo;

    @PostMapping("")
    public ResponseEntity<?> newOwner(@RequestBody Owners owner){
        Owners owner2= ownerRepo.save(owner);
        return new ResponseEntity<>(owner2,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOwner(@PathVariable("id") int spice,@RequestBody Owners owner){
        if(ownerRepo.findById(spice).isPresent()){
            owner.setId(spice);
            Owners owner2= ownerRepo.save(owner);
            return new ResponseEntity<>(owner2,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Owner not found",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOwner(@PathVariable("id") int spice){
        if(ownerRepo.findById(spice).isPresent()){
            ownerRepo.deleteById(spice);
            return new ResponseEntity<>("Owner has been deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Owner not found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> newOwner(){
        List<Owners> owners= ownerRepo.findAll();
        return new ResponseEntity<>(owners,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> newOwner(@PathVariable("id") int id){
        Optional<Owners> owner = ownerRepo.findById(id);
        if(owner.isPresent()){
            return new ResponseEntity<>(owner.get(),HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("Owner with id "+Integer.toString(id)+" is  not found",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<?> selectByOwnerName(@PathVariable("name") String name){
//        List<Owners> owners=ownerRepo.getOwnerByName(name);
        List<Owners> owners=ownerRepo.getOwnersByNameJPQL(name);
        return new ResponseEntity<>(owners,HttpStatus.OK);
    }
}
