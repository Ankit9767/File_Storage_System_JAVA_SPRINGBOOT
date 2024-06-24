package com.example.FileStorageSystem.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class FileShare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private File file;

    @ManyToOne
    private User sharedWith;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public User getSharedWith() {
		return sharedWith;
	}

	public void setSharedWith(User sharedWith) {
		this.sharedWith = sharedWith;
	}
    
    

    // Getters and Setters
}

