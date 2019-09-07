package com.mdps.controller;

import com.mdps.model.dao.Inventory;
import com.mdps.model.rest.HttpResponse;
import com.mdps.service.InventoryServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    static Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryServices services;

    @RequestMapping(value = "/getList", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getList(){
        List list = services.findAll();
        logger.info("Count of Inventory : {} " + list.size() );
        return list;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET, headers = "Accept=application/json")
    public Inventory getById(@RequestParam(value = "id", required = false)long id){
        logger.info("Request Inventory Id : {} " + id );
        return services.getOne(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    public Inventory save(@RequestBody Inventory obj){
        logger.info("Inventory Name : {} " + obj.getName() );
        return services.save(obj);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public HttpResponse delete(@RequestParam(value = "id", required = false)Long id){
        logger.info("Delete Inventory Name : {} " + id);
        HttpResponse response =new HttpResponse();
        Inventory item = services.getOne(id);
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
    public List<Inventory> bulkInsert(@RequestBody List<Inventory> items){
        logger.info("Inventory countt : {} " + items.size() );
        items.forEach(item -> {
            item.setId(null);
            item.setDateCreated(new Date());
        });
        return services.saveAll(items);
    }

}
