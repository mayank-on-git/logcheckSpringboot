package com.logcheck.logcheck.Service;

import com.logcheck.logcheck.Repository.Demo_DetailsRepository;
import com.logcheck.logcheck.entity.Demo_Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class Demo_dataServiceImpl implements Demo_dataService{

    @Autowired
    Demo_DetailsRepository demoDetailsRepository;

    @Override
    public Demo_Details saveData(Demo_Details demoDetails) {
        Demo_Details save = demoDetailsRepository.save(demoDetails);
        return save;
    }

    @Override
    public Demo_Details findById(long id) {
        Optional<Demo_Details> byId = demoDetailsRepository.findById(id);
        Optional<Demo_Details> byId1 = byId;
        byId1.get();
        return byId1.get();
    }
}
