package com.addon.survey;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.util.FileCopyUtils;

import com.addon.survey.helper.Password;
import com.addon.survey.helper.SampleData;
import com.addon.survey.model.Designation;
import com.addon.survey.model.District;
import com.addon.survey.model.EmpRole;
import com.addon.survey.model.Employee;
import com.addon.survey.model.EmployeeLogin;
import com.addon.survey.model.Polity;
import com.addon.survey.repositories.DistrictRepository;
import com.addon.survey.repositories.EmpRoleRepository;
import com.addon.survey.repositories.EmployeeLoginRepository;
import com.addon.survey.repositories.EmployeeRepository;
import com.addon.survey.repositories.PolityRepository;
import com.google.gson.Gson;

@SpringBootApplication
@EntityScan(basePackageClasses = { SurveyServiceApplication.class, Jsr310JpaConverters.class })
public class SurveyServiceApplication implements CommandLineRunner {

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	EmpRoleRepository empRoleRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeLoginRepository empLoginRepository;
	@Autowired
	PolityRepository polityRepository;
	@Autowired
	DistrictRepository districtRepository;

	@Autowired
	Gson gson;

	public static void main(String[] args) {
		SpringApplication.run(SurveyServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (empRoleRepository.count() == 0) {
			List<EmpRole> roles = new ArrayList<EmpRole>();
			roles.add(new EmpRole("Admin", "Admin"));
			roles.add(new EmpRole("User", "User"));
			empRoleRepository.saveAll(roles);
		}
		if (employeeRepository.count() == 0) {
			String password = "secret";
			char[] passwordChars = password.toCharArray();
			byte[] saltValue = Password.getNextSalt();
			byte[] passwordHashed = Password.hash(passwordChars, saltValue);

			String base64Password = Base64.getEncoder().encodeToString(passwordHashed);
			String saltBase64 = Base64.getEncoder().encodeToString(saltValue);
			EmployeeLogin empLogin = new EmployeeLogin("Rahul", "addon101", base64Password, saltBase64);
			empLogin = empLoginRepository.save(empLogin);

			Designation designation = new Designation("GeneralManager");
			Employee employee = new Employee("AD101", designation, empLogin);
			employeeRepository.save(employee);
		}
		if (districtRepository.count() == 0) {

			String districtsJson = "";
			ClassPathResource cpr = new ClassPathResource("districts.json");
			try {
				byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
				districtsJson = new String(bdata, StandardCharsets.UTF_8);

			} catch (IOException e) {

			}
			// Path path =
			// Paths.get(resourceLoader.getResource("classpath:districts.json").getURI());
			// districtsJson = new String(Files.readAllBytes(path));
			Polity polity = polityRepository.save(SampleData.getPolity());

			District[] districts = gson.fromJson(districtsJson, District[].class);
			for (District district : districts) {
				district.setPolity(polity);
			}
			districtRepository.saveAll(Arrays.asList(districts));

		}

	}

}
