package com.example.demo;
import com.example.demo.dto.itemDto;
import com.example.demo.model.item;
import com.example.demo.service.pdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/api/v1")
public class pdfController {
    @Autowired
    private pdfService service;
//    @GetMapping(value = "/demo-report", produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<byte[]> getReport() {
//        try {
//            return new ResponseEntity<byte[]>(service.getReport(), HttpStatus.OK);
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @GetMapping(value = "/demo-item", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getReports(@RequestParam int id) {
        try {
            return new ResponseEntity<byte[]>(service.getReports(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/add")
    public item add(@RequestBody item it){
        return service.add(it);
    }
    @PostMapping("/upload")
    public  String uploadImage(@RequestParam("file") MultipartFile file ){
         return service.uploadImage(file);
    }
    @GetMapping("/getid")
    public ResponseEntity<byte[]> getImage(@RequestParam int id){
        return service.getImage(id);
    }
    @GetMapping(value = "/demo-test", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getReports() {
        try {
            return new ResponseEntity<byte[]>(service.gettest(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/demo-test1", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getReports1(@RequestParam int id) {
        try {
            return new ResponseEntity<byte[]>(service.gettest1(id), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    }
