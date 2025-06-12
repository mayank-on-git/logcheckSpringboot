package com.logcheck.logcheck.Service;

import com.logcheck.logcheck.entity.Demo_Details;

public interface Demo_dataService {

Demo_Details saveData(Demo_Details demoDetails);

Demo_Details findById(long id);

}


