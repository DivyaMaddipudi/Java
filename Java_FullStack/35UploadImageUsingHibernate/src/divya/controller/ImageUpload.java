package divya.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import divya.hibernate.DAO.FilesDAO;
import divya.hibernate.entity.Files;

/**
 * Servlet implementation class ImageUpload
 */
@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public String path = "c:/images/";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
		
		
		try {
			List<FileItem> images = upload.parseRequest(request);
			for(FileItem image: images) {
				
				String name = image.getName();
				try {name = name.substring(name.lastIndexOf("\\")+1);} catch(Exception e) {}
				image.write(new File(path + name));
				
				new FilesDAO().addFileDetails(new Files(name));
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
