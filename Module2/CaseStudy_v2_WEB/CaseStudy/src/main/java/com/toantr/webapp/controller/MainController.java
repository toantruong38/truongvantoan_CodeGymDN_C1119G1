package com.toantr.webapp.controller;

import com.toantr.webapp.persistence.model.Comment;
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
import com.toantr.webapp.security.MyUserDetails;
import com.toantr.webapp.security.User;
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
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@SessionAttributes(names = {"favServices","currentUser"})
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
    @Autowired
    private CommentRepo commentRepo;
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
    @ModelAttribute("favServices")
    private List<Service> favServices(){
        return new ArrayList<>();
    }
    @ModelAttribute("currentUser")
    private User setUpUser(){
        return new User();
    }
    @RequestMapping(path = "/",method = {RequestMethod.GET,RequestMethod.POST})
    public String handleHomePage(HttpServletRequest request,
                                 Model model,
                                 @ModelAttribute("currentUser") User currentUser
                                 ){
        Cookie[] cookies=request.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("dateCreated")){
                StringBuilder formatted= new StringBuilder();
                Arrays.asList(c.getValue().split("#")).forEach(s -> {
                    if(!s.equals("")){
                        formatted.append("#").append(s).append("<br>");
                    }
                });
                model.addAttribute("dateCreated",formatted);
                System.out.println(c.getValue());
            }
        }
        Object principal=SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(principal instanceof MyUserDetails){
            currentUser=((MyUserDetails)principal).getUser();
            System.out.printf("User name {%s}",currentUser.getUsername());
        }
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
                                       BindingResult result,
                                       RedirectAttributes redirectAttributes
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
                                     BindingResult result,
                                     HttpServletResponse response,
                                     @CookieValue(value = "dateCreated",defaultValue = "") String dateCreated )
    {
        new ContractValidator().validate(contract,result);
        if(result.hasFieldErrors()) return "contract/new";
        contractService.save(contract);

        LocalDate today=LocalDate.now();
        dateCreated+="#"+today.toString();
        Cookie cookie=new Cookie("dateCreated",dateCreated);
        cookie.setMaxAge(3*24*60*60);
        cookie.setPath("/");
        response.addCookie(cookie);

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
    @GetMapping("/customer-using-service")
    public ModelAndView handleCustomerUsingContract(Pageable pageable,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "5") int size){
        pageable=PageRequest.of(page, size);
        return new ModelAndView("customer/customer-using-service",
                "customers",customerService.findCustomersUsingService(pageable));
    }
    @PostMapping("/delete-service/{id}")
    public String handleDeleteService(@RequestParam String confirm,
                                      RedirectAttributes redirectAttributes,
                                      @PathVariable Long id){
        if(confirm.equals("yes"))
        {
            serviceService.remove(id);
            redirectAttributes.addFlashAttribute("status","Deleted successfully!");
        }
        System.out.printf("Service id:{%d}",id);
        return "redirect:/service";
    }
    @GetMapping("/delete-service/{id}")
    public String handleDeleteService(@PathVariable Long id,
                                      Model model){
        model.addAttribute("serviceId",id);
        return "service/delete-confirm";
    }
    @PostMapping("/delete-customer/{id}")
    public String handleDeleteCustomer(@RequestParam String confirm,
                                      RedirectAttributes redirectAttributes,
                                      @PathVariable Long id){
        if(confirm.equals("yes"))
        {
            customerService.remove(id);
            redirectAttributes.addFlashAttribute("status","Deleted successfully!");
        }
        System.out.printf("Customer id:{%d}",id);
        return "redirect:/customer";
    }
    @GetMapping("/delete-customer/{id}")
    public String handleDeleteCustomer(@PathVariable Long id,
                                      Model model){
        model.addAttribute("customerId",id);
        return "customer/delete-confirm";
    }
    @GetMapping("/like-service/{id}")
    public String handleLikeService(@PathVariable Long id,
                                    @ModelAttribute("favServices") List<Service> favServices,
                                    RedirectAttributes redirectAttributes){
        favServices.add(serviceService.findById(id));
        redirectAttributes.addFlashAttribute("status","Added to collections!");
        return "redirect:/service";
    }
    @GetMapping("/comment")
    public String handleGetCommentPage(Model model){
        model.addAttribute("comment",new Comment());
        model.addAttribute("comments",commentRepo.findAll());
        return "comment-page";
    }
    @PostMapping("/comment-post")
    public String handlePostComment(Comment comment){
        commentRepo.save(comment);
        return "redirect:/comment";
    }
}
