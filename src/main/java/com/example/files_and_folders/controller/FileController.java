package com.example.files_and_folders.controller;

import com.example.files_and_folders.models.File;
import com.example.files_and_folders.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping(value="/files")
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/files/{id}")
    public Optional<File> getFile(@PathVariable Long id) { return fileRepository.findById(id);}

    @PostMapping(value="/files")
    public ResponseEntity<File> postFile(@RequestBody File file) {
        fileRepository.save(file);
        return new ResponseEntity<>(file,HttpStatus.CREATED);
    }
}
