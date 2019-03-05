package cn.com.ssh.controller;

import cn.com.ssh.entity.Customer;
import cn.com.ssh.service.CustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class AddController {
    private static Log log = LogFactory.getLog(AddController.class);
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getAll(HttpServletRequest request,HttpServletResponse response) {
        List<Customer> result = customerService.getAll();
        return result;
    }

    @RequestMapping(value = "/batchimport", method = RequestMethod.POST)
    @ResponseBody
    public String batchimport(@RequestParam("filename") MultipartFile file,
                              HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("AddController ..batchimport() start");
        //判断文件是否为空
        if (file == null) {
            return null;
        }
        //获取文件名
        String name = file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size = file.getSize();
        if (name == null || ("").equals(name) && size == 0) {
            return null;
        }

        //批量导入。参数：文件名，文件。
        boolean b = customerService.batchImport(name, file);
        String result = null;
        if (b) {
            String Msg = "批量导入EXCEL成功！";
            result = "success";
            request.getSession().setAttribute("msg", Msg);
        } else {
            String Msg = "批量导入EXCEL失败！";
            result = "failed";
            request.getSession().setAttribute("msg", Msg);
        }
        return result;
    }
}
