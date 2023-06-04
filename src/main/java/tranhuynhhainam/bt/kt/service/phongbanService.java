package tranhuynhhainam.bt.kt.service;

import tranhuynhhainam.bt.kt.entity.phongban;

import tranhuynhhainam.bt.kt.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class phongbanService {
    @Autowired
    private phongbanRepository phongbanRepository;

    public List<phongban> getAllPhongban(){
        return phongbanRepository.findAll();

    }

    public phongban getPhongbanById(String id){
        Optional<phongban> optionalPhongban= phongbanRepository.findById(id);
        if(optionalPhongban.isPresent()){
            return optionalPhongban.get();
        }
        else{
            throw new RuntimeException("Phong ban not found");
        }

    }

    public phongban savePhongban(phongban phongban){
        return phongbanRepository.save(phongban);
    }

    public void deletePhongban(String id){
        phongbanRepository.deleteById(id);
    }
}