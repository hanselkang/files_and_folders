package com.example.files_and_folders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "files")
public class File {

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "extension")
    private String extension;

    @Column(name = "size_kb")
    private int size;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @ManyToOne
    @JsonIgnoreProperties({"files"})
    @JoinColumn(name = "folder_id")
    private Folder folder;


    public File(String fileName, String extension, int size, Folder folder) {
        this.fileName = fileName;
        this.extension = extension;
        this.size = size;
        this.folder = folder;
    }

    public File() {
    }


    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
