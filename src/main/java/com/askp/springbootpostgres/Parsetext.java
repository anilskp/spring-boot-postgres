package com.askp.springbootpostgres;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class Parsetext {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/parse")
    public String process() {

        String data="Anil-Benil-Haanin Shafeeque";
        String[] pdata = data.split("-");
        return pdata[2];
    }

    @RequestMapping("/parsejson")
    public String displayson() throws IOException {

        String jsonString = "{\"id\":\"2411\",\"name\":\"Ravi\",\"dept\":\"IT\"}";
        ObjectMapper mapper = new ObjectMapper();

        JsonNode actualObj = mapper.readValue(jsonString, JsonNode.class);
        // When
        JsonNode jsonNode1 = actualObj.get("name");

        return jsonNode1.textValue();

    }

    @RequestMapping("/employees")
    public List<Employee> getallEmployees(){
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable String id){

        return employeeService.getEmploye(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/employees")
    public void addEmployee(@RequestBody Employee employee) throws IOException {
        employeeService.addEmployee(employee);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/employees/{id}")
    public void updateEmployee(@RequestBody Employee employee, @PathVariable String id) throws IOException {
        employeeService.updateEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/employees/{id}")
    public void deleteEmployee(@PathVariable String id){

        employeeService.deleteEmployee(id);
    }
}
