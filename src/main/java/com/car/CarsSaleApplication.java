package com.car;

import com.car.dao.UserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.car.dao"})
public class CarsSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarsSaleApplication.class, args);
    }

}
