package com.mdps.controller;

import com.mdps.model.dao.Category;
import com.mdps.model.rest.HttpResponse;
import com.mdps.service.CategoryServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryServices services;

    @RequestMapping(value = "/getList", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getList(){
        List list = services.findAll();
        logger.info("Count of Category : {} " + list.size() );
        return list;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET, headers = "Accept=application/json")
    public Category getById(@RequestParam(value = "id", required = false)long id){
        logger.info("Request Category Id : {} " + id );
        return services.getOne(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, headers = "Accept=application/json")
    public Category save(@RequestBody Category obj){
        logger.info("Category Name : {} " + obj.getName() );
        return services.save(obj);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public HttpResponse delete(@RequestParam(value = "id", required = false)Long id){
        logger.info("Delete Category Name : {} " + id);
        HttpResponse response =new HttpResponse();
        Category item = services.getOne(id);
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
    public List<Category> bulkInsert(@RequestBody List<Category> items){
        logger.info("Category countt : {} " + items.size() );
        items.forEach(item -> {
            item.setId(null);
            item.setDateCreated(new Date());
        });
        return services.saveAll(items);
    }

}
