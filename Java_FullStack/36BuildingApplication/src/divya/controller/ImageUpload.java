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
		String action = request.getParameter("action");

		switch(action) {
		case "filesUpload":
			filesUpload(request, response);
			break;
		
		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch(action) {
		
		case "listingImages":
			listingImages(request, response);
			break;
		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	private void listingImages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Files> files = new FilesDAO().listFiles();
		request.setAttribute("files", files);
		request.setAttribute("path", path);
		request.getRequestDispatcher("listFiles.jsp").forward(request, response);
		
	}

	public void filesUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());


		try {
			List<FileItem> images = upload.parseRequest(request);
			for(FileItem image: images) {

				String name = image.getName();
				try {name = name.substring(name.lastIndexOf("\\")+1);} catch(Exception e) {}
				
				File file = new File(path + name);
				if(!file.exists()) {
					new FilesDAO().addFileDetails(new Files(name)); //Writes file into db
					image.write(file); //Writes file into file system
				}
				listingImages(request, response);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}	

	}

}