package com.example.files_and_folders;

import com.example.files_and_folders.models.File;
import com.example.files_and_folders.models.Folder;
import com.example.files_and_folders.models.Person;
import com.example.files_and_folders.repository.FileRepository;
import com.example.files_and_folders.repository.FolderRepository;
import com.example.files_and_folders.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesAndFoldersApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;


	@Test
	void contextLoads() {
	}

	@Test
	public void createFileAndPersonThenSave(){


		Person hansel = new Person("Hansel");
		personRepository.save(hansel);
		Folder folder1 = new Folder("image",hansel );
		folderRepository.save(folder1);
		File owl = new File("Owl",".svg",20,folder1);
		fileRepository.save(owl);



	}

	@Test
	public void createFileAndFolderThenSave(){
		Person hansel = new Person("Hansel");
		personRepository.save(hansel);

		Folder folder1 = new Folder("image", hansel);
		folderRepository.save(folder1);

		File owl = new File("Owl",".svg",20,folder1);
		fileRepository.save(owl);

		hansel.addFolder(folder1);
		folder1.addFile(owl);
		folderRepository.save(folder1);


	}
}
