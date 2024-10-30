package pl.krzysztofskul.attachment;

import pl.krzysztofskul.project.Project;

import javax.persistence.*;

@Entity
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "attachmentCategory_id")
    private AttachmentCategory attachmentCategory;

    @Lob
    private byte[] data;

    @ManyToOne
    private Project project;

    private String description;
    
    /**
     * Constructor    
     */
    public Attachment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

	public AttachmentCategory getAttachmentCategory() {
		return attachmentCategory;
	}

	public void setAttachmentCategory(AttachmentCategory attachmentCategory) {
		this.attachmentCategory = attachmentCategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
