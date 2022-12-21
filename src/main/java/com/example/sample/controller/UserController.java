package com.example.sample.controller;

import com.example.sample.Mapper.UserMapStruct;
import com.example.sample.Mapper.UserMapper;
import com.example.sample.dto.UserDto;
import com.example.sample.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;
    private final UserMapStruct userMapStruct;

    public UserController(UserService userService, UserMapStruct userMapStruct) {
        this.userService = userService;
        this.userMapStruct = userMapStruct;
    }
    @GetMapping("/users")
    public List<UserDto>findAll(){
        return UserMapper.userToUserDto(userService.findAll());
    }
    @GetMapping("/user/")
    public ResponseEntity<UserDto>findById(@RequestParam String id){
        ResponseEntity responseEntity=new ResponseEntity<>(UserMapper.userToUserDto1(userService.findById(Long.parseLong(id))), HttpStatus.ACCEPTED);
    return responseEntity;
    }
    @GetMapping("/user")
    public Optional<UserDto> findByNationalCode(@RequestParam("full_name") String nationalCode){
return UserMapper.userToUserDto1  (userService.findByNationalCode(nationalCode));
    }

    @PostMapping("/user//")
    public void createUser(@RequestBody UserDto userDto){
        userService.save( UserMapper.toEntity((userDto)));
    }
//    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
//                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employee.setEmailId(employeeDetails.getEmailId());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setFirstName(employeeDetails.getFirstName());
//        final Employee updatedEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }

//    @DeleteMapping("/employees/{id}")
//    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
//            throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employeeRepository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

//    @PatchMapping("/employees/{id}/{firstName}")
//    public ResponseEntity<Employee> updateEmployeePartially(@PathVariable Long id, @PathVariable String firstName) {
//        try {
//            Employee employee = employeeRepository.findById(id).get();
//            employee.setFirstName(firstName);
//            return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}