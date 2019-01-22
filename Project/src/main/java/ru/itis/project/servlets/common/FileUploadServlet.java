package ru.itis.project.servlets.common;

import ru.itis.project.models.UploadDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 30, maxRequestSize = 1024 * 1024 * 50)

public class FileUploadServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String UPLOAD_DIR = "uploadedFiles";

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/sendFile.jsp").forward(req, resp);
    }

    /***** This Method Is Called By The Servlet Container To Process A 'POST' Request *****/
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(request, response);
    }

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /***** Get The Absolute Path Of The Web Application *****/
        String uploadPath = "C:\\Users\\Iljas\\Desktop" + File.separator + UPLOAD_DIR;
        File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }

        String fileName;
        UploadDetail details = null;
        List<UploadDetail> fileList = new ArrayList<>();

        for (Part part : request.getParts()) {
            fileName = extractFileName(part);
            details = new UploadDetail();
            details.setFileName(fileName);
            details.setFileSize(part.getSize() / 1024);
            try {
                part.write(uploadPath + File.separator + fileName);
                details.setUploadStatus("Success");
            } catch (IOException ioObj) {
                details.setUploadStatus("Failure : " + ioObj.getMessage());
            }
            fileList.add(details);
        }

        request.setAttribute("uploadedFiles", fileList);

    }

    /***** Helper Method #1 - This Method Is Used To Read The File Names *****/
    private String extractFileName(Part part) {
        String fileName = "",
                contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            if (item.trim().startsWith("filename")) {
                fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
            }
        }
        return fileName;
    }
}


