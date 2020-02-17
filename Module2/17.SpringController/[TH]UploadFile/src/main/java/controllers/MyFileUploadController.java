package controllers;

import forms.MyUploadForm;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

@Controller
public class MyFileUploadController
{
    @InitBinder
    public void initBinder(WebDataBinder dataBinder)
    {
        Object target=dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target="+target);
        if (target.getClass() == MyUploadForm.class) {
            dataBinder.registerCustomEditor(byte[].class,
                    new ByteArrayMultipartFileEditor());
        }
    }
    @GetMapping("/uploadMultiFile")
    public String uploadMultiFileHandler(Model model){
        MyUploadForm myUploadForm=new MyUploadForm();
        model.addAttribute("myUploadForm",myUploadForm);
        return "uploadMultiFile";
    }
    @PostMapping("/uploadOneFile")
    public String uploadOneFileHandler(HttpRequest request, Model model, @ModelAttribute("myUploadForm")MyUploadForm myUploadForm){
        return this.doUpload(request,model,myUploadForm);
    }

    @PostMapping("/uploadMultiFile")
    public String uploadMultiFileHandler(HttpRequest request,Model model,@ModelAttribute("myUploadForm")MyUploadForm myUploadForm)
    {
        return this.doUpload(request, model, myUploadForm);
    }

    private String doUpload(HttpRequest request, Model model, MyUploadForm myUploadForm)
    {
        String description=myUploadForm.getDescription();
        System.out.println("Description "+description);

        String uploadRootPath=request.getServletContext().getRealPath("upload");
        System.out.println();
    }
}
