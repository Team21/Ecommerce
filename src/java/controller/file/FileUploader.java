package controller.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.util.Streams;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mrnull
 */
public class FileUploader extends HttpServlet {

    public static void fileDownloader(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            String filename = "foo.xml";
            String filepath = "/tmp/";
            out = response.getWriter();
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition",
                    "attachment; filename=\"" + filename + "\"");
            java.io.FileInputStream fileInputStream
                    = new java.io.FileInputStream(filepath + filename);
            int i;
            while ((i = fileInputStream.read()) != -1) {
                out.write(i);
            }
            fileInputStream.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUploader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    public static void fileUploader(HttpServletRequest req, HttpServletResponse resp) {
        try {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();//manage disk factory
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);//put it into servletfileuploader
            List<FileItem> items = servletFileUpload.parseRequest(req);//parse request
            Iterator<FileItem> iterator = items.iterator();//iterate on items
            System.out.println("trace-> file upload");
            while (iterator.hasNext()) {
                FileItem item = iterator.next();
                System.out.println(item);
                if (item.isFormField()) {

                    String fileName = item.getFieldName();
                    String value = item.getString();
                    System.out.println(fileName);
                    System.out.println(value);

                } else {
                    if (!item.isFormField()) {
                        System.out.println(new File(req.getServletContext().getRealPath("/")));
                        item.write(new File(req.getServletContext().getRealPath("/")+"/WEB-INF/img/prod/"+ item.getName()));

                    }

                }

            }
        } catch (FileUploadException ex) {
            Logger.getLogger(FileUploader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FileUploader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
