/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv.cv.controller;

import cv.cv.entities.Achievement;
import cv.cv.entities.Certification;
import cv.cv.entities.Client;
import cv.cv.entities.Education;
import cv.cv.entities.Employee;
import cv.cv.entities.Experience;
import cv.cv.entities.Language;
import cv.cv.entities.LanguageEmployee;
import cv.cv.entities.Organization;
import cv.cv.entities.Project;
import cv.cv.entities.ProjectEmployee;
import cv.cv.entities.QualificationEmployee;
import cv.cv.entities.RoleMii;
import cv.cv.entities.Training;
import cv.cv.entities.UserMii;
import cv.cv.entities.WorkAssignment;
import cv.cv.repository.serviceinterface.serviceimpl.AchievementServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.CertificationServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.ClientServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.EducationServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.EmailServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.EmployeeServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.ExperienceServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.LanguageEmployeeServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.LanguageServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.MajorUniversityServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.OrganizationServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.ProjectEmployeeServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.ProjectServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.QualificationEmployeeServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.QualificationServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.RoleServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.TrainingServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.UserMiiServiceImpl;
import cv.cv.repository.serviceinterface.serviceimpl.WorkAssignmentServiceImpl;
import java.io.File;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author NINDA
 */
@Controller
public class MainController {

    @Autowired
    private ProjectServiceImpl projectImpl;

    @Autowired
    private ClientServiceImpl clientImpl;

    @Autowired
    private UserMiiServiceImpl userImpl;

    @Autowired
    private EmployeeServiceImpl employeeImpl;

    @Autowired
    private RoleServiceImpl roleImpl;

    @Autowired
    private AchievementServiceImpl achievementImpl;

    @Autowired
    private CertificationServiceImpl certificationImpl;

    @Autowired
    private EducationServiceImpl educationImpl;

    @Autowired
    private ExperienceServiceImpl experienceImpl;

    @Autowired
    private LanguageEmployeeServiceImpl languageEmployeeImpl;

    @Autowired
    private OrganizationServiceImpl organizationImpl;

    @Autowired
    private QualificationEmployeeServiceImpl qualificationEmployeeImpl;

    @Autowired
    private TrainingServiceImpl trainingImpl;

    @Autowired
    private WorkAssignmentServiceImpl workAssignmentImpl;

    @Autowired
    private MajorUniversityServiceImpl majorUniversityImpl;

    @Autowired
    private LanguageServiceImpl languageImpl;

    @Autowired
    private QualificationServiceImpl qualificationImpl;

    @Autowired
    private ProjectEmployeeServiceImpl projectEmployeeImpl;

    private static Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private EmailServiceImpl emailImpl;

    public static String userId;

    public PasswordEncoder bcrypt() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

//  LOGIN MAPPING
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "login";
    }

    @RequestMapping(value = {"/default"}, method = RequestMethod.GET)
    public String defaultAfterLogin() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication.getName());

        Collection<? extends GrantedAuthority> authorities;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authorities = auth.getAuthorities();

        userId = auth.getName();

        String myRole = authorities.toArray()[0].toString();
        if (myRole.equals("admin")) {
            return "redirect:/admhome/";
        } else if (myRole.equals("employee")) {
            return "redirect:/emphome/";

        } else if (myRole.equals("RM")) {
            return "redirect:/rmhome/";
        }
        return "redirect:/clienthome/";
    }
//    END OF LOGIN MAPPING

