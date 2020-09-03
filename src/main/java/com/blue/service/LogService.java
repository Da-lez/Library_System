package com.blue.service;
import com.blue.dao.LogDAO;
import com.blue.pojo.Log;
import com.blue.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
public class LogService {
    
    @Autowired
    private LogDAO logDAO;
    public List<Log> listLog() {
        return logDAO.findAll();
    }
   public void add(Log log){
        logDAO.save(log);
   }
}
