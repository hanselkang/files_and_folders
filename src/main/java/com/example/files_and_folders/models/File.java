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




    @ManyToMany
    @JsonIgnoreProperties({"files"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "files_folders",
            joinColumns = {
                    @JoinColumn(name = "file_id", nullable = false, referencedColumnName = "folders_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "NULL", nullable = false, referencedColumnName = "NULL")}
    )
    private List<Folder> folders;

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public File(String fileName, String extension, int size, Person person) {
        this.fileName = fileName;
        this.extension = extension;
        this.size = size;
        this.person = person;
        this.folders = new ArrayList<Folder>();
    }

    public File() {
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
