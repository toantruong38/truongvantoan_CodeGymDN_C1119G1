package com.toantr.webapp.controller;

import com.toantr.webapp.persistence.model.Service;
import com.toantr.webapp.persistence.model.accompanyservice.AccompanyService;
import com.toantr.webapp.persistence.model.contract.Contract;
import com.toantr.webapp.persistence.model.contractdetail.ContractDetail;
import com.toantr.webapp.persistence.model.customer.Customer;
import com.toantr.webapp.persistence.model.customertype.CustomerType;
import com.toantr.webapp.persistence.model.employee.Employee;
import com.toantr.webapp.persistence.model.renttype.RentType;
import com.toantr.webapp.persistence.model.servicetype.ServiceType;
import com.toantr.webapp.persistence.repo.*;
import com.toantr.webapp.persistence.service.ContractService;
import com.toantr.webapp.persistence.service.CustomerService;
import com.toantr.webapp.persistence.service.EmployeeService;
import com.toantr.webapp.persistence.service.ServiceService;
import com.toantr.webapp.validator.ContractDetailValidator;
import com.toantr.webapp.validator.ContractValidator;
import com.toantr.webapp.validator.CustomerValidator;
import com.toantr.webapp.validator.ServiceValidator;
import org.hibernate.boot.model.source.spi.Sortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController
{
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeRepo customerTypeRepo;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private RentTypeRepo rentTypeRepo;
    @Autowired
    private ServiceTypeRepo serviceTypeRepo;
    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractDetailRepo contractDetailRepo;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AccompanyServiceRepo accompanyServiceRepo;
    @ModelAttribute("employees")
    private Page<Employee> employees(Pageable pageable){
        return employeeService.findAll(pageable);
    }
    @ModelAttribute("accompanyServices")
    private List<AccompanyService> accompanyServices(){
        return accompanyServiceRepo.myFindAll();
    }
    @ModelAttribute("contracts")
    private Page<Contract> contracts(Pageable pageable){
        return contractService.findAll(pageable);
    }
    @ModelAttribute("customerTypes")
    private List<CustomerType> customerTypes()
    {
        return customerTypeRepo.getAll();
    }
    @ModelAttribute("customers")
    private List<Customer> customers(){
        return customerService.findAll();
    }
    @ModelAttribute("rentTypes")
    private List<RentType> rentTypes(){
        return rentTypeRepo.findAll();
    }
    @ModelAttribute("serviceTypes")
    private List<ServiceType> serviceTypes(){
        return serviceTypeRepo.findAll();
    }
    @ModelAttribute("services")
    private Page<Service> services(Pageable pageable){
        return serviceService.findAll(pageable);
    }
    @GetMapping("/")
    public String handleHomePage(){
        return "home";
    }
    @GetMapping("/customer")
    public String handleCustomerPage(
            @RequestParam(name = "page",required = false,defaultValue = "0")int page,
            @RequestParam(name="size",required = false,defaultValue = "5")int size,
            @RequestParam(name = "sort",required = false,defaultValue = "ASC")String sort,
            @RequestParam(name = "sortValue",required = false,defaultValue = "fullName") String sortValue,
            Model model, Pageable pageable, Sort sortable
            )
    {
        if(sort.equals("ASC"))
        {
            if(sortable.isSorted()){
                sortable= Sort.by(sortValue).descending();
            }
            else{
                sortable=Sort.by(sortValue).ascending();
            }
        }
        if(sort.equals("DESC"))
        {
            if(sortable.isSorted()){
                sortable= Sort.by(sortValue).ascending();
            }
            else{
                sortable=Sort.by(sortValue).descending();
            }
        }
        pageable=PageRequest.of(page, size,sortable);
        model.addAttribute("customers",customerService.findAll(pageable));
        return "customer/display";
    }
    @GetMapping("/customer/new") //TODO valid customer
    public ModelAndView handleNewCustomer(){
        return new ModelAndView("customer/new","customer",new Customer());
    }
    @PostMapping("/customer/new")
    public String handleSaveCustomer(@Valid Customer customer,
                                     RedirectAttributes redirectAttributes,
                                     BindingResult result
    )
    {
        new CustomerValidator().validate(customer,result);
        if(result.hasFieldErrors()) return "customer/new";//TODO suspected
        customerService.save(customer);//TODO catch ParseException
        redirectAttributes.addFlashAttribute("status","Added successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/customer/edit/{id}")
    public String handleUpdateCustomer(@PathVariable Long id,Model model)
    {
        model.addAttribute("customer",customerService.findById(id));
        return "customer/edit";
    }
    @PostMapping("/customer/edit")
    public String handleUpdateCustomer(@Valid Customer customer,
                                       RedirectAttributes redirectAttributes,
                                       BindingResult result
    ){
        new CustomerValidator().validate(customer,result);
        if(result.hasFieldErrors()) return "customer/edit";
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("status","Updated successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/service")
    public String handleServicePage(
            @RequestParam(name = "page",required = false,defaultValue = "0")int page,
            @RequestParam(name="size",required = false,defaultValue = "5")int size,
            @RequestParam(name = "sort",required = false,defaultValue = "ASC")String sort,
            @RequestParam(name = "sortValue",required = false,defaultValue = "area") String sortValue,
            Model model, Pageable pageable, Sort sortable
    ){
        if(sort.equals("ASC"))
        {
            if(sortable.isSorted()){
                sortable= Sort.by(sortValue).descending();
            }
            else{
                sortable=Sort.by(sortValue).ascending();
            }
        }
        if(sort.equals("DESC"))
        {
            if(sortable.isSorted()){
                sortable= Sort.by(sortValue).ascending();
            }
            else{
                sortable=Sort.by(sortValue).descending();
            }
        }
        pageable=PageRequest.of(page, size,sortable);
        model.addAttribute("services",serviceService.findAll(pageable));
        return "service/display";
    }
    @GetMapping("/service/new")
    public ModelAndView handleNewService(){
        return new ModelAndView("service/new","service",new Service());
    }
    @PostMapping("/service/new")
    public String handleSaveService(@Valid Service service,
                                    RedirectAttributes redirectAttributes,
                                    BindingResult result
    ){
        new ServiceValidator().validate(service,result);
        if(result.hasFieldErrors()) return "service/new";
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("status","Added successfully!");
        return "redirect:/service";
    }
    @GetMapping("/service/edit/{id}")
    public ModelAndView handleUpdateService(@PathVariable Long id){
        ModelAndView mav=new ModelAndView("service/edit","service",serviceService.findById(id));
        return  mav;
    }
    @PostMapping("/service/edit")
    public String handleUpdateService(@Valid Service service,
                                      RedirectAttributes redirectAttributes,
                                      BindingResult result
    )
    {
        new ServiceValidator().validate(service,result);
        if(result.hasFieldErrors()){
            return "service/edit";
        }
        serviceService.save(service);
        redirectAttributes.addFlashAttribute("status","Updated successfully!");
        return "redirect:/service";
    }
    @GetMapping("/contract/new")
    public ModelAndView handleNewContract(){
        return new ModelAndView("contract/new","contract",new Contract());
    }
    @PostMapping("/contract/new")
    public String handleSaveContract(@Valid Contract contract,
                                     BindingResult result
    ){
        new ContractValidator().validate(contract,result);
        if(result.hasFieldErrors()) return "contract/new";
        contractService.save(contract);
        return "redirect:/";
    }
    @GetMapping("/contract-detail/new")
    public ModelAndView handleNewDetailContract(){
        return new ModelAndView("contractDetail/new","contractDetail",new ContractDetail());
    }
    @PostMapping("/contract-detail/new")
    public String handleSaveDetailContract(@Valid ContractDetail contractDetail,
                                           BindingResult result

    ){
        new ContractDetailValidator().validate(contractDetail,result);
        if(result.hasFieldErrors()) return "contractDetail/new";
        contractDetailRepo.save(contractDetail); //TODO need testing
        return "redirect:/";
    }
    @GetMapping("/customer-using-contract")
    public ModelAndView handleCustomerUsingContract(Pageable pageable){
        return new ModelAndView("customer/customer-using-service",
                "customers",customerService.findCustomersUsingService(pageable));
    }
}
