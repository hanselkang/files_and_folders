package com.example.files_and_folders.components;

import com.example.files_and_folders.models.File;
import com.example.files_and_folders.models.Folder;
import com.example.files_and_folders.models.Person;
import com.example.files_and_folders.repository.FileRepository;
import com.example.files_and_folders.repository.FolderRepository;
import com.example.files_and_folders.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    PersonRepository personRepository;


    public void run(ApplicationArguments args) throws Exception{

        Person person1 = new Person("Fuchsia");
        personRepository.save(person1);

        Folder folder1 = new Folder("Painting", person1);
        folderRepository.save(folder1);
        Folder folder2 = new Folder("Videos", person1);
        folderRepository.save(folder2);



        File image1 = new File("Owl",".jpg",249, folder1);
        fileRepository.save(image1);
        File image2 = new File("Chicken",".png",222,folder1);
        fileRepository.save(image2);

        folder1.addFile(image1);
        folder1.addFile(image2);
        folderRepository.save(folder1);

        person1.addFolder(folder1);
        person1.addFolder(folder2);
        personRepository.save(person1);

    }

}