//Admin Controller
    @GetMapping("/admhome")
    public String admin(Model model) {
        model.addAttribute("dataAdmin", userImpl.findbyid(userId));
        return "pages/AdmDashboard";
    }

    @GetMapping("/project")
    public String project(Model model) {
        String choose[] = {"do", "done"};
        model.addAttribute("dataChoose", choose);
        model.addAttribute("dataProject", projectImpl.findall());
        model.addAttribute("projectsave", new Project());
        model.addAttribute("findclient", clientImpl.findall());
        return "pages/AdmProject";
    }

    @GetMapping("/employee")
    public String employee(Model model) {

        String religion[] = {"Moslem", "Christian", "Catholic", "Buddha", "Hindu"};
        model.addAttribute("dataReligion", religion);

        String marital[] = {"Single", "Married"};
        model.addAttribute("dataMarital", marital);

        String gender[] = {"Male", "Female"};
        model.addAttribute("dataGender", gender);

        model.addAttribute("dataEmployee", employeeImpl.findall());
        model.addAttribute("usersave", new UserMii());
        model.addAttribute("employeesave", new Employee());
        model.addAttribute("findrole", roleImpl.findall());
        return "pages/AdmEmployee";
    }

    @GetMapping("/client")
    public String client(Model model) {
        model.addAttribute("dataClient", clientImpl.findall());
        model.addAttribute("usersave", new UserMii());
        model.addAttribute("clientsave", new Client());
        return "pages/AdmClient";
    }

    @RequestMapping(value = "/projectsave", method = RequestMethod.POST)
    public String saveProject(@ModelAttribute("projectsave") Project siswa) {
        siswa.setProjectStatus("do");
        projectImpl.save(siswa);
        return "redirect:/project";
    }

    @RequestMapping(value = "/projectedit", method = RequestMethod.POST)
    public String saveEditProject(@ModelAttribute("projectsave") Project siswa) {
        projectImpl.save(siswa);
        return "redirect:/project";
    }

    @RequestMapping(value = "/clientsave", method = RequestMethod.POST)
    public String saveUserMII(@ModelAttribute("usersave") UserMii user,
            @ModelAttribute("clientsave") Client client) {
        client.setId(user.getId());
        String pwd = user.getId() + user.getName();
        user.setPassword(pwd);
        client.setIsDelete("NO");
        user.setRole(new RoleMii("4"));
        userImpl.save(user);
        clientImpl.save(client);
        UserMii umii = userImpl.findbyid(user.getId());
        try {
            emailImpl.sendNotificationService(umii);
        } catch (Exception e) {
            log.info("Error sending email = " + e.getMessage());
        }

        String encrypt = bcrypt().encode(pwd);
        user.setPassword(encrypt);
        userImpl.save(user);
        clientImpl.save(client);
        return "redirect:/client";
    }

    @RequestMapping(value = "/clientedit", method = RequestMethod.POST)
    public String saveEditUserMII(@ModelAttribute("usersave") UserMii user,
            @ModelAttribute("clientsave") Client client) {
        client.setIsDelete("NO");
        user.setRole(new RoleMii("4"));
        userImpl.save(user);
        clientImpl.save(client);
        return "redirect:/client";
    }

    @RequestMapping(value = "/employeesave", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("usersave") UserMii user, @ModelAttribute("employeesave") Employee employee) {

        String ids = user.getId();
        String dates;
        String months;
        String tahun = null;

        if (employee.getBirthDate().getDate() < 10) {
            dates = "0" + employee.getBirthDate().getDate();
        } else {
            dates = "" + employee.getBirthDate().getDate();
        }
        if (employee.getBirthDate().getMonth() < 10) {
            months = "0" + (employee.getBirthDate().getMonth() + 1);
        } else {
            months = "" + (employee.getBirthDate().getMonth() + 1);
        }
        if (employee.getBirthDate().getYear() < 100) {
            tahun = "" + employee.getBirthDate().getYear();
        } else if (employee.getBirthDate().getYear() >= 100 && employee.getBirthDate().getYear() < 110) {
            tahun = "0" + (employee.getBirthDate().getYear() - 100);
        } else if (employee.getBirthDate().getYear() >= 110) {
            tahun = "" + (employee.getBirthDate().getYear() - 100);
        }

        String pwd = ids + dates + months + tahun;
        user.setPassword(pwd);
        employee.setId(user.getId());
        employee.setIsDelete("NO");
//        Byte[] byteobjects = new Byte[file.getBytes().length];
//        int i = 0;
//        for (byte b : file.getBytes()) {
//            byteobjects[i++] = b;
//        }
//        for (byte byteobject : byteobjects) {
//            System.out.println(byteobject);
//        }
//        for (Byte byteobject : byteobjects) {
//            System.out.print(byteobject); 
//        }
//       
//        employee.setPhoto(byteobjects);
        userImpl.save(user);
        employeeImpl.save(employee);

        UserMii umii = userImpl.findbyid(ids);
        try {

            emailImpl.sendNotificationService(umii);

        } catch (Exception e) {
            log.info("Error sending email = " + e.getMessage());
        }
        String encrypt = bcrypt().encode(pwd);
        user.setPassword(encrypt);
        userImpl.save(user);
        employeeImpl.save(employee);

        return "redirect:/employee";
    }

    @RequestMapping(value = "/employeeedit", method = RequestMethod.POST)
    public String saveEditEmployee(@ModelAttribute("usersave") UserMii user,
            @ModelAttribute("employeesave") Employee employee) {
        employee.setIsDelete("NO");
        userImpl.save(user);
        employeeImpl.save(employee);
        return "redirect:/employee";
    }

