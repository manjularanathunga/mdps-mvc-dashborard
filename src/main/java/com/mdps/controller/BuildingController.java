package com.mdps.controller;

import com.mdps.model.dao.Building;
import com.mdps.model.rest.HttpResponse;
import com.mdps.service.BuildingServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {

    static Logger logger = LoggerFactory.getLogger(BuildingController.class);

    @Autowired
    private BuildingServices services;

    @RequestMapping(value = "/getList", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getList(){
        List list = services.findAll();
        logger.info("Count of Building : {} " + list.size() );
        return list;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET, headers = "Accept=application/json")
    public Building getById(@RequestParam(value = "id", required = false)long id){
        logger.info("Request Building Id : {} " + id );
        return services.getOne(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    public Building save(@RequestBody Building obj){
        logger.info("Building Name : {} " + obj.getName() );
        return services.save(obj);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public HttpResponse delete(@RequestParam(value = "id", required = false)Long id){
        logger.info("Delete Building Name : {} " + id);
        HttpResponse response =new HttpResponse();
        Building item = services.getOne(id);
        if(item != null){
            services.delete(item);
            response.setSuccess(true);
        }else{
            response.setSuccess(false);
            logger.info("Record has been already deleted : {} " + id);
            response.setException("Record has been already deleted");
        }
        return response;
    }

    @RequestMapping(value = "/bulkInsert", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<Building> bulkInsert(@RequestBody List<Building> items){
        logger.info("Building countt : {} " + items.size() );
        items.forEach(item -> {
            item.setId(null);
            item.setDateCreated(new Date());
        });
        return services.saveAll(items);
    }

}
