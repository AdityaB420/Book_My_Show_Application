package com.example.Book_my_Show_Application_February.Controller;

import com.example.Book_my_Show_Application_February.Entities.ShowEntity;
import com.example.Book_my_Show_Application_February.EntryDtos.ShowEntryDto;
import com.example.Book_my_Show_Application_February.EntryDtos.ShowTimingDto;
import com.example.Book_my_Show_Application_February.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody ShowEntryDto showEntryDto){
        try{
            String result = showService.addShow(showEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            String response = "Show not added";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }


    }
    @GetMapping("/get_show_time")
    public ResponseEntity<List<ShowEntity>> getShowTime(@RequestBody ShowTimingDto showTimingDto){
        try{
            List<ShowEntity> result = showService.getShowTime(showTimingDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }


    }


}