// end Admin Controller
//Employee Controller
    //dashboard(home)
    @GetMapping("/emphome")
    public String emp(Model model) {
        model.addAttribute("dataEmployee", userImpl.findbyid(userId));
        return "pages/EmpDashboard";
    }
    // end dashboard

    //page profil 
    //get mapping page profil
    @GetMapping("/profilEmployee")
    public String profilEmployee(Model model) {
        model.addAttribute("dataUser", userImpl.findbyid(userId));
        model.addAttribute("profilEmployee", employeeImpl.findbyid(userId));
        model.addAttribute("usersave", new UserMii());
        model.addAttribute("employeesave", new Employee());

        String religion[] = {"Moslem", "Christian", "Catholic", "Buddha", "Hindu"};
        model.addAttribute("dataReligion", religion);

        String marital[] = {"Single", "Married"};
        model.addAttribute("dataMarital", marital);

        String choose[] = {"YES", "NO"};
        model.addAttribute("dataChoose", choose);

        String gender[] = {"Male", "Female"};
        model.addAttribute("dataGender", gender);

        model.addAttribute("maxidAchievement", achievementImpl.findmaxId());
        model.addAttribute("dataAchievement", achievementImpl.findbyempid(userId));
        model.addAttribute("maxidCertification", certificationImpl.findmaxId());
        model.addAttribute("dataCertification", certificationImpl.findbyempid(userId));
        model.addAttribute("maxidEducation", educationImpl.findmaxId());
        model.addAttribute("dataEducation", educationImpl.findbyempid(userId));
        model.addAttribute("maxidExperience", experienceImpl.findmaxId());
        model.addAttribute("dataExperience", experienceImpl.findbyempid(userId));
        model.addAttribute("maxidLanguageEmployee", languageEmployeeImpl.findmaxId());
        model.addAttribute("dataLanguageEmployee", languageEmployeeImpl.findbyempid(userId));
        model.addAttribute("maxidOrganization", organizationImpl.findmaxId());
        model.addAttribute("dataOrganization", organizationImpl.findbyempid(userId));
        model.addAttribute("maxidQualificationEmployee", qualificationEmployeeImpl.findmaxId());
        model.addAttribute("dataQualificationEmployee", qualificationEmployeeImpl.findbyempid(userId));
        model.addAttribute("maxidTraining", trainingImpl.findmaxId());
        model.addAttribute("dataTraining", trainingImpl.findbyempid(userId));
        model.addAttribute("maxidWorkAssignment", workAssignmentImpl.findmaxId());
        model.addAttribute("dataWorkAssignment", workAssignmentImpl.findbyempid(userId));
        model.addAttribute("achievementsave", new Achievement());
        model.addAttribute("certificationsave", new Certification());
        model.addAttribute("educationsave", new Education());
        model.addAttribute("findmajoruniversity", majorUniversityImpl.findall());
        model.addAttribute("experiencesave", new Experience());
        model.addAttribute("languageemployeesave", new LanguageEmployee());
        model.addAttribute("findlanguage", languageImpl.findall());
        model.addAttribute("organizationsave", new Organization());
        model.addAttribute("qualificationemployeesave", new QualificationEmployee());
        model.addAttribute("findqualification", qualificationImpl.findall());
        model.addAttribute("trainingsave", new Training());
        model.addAttribute("worksave", new WorkAssignment());
        return "pages/EmpProfilEmployee";
    }
    //end get mapping page profil

    @RequestMapping(value = "/profilemployeesave", method = RequestMethod.POST)
    public String saveProfilEmployee(@ModelAttribute("usersave") UserMii user, @ModelAttribute("employeesave") Employee employee) {
        employee.setId(user.getId());
        employee.setIsDelete("NO");
        userImpl.save(user);
        employeeImpl.save(employee);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.POST)
    public String editPasswordEmployee(@ModelAttribute("usersave") UserMii user) {
        String encrypt = bcrypt().encode(user.getPassword());
        user.setPassword(encrypt);
        userImpl.save(user);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/achievementsave", method = RequestMethod.POST)
    public String saveAchievement(@ModelAttribute("achievementsave") Achievement achievement) {
        achievement.setEmployee(new Employee(userId));
        achievementImpl.save(achievement);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/certificationsave", method = RequestMethod.POST)
    public String saveCertification(@ModelAttribute("certificationsave") Certification certification) {
        certification.setEmployee(new Employee(userId));
        certificationImpl.save(certification);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/educationsave", method = RequestMethod.POST)
    public String saveEducation(@ModelAttribute("educationsave") Education education) {
        education.setEmployee(new Employee(userId));
        educationImpl.save(education);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/experiencesave", method = RequestMethod.POST)
    public String saveExperience(@ModelAttribute("experiencesave") Experience experience) {
        experience.setEmployee(new Employee(userId));
        experienceImpl.save(experience);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/languageemployeesave", method = RequestMethod.POST)
    public String saveLanguageEmployee(@ModelAttribute("languageemployeesave") LanguageEmployee languageEmployee) {
        languageEmployee.setEmployee(new Employee(userId));
        languageEmployeeImpl.save(languageEmployee);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/organizationsave", method = RequestMethod.POST)
    public String saveOrganization(@ModelAttribute("organizationsave") Organization organization) {
        organization.setEmployee(new Employee(userId));
        organizationImpl.save(organization);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/qualificationemployeesave", method = RequestMethod.POST)
    public String saveQualificationEmployee(@ModelAttribute("qualificationemployeesave") QualificationEmployee qualificationEmployee) {
        qualificationEmployee.setEmployee(new Employee(userId));
        qualificationEmployeeImpl.save(qualificationEmployee);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/trainingsave", method = RequestMethod.POST)
    public String saveTraining(@ModelAttribute("qualificationemployeesave") Training training) {
        training.setEmployee(new Employee(userId));
        trainingImpl.save(training);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/worksave", method = RequestMethod.POST)
    public String saveWorkAssignment(@ModelAttribute("worksave") WorkAssignment workAssignment) {
        workAssignment.setEmployee(new Employee(userId));
        workAssignmentImpl.save(workAssignment);
        return "redirect:/profilEmployee";
    }
    //end page profil

    @GetMapping("/empproject")
    public String empproject(Model model) {
        model.addAttribute("dataProject", projectEmployeeImpl.findbyempid(userId));
        return "pages/EmpProjectEmployee";
    }
// end Employee Controller

    @GetMapping("/rmhome")
    public String rm(Model model) {
        model.addAttribute("dataEmployee", userImpl.findbyid(userId));
        return "pages/RMDashboard";
    }

    @GetMapping("/clienthome")
    public String cl(Model model) {
        model.addAttribute("dataClient", userImpl.findbyid(userId));
        return "pages/ClientDashboard";
    }

    //client
    @GetMapping("/assessment")
    public String assessment(Model model) {
        model.addAttribute("dataProject", projectImpl.findbyclientid(userId));
        model.addAttribute("assessmentsave", new Project());
        return "pages/ClientAssessment";
    }

    @GetMapping("/clientprofilemployee")
    public String clientProfilEmployee(Model model) {

        List<String> projid = new ArrayList<String>();
        List<ProjectEmployee> projectEmployeeData = new ArrayList<ProjectEmployee>();

        for (Project proj : projectImpl.findbyclientid(userId)) {
            projid.add(proj.getId());
        }
        for (String string : projid) {
            for (ProjectEmployee projectEmployee : projectEmployeeImpl.findbyprojid(string)) {
                projectEmployeeData.add(projectEmployee);
            }
        }
        model.addAttribute("dataProjectEmp", projectEmployeeData);
        model.addAttribute("dataProject", projectImpl.findall());
        model.addAttribute("employee", employeeImpl.findall());
        return "pages/ClientEmployee";
    }
    //client

//RM controller
    @GetMapping("/rmproject")
    public String rmproject(Model model) {
        List<String> projid = new ArrayList<String>();
        List<ProjectEmployee> projectEmployeeData = new ArrayList<ProjectEmployee>();
        for (ProjectEmployee projectEmployee : projectEmployeeImpl.findbyempid(userId)) {
            projid.add(projectEmployee.getProject().getId());
        }
        for (String string : projid) {
            for (ProjectEmployee pe : projectEmployeeImpl.findbyprojid(string)) {
                if (!pe.getEmployee().getId().equalsIgnoreCase(userId)) {
                    projectEmployeeData.add(pe);
                }
            }

        }
        model.addAttribute("maxid", projectEmployeeImpl.findmaxId());
        model.addAttribute("dataProjectEmp", projectEmployeeData);
        model.addAttribute("dataProject", projectImpl.findall());
        model.addAttribute("rmprojectempsave", new ProjectEmployee());
        model.addAttribute("employee", employeeImpl.findall());
        return "pages/RMProjectEmployee";
    }

    @GetMapping("/RMProfil")
    public String RMprofilEmployee(Model model) {
        model.addAttribute("dataUser", userImpl.findbyid(userId));

        model.addAttribute("profilEmployee", employeeImpl.findbyid(userId));
        model.addAttribute("usersave", new UserMii());
        model.addAttribute("employeesave", new Employee());

        String religion[] = {"Moslem", "Christian", "Catholic", "Buddha", "Hindu"};
        model.addAttribute("dataReligion", religion);

        String marital[] = {"Single", "Married"};
        model.addAttribute("dataMarital", marital);

        String choose[] = {"YES", "NO"};
        model.addAttribute("dataChoose", choose);

        String gender[] = {"Male", "Female"};
        model.addAttribute("dataGender", gender);

        model.addAttribute("maxidAchievement", achievementImpl.findmaxId());
        model.addAttribute("dataAchievement", achievementImpl.findbyempid(userId));
        model.addAttribute("maxidCertification", certificationImpl.findmaxId());
        model.addAttribute("dataCertification", certificationImpl.findbyempid(userId));
        model.addAttribute("maxidEducation", educationImpl.findmaxId());
        model.addAttribute("dataEducation", educationImpl.findbyempid(userId));
        model.addAttribute("maxidExperience", experienceImpl.findmaxId());
        model.addAttribute("dataExperience", experienceImpl.findbyempid(userId));
        model.addAttribute("maxidLanguageEmployee", languageEmployeeImpl.findmaxId());
        model.addAttribute("dataLanguageEmployee", languageEmployeeImpl.findbyempid(userId));
        model.addAttribute("maxidOrganization", organizationImpl.findmaxId());
        model.addAttribute("dataOrganization", organizationImpl.findbyempid(userId));
        model.addAttribute("maxidQualificationEmployee", qualificationEmployeeImpl.findmaxId());
        model.addAttribute("dataQualificationEmployee", qualificationEmployeeImpl.findbyempid(userId));
        model.addAttribute("maxidTraining", trainingImpl.findmaxId());
        model.addAttribute("dataTraining", trainingImpl.findbyempid(userId));
        model.addAttribute("maxidWorkAssignment", workAssignmentImpl.findmaxId());
        model.addAttribute("dataWorkAssignment", workAssignmentImpl.findbyempid(userId));
        model.addAttribute("achievementsave", new Achievement());
        model.addAttribute("certificationsave", new Certification());
        model.addAttribute("educationsave", new Education());
        model.addAttribute("findmajoruniversity", majorUniversityImpl.findall());
        model.addAttribute("experiencesave", new Experience());
        model.addAttribute("languageemployeesave", new LanguageEmployee());
        model.addAttribute("findlanguage", languageImpl.findall());
        model.addAttribute("organizationsave", new Organization());
        model.addAttribute("qualificationemployeesave", new QualificationEmployee());
        model.addAttribute("findqualification", qualificationImpl.findall());
        model.addAttribute("trainingsave", new Training());
        model.addAttribute("worksave", new WorkAssignment());
        return "pages/RMProfil";
    }

    @RequestMapping(value = "/profilemployeesaveRM", method = RequestMethod.POST)
    public String saveProfilEmployeeRM(@ModelAttribute("usersave") UserMii user, @ModelAttribute("employeesave") Employee employee) {
        employee.setId(user.getId());
        employee.setIsDelete("NO");
        userImpl.save(user);
        employeeImpl.save(employee);
        return "redirect:/RMProfil";
    }

    @RequestMapping(value = "/changepasswordRM", method = RequestMethod.POST)
    public String editPasswordRM(@ModelAttribute("usersave") UserMii user) {
        String encrypt = bcrypt().encode(user.getPassword());
        user.setPassword(encrypt);
        userImpl.save(user);
        return "redirect:/profilEmployee";
    }

    @RequestMapping(value = "/achievementsaveRM", method = RequestMethod.POST)
    public String saveAchievementRM(@ModelAttribute("achievementsave") Achievement achievement) {
        achievement.setEmployee(new Employee(userId));
        achievementImpl.save(achievement);
        return "redirect:/RMProfil";
    }

    @RequestMapping(value = "/certificationsaveRM", method = RequestMethod.POST)
    public String saveCertificationRM(@ModelAttribute("certificationsave") Certification certification) {
        certification.setEmployee(new Employee(userId));
        certificationImpl.save(certification);
        return "redirect:/RMProfil";
    }

    @RequestMapping(value = "/educationsaveRM", method = RequestMethod.POST)
    public String saveEducationRM(@ModelAttribute("educationsave") Education education) {
        education.setEmployee(new Employee(userId));
        educationImpl.save(education);
        return "redirect:/RMProfil";
    }

    @RequestMapping(value = "/experiencesaveRM", method = RequestMethod.POST)
    public String saveExperienceRM(@ModelAttribute("experiencesave") Experience experience) {
        experience.setEmployee(new Employee(userId));
        experienceImpl.save(experience);
        return "redirect:/RMProfil";
    }

    @RequestMapping(value = "/languageemployeesaveRM", method = RequestMethod.POST)
    public String saveLanguageEmployeeRM(@ModelAttribute("languageemployeesave") LanguageEmployee languageEmployee) {
        languageEmployee.setEmployee(new Employee(userId));
        languageEmployeeImpl.save(languageEmployee);
        return "redirect:/RMProfil";
    }

    @RequestMapping(value = "/organizationsaveRM", method = RequestMethod.POST)
    public String saveOrganizationRM(@ModelAttribute("organizationsave") Organization organization) {
        organization.setEmployee(new Employee(userId));
        organizationImpl.save(organization);
        return "redirect:/RMProfil";
    }

    @RequestMapping(value = "/qualificationemployeesaveRM", method = RequestMethod.POST)
    public String saveQualificationEmployeeRM(@ModelAttribute("qualificationemployeesave") QualificationEmployee qualificationEmployee) {
        qualificationEmployee.setEmployee(new Employee(userId));
        qualificationEmployeeImpl.save(qualificationEmployee);
        return "redirect:/RMProfil";
    }

    @RequestMapping(value = "/trainingsaveRM", method = RequestMethod.POST)
    public String saveTrainingRM(@ModelAttribute("qualificationemployeesave") Training training) {
        training.setEmployee(new Employee(userId));
        trainingImpl.save(training);
        return "redirect:/RMProfil";
    }

    @RequestMapping(value = "/worksaveRM", method = RequestMethod.POST)
    public String saveWorkAssignmentRM(@ModelAttribute("worksave") WorkAssignment workAssignment) {
        workAssignment.setEmployee(new Employee(userId));
        workAssignmentImpl.save(workAssignment);
        return "redirect:/RMProfil";
    }

    @RequestMapping("achievementRM/delete/{id}")
    public String deleteAchievementRM(@PathVariable String id) {
        achievementImpl.delete(id);
        return "redirect:/RMProfil";
    }

    @RequestMapping("certificationRM/delete/{id}")
    public String deleteCertificationRM(@PathVariable String id) {
        certificationImpl.delete(id);
        return "redirect:/RMProfil";
    }

    @RequestMapping("educationRM/delete/{id}")
    public String deleteEducationRM(@PathVariable String id) {
        educationImpl.delete(id);
        return "redirect:/RMProfil";
    }

    @RequestMapping("experienceRM/delete/{id}")
    public String deleteExperienceRM(@PathVariable String id) {
        experienceImpl.delete(id);
        return "redirect:/RMProfil";
    }

    @RequestMapping("languageEmployeeRM/delete/{id}")
    public String deleteLanguageEmployeeRM(@PathVariable String id) {
        languageEmployeeImpl.delete(id);
        return "redirect:/RMProfil";
    }

    @RequestMapping("organizationRM/delete/{id}")
    public String deleteOrganizationRM(@PathVariable String id) {
        organizationImpl.delete(id);
        return "redirect:/RMProfil";
    }

    @RequestMapping("qualificationEmployeeRM/delete/{id}")
    public String deleteQualificationEmployeeRM(@PathVariable String id) {
        qualificationEmployeeImpl.delete(id);
        return "redirect:/RMProfil";
    }

    @RequestMapping("trainingRM/delete/{id}")
    public String deleteTrainingRM(@PathVariable String id) {
        trainingImpl.delete(id);
        return "redirect:/RMProfil";
    }

    @RequestMapping("workAssignmentRM/delete/{id}")
    public String deleteWorkAssignmentRM(@PathVariable String id) {
        workAssignmentImpl.delete(id);
        return "redirect:/RMProfil";
    }

// end RM controller
    @RequestMapping(value = "/assessmentsave", method = RequestMethod.POST)
    public String saveAssesment(@ModelAttribute("assessmentsave") Project project) {
        projectImpl.save(project);
        return "redirect:/assessment";
    }

    @RequestMapping(value = "/projectempsave", method = RequestMethod.POST)
    public String saveProjectEmp(@ModelAttribute("projectempsave") ProjectEmployee pe) {
        projectEmployeeImpl.save(pe);
        return "redirect:/projectemp";
    }

    @RequestMapping(value = "rmhome/rmprojectempsave", method = RequestMethod.POST)
    public String saveRMProjectEmp(@ModelAttribute("rmprojectempsave") ProjectEmployee pe) {
        projectEmployeeImpl.save(pe);
        return "redirect:/rmproject";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }

    @RequestMapping("project/delete/{id}")
    public String deleteProject(@PathVariable String id) {
        projectImpl.delete(id);
        return "redirect:/project";
    }

    @RequestMapping("client/delete/{id}")
    public String deleteClient(@PathVariable String id) {
        Client client = clientImpl.findbyid(id);
        client.setIsDelete("YES");
        clientImpl.save(client);
        return "redirect:/client";
    }

    @RequestMapping("employee/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        Employee employee = employeeImpl.findbyid(id);
        employee.setIsDelete("YES");
        employeeImpl.save(employee);
        return "redirect:/client";
    }

    @RequestMapping("achievement/delete/{id}")
    public String deleteAchievement(@PathVariable String id) {
        achievementImpl.delete(id);
        return "redirect:/profilEmployee";
    }

    @RequestMapping("certification/delete/{id}")
    public String deleteCertification(@PathVariable String id) {
        certificationImpl.delete(id);
        return "redirect:/profilEmployee";
    }

    @RequestMapping("education/delete/{id}")
    public String deleteEducation(@PathVariable String id) {
        educationImpl.delete(id);
        return "redirect:/profilEmployee";
    }

    @RequestMapping("experience/delete/{id}")
    public String deleteExperience(@PathVariable String id) {
        experienceImpl.delete(id);
        return "redirect:/profilEmployee";
    }

    @RequestMapping("languageEmployee/delete/{id}")
    public String deleteLanguageEmployee(@PathVariable String id) {
        languageEmployeeImpl.delete(id);
        return "redirect:/profilEmployee";
    }

    @RequestMapping("organization/delete/{id}")
    public String deleteOrganization(@PathVariable String id) {
        organizationImpl.delete(id);
        return "redirect:/profilEmployee";
    }

    @RequestMapping("qualificationEmployee/delete/{id}")
    public String deleteQualificationEmployee(@PathVariable String id) {
        qualificationEmployeeImpl.delete(id);
        return "redirect:/profilEmployee";
    }

    @RequestMapping("training/delete/{id}")
    public String deleteTraining(@PathVariable String id) {
        trainingImpl.delete(id);
        return "redirect:/profilEmployee";
    }

    @RequestMapping("workAssignment/delete/{id}")
    public String deleteWorkAssignment(@PathVariable String id) {
        workAssignmentImpl.delete(id);
        return "redirect:/profilEmployee";
    }

    @RequestMapping("rmhome/rmproject/delete/{id}")
    public String deletermProject(@PathVariable String id) {
        projectEmployeeImpl.delete(id);
        return "redirect:/rmproject";
    }

    @GetMapping("rmprojectprofilemployee/{id}")
    public String detailEmp(@PathVariable("id") String id, Model model) {

        model.addAttribute("profilEmployee", employeeImpl.findbyid(id));
        model.addAttribute("dataAchievement", achievementImpl.findbyempid(id));
        model.addAttribute("dataCertification", certificationImpl.findbyempid(id));
        model.addAttribute("dataEducation", educationImpl.findbyempid(id));
        model.addAttribute("dataExperience", experienceImpl.findbyempid(id));
        model.addAttribute("dataLanguageEmployee", languageEmployeeImpl.findbyempid(id));
        model.addAttribute("dataOrganization", organizationImpl.findbyempid(id));
        model.addAttribute("dataQualificationEmployee", qualificationEmployeeImpl.findbyempid(id));
        model.addAttribute("dataTraining", trainingImpl.findbyempid(id));
        model.addAttribute("dataWorkAssignment", workAssignmentImpl.findbyempid(id));
        model.addAttribute("dataProject", projectEmployeeImpl.findbyempid(id));
        return "pages/RMProfilEmployeeProject";
    }

    @GetMapping("clientprojectprofilemployee/{id}")
    public String detailEmpClient(@PathVariable("id") String id, Model model) {

        model.addAttribute("profilEmployee", employeeImpl.findbyid(id));
        model.addAttribute("dataAchievement", achievementImpl.findbyempid(id));
        model.addAttribute("dataCertification", certificationImpl.findbyempid(id));
        model.addAttribute("dataEducation", educationImpl.findbyempid(id));
        model.addAttribute("dataExperience", experienceImpl.findbyempid(id));
        model.addAttribute("dataLanguageEmployee", languageEmployeeImpl.findbyempid(id));
        model.addAttribute("dataOrganization", organizationImpl.findbyempid(id));
        model.addAttribute("dataQualificationEmployee", qualificationEmployeeImpl.findbyempid(id));
        model.addAttribute("dataTraining", trainingImpl.findbyempid(id));
        model.addAttribute("dataWorkAssignment", workAssignmentImpl.findbyempid(id));
        model.addAttribute("dataProject", projectEmployeeImpl.findbyempid(id));
        return "pages/ClientProfilEmployeeProject";
    }

// report
    @GetMapping("/empreport")
    public String empReport(Model model) {
        return "pages/EmpReport";
    }

    @RequestMapping(value = "empreport/generatereport", method = RequestMethod.POST)
    @ResponseBody
    public void reportget(HttpServletResponse response) throws SQLException {
        JasperReport jrep;
        JasperPrint jprint;
        JasperDesign jdes;
        Map<String, Object> param = new HashMap<String, Object>();
        List<Employee> emp = new ArrayList<Employee>();
        emp.add(employeeImpl.findbyid(userId));
        try {

            File file = new File("src/main/resources/cv.jrxml");
            jdes = JRXmlLoader.load(file);
            param.clear();
            jrep = JasperCompileManager.compileReport(jdes);
            jprint = JasperFillManager.fillReport(jrep, param, new JRBeanCollectionDataSource(emp));
            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=CV.pdf");

            final OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jprint, outStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "empreport/viewreport", method = RequestMethod.POST)
    @ResponseBody
    public void viewreport(HttpServletResponse response) throws SQLException {
        JasperReport jrep;
        JasperPrint jprint;
        JasperDesign jdes;
        Map<String, Object> param = new HashMap<String, Object>();
        List<Employee> emp = new ArrayList<Employee>();
        emp.add(employeeImpl.findbyid(userId));
        try {

            File file = new File("src/main/resources/cv.jrxml");
            jdes = JRXmlLoader.load(file);
            param.clear();
            jrep = JasperCompileManager.compileReport(jdes);
            jprint = JasperFillManager.fillReport(jrep, param, new JRBeanCollectionDataSource(emp));
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "inline; filename=CV.pdf");

            final OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jprint, outStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/RMreport")
    public String RMReport(Model model) {
        return "pages/RMreport";
    }

    @RequestMapping(value = "RMreport/generatereport", method = RequestMethod.POST)
    @ResponseBody
    public void RMreportget(HttpServletResponse response) throws SQLException {
        JasperReport jrep;
        JasperPrint jprint;
        JasperDesign jdes;
        Map<String, Object> param = new HashMap<String, Object>();
        List<Employee> emp = new ArrayList<Employee>();
        emp.add(employeeImpl.findbyid(userId));
        try {

            File file = new File("src/main/resources/cv.jrxml");
            jdes = JRXmlLoader.load(file);
            param.clear();
            jrep = JasperCompileManager.compileReport(jdes);
            jprint = JasperFillManager.fillReport(jrep, param, new JRBeanCollectionDataSource(emp));
            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename=CV.pdf");

            final OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jprint, outStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "RMreport/viewreport", method = RequestMethod.POST)
    @ResponseBody
    public void RMViewReport(HttpServletResponse response) throws SQLException {
        JasperReport jrep;
        JasperPrint jprint;
        JasperDesign jdes;
        Map<String, Object> param = new HashMap<String, Object>();
        List<Employee> emp = new ArrayList<Employee>();
        emp.add(employeeImpl.findbyid(userId));
        try {

            File file = new File("src/main/resources/cv.jrxml");
            jdes = JRXmlLoader.load(file);
            param.clear();
            jrep = JasperCompileManager.compileReport(jdes);
            jprint = JasperFillManager.fillReport(jrep, param, new JRBeanCollectionDataSource(emp));
            response.setContentType("application/pdf");
            response.setHeader("Content-disposition", "inline; filename=CV.pdf");

            final OutputStream outStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jprint, outStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @GetMapping("/ForgetPassword")
//    public String forgetpass() {
//        return "pages/ForgetPassword";
//    }
//
//    @RequestMapping(value = "/ForgetPassword/forget", method = RequestMethod.POST)
//    public String forget(@RequestParam("email") String email) {
//        UserMii umii = userImpl.findbyemail(email);
//        UUID rand = UUID.randomUUID();
//        String pwd = rand.toString();
//        umii.setPassword(pwd);
//        System.out.println(umii.getPassword());
//        try {
//
//            emailImpl.sendNotificationService(umii);
//
//        } catch (Exception e) {
//            log.info("Error sending email = " + e.getMessage());
//        }
//        String encrypt = bcrypt().encode(pwd);
//        umii.setPassword(encrypt);
//        userImpl.save(umii);
//        return "redirect:/ForgetPassword";
//    }

    //email
//    @RequestMapping("/sendemail")
//    public String signupComplete() {
//        UserMii umii = userImpl.findbyid("0");        
//        try {
//            emailImpl.sendNotificationService(umii);
//            
//        } catch (Exception e) {
//            log.info("Error sending email = " + e.getMessage());
//        }
//        return "redirect:/employee";
//    }
    //    @RequestMapping(value = "/projectsave", method = RequestMethod.POST)
//    public String saveProject(@ModelAttribute("projectsave") Project project) {
//        projectImpl.save(project);
//        return "redirect:/assessment";
//    }
    @GetMapping("/receiveemail")
    public String receiveemail(@PathVariable("id") String id, Model model) {
        model.addAttribute("dataReceiverEmail", id);
        return "redirect:/employee";
    }
}
