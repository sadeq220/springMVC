package controller;

import model.Array;
import model.Inventory;
import model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.Service;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Service service;
@RequestMapping({"/","home"})
    public String home(Model model){
    model.addAttribute("news",service.allNews());

    return "home";
}
@GetMapping("update")
    public String update(Model model, Authentication auth){

    model.addAttribute("news",new News());
    model.addAttribute("newses",service.allNews());
    model.addAttribute("auth",auth);
    return "update";
}
@GetMapping("/update/delete")
public String delete(@RequestParam(name="id")int id){
    File file=new File("E:\\imgs\\pic"+id+".jpg");
    file.delete();
    service.delete(id);
    return "redirect:/update";
}
@GetMapping("/update/modify")
public String modify(@RequestParam int id, Model model, HttpSession session){
    session.setAttribute("id",new Integer(id));
    model.addAttribute("loadedObject",service.find(id));
    return "modify";

}
@PostMapping("/update/modify")
public String modify(@ModelAttribute News loadedObject,HttpSession session){
    if(session.getAttribute("id")==null)
        return "redirect:/update";
    loadedObject.setId((Integer)session.getAttribute("id"));
    loadedObject.setImagePath("pic"+session.getAttribute("id")+".jpg");
    service.update(loadedObject);
    return "redirect:/update";
}
@ExceptionHandler({javax.persistence.NoResultException.class})
public String noEntry(){
    return "home";
}
@PostMapping("/update")
    public String update(@ModelAttribute(name="news")News news ){
    String s0=service.saveNews(news);
    String s=String.format("D:\\imgs\\%s",s0);

    MultipartFile file=news.getImage();

        try {
            file.transferTo(new File(s));

        } catch (IOException e) {
            e.printStackTrace();
        }

    return "redirect:home";
}
@GetMapping("/Array")
public String testingArray(Model model){
    model.addAttribute("array",new Array());
    return "testingArray";
}
@PostMapping("/Array")
public String gettingArray(Array array){
    for(String a:array.getA())
        System.out.println(a);
    return "redirect:home";
}
@RequestMapping(value = "/imgs",produces = MediaType.IMAGE_PNG_VALUE)
@ResponseBody
    public byte[] images(@RequestParam(name="imgID") String s){
    String path=String.format("D:\\imgs\\%s",s);
    File file=new File(path);
    try(FileInputStream stream=new FileInputStream(file)){
        MultipartFile finalFile=new MockMultipartFile("file",s,"image/png/jpg",stream);

        return finalFile.getBytes();
    }catch(IOException e){
        e.printStackTrace();
        return null;
    }

}
}
