package com.example.files_and_folders.controller;

import com.example.files_and_folders.models.Folder;
import com.example.files_and_folders.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
//public class FolderController {
//
//    @Autowired
//    FolderRepository folderRepository;
//
//    @GetMapping(value="/folders")
//    public ResponseEntity<List<Folder>> getAllFolders(){
//        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
//    }
//
//    @GetMapping(value="/folders/{id}")
//    public Optional<Folder> getFolder(@PathVariable Long id) { return folderRepository.findById(id);}
//
//    @PostMapping(value="/files")
//    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder) {
//        folderRepository.save(folder);
//        return new ResponseEntity<>(folder,HttpStatus.CREATED);
//    }
//}

@RestController
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping("/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        List<Folder> foundFolders = folderRepository.findAll();
        return new ResponseEntity<>(foundFolders, HttpStatus.OK);
    }

    @GetMapping("/folders/{id}")
    public ResponseEntity getFolderById(@PathVariable Long id){
        Optional<Folder> foundFolder = folderRepository.findById(id);
        return new ResponseEntity(foundFolder, HttpStatus.OK);
    }

    @PostMapping("/folders")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

}
