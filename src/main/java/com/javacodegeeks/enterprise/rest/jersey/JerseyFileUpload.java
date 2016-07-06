package com.javacodegeeks.enterprise.rest.jersey;

 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/files")
public class JerseyFileUpload {

	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "url where you want to upload";

	/**
	 * Upload a File
	 */

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("firstname")	String firstname ,
			@FormDataParam("lastname")	String lastname,
			@FormDataParam("emailID")	String emailID,
			@FormDataParam("jobTitle") String jobTitle,
			@FormDataParam("source")	String source,
			@FormDataParam("file") FormDataContentDisposition contentDispositionHeader) {
			
			/*firstname = "Raja Sekhar";
			lastname = "Pula Venkata";
			emailID = "rajashekarpula@live.com";
			jobTitle = "Java Enginner in Test";
			source = "LinkedIn";*/

		String filePath = SERVER_UPLOAD_LOCATION_FOLDER
				+ contentDispositionHeader.getFileName();

		// save the file to the server
		//saveFile(fileInputStream, filePath);

		String output = "File saved to server location : " + filePath;

		return Response.status(200).entity(output).build();

	}
	
	

	// save uploaded file to a defined location on the server
	/*private void saveFile(InputStream uploadedInputStream, String serverLocation) {

		try {
			OutputStream outpuStream = new FileOutputStream(new File(
					serverLocation));
			int read = 0;
			byte[] bytes = new byte[1024];
			
			outpuStream = new FileOutputStream(new File(serverLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}*/

}