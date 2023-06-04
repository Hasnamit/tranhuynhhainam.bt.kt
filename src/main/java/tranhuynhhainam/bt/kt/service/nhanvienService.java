package tranhuynhhainam.bt.kt.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tranhuynhhainam.bt.kt.repository.*;
import tranhuynhhainam.bt.kt.entity.*;

@Service
public class nhanvienService {

	@Autowired
	private nhanvienRepository repo;
	
	public List<nhanvien>getAllnhanvien(){return (List<nhanvien>) repo.findAll();}
	
	public void add(nhanvien newnhanvien) {
		repo.save(newnhanvien);
	}
	
    public nhanvien getById(String id){
        Optional<nhanvien> optional = repo.findById(id);
        return optional.orElse(null);
    }
    public void deletenhanvien(String id){
        repo.deleteById(id);
    }
}
