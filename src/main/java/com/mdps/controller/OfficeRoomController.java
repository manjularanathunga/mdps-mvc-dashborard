package com.mdps.controller;

import com.mdps.model.dao.OfficeRoom;
import com.mdps.model.rest.HttpResponse;
import com.mdps.service.BuildingServices;
import com.mdps.service.OfficeRoomServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/officeRoom")
public class OfficeRoomController {

    static Logger logger = LoggerFactory.getLogger(OfficeRoomController.class);

    @Autowired
    private OfficeRoomServices services;

    @Autowired
    private BuildingServices bServices;

    @RequestMapping(value = "/getList", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getList(){
        List list = services.findAll();
        logger.info("Count of OfficeRoom : {} " + list.size() );
        return list;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET, headers = "Accept=application/json")
    public OfficeRoom getById(@RequestParam(value = "id", required = false)long id){
        logger.info("Request OfficeRoom Id : {} " + id );
        return services.getOne(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    public OfficeRoom save(@RequestBody OfficeRoom obj){
        logger.info("OfficeRoom Name : {} " + obj.getName() );
        return services.save(obj);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public HttpResponse delete(@RequestParam(value = "id", required = false)Long id){
        logger.info("Delete OfficeRoom Name : {} " + id);
        HttpResponse response =new HttpResponse();
        OfficeRoom item = services.getOne(id);
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
    public List<OfficeRoom> bulkInsert(@RequestBody List<OfficeRoom> items){
        logger.info("OfficeRoom countt : {} " + items.size() );
        items.forEach(item -> {
            item.setId(null);
            item.setDateCreated(new Date());
        });
        return services.saveAll(items);
    }

}
