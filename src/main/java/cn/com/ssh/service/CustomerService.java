package cn.com.ssh.service;

import cn.com.ssh.dao.CustomerDao;
import cn.com.ssh.entity.Customer;
import cn.com.ssh.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    //批量导入客户
    public boolean batchImport(String name, MultipartFile file) {
        boolean b = false;
        //创建处理EXCEL
        ReadExcel readExcel = new ReadExcel();
        //解析excel，获取客户信息集合。
        List<Customer> customerList = readExcel.getExcelInfo(name, file);

        if (customerList != null) {
            b = true;
        }

        //迭代添加客户信息（注：实际上这里也可以直接将customerList集合作为参数，在Mybatis的相应映射文件中使用foreach标签进行批量添加。）
        for (Customer customer : customerList) {
            customerDao.addCustomer(customer);
        }
        return b;
    }
}
